package com.pricingengine.www.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.pricingengine.www.model.dealer.Dealer;
import com.pricingengine.www.model.rates.FinanceSpecialRate;
import com.pricingengine.www.model.rates.FinanceStandardRate;
import com.pricingengine.www.model.ratesandincentives.GetRatesAndIncentivesRequest;
import com.pricingengine.www.model.ratesandincentives.GetRatesAndIncentivesResponse;
import com.pricingengine.www.model.ratesandincentives.Incentive;
import com.pricingengine.www.model.ratesandincentives.Offer;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

@Component
@Service
public class PricingService {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public String loadFinanceSpecialRates(InputStream inputStream) {
		try{
			mongoTemplate.dropCollection(FinanceSpecialRate.class);
			CsvParserSettings csvParserSettings = new CsvParserSettings();
			csvParserSettings.setHeaderExtractionEnabled(true);
			CsvParser csvParser = new CsvParser(csvParserSettings);
			List<com.univocity.parsers.common.record.Record> csvRecords = csvParser.parseAllRecords(inputStream);
			csvRecords.forEach(record -> {
				FinanceSpecialRate financeSpecialRate = new FinanceSpecialRate();
				financeSpecialRate.setModelYear(record.getInt("model_year"));
				financeSpecialRate.setModel(record.getString("model"));
				financeSpecialRate.setModelCode(record.getString("model_code"));
				financeSpecialRate.setSalesClass(record.getString("sales_class"));
				financeSpecialRate.setTerm(record.getInt("term"));
				financeSpecialRate.setTier(record.getString("tier"));
				financeSpecialRate.setRate(record.getDouble("rate"));
				financeSpecialRate.setIncentiveAmount(record.getDouble("incentive_amount"));
				financeSpecialRate.setRegion(record.getString("region"));
				List<String> states = Arrays.asList(record.getString("states").split(","));
				financeSpecialRate.setStates(states);
				mongoTemplate.save(financeSpecialRate);
			});
			return "finance special rates loaded successfully!!!";
		}catch(Exception e) {
			return "finance special rates failed to load!!!";
		}
	}

	public GetRatesAndIncentivesResponse getRatesAndIncentives(GetRatesAndIncentivesRequest getRatesAndIncentivesRequest) {
		
		Query dealerQuery = new Query();
		dealerQuery.addCriteria(Criteria.where("dealerId").is(getRatesAndIncentivesRequest.getDealer().getDealerId()));
		Dealer dealer = mongoTemplate.findOne(dealerQuery, Dealer.class);
		GetRatesAndIncentivesResponse getRatesAndIncentivesResponse = new GetRatesAndIncentivesResponse();
		getRatesAndIncentivesResponse.setModelYear(getRatesAndIncentivesRequest.getVehicle().getModelYear());
		getRatesAndIncentivesResponse.setModel(getRatesAndIncentivesRequest.getVehicle().getVehicleModel());
		getRatesAndIncentivesResponse.setModelCode(getRatesAndIncentivesRequest.getVehicle().getVehicleModelCode());
		getRatesAndIncentivesResponse.setSalesClass(getRatesAndIncentivesRequest.getVehicle().getSalesClass());
		
		//Fetching special discounts based on customer's subjective qualifiers
		List<Incentive> incentives = new ArrayList<Incentive>();
		for(Integer eachIncentiveId : getRatesAndIncentivesRequest.getIncentiveIds()) {
			Query incentiveQuery = new Query();
			incentiveQuery.addCriteria(Criteria.where("incentiveId").is(eachIncentiveId));
			incentives.add((Incentive) mongoTemplate.findOne(incentiveQuery, Incentive.class));
		}
		getRatesAndIncentivesResponse.setIncentives(incentives);
		
		List<Offer> offers = new ArrayList<Offer>();
		for(Integer eachTerm : getRatesAndIncentivesRequest.getTerms()) {
			if(getRatesAndIncentivesRequest.getTransactionType().equalsIgnoreCase("finance")) {
				
				//Preparing query to fetch finance special rates
				Query financeSpecialRateQuery = new Query();
				financeSpecialRateQuery.addCriteria(Criteria.where("modelYear").is(getRatesAndIncentivesRequest.getVehicle().getModelYear())
						.and("modelCode").is(getRatesAndIncentivesRequest.getVehicle().getVehicleModelCode())
						.and("salesClass").is(getRatesAndIncentivesRequest.getVehicle().getSalesClass())
						.and("term").is(eachTerm)
						.and("tier").is(getRatesAndIncentivesRequest.getTier())
						.and("states").is(dealer.getDealerState()));
				FinanceSpecialRate financeSpecialRate = mongoTemplate.findOne(financeSpecialRateQuery, FinanceSpecialRate.class);
				
				//Populating finance special rate offer
				if(financeSpecialRate != null) {
					Offer offer = new Offer();
					offer.setRate(financeSpecialRate.getRate());
					offer.setTerm(eachTerm);
					offer.setStates(financeSpecialRate.getStates());
					offer.setRegion(financeSpecialRate.getRegion());
					offer.setSpecialProgram(true);
					
					//Preparing query to fetch finance cash back offers for special rate
					Query incentivesQuery = new Query();
					incentivesQuery.addCriteria(Criteria.where("modelYears").is(String.valueOf(getRatesAndIncentivesRequest.getVehicle().getModelYear()))
							.and("modelCodes").is(getRatesAndIncentivesRequest.getVehicle().getVehicleModelCode())
							.and("states").is(dealer.getDealerState())
							.and("compatibleWith").is("subvented"));
					Incentive incentive = mongoTemplate.findOne(incentivesQuery, Incentive.class);
					if(incentive != null) {
						offer.setCashBackAmount(incentive.getIncentiveAmount());
					}
					offers.add(offer);
				}
				
				//Preparing query to fetch finance standard rates
				Query financeStandardRateQuery = new Query();
				financeStandardRateQuery.addCriteria(Criteria.where("salesClass").is(getRatesAndIncentivesRequest.getVehicle().getSalesClass())
						.and("state").is(dealer.getDealerState())
						.and("term").is(eachTerm)
						.and("tier").is(getRatesAndIncentivesRequest.getTier()));
				FinanceStandardRate financeStandardRate = mongoTemplate.findOne(financeStandardRateQuery, FinanceStandardRate.class);
				if(financeStandardRate != null) {
					Offer offer = new Offer();
					List<String> states = new ArrayList<String>();
					states.add(financeStandardRate.getState());
					offer.setStates(states);
					offer.setRegion(financeStandardRate.getRegion());
					offer.setRate(financeStandardRate.getRate());
					offer.setTerm(financeStandardRate.getTerm());
					offer.setSpecialProgram(false);
					
					//Preparing query to fetch finance cash back offers for standard rate
					Query incentivesQuery = new Query();
					incentivesQuery.addCriteria(Criteria.where("modelYears").is(String.valueOf(getRatesAndIncentivesRequest.getVehicle().getModelYear()))
							.and("modelCodes").is(getRatesAndIncentivesRequest.getVehicle().getVehicleModelCode())
							.and("states").is(dealer.getDealerState())
							.and("compatibleWith").is("standard"));
					Incentive incentive = mongoTemplate.findOne(incentivesQuery, Incentive.class);
					if(incentive != null) {
						offer.setCashBackAmount(incentive.getIncentiveAmount());
					}
					offers.add(offer);
				}
			}
		}
		getRatesAndIncentivesResponse.setOffers(offers);
		return getRatesAndIncentivesResponse;
	}

