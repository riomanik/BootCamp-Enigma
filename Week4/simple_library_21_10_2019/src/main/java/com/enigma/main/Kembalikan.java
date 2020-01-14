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

public class Kembalikan {
	

	void returnBook() {
		
		
        Scanner in = new Scanner(System.in);
        System.out.println("Masukkan Id Buku yang ingin di kembalikan = ");
        Integer idBuku = in.nextInt();
        System.out.println("Masukkan jumlah Buku yang ingin di kembalikan = ");
        Integer jumlahBuku = in.nextInt();
        Service.Kembalikan(jumlahBuku,idBuku);
	   	}
	
}
