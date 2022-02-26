package com.pricingengine.www.model.rates;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "salesClass", "state", "region", "term", "tier", "rate" })
@Generated("jsonschema2pojo")
public class LeaseStandardRate {

	@JsonProperty("salesClass")
	private String salesClass;
	@JsonProperty("state")
	private String state;
	@JsonProperty("region")
	private String region;
	@JsonProperty("term")
	private Integer term;
	@JsonProperty("tier")
	private String tier;
	@JsonProperty("rate")
	private Double rate;

	@JsonProperty("salesClass")
	public String getSalesClass() {
		return salesClass;
	}

	@JsonProperty("salesClass")
	public void setSalesClass(String salesClass) {
		this.salesClass = salesClass;
	}

	@JsonProperty("state")
	public String getState() {
		return state;
	}

	@JsonProperty("state")
	public void setState(String state) {
		this.state = state;
	}

	@JsonProperty("region")
	public String getRegion() {
		return region;
	}

	@JsonProperty("region")
	public void setRegion(String region) {
		this.region = region;
	}

	@JsonProperty("term")
	public Integer getTerm() {
		return term;
	}

	@JsonProperty("term")
	public void setTerm(Integer term) {
		this.term = term;
	}

	@JsonProperty("tier")
	public String getTier() {
		return tier;
	}

	@JsonProperty("tier")
	public void setTier(String tier) {
		this.tier = tier;
	}

	@JsonProperty("rate")
	public Double getRate() {
		return rate;
	}

	@JsonProperty("rate")
	public void setRate(Double rate) {
		this.rate = rate;
	}

}
