package com.pricingengine.www.dealerengineadapter;

import com.pricingengine.www.model.dealer.Dealer;

public interface IDealerEngine {
	public Dealer findDealerById(Integer dealerId);
}