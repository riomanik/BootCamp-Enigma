package com.enigma.rio.calculator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
	private final Logger logger = LoggerFactory.getLogger(CalculatorService.class);
	
	public String tambah(int i, int j) {
		try {
			int result = i + j;
			logger.debug(String.valueOf(result));
			return String.valueOf(result);
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			return "";
		}
	}
	
	public String pembagian(int i, int j) {
		try {
			int result = i / j;
			logger.debug(String.valueOf(result));
			return String.valueOf(result);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			return "";
		}
	}

}
