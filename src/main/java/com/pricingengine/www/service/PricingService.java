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
import com.pricingengine.www.model.ratesandincentives.GetRatesAndIncentivesRequest;
import com.pricingengine.www.model.ratesandincentives.GetRatesAndIncentivesResponse;
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
		List<Offer> offers = new ArrayList<Offer>();
		for(Integer eachTerm : getRatesAndIncentivesRequest.getTerms()) {
			Query ratesQuery = new Query();
			ratesQuery.addCriteria(Criteria.where("modelYear").is(getRatesAndIncentivesRequest.getVehicle().getModelYear())
					.and("modelCode").is(getRatesAndIncentivesRequest.getVehicle().getVehicleModelCode())
					.and("salesClass").is(getRatesAndIncentivesRequest.getVehicle().getSalesClass())
					.and("term").is(eachTerm)
					.and("tier").is(getRatesAndIncentivesRequest.getTier())
					.and("states").is(dealer.getDealerState()));
			if(getRatesAndIncentivesRequest.getTransactionType().equalsIgnoreCase("finance") && getRatesAndIncentivesRequest.getOfferType().equalsIgnoreCase("subvented")) {
				FinanceSpecialRate financeSpecialRate = mongoTemplate.findOne(ratesQuery, FinanceSpecialRate.class);
				if(financeSpecialRate != null) {
					Offer offer = new Offer();
					offer.setRate(financeSpecialRate.getRate());
					offer.setTerm(eachTerm);
					offer.setStates(financeSpecialRate.getStates());
					offer.setRegion(financeSpecialRate.getRegion());
					offers.add(offer);
				}
			}
		}
		getRatesAndIncentivesResponse.setOffers(offers);
		return getRatesAndIncentivesResponse;
	}
}
