package com.currency.converter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.currency.converter.service.FxRateServiceImpl;

@SpringBootApplication
public class ConverterApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ConverterApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner run(FxRateServiceImpl service) throws Exception {
		return args -> {
			service.saveRatesToRepository();;
		};
	}

}
