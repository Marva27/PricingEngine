package com.pricingengine.www.controller;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pricingengine.www.model.ratesandincentives.GetRatesAndIncentivesRequest;
import com.pricingengine.www.model.ratesandincentives.GetRatesAndIncentivesResponse;
import com.pricingengine.www.service.PricingService;

@RestController
public class PricingEngineController {

	@Autowired
	private PricingService pricingService;
	
	@PostMapping(value="/loadFinanceSpecialRates", consumes= {"multipart/form-data"})
	public String loadFinanceSpecialRates(@RequestParam("source file") MultipartFile uploadedFile) {
		try {
			InputStream inputStream = uploadedFile.getInputStream();
			return pricingService.loadFinanceSpecialRates(inputStream);
		}catch(Exception e) {
			return "failed to upload finance special rates";
		}
	}
	
	@PostMapping(value="/loadLeaseSpecialRates")
	public String loadLeaseSpecialRates() {
		return "success!!!";
	}
	
	@PostMapping(value="/loadFinanceStandardRates")
	public String loadFinanceStandardRates() {
		return "success!!!";
	}
	
	@PostMapping(value="/loadLeaseStandardRates")
	public String loadLeaseStandardRates() {
		return "success!!!";
	}
	
	@PostMapping(value="/getRatesAndIncentives")
	public GetRatesAndIncentivesResponse getRatesAndIncentives(@RequestBody GetRatesAndIncentivesRequest getRatesAndIncentivesRequest) {
		return pricingService.getRatesAndIncentives(getRatesAndIncentivesRequest);
	}
	
}
