package com.enigma.camp.LatihanHeroes.src.com.app;

public class Data {
	String id,nama,email,notlp,alamat,pekerjaan;
	
	public Data(String str) {
		this.id = str.substring(0,2).trim();
		this.nama = str.substring(2,16).trim();
		this.email = str.substring(16,37).trim();
		this.notlp = str.substring(37,60).trim();
		this.alamat = str.substring(60,113).trim();
		this.pekerjaan = str.substring(113,130).trim();
	}

	@Override
	public String toString() {
		return " ID        = " + id +"\n"+
			   " Nama      = " + nama +"\n"+
			   " Email     = " + email + "\n" + 
			   " No Tlp    = " + notlp + "\n"+ 
			   " Alamat    = " + alamat+ "\n"+
			   " Pekerjaan = " + pekerjaan + "\n";
	}

}
