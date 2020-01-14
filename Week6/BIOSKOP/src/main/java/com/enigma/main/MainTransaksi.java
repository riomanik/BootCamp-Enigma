package com.enigma.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.omg.CORBA.Current;

import com.enigma.config.HibernateConfig;
import com.enigma.model.FilmModel;
import com.enigma.model.HargaModel;
import com.enigma.model.JadwalModel;
import com.enigma.model.StudioModel;
import com.enigma.model.TransaksiModel;
import com.enigma.service.ServiceTransaksi;

public class MainTransaksi {

	public void transaksi() {	
	Scanner in = new Scanner(System.in);
	
	
	MainFilm.tampilFilm();
	System.out.println("Masukkan ID Jadwal Yang ingin di pilih = ");
	Integer idFilm = in.nextInt();
//			MainJadwal.tampilJadwal();
			tampilFilm(idFilm);
	System.out.println("Masukkan ID Jadwal Yang ingin di pilih = ");
	Integer idJadwal = in.nextInt();		
			MainHarga.tampilHarga();

	System.out.println("Pilih ID Pembayaran");
	Integer idHarga = in.nextInt();
	
	System.out.println("Masukkan jumlah Ticket yang ingin di pesan = ");
	Integer quantity = in.nextInt();	
	ServiceTransaksi.ServTrans(idHarga,quantity,idJadwal);
			
	}
	
	public static void tampil() {
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<TransaksiModel> cr = cb.createQuery(TransaksiModel.class);
		Root<TransaksiModel> root1 = cr.from(TransaksiModel.class);
		cr.select(root1);
		session.beginTransaction();
		Query<TransaksiModel> q1 = session.createQuery(cr);
		List<TransaksiModel> result1 = q1.getResultList();
		for (TransaksiModel hargaModel : result1) {
			System.out.println("|======================================================================");
			System.out.println("|id \t\t = " + hargaModel.getIdTransaksi());
			System.out.println("|Nama Film \t = " + hargaModel.getJadwal().getFilm().getNamaFilm());
			System.out.println("|Jam Mulai  \t = " + hargaModel.getJadwal().getJamMulai());
			System.out.println("|Jam Selesai  \t = " + hargaModel.getJadwal().getJamSelesai());
			System.out.println("|quantity  \t = " + hargaModel.getQuantity());
			System.out.println("|tanggal  \t = " + hargaModel.getTanggal());
			System.out.println("|totalBayar \t = "+hargaModel.getTotalBayar());
			System.out.println("|totalHarga \t = " + hargaModel.getTotalHarga());
		}
		session.getTransaction().commit();
	}
	
	static public void tampilFilm(Integer idFilm) {
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<JadwalModel> cr = cb.createQuery(JadwalModel.class);
		Root<JadwalModel> root = cr.from(JadwalModel.class);
		Join<JadwalModel, FilmModel> joinfilm = root.join(JadwalModel.FIELD_FILM, JoinType.INNER);
		
//		cr.select(root).where(cb.equal(root.get("studio"),idFilm));
		cr.select(root).where(cb.equal(joinfilm.get(FilmModel.FIELD_ID).as(Integer.class),idFilm));
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

	private static Expression<Boolean> cb(Expression<Integer> as, Integer idFilm) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
