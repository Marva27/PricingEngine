package com.pricingengine.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pricingengine.www.exception.ErrorMessage;
import com.pricingengine.www.model.message.SuccessfulResponse;
import com.pricingengine.www.model.ratesandincentives.GetRatesAndIncentivesRequest;
import com.pricingengine.www.model.ratesandincentives.GetRatesAndIncentivesResponse;
import com.pricingengine.www.service.PricingService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class PricingEngineController {

	@Autowired
	private PricingService pricingService;

	@Operation(tags = {
			"Pricing" }, description = "To load finance special rates", summary = "Load Finance Special Rates")
	@RequestMapping(value = "pricing/loadFinanceSpecialRates", produces = { "application/json" }, consumes = {
			"multipart/form-data" }, method = RequestMethod.POST)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Finance special rates loaded successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SuccessfulResponse.class))),
			@ApiResponse(responseCode = "404", description = "File is invalid", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
	public ResponseEntity<SuccessfulResponse> loadFinanceSpecialRates(
			@RequestParam("source file") MultipartFile uploadedFile) {
		return pricingService.loadFinanceSpecialRates(uploadedFile);
	}

	@Operation(tags = { "Pricing" }, description = "To load lease special rates", summary = "Load Lease Special Rates")
	@RequestMapping(value = "pricing/loadLeaseSpecialRates", method = RequestMethod.POST, produces = {
			"application/json" }, consumes = { "multipart/form-data" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lease special rates loaded successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SuccessfulResponse.class))),
			@ApiResponse(responseCode = "404", description = "File is invalid", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
	public ResponseEntity<SuccessfulResponse> loadLeaseSpecialRates(@RequestParam("source file") MultipartFile uploadedFile) {
		return pricingService.loadLeaseSpecialRates(uploadedFile);
	}

	@Operation(tags = {
			"Pricing" }, description = "To load finance standard rates", summary = "Load Finance Standard Rates")
	@RequestMapping(value = "pricing/loadFinanceStandardRates", consumes = { "multipart/form-data" }, produces = {
			"application/json" }, method = RequestMethod.POST)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Finance standard rates loaded successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SuccessfulResponse.class))),
			@ApiResponse(responseCode = "404", description = "File is invalid", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
	public ResponseEntity<SuccessfulResponse> loadFinanceStandardRates(@RequestParam("source file") MultipartFile uploadedFile) {
		return pricingService.loadFinanceStandardRates(uploadedFile);
	}

	@Operation(tags = {
			"Pricing" }, description = "To load lease standard rates", summary = "Load Lease Standard Rates")
	@RequestMapping(value = "pricing/loadLeaseStandardRates", consumes = { "multipart/form-data" }, produces = {
			"application/json" }, method = RequestMethod.POST)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lease standard rates loaded successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SuccessfulResponse.class))),
			@ApiResponse(responseCode = "404", description = "File is invalid", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
	public ResponseEntity<SuccessfulResponse> loadLeaseStandardRates(@RequestParam("source file") MultipartFile uploadedFile) {
		return pricingService.loadLeaseStandardRates(uploadedFile);
	}

	@Operation(tags = { "Pricing" }, description = "To load incentives", summary = "Load Incentives")
	@RequestMapping(value = "pricing/loadIncentives", consumes = { "multipart/form-data" }, produces = {
			"application/json" }, method = RequestMethod.POST)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Incentives loaded successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SuccessfulResponse.class))),
			@ApiResponse(responseCode = "404", description = "File is invalid", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))

	})
	public ResponseEntity<SuccessfulResponse> loadIncentives(@RequestParam("source file") MultipartFile uploadedFile) {
		return pricingService.loadIncentives(uploadedFile);
	}

	@Operation(tags = { "Pricing" }, description = "To get pricing offers", summary = "Get Pricing Offers")
	@RequestMapping(value = "pricing/getRatesAndIncentives", consumes = { "application/json" }, produces = {
			"application/json" }, method = RequestMethod.POST)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Pricing offers were returned successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GetRatesAndIncentivesResponse.class))),
			@ApiResponse(responseCode = "404", description = "No pricing offers were found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))) })
	public GetRatesAndIncentivesResponse getRatesAndIncentives(
			@RequestBody GetRatesAndIncentivesRequest getRatesAndIncentivesRequest) {
		return pricingService.getRatesAndIncentives(getRatesAndIncentivesRequest);
	}

}
