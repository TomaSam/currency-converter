package com.currency.converter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.currency.converter.entity.FxRate;


@Repository
public interface FxRateRepository extends JpaRepository<FxRate, Long> {
	
	
}
