package com.pricingengine.www.model.ratesandincentives;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "dealerId" })
@Generated("jsonschema2pojo")
public class Dealer {

	@JsonProperty("dealerId")
	private Integer dealerId;

	@JsonProperty("dealerId")
	public Integer getDealerId() {
		return dealerId;
	}

	@JsonProperty("dealerId")
	public void setDealerId(Integer dealerId) {
		this.dealerId = dealerId;
	}

}
