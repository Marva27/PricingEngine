package com.pricingengine.www.model.ratesandincentives;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "term", "rate", "states", "region", "cashBackAmount", "specialProgram"})
@Generated("jsonschema2pojo")
public class Offer {

	@JsonProperty("term")
	private Integer term;
	@JsonProperty("rate")
	private Double rate;
	@JsonProperty("cashBackAmount")
	private Double cashBackAmount;
	@JsonProperty("states")
	private List<String> states = null;
	@JsonProperty("region")
	private String region;
	@JsonProperty("specialProgram")
	private boolean specialProgram;

	@JsonProperty("term")
	public Integer getTerm() {
		return term;
	}

	@JsonProperty("term")
	public void setTerm(Integer term) {
		this.term = term;
	}

	@JsonProperty("rate")
	public Double getRate() {
		return rate;
	}

	@JsonProperty("rate")
	public void setRate(Double rate) {
		this.rate = rate;
	}

	@JsonProperty("cashBackAmount")
	public Double getCashBackAmount() {
		return cashBackAmount;
	}

	@JsonProperty("cashBackAmount")
	public void setCashBackAmount(Double cashBackAmount) {
		this.cashBackAmount = cashBackAmount;
	}

	@JsonProperty("states")
	public List<String> getStates() {
		return states;
	}

	@JsonProperty("states")
	public void setStates(List<String> states) {
		this.states = states;
	}

	@JsonProperty("region")
	public String getRegion() {
		return region;
	}

	@JsonProperty("region")
	public void setRegion(String region) {
		this.region = region;
	}
	
	@JsonProperty("specialProgram")
	public boolean getSpecialProgram() {
		return specialProgram;
	}

	@JsonProperty("specialProgram")
	public void setSpecialProgram(boolean specialProgram) {
		this.specialProgram = specialProgram;
	}

}