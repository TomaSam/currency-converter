package com.currency.converter;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.currency.converter.entity.UserActivity;
import com.currency.converter.service.FxRateService;
import com.currency.converter.service.UserActivityServiceImpl;

@SpringBootTest
public class TestConverter {
	
	@Autowired
	private FxRateService fxRateservice;
	
	@Autowired
	private UserActivityServiceImpl service;
	
	@Test
	public void convertCurrencyCorrectly() {
		
		UserActivity activity = new UserActivity("EUR", "AUD", new BigDecimal(10));
		BigDecimal expectedResult = fxRateservice.findByCurrency("AUD").getRate().multiply(new BigDecimal(10));
		BigDecimal result = service.convertCurrency(activity);
		assertThat(result, equalTo(expectedResult.setScale(2, RoundingMode.HALF_UP)));
	}
	
	
}
