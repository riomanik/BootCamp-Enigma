package dependency_injection_kalkulator_Analytics;

import dependency_injection_kalkulator_report.ReportService;

public class CalculatorAnalytics {
	private static ReportService reportService;

	public CalculatorAnalytics(ReportService reportService) {
		this.reportService = reportService;
	}
	public static void reporting(double param1,double param2) {
		reportService.calculator(param1, param2);
	}
}
