package com.enigma.pascal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.enigma.pascal.pajakAnalytics.IAnalytics;
import com.enigma.pascal.pajakAnalytics.Individu;
import com.enigma.pascal.ReportPajak

@Configuration
public class AppConfig {
	
	@Bean(name = "individuAnalytics")
	public IAnalytics Individu() {
		return new Individu();
	}

	@Bean("reportPajakIndividual")
	public ReportService ReportIndividualTax() {
		return new ReportIndividualTax();
	}
}
