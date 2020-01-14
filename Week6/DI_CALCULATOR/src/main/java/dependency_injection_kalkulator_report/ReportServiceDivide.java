package dependency_injection_kalkulator_report;

public class ReportServiceDivide implements ReportService{
	public void calculator(double param1,double param2) {
		System.out.println("      BAGI       ");
		System.out.println("=================");
		System.out.println("ID 1 = " + param1);
		System.out.println("ID 2 = " + param2);
		System.out.println("TOTAL = " + (param1 / param2));
	}
}
