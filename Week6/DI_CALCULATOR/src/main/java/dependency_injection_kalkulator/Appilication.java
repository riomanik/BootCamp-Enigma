package dependency_injection_kalkulator;


import java.util.Scanner;

import dependency_injection_kalkulator_Analytics.CalculatorAnalytics;
import dependency_injection_kalkulator_report.ReportServiceDivide;
import dependency_injection_kalkulator_report.ReportServiceMinus;
import dependency_injection_kalkulator_report.ReportServicePlus;
import dependency_injection_kalkulator_report.ReportServiceTimes;

public class Appilication {
public static void main(String[] args) {
Integer Pilihan;


//	ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
//	IAnalytic
	
	do {
		System.out.println("|========================|");
		System.out.println("| 1. TAMBAH              |");
		System.out.println("| 2. KURANG              |");
		System.out.println("| 3. BAGI                |");
		System.out.println("| 4. KALI                |");
		System.out.println("|========================|");
		Scanner in = new Scanner(System.in);
		System.out.println("Masukkan Pilihan");
		Integer pilihan = in.nextInt();
		Pilihan=pilihan;
		
		switch (Pilihan) {
		case 1:
			CalculatorAnalytics plus = new CalculatorAnalytics(new ReportServicePlus());
			System.out.println("Masukkan Angka 1 = ");
			double param1 = in.nextDouble();
			System.out.println("Masukkan Angka 2 = ");
			double param2 = in.nextDouble();
			CalculatorAnalytics.reporting(param1,param2);
			break;
		case 2:
			CalculatorAnalytics minus = new CalculatorAnalytics(new ReportServiceMinus());
			System.out.println("Masukkan Angka 1 = ");
			double param3 = in.nextDouble();
			System.out.println("Masukkan Angka 2 = ");
			double param4 = in.nextDouble();
			CalculatorAnalytics.reporting(param3,param4);
			break;
		case 3:
			CalculatorAnalytics divide = new CalculatorAnalytics(new ReportServiceDivide());
			System.out.println("Masukkan Angka 1 = ");
			double param5 = in.nextDouble();
			System.out.println("Masukkan Angka 2 = ");
			double param6 = in.nextDouble();
			CalculatorAnalytics.reporting(param5,param6);
			break;
		case 4:
			CalculatorAnalytics times = new CalculatorAnalytics(new ReportServiceTimes());
			System.out.println("Masukkan Angka 1 = ");
			double param7 = in.nextDouble();
			System.out.println("Masukkan Angka 2 = ");
			double param8 = in.nextDouble();
			CalculatorAnalytics.reporting(param7,param8);
			break;
		}
		
		
		
	} while (Pilihan != 5);

}
}
