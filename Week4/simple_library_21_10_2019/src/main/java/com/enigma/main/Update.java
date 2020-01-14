package com.enigma.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.enigma.config.HibernateConfig;
import com.enigma.model.Perpustakaan;
import com.enigma.service.Service;

public class Update {

	void update() {
		boolean update = true;
		try {
			do {
				Main.PrintList();
				// INPUTAN DATA YANG AKAN DIRUBAH
				Scanner inn = new Scanner(System.in);
				System.out.println("Masukkan ID yang ingin dirubah = ");
				Integer inputId = inn.nextInt();
				if (Service.check(inputId) == false) {

					System.out.println("maaf Id tidak ditemukan");

				} else {
					// INPUT SCANNER
					Scanner in = new Scanner(System.in);
					System.out.println("Masukkan Nama = ");
					String nama = in.nextLine();
					System.out.println("Masukkan Author = ");
					String author = in.nextLine();
					System.out.println("Masukkan Genre = ");
					String genre = in.nextLine();
					System.out.println("Masukkan Tahun Terbit = ");
					Integer TahunTerbit = in.nextInt();
					System.out.println("Masukkan Total Stock = ");
					Integer TotalStock = in.nextInt();
					System.out.println("Masukkan Curent Stock = ");
					Integer CurentStock = in.nextInt();
					update = true;
					
					Service.Update(nama, author, genre, TahunTerbit, TotalStock, CurentStock, inputId);
					break;
				}

				
			} while (update);

		
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println("Inputan Salah Harap Ulangi Kembali");
		}
	}	
}
