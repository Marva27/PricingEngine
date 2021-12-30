package com.pricingengine.www.model.ratesandincentives;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "modelYear", "vehicleMake", "vehicleModel", "vehicleTrim", "vehicleModelCode", "vin", "salesClass",
		"msrp", "sellingPrice" })
@Generated("jsonschema2pojo")
public class Vehicle {

	@JsonProperty("modelYear")
	private Integer modelYear;
	@JsonProperty("vehicleMake")
	private String vehicleMake;
	@JsonProperty("vehicleModel")
	private String vehicleModel;
	@JsonProperty("vehicleTrim")
	private String vehicleTrim;
	@JsonProperty("vehicleModelCode")
	private String vehicleModelCode;
	@JsonProperty("vin")
	private String vin;
	@JsonProperty("salesClass")
	private String salesClass;
	@JsonProperty("msrp")
	private Double msrp;
	@JsonProperty("sellingPrice")
	private Double sellingPrice;

	@JsonProperty("modelYear")
	public Integer getModelYear() {
		return modelYear;
	}

	@JsonProperty("modelYear")
	public void setModelYear(Integer modelYear) {
		this.modelYear = modelYear;
	}

	@JsonProperty("vehicleMake")
	public String getVehicleMake() {
		return vehicleMake;
	}

	@JsonProperty("vehicleMake")
	public void setVehicleMake(String vehicleMake) {
		this.vehicleMake = vehicleMake;
	}

	@JsonProperty("vehicleModel")
	public String getVehicleModel() {
		return vehicleModel;
	}

	@JsonProperty("vehicleModel")
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	@JsonProperty("vehicleTrim")
	public String getVehicleTrim() {
		return vehicleTrim;
	}

	@JsonProperty("vehicleTrim")
	public void setVehicleTrim(String vehicleTrim) {
		this.vehicleTrim = vehicleTrim;
	}

	@JsonProperty("vehicleModelCode")
	public String getVehicleModelCode() {
		return vehicleModelCode;
	}

	@JsonProperty("vehicleModelCode")
	public void setVehicleModelCode(String vehicleModelCode) {
		this.vehicleModelCode = vehicleModelCode;
	}

	@JsonProperty("vin")
	public String getVin() {
		return vin;
	}

	@JsonProperty("vin")
	public void setVin(String vin) {
		this.vin = vin;
	}

	@JsonProperty("salesClass")
	public String getSalesClass() {
		return salesClass;
	}

	@JsonProperty("salesClass")
	public void setSalesClass(String salesClass) {
		this.salesClass = salesClass;
	}

	@JsonProperty("msrp")
	public Double getMsrp() {
		return msrp;
	}

	@JsonProperty("msrp")
	public void setMsrp(Double msrp) {
		this.msrp = msrp;
	}

	@JsonProperty("sellingPrice")
	public Double getSellingPrice() {
		return sellingPrice;
	}

	@JsonProperty("sellingPrice")
	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

}