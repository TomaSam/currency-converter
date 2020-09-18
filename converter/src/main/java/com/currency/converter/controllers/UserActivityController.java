package com.currency.converter.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.currency.converter.entity.UserActivity;
import com.currency.converter.service.UserActivityService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/converter")
public class UserActivityController {
	
	@Autowired
	private UserActivityService service;
	
	@PostMapping
	public BigDecimal convertCurrency(@RequestBody UserActivity activity) {
		
		BigDecimal result = service.convertCurrency(activity);
		return result;
	}

}
