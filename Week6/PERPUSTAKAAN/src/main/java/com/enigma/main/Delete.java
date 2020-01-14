package com.enigma.main;

import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.enigma.config.HibernateConfig;
import com.enigma.model.Perpustakaan;
import com.enigma.service.Service;
import com.sun.istack.NotNull;

public class Delete {

	
	void deleted() {
		boolean bol_del = true;
		
		do {
			Main.PrintList();
			//INPUTAN ID YANG INGIN DIHAPUS
			Scanner in = new Scanner(System.in);
			System.out.println("Masukkan id buku yang ingin dihapus = ");
			Integer idbuku = in.nextInt();
			if (Service.check(idbuku) == false) {
				
				System.out.println("maaf Id tidak ditemukan");
				
			} else {
				bol_del = true;
				Service.Delete(idbuku);
				break;
			}
			
		} while (bol_del);
		
		
		
		
	}

}
