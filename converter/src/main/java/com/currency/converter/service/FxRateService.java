package com.currency.converter.service;

import com.currency.converter.entity.FxRate;

public interface FxRateService {

	FxRate findByCurrency(String currency);
	void saveRatesToRepository() throws Exception;
	
	
}
