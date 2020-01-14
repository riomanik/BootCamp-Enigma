package com.enigma.rio.config;

import org.springframework.context.annotation.Bean;

import com.enigma.rio.service.BatchService;
import com.enigma.rio.service.BatchServiceImpl;


public class DaoConfig {

	@Bean
	public BatchService getBatchService() {
		return new BatchServiceImpl();
	}
}