	public String loadFinanceStandardRates(InputStream inputStream) {
		try {
			CsvParserSettings csvParserSettings = new CsvParserSettings();
			csvParserSettings.setHeaderExtractionEnabled(true);
			CsvParser csvParser = new CsvParser(csvParserSettings);
			List<com.univocity.parsers.common.record.Record> records = csvParser.parseAllRecords(inputStream);
			mongoTemplate.dropCollection(FinanceStandardRate.class);
			records.forEach(record -> {
				FinanceStandardRate financeStandardRate = new FinanceStandardRate();
				financeStandardRate.setSalesClass(record.getString("sales_class"));
				financeStandardRate.setState(record.getString("state"));
				financeStandardRate.setRegion(record.getString("region"));
				financeStandardRate.setTerm(record.getInt("term"));
				financeStandardRate.setTier(record.getString("tier"));
				financeStandardRate.setRate(record.getDouble("rate"));
				mongoTemplate.save(financeStandardRate);
			});
			return "finance standard rates loaded successfully!!!";
		}catch(Exception e) {
			return "failed to load finance standard rates";
		}
	}

	public String loadIncentives(InputStream inputStream) {
		try {
			CsvParserSettings csvParserSettings = new CsvParserSettings();
			csvParserSettings.setHeaderExtractionEnabled(true);
			CsvParser csvParser = new CsvParser(csvParserSettings);
			List<com.univocity.parsers.common.record.Record> records = csvParser.parseAllRecords(inputStream);
			mongoTemplate.dropCollection(Incentive.class);
			records.forEach(record -> {
				Incentive incentive = new Incentive();
				incentive.setIncentiveId(record.getInt("incentiveId"));
				incentive.setIncentiveName(record.getString("incentiveName"));
				incentive.setIncentiveAmount(record.getDouble("incentiveAmount"));
				incentive.setIncentiveType(record.getString("incentiveType"));
				incentive.setModel(record.getString("model"));
				if(record.getString("modelYears") != null)
					incentive.setModelYears(Arrays.asList(record.getString("modelYears").split(",")));
				if(record.getString("modelCodes") != null)
					incentive.setModelCodes(Arrays.asList(record.getString("modelCodes").split(",")));
				if(record.getString("regions") != null)
					incentive.setRegions(Arrays.asList(record.getString("regions").split(",")));
				if(record.getString("states") != null)
					incentive.setStates(Arrays.asList(record.getString("states").split(",")));
				incentive.setCompatibleWith(record.getString("compatibleWith"));
				mongoTemplate.save(incentive);
			});
			return "incentives loaded successfully";
		} catch(Exception e) {
			e.printStackTrace();
			return "failed to load incentives";
		}
	}
}
