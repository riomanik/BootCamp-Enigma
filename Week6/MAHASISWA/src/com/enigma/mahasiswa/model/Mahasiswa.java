package com.enigma.mahasiswa.model;

public class Mahasiswa {
	String id;
	String fullname;
	
	
	public Mahasiswa(String id, String fullname) {
		super();
		this.id = id;
		this.fullname = fullname;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	
	
}
