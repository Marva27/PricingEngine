package com.pricingengine.www.dealerengineadapter;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pricingengine.www.exception.ApplicationError;
import com.pricingengine.www.model.dealer.Dealer;

@Component
@ConditionalOnExpression("'${components.dealerengineadapter.strategy}'=='mock'")
public class MockDealerEngineAdapter implements IDealerEngine {

	@Override
	public Dealer findDealerById(Integer dealerId) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			List<Dealer> allDealers = objectMapper.readValue(new File(System.getProperty("user.dir") + "\\src\\main\\resources\\mock-dealers.json"), new TypeReference<List<Dealer>>() {});
			for(Dealer eachDealer : allDealers) {
				if(eachDealer.getDealerId().equals(dealerId)) {
					return eachDealer;
				}	
			}
			throw new ApplicationError(ApplicationError.ErrorType.badRequest, "invalid dealer " + dealerId, "invalid dealer");
		} catch (IOException e) {
			throw new ApplicationError(ApplicationError.ErrorType.functionalError, "unexpected server error", e);
		}
	}

}
