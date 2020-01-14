package com.enigma.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
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

import com.enigma.config.HibernateConfig;
import com.enigma.main.Main;
import com.enigma.main.Search;

import com.enigma.model.Perpustakaan;

public class Service {

	public static void insert(String nama, String author, String genre, Integer TahunTerbit, Integer TotalStock,
			Integer CurentStock) {
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction transObj = session.beginTransaction();

		Perpustakaan perp = new Perpustakaan();

		//
		Perpustakaan studentObj1 = new Perpustakaan(null, nama, author, genre, TahunTerbit, TotalStock, CurentStock);

		// SAVE OR INSERT
		session.save(studentObj1);

		// COMMIT
		session.getTransaction().commit();
	}

	public static void Update(String newnama, String newauthor, String newgenre, Integer newtahun, Integer newtotal,
			Integer newcurent, Integer inputId) {
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();
		// BEGIN TRANSAKSI
		session.beginTransaction();

		// CREATE BUILDER
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaUpdate<Perpustakaan> updateCriteria = cb.createCriteriaUpdate(Perpustakaan.class);
		Root<Perpustakaan> root = updateCriteria.from(Perpustakaan.class);

		// SET
		updateCriteria.where(cb.equal(root.get("idBuku"), inputId));
		if(root.get("idBuku").isNull() != null) {
			System.out.println("tidak ditemukan");
			
		} else {
		
		updateCriteria.set("namaBuku", newnama);
		updateCriteria.set("authorBuku", newauthor);
		updateCriteria.set("genreBuku", newgenre);
		updateCriteria.set("tahun_terbitBuku", newtahun);
		updateCriteria.set("total_stockBuku", newtotal);
		updateCriteria.set("curent_stockBuku", newcurent);
		session.createQuery(updateCriteria).executeUpdate();

		}
		
		session.getTransaction().commit();

	}
	public static boolean check(Integer id) {
		boolean check = true ;
		try {
			SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
			Session session = sessionFactory.openSession();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaUpdate<Perpustakaan> updateCriteria = cb.createCriteriaUpdate(Perpustakaan.class);
			Root<Perpustakaan> root = updateCriteria.from(Perpustakaan.class);
			Perpustakaan perpus = session.find(Perpustakaan.class,id);
			if(perpus == null) {
				return check = false;
			}
			session.getTransaction().commit();
			
		} catch (IllegalStateException e) {
			// TODO: handle exception
		}
		return check;
		
	}

	public static void Delete(Integer idbuku) {
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaDelete<Perpustakaan> deleteCriteria = cb.createCriteriaDelete(Perpustakaan.class);
		Root<Perpustakaan> root = deleteCriteria.from(Perpustakaan.class);

		// BEGIN
		session.beginTransaction();
		// CREATE TRANSAKSI
		deleteCriteria.where(cb.equal(root.get("idBuku"), idbuku));
		session.createQuery(deleteCriteria).executeUpdate();

		session.getTransaction().commit();
	}
	public static void Pinjam(Integer jumlahBuku , Integer idBuku) {
		List<Perpustakaan> perpus = new ArrayList<Perpustakaan>();
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Perpustakaan> cr = cb.createQuery(Perpustakaan.class);
		CriteriaUpdate<Perpustakaan> updateCriteria = cb.createCriteriaUpdate(Perpustakaan.class);
		Root<Perpustakaan> root1 = cr.from(Perpustakaan.class);
		Root<Perpustakaan> root = updateCriteria.from(Perpustakaan.class);

		session.beginTransaction();
//		Main.PrintList();
		perpus = SearchById(idBuku);
		Integer CurentStockNow = perpus.get(0).getCurent_stockBuku() - jumlahBuku;

		updateCriteria.set("curent_stockBuku", CurentStockNow);
		updateCriteria.where(cb.equal(root.get("idBuku"), perpus.get(0).getIdBuku()));

		session.createQuery(updateCriteria).executeUpdate();
		Query<Perpustakaan> q = session.createQuery(cr);
		List<Perpustakaan> result = q.getResultList();

		for (Perpustakaan buku : result) {
			System.out.println(buku);
		}
		session.getTransaction().commit();

		//session.beginTransaction();

	}

	public static void Kembalikan(Integer idBuku , Integer jumlahBuku) {
		List<Perpustakaan> perpus = new ArrayList<Perpustakaan>();
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Perpustakaan> cr = cb.createQuery(Perpustakaan.class);
		CriteriaUpdate<Perpustakaan> updateCriteria = cb.createCriteriaUpdate(Perpustakaan.class);
		Root<Perpustakaan> root1 = cr.from(Perpustakaan.class);
		Root<Perpustakaan> root = updateCriteria.from(Perpustakaan.class);

		perpus = SearchById(idBuku);
		Integer CurentStockNow = perpus.get(0).getCurent_stockBuku() + jumlahBuku;

		updateCriteria.set("curent_stockBuku", CurentStockNow);
		updateCriteria.where(cb.equal(root.get("idBuku"), perpus.get(0).getIdBuku()));

		session.createQuery(updateCriteria).executeUpdate();

		Query<Perpustakaan> q = session.createQuery(cr);
		List<Perpustakaan> result = q.getResultList();

		for (Perpustakaan buku : result) {
			System.out.println(buku);
		}
		session.getTransaction().commit();

		session.beginTransaction();

	}

	public static List<Perpustakaan> SearchById(Integer idBuku) {
		List<Perpustakaan> perpus = new ArrayList<Perpustakaan>();

		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Perpustakaan> cr = cb.createQuery(Perpustakaan.class);
		Root<Perpustakaan> root = cr.from(Perpustakaan.class);

		Predicate predic1 = cb.equal(root.get("idBuku"), idBuku);

		cr.select(root).where(predic1);

		Query<Perpustakaan> q = session.createQuery(cr);
		List<Perpustakaan> result = q.getResultList();

		for (Perpustakaan buku : result) {
			System.out.println(buku);
		}
		return result;

	}

