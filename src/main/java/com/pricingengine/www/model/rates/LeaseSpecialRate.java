package com.pricingengine.www.model.rates;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "modelYear", "model", "modelCode", "salesClass", "term", "tier", "rate", "incentiveAmount", "region", "states" })
@Generated("jsonschema2pojo")
public class LeaseSpecialRate {

	@JsonProperty("modelYear")
	private Integer modelYear;
	@JsonProperty("model")
	private String model;
	@JsonProperty("modelCode")
	private String modelCode;
	@JsonProperty("salesClass")
	private String salesClass;
	@JsonProperty("term")
	private Integer term;
	@JsonProperty("tier")
	private String tier;
	@JsonProperty("rate")
	private Double rate;
	@JsonProperty("incentiveAmount")
	private Double incentiveAmount;
	@JsonProperty("region")
	private String region;
	@JsonProperty("states")
	private List<String> states = null;

	@JsonProperty("modelYear")
	public Integer getModelYear() {
		return modelYear;
	}

	@JsonProperty("modelYear")
	public void setModelYear(Integer modelYear) {
		this.modelYear = modelYear;
	}

	@JsonProperty("model")
	public String getModel() {
		return model;
	}

	@JsonProperty("model")
	public void setModel(String model) {
		this.model = model;
	}

	@JsonProperty("modelCode")
	public String getModelCode() {
		return modelCode;
	}

	@JsonProperty("modelCode")
	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	@JsonProperty("salesClass")
	public String getSalesClass() {
		return salesClass;
	}

	@JsonProperty("salesClass")
	public void setSalesClass(String salesClass) {
		this.salesClass = salesClass;
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
	
	public Double getIncentiveAmount() {
		return incentiveAmount;
	}

	public void setIncentiveAmount(Double incentiveAmount) {
		this.incentiveAmount = incentiveAmount;
	}

	@JsonProperty("region")
	public String getRegion() {
		return region;
	}

	@JsonProperty("region")
	public void setRegion(String region) {
		this.region = region;
	}

	@JsonProperty("states")
	public List<String> getStates() {
		return states;
	}

	@JsonProperty("states")
	public void setStates(List<String> states) {
		this.states = states;
	}

}
