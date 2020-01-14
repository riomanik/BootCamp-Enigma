package com.enigma.main;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.enigma.config.HibernateConfig;
import com.enigma.model.JadwalModel;
import com.enigma.model.StudioModel;

public class MainStudio {
	static public void tampilStudio() {
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<StudioModel> cr = cb.createQuery(StudioModel.class);
		Root<StudioModel> root = cr.from(StudioModel.class);
		cr.select(root);

		Query<StudioModel> q = session.createQuery(cr);
		List<StudioModel> result = q.getResultList();
		System.out.println("|               DAFTAR FILM                      ");
		for (StudioModel jadwal : result) {
			System.out.println("|===============================================================");
			System.out.println("| ID JADWAL \t\t: " + jadwal.getIdStudio());
			System.out.println("| NAMA STUDIO \t\t: " + jadwal.getNamaStudio());
			System.out.println("| MAX KURSI \t\t: " + jadwal.getTotalKursi());


		}session.getTransaction().commit();
		}
}
