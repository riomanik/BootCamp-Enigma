package com.enigma.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name = "transaksi")
public class TransaksiModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_transaksi")
	private Integer idTransaksi;
	
	 
	@Column(name = "quantity")
	private Integer Quantity;
	
	@Column(name = "total_harga")
	private Integer totalHarga;
	
	@Column(name = "total_bayar")
	private Integer totalBayar;
	
	@Column(name = "tanggal")
	private String tanggal;
	
	@Column(name = "harga")
	private float harga;
	
	@Column(name = "id_jadwal")
	private Integer idJadwal;
	
	@ManyToOne
	@JoinColumn(name = "id_jadwal", insertable = false,updatable = false)
	JadwalModel jadwal;

	
	
	

	public Integer getIdJadwal() {
		return idJadwal;
	}

	public void setIdJadwal(Integer idJadwal) {
		this.idJadwal = idJadwal;
	}

	public String getTanggal() {
		return tanggal;
	}

	public void setTanggal(String tanggal) {
		this.tanggal = tanggal;
	}

	public JadwalModel getJadwal() {
		return jadwal;
	}

	public void setJadwal(JadwalModel jadwal) {
		this.jadwal = jadwal;
	}



	public float getHarga() {
		return harga;
	}

	public void setHarga(float harga) {
		this.harga = harga;
	}

	public Integer getIdTransaksi() {
		return idTransaksi;
	}

	public void setIdTransaksi(Integer idTransaksi) {
		this.idTransaksi = idTransaksi;
	}



	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	public Integer getTotalHarga() {
		return totalHarga;
	}

	public void setTotalHarga(Integer totalHarga) {
		this.totalHarga = totalHarga;
	}

	public Integer getTotalBayar() {
		return totalBayar;
	}

	public void setTotalBayar(Integer totalBayar) {
		this.totalBayar = totalBayar;
	}

	@Override
	public String toString() {
		return "TransaksiModel [idTransaksi=" + idTransaksi + ", Quantity=" + Quantity + ", totalHarga=" + totalHarga
				+ ", totalBayar=" + totalBayar + ", tanggal=" + tanggal + ", jadwal=" + jadwal + ", harga=" + harga
				+ "]";
	}






	

	
	
}
