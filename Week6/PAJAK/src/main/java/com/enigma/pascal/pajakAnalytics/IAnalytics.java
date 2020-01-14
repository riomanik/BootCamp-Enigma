package com.enigma.pascal.pajakAnalytics;

import com.enigma.pascal.PajakReport.ReportPajak;

public interface IAnalytics {
	// Kesepakatan memakai SET
	void setReportPajak(ReportPajak reportPajak);
	// Menghitung hasilnya dengan aturan tertentu
	void TaxSum(int a);
	// Menampilkan hasilnya
	void result();

}
