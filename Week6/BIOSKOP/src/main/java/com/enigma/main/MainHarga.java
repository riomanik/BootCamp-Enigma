package com.enigma.main;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.enigma.config.HibernateConfig;
import com.enigma.model.FilmModel;
import com.enigma.model.HargaModel;
import com.enigma.model.JadwalModel;
import com.enigma.model.StudioModel;

public class MainHarga {
	static public void tampilHarga() {
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<HargaModel> cr = cb.createQuery(HargaModel.class);
		Root<HargaModel> root = cr.from(HargaModel.class);

//		Join<HargaModel, StudioModel> joinstudio = root.join(JadwalModel.FIELD_FILM, JoinType.INNER);
		
//		Predicate predic1 = cb.like(root.get("nama").as(String.class), "%di%");
//        Predicate predic1 = cb.like(root.get("nama").as(String.class), "%di%");
//		cr.select(root).where(cb.equal(joinstudio.get(FilmModel.FIELD_ID).as(Integer.class), idFilm));

		cr.select(root).groupBy();

		Query<HargaModel> q = session.createQuery(cr);
		List<HargaModel> result = q.getResultList();
		System.out.println("|               DAFTAR FILM DAN HARGA                ");
		for (HargaModel jadwal : result) {
			System.out.println("|===============================================================");
			System.out.println("| ID HARGA \t\t: " + jadwal.getIdHarga());
			System.out.println("| NAMA STUDIO \t\t: " + jadwal.getStudio().getNamaStudio());
			System.out.println("| HARI PENAYANGAN \t: " + jadwal.getHari());
			System.out.println("| HARGA TICKET \t\t: " + jadwal.getHarga());
			System.out.println("| TOTAL KURSI TERSEDIA \t\t: " + jadwal.getStudio().getTotalKursi());

		}
		session.getTransaction().commit();
	}
}
