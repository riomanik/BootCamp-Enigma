package com.enigma.main;

import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.enigma.config.HibernateConfig;
import com.enigma.service.Service;

public class Report {
	static Scanner inInt = new Scanner(System.in);
	
	
//	session.beginTransaction();
	
//	CriteriaBuilder cb = 
	static void report() {
		int pilih;
		do {
			menuSearch();
			pilih = inInt.nextInt();
			switch (pilih) {
			case 1:
				Service.reportByThTerbit();		
				break;
			case 2:
				Service.reportByAuthor();
				break;
			case 3:
				System.out.println("Anda Keluar Menu Report");
				break;
			default:
				System.out.println("Input Anda Salah, Input Pilihan Menu [1-3]");
				break;
			}
			
		} while (pilih !=3);
	}
	
	static void menuSearch() {
		System.out.println("1.Report by Tahun Terbit");
		System.out.println("2.Report by Author ");
		System.out.println("3.Exit");
	}
	
	
	
}
