package com.pricingengine.www.model.ratesandincentives;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "modelYear", "model", "modelCode", "salesClass", "offers", "incentives" })
@Generated("jsonschema2pojo")
public class GetRatesAndIncentivesResponse {

	@JsonProperty("modelYear")
	private Integer modelYear;
	@JsonProperty("model")
	private String model;
	@JsonProperty("modelCode")
	private String modelCode;
	@JsonProperty("salesClass")
	private String salesClass;
	@JsonProperty("offers")
	private List<Offer> offers = null;
	@JsonProperty("incentives")
	private List<Incentive> incentives = null;

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

	@JsonProperty("offers")
	public List<Offer> getOffers() {
		return offers;
	}

	@JsonProperty("offers")
	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}

	@JsonProperty("incentives")
	public List<Incentive> getIncentives() {
		return incentives;
	}

	@JsonProperty("incentives")
	public void setIncentives(List<Incentive> incentives) {
		this.incentives = incentives;
	}

}