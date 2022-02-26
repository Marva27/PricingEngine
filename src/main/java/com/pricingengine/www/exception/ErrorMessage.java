package com.pricingengine.www.exception;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "errorId", "errorMessage" })
@Generated("jsonschema2pojo")
public class ErrorMessage {

	@JsonProperty("errorId")
	private String errorId;
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