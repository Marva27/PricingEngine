package com.pricingengine.www.dealerengineadapter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.pricingengine.www.exception.ApplicationError;
import com.pricingengine.www.model.dealer.Dealer;

@Component
@ConditionalOnExpression("'${components.dealerengineadapter.strategy}'=='adapter'")
public class DealerEngineAdapter implements IDealerEngine {

	public RestTemplate restTemplate = new RestTemplate();
	
	@Value("${dealerengineadapter.getdealer.url}")
	public String getDealerByIdUrl  = "http://localhost:9090/dealer/";
	
	@Override
	public Dealer findDealerById(Integer dealerId) {
		try {
			Dealer dealer = restTemplate.exchange(getDealerByIdUrl + dealerId, HttpMethod.GET, null, Dealer.class).getBody();
			return dealer;
		}catch(Exception e) {
			throw new ApplicationError(ApplicationError.ErrorType.serverError, "error in calling dealer engine service", e);
		}
		
	}

}
