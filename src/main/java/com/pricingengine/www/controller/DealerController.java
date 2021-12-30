package com.pricingengine.www.controller;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pricingengine.www.service.DealerService;

@RestController
public class DealerController {

	@Autowired
	private DealerService dealerService;
	
	@PostMapping(value="/loadDealers", consumes= {"multipart/form-data"})
	public String loadDealers(@RequestParam("source file") MultipartFile uploadedFile) {
		try {
			InputStream inputStream = uploadedFile.getInputStream();
			return dealerService.loadDealers(inputStream);
		}catch(Exception e) {
			return "dealers loading failed!!!";
		}
	}
}