	public static void SearchByName(String namaBuku) {
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Perpustakaan> cr = cb.createQuery(Perpustakaan.class);
        Root<Perpustakaan> root = cr.from(Perpustakaan.class);
        Predicate predic1 = cb.like(root.get("namaBuku").as(String.class), "%"+namaBuku+"%" );
        
	    cr.select(root).where(predic1);
	    
        Query<Perpustakaan> q=session.createQuery(cr);
        List<Perpustakaan> result=q.getResultList();  
              
        for (Perpustakaan buku : result) {
			System.out.println(buku);
		}
		session.getTransaction().commit();

	}
	
	public static void SearchByAuthor(String authorBuku) {
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Perpustakaan> cr = cb.createQuery(Perpustakaan.class);
        Root<Perpustakaan> root = cr.from(Perpustakaan.class);
        Predicate predic1 = cb.equal(root.get("authorBuku").as(String.class),"%"+authorBuku+"%" );
        
	    cr.select(root).where(predic1);
	    
        Query<Perpustakaan> q=session.createQuery(cr);
        List<Perpustakaan> result=q.getResultList();  
              
        for (Perpustakaan buku : result) {
			System.out.println(buku);
		}
		session.getTransaction().commit();

		
	}
	public static List<Perpustakaan> displayAll() {
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Perpustakaan> cr = cb.createQuery(Perpustakaan.class);
        Root<Perpustakaan> root = cr.from(Perpustakaan.class);
        cr.select(root);
        Query<Perpustakaan> q=session.createQuery(cr);
        List<Perpustakaan> result=q.getResultList();  
 
		session.getTransaction().commit();
		return result;
		
	}
	
//	public static void report() {
//		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		
//		CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<Tuple> cr = cb.createQuery(Tuple.class);
//        Root<Perpustakaan> root = cr.from(Perpustakaan.class);
//    
////        cr.select(root).where(cb.count(root.get(map));
//        cr.multiselect(root.get("tahun_terbit"),
//        		cb.count(root.get("judul")),
//        		cb.count(root.get("total_stock")));
//        		cr.groupBy(root.get("judul"));
////        query.orderBy(builder.asc(root.get(SampleModel_.name)));
//        Query<Tuple> q=session.createQuery(cr);
//        List<Tuple> result=q.getResultList();  
//              
//        for (Tuple buku : result) {
//			System.out.println(buku);
//		}
//		session.getTransaction().commit();
//	}
	
	public static Integer getCurentStock(Integer idBuku) {
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Perpustakaan> cr = cb.createQuery(Perpustakaan.class);
        Root<Perpustakaan> root = cr.from(Perpustakaan.class);
        cr.select(root).where(cb.equal(root.get("idBuku"), idBuku));
        session.beginTransaction();
        Query<Perpustakaan> q=session.createQuery(cr);
        List<Perpustakaan> result=q.getResultList();  
        session.getTransaction().commit();
        Integer totalStock = result.get(0).getCurent_stockBuku();
        return totalStock;	
		
	}
	
	public static Integer getTotalStock(Integer idBuku) {
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Perpustakaan> cr = cb.createQuery(Perpustakaan.class);
        Root<Perpustakaan> root = cr.from(Perpustakaan.class);
        cr.select(root).where(cb.equal(root.get("idBuku"), idBuku));
        session.beginTransaction();
        Query<Perpustakaan> q=session.createQuery(cr);
        List<Perpustakaan> result=q.getResultList();  
        session.getTransaction().commit();
        Integer totalStock = result.get(0).getTotal_stockBuku();
        return totalStock;	
		
	}

	public static void reportByThTerbit() {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Tuple> cr = cb.createQuery(Tuple.class);
		Root<Perpustakaan> root = cr.from(Perpustakaan.class);
		Expression<Integer> group = root.get("tahun_terbitBuku").as(Integer.class);
		Expression<Integer> totStok = root.get("total_stockBuku").as(Integer.class);
		Expression<Long> sum = cb.sumAsLong(totStok);
		CriteriaQuery<Tuple> select = cr.multiselect(sum,group);
		cr.groupBy(group);
		TypedQuery<Tuple> query = session.createQuery(select);
		List<Tuple> listBuku = query.getResultList();
		for (Tuple b : listBuku) {
			System.out.println("====================================================");
			System.out.println("Tahun Terbit         : " + b.get(1));
			System.out.println("Total Stock Buku     : " + b.get(0));
			System.out.println("====================================================");
		}
	}

	public static void reportByAuthor() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
				Session session = sessionFactory.openSession();
				CriteriaBuilder cb = session.getCriteriaBuilder();
		        CriteriaQuery<Tuple> cr = cb.createTupleQuery();
				Root<Perpustakaan> root = cr.from(Perpustakaan.class);
				Expression<String> group = root.get("authorBuku").as(String.class);
				Expression<Integer> totStok = root.get("total_stockBuku").as(Integer.class);
				Expression<Long> sum = cb.sumAsLong(totStok);
				CriteriaQuery<Tuple> select = cr.multiselect(sum,group);
				cr.groupBy(group);
				TypedQuery<Tuple> query = session.createQuery(select);
				List<Tuple> listBuku = query.getResultList();
				for (Tuple b : listBuku) {
					System.out.println("====================================================");
					System.out.println("Author               : " + b.get(1));
					System.out.println("Total Stock Buku     : " + b.get(0));
					System.out.println("====================================================");
				}
	}
	
	
}
