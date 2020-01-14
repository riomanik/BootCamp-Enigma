package com.enigma.rio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.enigma.rio.config.DaoConfig;

@SpringBootApplication
@Import({DaoConfig.class})
public class Appilication {

	public static void main(String[] args) {
		
		SpringApplication.run(Appilication.class, args);
	}

}
