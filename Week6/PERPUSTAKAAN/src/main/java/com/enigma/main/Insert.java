package com.enigma.main;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.enigma.config.HibernateConfig;
import com.enigma.model.Perpustakaan;
import com.enigma.service.Service;

public class Insert {

	void insertMenu() {
		Scanner in = new Scanner(System.in);
		boolean bol_nama = true;
		boolean bol_author = true;
		boolean bol_genre = true;
		boolean bol_tahun = true;
		boolean bol_total = true;
		boolean bol_curent = true;
		String nama;
		String author;
		String genre;
		Integer TahunTerbit;
		Integer TotalStock;
		Integer CurentStock;
		
			do {
				// INPUT SCANNER 
				
				System.out.println("Masukkan Nama = ");
				nama = in.nextLine();
				if(nama.length() > 100) {
					System.out.println("Character tidak boleh lebih dari 100 CHaracter");
				} else {
					bol_nama = false;
				}
			} while (bol_nama);
				
			do {
				System.out.println("Masukkan Author = ");
				author = in.nextLine();
				if(author.length() > 100) {
					System.out.println("Character tidak boleh lebih dari 100 CHaracter");
				} else {
					bol_author = false;
				}
			} while (bol_author);
			do {
				System.out.println("Masukkan Genre = ");
				genre = in.nextLine();
				if(genre.length() > 100) {
					System.out.println("Character tidak boleh lebih dari 100 CHaracter");
				} else {
					bol_genre = false;
				}
				
			} while (bol_genre);
			do {
				System.out.println("Masukkan Tahun Terbit = ");
				TahunTerbit = in.nextInt();
				if(TahunTerbit.intValue() < 0 ) {
					System.out.println("Tahun tidak boleh Minus");
				} else {
					bol_tahun = false;
				}
			} while (bol_tahun);
			do {
				System.out.println("Masukkan Total Stock = ");
				TotalStock = in.nextInt();
				if(TotalStock.intValue() < 0 ) {
					System.out.println("Total Stock tidak boleh Minus");
				} else {
					bol_total = false;
				}
			} while (bol_total);
			do {
				System.out.println("Masukkan Curent Stock = ");
				CurentStock = in.nextInt();
				if(CurentStock.intValue() < 0 ) {
					System.out.println("Curent Stock tidak boleh Minus");
				} else {
					bol_curent = false;
				}
			} while (bol_curent);
				
			
			 
			Service.insert(nama,author,genre,TahunTerbit,TotalStock,CurentStock);
			
	}
}
