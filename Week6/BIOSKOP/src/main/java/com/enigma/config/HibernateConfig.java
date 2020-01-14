package com.enigma.config;



import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.cfg.Configuration;
import org.jboss.logging.Logger;


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
	
}