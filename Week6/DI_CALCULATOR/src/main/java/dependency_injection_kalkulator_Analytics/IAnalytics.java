package dependency_injection_kalkulator_Analytics;

public interface IAnalytics {
	void report();
	
	void setReportService(ReportService reportService);
}
