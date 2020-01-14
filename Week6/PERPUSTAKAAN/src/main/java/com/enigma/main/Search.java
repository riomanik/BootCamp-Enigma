package com.enigma.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.enigma.config.HibernateConfig;
import com.enigma.model.Perpustakaan;
import com.enigma.service.Service;

public class Search {
	
	static public void searchById() {
		       
        Scanner in = new Scanner(System.in);
        System.out.println("Masukkan Id yang ingin dicari = ");
        Integer idBuku = in.nextInt();
        
        Service.SearchById(idBuku);
	}
	
	static public void searchNama() {
		
		
        
        Scanner in = new Scanner(System.in);
        System.out.println("Masukkan Nama Buku yang ingin dicari = ");
        String namaBuku = in.nextLine();
        
       Service.SearchByName(namaBuku);
		
	}
	
	static public void searchAuthor() {
		
		
        
        Scanner in = new Scanner(System.in);
        System.out.println("Masukkan Nama Author yang ingin dicari = ");
        String authorBuku = in.nextLine();
        
        Service.SearchByAuthor(authorBuku);

	}
}
