package com.currency.converter.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.currency.converter.entity.UserActivity;
import com.currency.converter.repositories.UserActivityRepository;

@Service
public class UserActivityServiceImpl implements UserActivityService {
	
	@Autowired
	private UserActivityRepository activityRepository;
	
	@Autowired
	private FxRateService rateService;
	
	public BigDecimal convertCurrency(UserActivity activity) {
		
		BigDecimal result = BigDecimal.ZERO;
		
		if (activity.getConvertFrom().equals("EUR")) {
			result = activity.getAmount().multiply(rateService.findByCurrency(activity.getConvertTo()).getRate());
		}
		else {
			result = activity.getAmount().divide(rateService.findByCurrency(activity.getConvertFrom()).getRate(), 2, RoundingMode.HALF_UP);
		}
		
		activity.setConvertedAmount(result);
		activityRepository.save(activity);
		
		return result;
	}
	
}
