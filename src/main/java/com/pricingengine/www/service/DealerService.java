package com.pricingengine.www.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.pricingengine.www.model.dealer.Dealer;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

@Component
@Service
public class DealerService {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public String loadDealers(InputStream inputStream) {
		try {
			mongoTemplate.dropCollection(Dealer.class);
			CsvParserSettings csvParserSettings = new CsvParserSettings();
			csvParserSettings.setHeaderExtractionEnabled(true);
			CsvParser csvParser = new CsvParser(csvParserSettings);
			List<com.univocity.parsers.common.record.Record> parseRecords = csvParser.parseAllRecords(inputStream);
			parseRecords.forEach(record -> {
				Dealer dealer = new Dealer();
				dealer.setDealerId(record.getInt("dealerId"));
				dealer.setDealerName(record.getString("dealerName"));
				dealer.setDealerAddress(record.getString("dealerAddress"));
				dealer.setDealerState(record.getString("dealerState"));
				dealer.setDealerRegion(record.getString("dealerRegion"));
				mongoTemplate.save(dealer);
			});
			return "dealers loaded successfully!!!";
		}catch(Exception e) {
			return "dealers failed to load!!!";
		}
	}
}
