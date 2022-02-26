package com.pricingengine.www.model.message;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "errorId", "errorMessage" })
@Generated("jsonschema2pojo")
public class ErrorMessage {

	
	@Schema(example = "badRequest|dealerId", description = "Unique id to identify an error", required = true)
	@JsonProperty("errorId")
	private String errorId;
	
	@Schema(example = "Dealer id is required", description = "Meaningful error message", required = true)
	@JsonProperty("errorMessage")
	private String errorMessage;

	@JsonProperty("errorId")
	public String getErrorId() {
		return errorId;
	}

	@JsonProperty("errorId")
	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}

	@JsonProperty("errorMessage")
	public String getErrorMessage() {
		return errorMessage;
	}

	@JsonProperty("errorMessage")
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}