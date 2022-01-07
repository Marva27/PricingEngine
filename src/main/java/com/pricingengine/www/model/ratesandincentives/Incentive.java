package com.pricingengine.www.model.ratesandincentives;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "incentiveId", "incentiveName", "incentiveAmount", "incentiveType", "model", "modelYears", "modelCodes", "regions", "states",
		"compatibleWith" })
@Generated("jsonschema2pojo")
public class Incentive {

	@JsonProperty("incentiveId")
	private Integer incentiveId;
	@JsonProperty("incentiveName")
	private String incentiveName;
	@JsonProperty("incentiveAmount")
	private Double incentiveAmount;
	@JsonProperty("incentiveType")
	private String incentiveType;
	@JsonProperty("model")
	private String model;
	@JsonProperty("modelYears")
	private List<String> modelYears = null;
	@JsonProperty("modelCodes")
	private List<String> modelCodes = null;
	@JsonProperty("regions")
	private List<String> regions = null;
	@JsonProperty("states")
	private List<String> states = null;
	@JsonProperty("compatibleWith")
	private String compatibleWith;

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
	public Double getIncentiveAmount() {
		return incentiveAmount;
	}

	@JsonProperty("incentiveAmount")
	public void setIncentiveAmount(Double incentiveAmount) {
		this.incentiveAmount = incentiveAmount;
	}

	public String getIncentiveType() {
		return incentiveType;
	}

	public void setIncentiveType(String incentiveType) {
		this.incentiveType = incentiveType;
	}

	@JsonProperty("model")
	public String getModel() {
		return model;
	}

	@JsonProperty("model")
	public void setModel(String model) {
		this.model = model;
	}

	@JsonProperty("modelYears")
	public List<String> getModelYears() {
		return modelYears;
	}

	@JsonProperty("modelYears")
	public void setModelYears(List<String> modelYears) {
		this.modelYears = modelYears;
	}
	
	@JsonProperty("modelCodes")
	public List<String> getModelCodes() {
		return modelCodes;
	}

	@JsonProperty("modelCodes")
	public void setModelCodes(List<String> modelCodes) {
		this.modelCodes = modelCodes;
	}

	@JsonProperty("regions")
	public List<String> getRegions() {
		return regions;
	}

	@JsonProperty("regions")
	public void setRegions(List<String> regions) {
		this.regions = regions;
	}

	@JsonProperty("states")
	public List<String> getStates() {
		return states;
	}

	@JsonProperty("states")
	public void setStates(List<String> states) {
		this.states = states;
	}

	@JsonProperty("compatibleWith")
	public String getCompatibleWith() {
		return compatibleWith;
	}

	@JsonProperty("compatibleWith")
	public void setCompatibleWith(String compatibleWith) {
		this.compatibleWith = compatibleWith;
	}

}