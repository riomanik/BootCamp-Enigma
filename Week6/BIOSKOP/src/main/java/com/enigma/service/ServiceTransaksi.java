package com.enigma.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.enigma.config.HibernateConfig;
import com.enigma.model.FilmModel;
import com.enigma.model.HargaModel;
import com.enigma.model.TransaksiModel;

public class ServiceTransaksi {
	
	public static void ServTrans(Integer idHarga, Integer quantity, Integer idJadwal) {
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		
//		START TRANSAKSI
			session.beginTransaction();
	
		//	TANGGAL
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");	
			Date d = new Date();
			String d1 = sdf.format(d);
			String tanggal = d1;
	
			//	HARGA
			CriteriaQuery<HargaModel> cr = cb.createQuery(HargaModel.class);
			Root<HargaModel> root = cr.from(HargaModel.class);
			cr.select(root).groupBy();
			Query<HargaModel> q = session.createQuery(cr);
			List<HargaModel> result = q.getResultList();
			Float harga = result.get(idHarga-1).getHarga();

			//  TOTAL HARGA	
			Integer totalHarga = (int) (quantity * harga);

			//	TOTAL BAYAR
			Integer totalBayar = (int) (quantity * harga);
	
			TransaksiModel tm = new TransaksiModel();
			
			
//	SET TRANSAKSI	
	tm.setHarga(harga);
	tm.setIdJadwal(idJadwal);
	tm.setQuantity(quantity);
	tm.setTotalHarga(totalHarga);
	tm.setTotalBayar(totalBayar);
	tm.setTanggal(tanggal);
		
//	SAVE TRANSAKSI
	session.save(tm);
	
//	COMMIT 
	session.getTransaction().commit();



	
	
}
	

	public static boolean check(Integer id) {
		boolean check = true;
		try {
			SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
			Session session = sessionFactory.openSession();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaUpdate<FilmModel> updateCriteria = cb.createCriteriaUpdate(FilmModel.class);
			Root<FilmModel> root = updateCriteria.from(FilmModel.class);
			FilmModel jadwal = session.find(FilmModel.class, id);

			if (jadwal == null) {
				return check = false;
			}
			
			session.getTransaction().commit();

		} catch (IllegalStateException e) {
			// TODO: handle exception
		}
		return check;

	}
}
