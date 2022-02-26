package com.pricingengine.www.model.dealer;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Document(collection="dealer")
public class Dealer {
	@Id
	@Schema(accessMode = Schema.AccessMode.READ_ONLY)
	private String id;
	
	@Schema(example = "34089", description = "Unique id to represent a dealer", required = true)
	@Indexed(unique = true)
	private Integer dealerId;
	@Schema(example = "Town North Mazda", description = "Name of the dealer", required = true)
	private String dealerName;
	@Schema(example = "6900 Preston Rd", description = "Location of the dealer", required = true)
	private String dealerAddress;
	@Schema(example = "Plano", description = "City at which the dealer is located", required = true)
	private String dealerCity;
	@Schema(example = "State", description = "State at which the dealer is located", required = true)
	private String dealerState;
	@Schema(example = "75080", description = "Zip Code at which the dealer is located", required = true)
	private Integer dealerZip;
	@Schema(example = "GU", description = "Region at which the dealer is located", required = true)
	private String dealerRegion;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getDealerId() {
		return dealerId;
	}
	public void setDealerId(Integer dealerId) {
		this.dealerId = dealerId;
	}
	public String getDealerName() {
		return dealerName;
	}
	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}
	public String getDealerAddress() {
		return dealerAddress;
	}
	public void setDealerAddress(String dealerAddress) {
		this.dealerAddress = dealerAddress;
	}
	public String getDealerCity() {
		return dealerCity;
	}
	public void setDealerCity(String dealerCity) {
		this.dealerCity = dealerCity;
	}
	public String getDealerState() {
		return dealerState;
	}
	public void setDealerState(String dealerState) {
		this.dealerState = dealerState;
	}
	public Integer getDealerZip() {
		return dealerZip;
	}
	public void setDealerZip(Integer dealerZip) {
		this.dealerZip = dealerZip;
	}
	public String getDealerRegion() {
		return dealerRegion;
	}
	public void setDealerRegion(String dealerRegion) {
		this.dealerRegion = dealerRegion;
	}
}