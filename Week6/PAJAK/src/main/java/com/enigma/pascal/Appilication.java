package com.enigma.pascal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.enigma.pascal.PajakReport.ReportPajak;
import com.enigma.pascal.pajakAnalytics.IAnalytics;


public class Appilication {
	
	public static void main(String[] args) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		IAnalytics analytics = (IAnalytics) appContext.getBean(args[0]);
		analytics.TaxSum(Integer.parseInt(args[1]));
		ReportPajak reportPajak = (ReportPajak) appContext.getBean(args[2]);
		analytics.setReportPajak(reportPajak);
		analytics.result();
	}
}
