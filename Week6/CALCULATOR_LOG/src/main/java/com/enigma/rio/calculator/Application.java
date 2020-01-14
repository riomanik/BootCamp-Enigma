package com.enigma.rio.calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.enigma.rio.calculator.service.CalculatorService;

@SpringBootApplication
public class Application implements CommandLineRunner{
	private final Logger logger = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	CalculatorService calculatorService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.debug(calculatorService.pembagian(3, 0));
		logger.debug(calculatorService.tambah(4, 1));
		logger.debug("This is a debug message");
		logger.info("This is an info message");
		logger.warn("This is a warn message");
		logger.error("This is an error message");
	}


}
