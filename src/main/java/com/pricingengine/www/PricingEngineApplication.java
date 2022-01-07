package com.pricingengine.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Pricing API", description = "API to maintain rates", version = "1.0"))
public class PricingEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(PricingEngineApplication.class, args);
	}

}
