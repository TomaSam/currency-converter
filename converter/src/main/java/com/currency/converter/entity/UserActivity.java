package com.currency.converter.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class UserActivity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String convertFrom;
	private String convertTo;
	private BigDecimal amount;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date converted_At;
	private BigDecimal convertedAmount = BigDecimal.ZERO;
	
	public UserActivity(String convertFrom, String convertTo, BigDecimal amount) {
		super();
		this.convertFrom = convertFrom;
		this.convertTo = convertTo;
		this.amount = amount;
	}
	
	@PrePersist
	protected void onCreate() {
		this.converted_At = new Date();
	}
	
	

}
