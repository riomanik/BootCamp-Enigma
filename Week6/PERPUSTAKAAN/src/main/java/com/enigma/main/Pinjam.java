package com.enigma.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.enigma.config.HibernateConfig;
import com.enigma.model.Perpustakaan;
import com.enigma.service.Service;

public class Pinjam {

	void RentBook() {

		Scanner in = new Scanner(System.in);
		boolean rent = true;
		do {
			Main.PrintList();
			System.out.println("Masukkan Id Buku yang ingin di Pinjam = ");
			Integer idBuku = in.nextInt();
			if (Service.check(idBuku) == false) {

				System.out.println("maaf Id tidak ditemukan");

			} else {
				System.out.println("Masukkan jumlah Buku yang ingin di pinjam = ");
				Integer jumlahBuku = in.nextInt();
				Service.Pinjam(jumlahBuku, idBuku);
				rent = true;
				break;
			}
		} while (rent);




	}


}
