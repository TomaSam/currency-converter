package com.currency.converter.service;

import java.math.BigDecimal;

import com.currency.converter.entity.UserActivity;

public interface UserActivityService {
	
	BigDecimal convertCurrency(UserActivity activity);

}
