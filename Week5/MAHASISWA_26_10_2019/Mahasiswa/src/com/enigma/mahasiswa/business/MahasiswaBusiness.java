package com.enigma.mahasiswa.business;

import java.util.ArrayList;
import java.util.List;

import com.enigma.mahasiswa.model.Mahasiswa;

public class MahasiswaBusiness {
	static public List<Mahasiswa> listMhs = new ArrayList<Mahasiswa>();

	public static List<Mahasiswa> getListMhs() {
		return listMhs;
	}

	public static void setListMhs(List<Mahasiswa> listMhs) {
		MahasiswaBusiness.listMhs = listMhs;
	}

	public static void addMahasiswa(Mahasiswa mahasiswa) {

		listMhs.add(mahasiswa);
	}
	
	public static void delMahasiswa(String mahasiswa) {		
		listMhs.removeIf(listMhs -> listMhs.getId().equals(mahasiswa));
	}
	
	public static void updMahasiswa(Integer mahasiswaId , String mahasiswaid , String Nama) {
		listMhs.get(mahasiswaId).setId(mahasiswaid);
		listMhs.get(mahasiswaId).setFullname(Nama);
	}
	
}
