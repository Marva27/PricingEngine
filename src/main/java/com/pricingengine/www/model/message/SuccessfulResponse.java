package com.pricingengine.www.model.message;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "message" })
@Generated("jsonschema2pojo")
public class SuccessfulResponse {

	@JsonProperty("message")
	@Schema(example = "Rates loaded successfully", description = "A meaningful message to be sent after successful operaation", required = true)
	private String message;

	@JsonProperty("message")
	public String getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(String message) {
		this.message = message;
	}

}