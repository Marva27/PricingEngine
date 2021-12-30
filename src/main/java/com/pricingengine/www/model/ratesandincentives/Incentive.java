package com.pricingengine.www.model.ratesandincentives;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "incentiveId", "incentiveName", "incentiveAmount" })
@Generated("jsonschema2pojo")
public class Incentive {

	@JsonProperty("incentiveId")
	private Integer incentiveId;
	@JsonProperty("incentiveName")
	private String incentiveName;
	@JsonProperty("incentiveAmount")
	private Integer incentiveAmount;

	@JsonProperty("incentiveId")
	public Integer getIncentiveId() {
		return incentiveId;
	}

	@JsonProperty("incentiveId")
	public void setIncentiveId(Integer incentiveId) {
		this.incentiveId = incentiveId;
	}

	@JsonProperty("incentiveName")
	public String getIncentiveName() {
		return incentiveName;
	}

	@JsonProperty("incentiveName")
	public void setIncentiveName(String incentiveName) {
		this.incentiveName = incentiveName;
	}

	@JsonProperty("incentiveAmount")
	public Integer getIncentiveAmount() {
		return incentiveAmount;
	}

	@JsonProperty("incentiveAmount")
	public void setIncentiveAmount(Integer incentiveAmount) {
		this.incentiveAmount = incentiveAmount;
	}

}