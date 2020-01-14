package com.enigma.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;

import com.enigma.config.HibernateConfig;
import com.enigma.model.Perpustakaan;
import com.enigma.service.Service;

@SuppressWarnings("unused")
public class Main {

	public final static Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
		m.start();

	}

	@SuppressWarnings("resource")
	private static Integer printMenu() {
		System.out.println("|===========================================|");
		System.out.println("|              GO - LIBRARY                 |");
		System.out.println("|===========================================|");
		System.out.println("|                                           |");
		System.out.println("| 1. INSERT                                 |");
		System.out.println("| 2. UPDATE                                 |");
		System.out.println("| 3. DELETE                                 |");
		System.out.println("| 4. PINJAM                                 |");
		System.out.println("| 5. KEMBALI                                |");
		System.out.println("| 6. SEARCH                                 |");
		System.out.println("| 7. REPORT                                 |");
		System.out.println("| 8. EXIT                                   |");
		System.out.println("|===========================================|");
		System.out.println();
		System.out.print(" Masukkan Perintah = ");
		Scanner in = new Scanner(System.in);
		Integer pilihan = in.nextInt();
		return pilihan;

	}

	private void start() {
		Integer pilihan;
		Insert ins = new Insert();
		Update upd = new Update();
		Delete del = new Delete();
		Pinjam rent = new Pinjam();
		Kembalikan ret = new Kembalikan();
		Search src = new Search();
		do {
			pilihan = printMenu();

			switch (pilihan) {
			case 1:
				ins.insertMenu();
				break;
			case 2:
				upd.update();
				break;
			case 3:
				del.deleted();
				break;
			case 4:
				rent.RentBook();
				break;
			case 5:
				ret.returnBook();
				break;
			case 6:
				do {
					pilihan = printMenuSearch();
					switch (pilihan) {
					case 1:
						src.searchById();
						break;
					case 2:
						src.searchNama();
						break;
					case 3:
						src.searchAuthor();
						break;
					case 4:
						break;
					}
				} while (pilihan != 4);
				break;
			case 7:
				Report.report();
				break;
			case 8:
				System.out.println("System Exit");
				System.exit(0);
				break;
			}
		} while (pilihan != 8);
	}


	


	private static Integer printMenuSearch() {
		System.out.println("|===========================================|");
		System.out.println("|              GO - LIBRARY                 |");
		System.out.println("|===========================================|");
		System.out.println("| Search By                                 |");
		System.out.println("| 1. ID                                     |");
		System.out.println("| 2. NAMA/JUDUL                             |");
		System.out.println("| 3. AUTHOR                                 |");
		System.out.println("| 4. BACK                                   |");
		System.out.println("|===========================================|");
		System.out.print(" Masukkan Perintah = ");
		Scanner in = new Scanner(System.in);
		Integer pilihan = in.nextInt();
		return pilihan;
	}

	public static void PrintList() {
		
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Perpustakaan> cr = cb.createQuery(Perpustakaan.class);
        Root<Perpustakaan> root = cr.from(Perpustakaan.class);
        
        cr.select(root);
	    
        Query<Perpustakaan> q=session.createQuery(cr);
        List<Perpustakaan> result=q.getResultList();  
              
        for (Perpustakaan buku : result) {
			System.out.println(buku.toString());
		}
		session.getTransaction().commit();

	}
	
	
	
	
	
	

	
	
	
	
}
