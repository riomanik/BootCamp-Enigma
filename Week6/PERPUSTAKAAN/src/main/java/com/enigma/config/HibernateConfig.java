package com.enigma.config;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.cfg.Configuration;
import org.jboss.logging.Logger;

import com.enigma.model.Perpustakaan;

public class HibernateConfig {
	private static SessionFactory sessionFactory;
	public final static Logger logger = Logger.getLogger(HibernateConfig.class);

	public static SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			sessionFactory = configuration.buildSessionFactory();

		} catch (Throwable ex) {
			// TODO: handle exception
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		return sessionFactory;
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null)
			sessionFactory = buildSessionFactory();
		return sessionFactory;
	}

	public static Perpustakaan createRecord(Perpustakaan perpustakaanObj) {
		Session sessionObj = getSessionFactory().openSession();

		// Creating Transaction Object
		Transaction transObj = sessionObj.beginTransaction();
		sessionObj.save(perpustakaanObj);

		// Transaction Is Committed To Database
		transObj.commit();

		// Closing The Session Object
		sessionObj.close();
		logger.info("Successfully Created " + perpustakaanObj.toString());
		return perpustakaanObj;

	}
	
	@SuppressWarnings("rawtypes")
	public static List displayRecords() {
        Session sessionObj = getSessionFactory().openSession();
        List perpusList = sessionObj.createQuery("FROM Perpustakaan").list();
 
        // Closing The Session Object
        sessionObj.close();
        System.out.println(perpusList.size());
        return perpusList;
    }
	
//	public static void updateRecord(Perpustakaan perpustakaanObj) {
//        Session sessionObj = getSessionFactory().openSession();
// 
//        //Creating Transaction Object  
//        Transaction transObj = sessionObj.beginTransaction();
//        Perpustakaan perpObj = (Perpustakaan) sessionObj.load(Perpustakaan.class, perpustakaanObj.getIdBuku());
//        perpObj.setNamaBuku(perpustakaanObj.getNamaBuku());
//        perpObj.setAuthorBuku(perpustakaanObj.getAuthorBuku());
//        perpObj.setGenreBuku(perpustakaanObj.getGenreBuku());
//        perpObj.setTahun_terbitBuku(perpustakaanObj.getTahun_terbitBuku());
//        perpObj.setTotal_stockBuku(perpustakaanObj.getTotal_stockBuku());
//        perpObj.setCurent_stockBuku(perpustakaanObj.getCurent_stockBuku());
// 
//        // Transaction Is Committed To Database
//        transObj.commit();
// 
//        // Closing The Session Object
//        sessionObj.close();
//        logger.info("Student Record Is Successfully Updated!= " + perpustakaanObj.toString());
//    }
	
	public void updateOrder(Integer idBuku) {

    }

	
	public static void deleteRecord(Integer idBuku) {
		
//		Session sessionObj = getSessionFactory().openSession();
//		
//		Transaction transObj = sessionObj.beginTransaction();
//
//        Perpustakaan perpObj = (Perpustakaan) sessionObj.load(Perpustakaan.class, idBuku);
////		Perpustakaan perpObj = findRecordById(idBuku);
//		sessionObj.delete(perpObj);
//		
//		transObj.commit();
//		sessionObj.close();
//		logger.info("Succesfully Record Is Succesfully Deleted! = " + perpObj.toString());
//					
	}
	
}