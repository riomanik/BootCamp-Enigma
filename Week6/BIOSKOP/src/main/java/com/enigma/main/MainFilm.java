package com.enigma.main;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.enigma.config.HibernateConfig;
import com.enigma.model.FilmModel;

public class MainFilm {
	static public void tampilFilm() {
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<FilmModel> cr = cb.createQuery(FilmModel.class);
		Root<FilmModel> root = cr.from(FilmModel.class);
		cr.select(root);
		Query<FilmModel> q = session.createQuery(cr);
		List<FilmModel> result = q.getResultList();
		System.out.println("|               DAFTAR FILM                      ");
		for (FilmModel film : result) {
			System.out.println("|================================================================");
			System.out.println("| ID FILM \t: " + film.getIdFilm());
			System.out.println("| NAMA FILM \t: " + film.getNamaFilm());
			System.out.println("|================================================================");
		}
		session.getTransaction().commit();

	}
}
