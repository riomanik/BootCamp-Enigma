package com.enigma.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.enigma.config.HibernateConfig;
import com.enigma.model.FilmModel;
import com.enigma.model.HargaModel;
import com.enigma.model.JadwalModel;
import com.enigma.model.StudioModel;
import com.enigma.model.TransaksiModel;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		start();

	}

	@SuppressWarnings("resource")

	static MainMenu mm = new MainMenu();
	static MainFilm mf = new MainFilm();
	static MainJadwal mj = new MainJadwal();
	static MainStudio ms = new MainStudio();
	static MainTransaksi mt = new MainTransaksi();

	static public void start() {
		Integer pilihan;
		do {
			pilihan = mm.printMenuAwal();
			switch (pilihan) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				mt.transaksi();
				
				break;
			case 5:do {
				pilihan = mm.printMenu();
				
				switch (pilihan) {
				case 1:
					mf.tampilFilm();
					break;
				case 2:
					mj.tampilJadwal();
					break;
				case 3:
					ms.tampilStudio();
					break;
				case 4:
					mt.tampil();
					break;
				case 5:
					start();
					break;
				}
				
			} while (pilihan != 4);
			break;
			
			case 6:
				System.out.println("System Keluar");
				System.exit(0);
				break;
			}
		} while (pilihan != 5);
		
	}

	
}

//		Scanner in = new Scanner(System.in);
//		boolean rent = true;
//		do {
//			tampilJadwal();
//			System.out.println("Masukkan ID jadwal yang ingin di pesan = ");
//			Integer idFilm = in.nextInt();
//	if(check(idFilm) == false) {
//
//				System.out.println("maaf penayangan yang dimaksud tidak ada ");
//			} else {
//				System.out.println("Masukkan Nama Studio yang ingin di pesan = ");
//				String namaStudio = in.nextLine();
//				beli(namaStudio);
//				rent = true;
//				break;
//			}
//		} while (rent);
//
//	}
//

//
//	public static List<StudioModel> SearchByName(String namaStudio) {
//		List<StudioModel> studio = new ArrayList<StudioModel>();
//		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
//		Session session = sessionFactory.openSession();
//
//		session.beginTransaction();
//
//		CriteriaBuilder cb = session.getCriteriaBuilder();
//		CriteriaQuery<StudioModel> cr = cb.createQuery(StudioModel.class);
//		Root<StudioModel> root = cr.from(StudioModel.class);
//		Predicate predic1 = cb.like(root.get("namaStudio").as(String.class), "%" + namaStudio + "%");
//
//		cr.select(root).where(predic1);
//
//		Query<StudioModel> q = session.createQuery(cr);
//		List<StudioModel> result = q.getResultList();
//
//		for (StudioModel std : result) {
//			System.out.println(std);
//		}
//		session.getTransaction().commit();
//		return result;
//
//	}
//
//	public static void beli(String namaStudio) {
//		List<StudioModel> perpus = new ArrayList<StudioModel>();
//		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
//		Session session = sessionFactory.openSession();
//
//		CriteriaBuilder cb = session.getCriteriaBuilder();
//		CriteriaQuery<StudioModel> cr = cb.createQuery(StudioModel.class);
//		CriteriaUpdate<StudioModel> updateCriteria = cb.createCriteriaUpdate(StudioModel.class);
//		Root<StudioModel> root1 = cr.from(StudioModel.class);
//		Root<StudioModel> root = updateCriteria.from(StudioModel.class);
//
//		session.beginTransaction();
////		Main.PrintList();
//		perpus = SearchByName(namaStudio);
//		Integer CurentStockNow = perpus.get(0).getTotalKursi() - 1;
//
//		updateCriteria.set("totalKursi", CurentStockNow);
//		updateCriteria.where(cb.equal(root.get("namaStudio"), perpus.get(0).getNamaStudio()));
//
//		session.createQuery(updateCriteria).executeUpdate();
//		Query<StudioModel> q = session.createQuery(cr);
//		List<StudioModel> result = q.getResultList();
//
//		session.getTransaction().commit();
//		tampilJadwal();
//
//		// session.beginTransaction();
//
//	}

//}
