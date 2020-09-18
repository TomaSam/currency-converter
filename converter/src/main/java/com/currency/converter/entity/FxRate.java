package com.currency.converter.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class FxRate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rateId;
	private BigDecimal rate;
	private String currency;
	
	public FxRate(BigDecimal rate, String currency) {
		super();
		this.rate = rate;
		this.currency = currency;
	}
	
	
	

}
