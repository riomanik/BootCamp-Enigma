package com.Enigma.StudentModel;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class StudentModel {
	private int id;
	private String nama;
	private String birth_place;
	private Date birth_date;
	private String gender;
	
	
	public StudentModel(int id, String nama, String birth_place, Date birth_date, String gender) {
		super();
		this.id = id;
		this.nama = nama;
		this.birth_place = birth_place;
		this.birth_date = birth_date;
		this.gender = gender;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return nama;
	}
	public void setName(String name) {
		this.nama = nama;
	}
	public String getBirth_place() {
		return birth_place;
	}
	public void setBirth_place(String birth_place) {
		this.birth_place = birth_place;
	}
	public Date getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}



	@Override
	public String toString() {
		return "StudentModel [id=" + id + ", nama=" + nama + ", birth_place=" + birth_place + ", birth_date="
				+ birth_date + ", gender=" + gender + "]";
	}
	
	
	
}
