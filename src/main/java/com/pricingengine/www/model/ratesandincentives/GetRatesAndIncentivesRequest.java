package com.pricingengine.www.model.ratesandincentives;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "transactionType", "offerType", "terms", "tier", "incentiveIds", "vehicle", "dealer" })
@Generated("jsonschema2pojo")
public class GetRatesAndIncentivesRequest {

	@JsonProperty("transactionType")
	private String transactionType;
	@JsonProperty("offerType")
	private String offerType;
	@JsonProperty("terms")
	private List<Integer> terms = null;
	@JsonProperty("tier")
	private String tier = null;
	@JsonProperty("incentiveIds")
	private List<Integer> incentiveIds = null;
	@JsonProperty("vehicle")
	private Vehicle vehicle;
	@JsonProperty("dealer")
	private Dealer dealer;

	@JsonProperty("transactionType")
	public String getTransactionType() {
		return transactionType;
	}

	@JsonProperty("transactionType")
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	@JsonProperty("offerType")
	public String getOfferType() {
		return offerType;
	}

	@JsonProperty("offerType")
	public void setOfferType(String offerType) {
		this.offerType = offerType;
	}

	@JsonProperty("terms")
	public List<Integer> getTerms() {
		return terms;
	}

	@JsonProperty("terms")
	public void setTerms(List<Integer> terms) {
		this.terms = terms;
	}
	
	@JsonProperty("tier")
	public String getTier() {
		return tier;
	}

	@JsonProperty("tier")
	public void setTier(String tier) {
		this.tier = tier;
	}

	@JsonProperty("incentiveIds")
	public List<Integer> getIncentiveIds() {
		return incentiveIds;
	}

	@JsonProperty("incentiveIds")
	public void setIncentiveIds(List<Integer> incentiveIds) {
		this.incentiveIds = incentiveIds;
	}

	@JsonProperty("vehicle")
	public Vehicle getVehicle() {
		return vehicle;
	}

	@JsonProperty("vehicle")
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@JsonProperty("dealer")
	public Dealer getDealer() {
		return dealer;
	}

	@JsonProperty("dealer")
	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

}
