package com.enigma.pascal.pajakAnalytics;

import com.enigma.pascal.PajakReport.ReportPajak;

public class Individu implements IAnalytics {
	private static ReportPajak reportPajak;
	private int a;
	private int result;

	// Membuat Report Pajak menggunakan Set
	public void setReportPajak(ReportPajak reportPajak) {
		Individu.reportPajak = reportPajak;
	}
	

	// Membuat fungsi menghitung hasil pajak dengan ketentuan berikut
	public void TaxSum(int a) {
		this.a = a;
		if (a <= 3000000) {
			result += 0;
		} else {
			result = a * 10 / 100;
		}

	}
	
	// Create or Merelasikan dengan report method sesuai permintaan yang membutuhkan dua buah string untuk dicetak
	public void result() {
		// TODO Auto-generated method stub
		reportPajak.createReport("Individu", new Integer(result).toString());
		
	}


}
