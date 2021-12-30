package com.pricingengine.www.model.dealer;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "dealerId", "dealerName", "dealerAddress", "dealerState", "dealerRegion" })
@Generated("jsonschema2pojo")
public class Dealer {

	@JsonProperty("dealerId")
	private Integer dealerId;
	@JsonProperty("dealerName")
	private String dealerName;
	@JsonProperty("dealerAddress")
	private String dealerAddress;
	@JsonProperty("dealerState")
	private String dealerState;
	@JsonProperty("dealerRegion")
	private String dealerRegion;

	@JsonProperty("dealerId")
	public Integer getDealerId() {
		return dealerId;
	}

	@JsonProperty("dealerId")
	public void setDealerId(Integer dealerId) {
		this.dealerId = dealerId;
	}

	@JsonProperty("dealerName")
	public String getDealerName() {
		return dealerName;
	}

	@JsonProperty("dealerName")
	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	@JsonProperty("dealerAddress")
	public String getDealerAddress() {
		return dealerAddress;
	}

	@JsonProperty("dealerAddress")
	public void setDealerAddress(String dealerAddress) {
		this.dealerAddress = dealerAddress;
	}

	@JsonProperty("dealerState")
	public String getDealerState() {
		return dealerState;
	}

	@JsonProperty("dealerState")
	public void setDealerState(String dealerState) {
		this.dealerState = dealerState;
	}

	@JsonProperty("dealerRegion")
	public String getDealerRegion() {
		return dealerRegion;
	}

	@JsonProperty("dealerRegion")
	public void setDealerRegion(String dealerRegion) {
		this.dealerRegion = dealerRegion;
	}

}