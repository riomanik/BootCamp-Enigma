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

public class MainJadwal {
	static public void tampilJadwal() {
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<JadwalModel> cr = cb.createQuery(JadwalModel.class);
		Root<JadwalModel> root = cr.from(JadwalModel.class);
		cr.select(root);
		Query<JadwalModel> q = session.createQuery(cr);
		List<JadwalModel> result = q.getResultList();
		System.out.println("|               DAFTAR FILM                      ");
		for (JadwalModel jadwal : result) {
			System.out.println("|===============================================================");
			System.out.println("| ID JADWAL \t\t: " + jadwal.getIdJadwal());
			System.out.println("| NAMA FILM \t\t: " + jadwal.getFilm().getNamaFilm());
			System.out.println("| NAMA TANGGAL \t\t: " + jadwal.getTanggal());
			System.out.println("| JAM MULAI \t\t: " + jadwal.getJamMulai());
			System.out.println("| JAM SELESAI \t\t: " + jadwal.getJamSelesai());

				
			}
			
			
				
			

		session.getTransaction().commit();
		}
}
