package com.enigma.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "studio")
public class StudioModel {
	public static final String FIELD_ID = "idStudio";
	public static final String FIELD_NAMA_STUDIO= "namaStudio";
	public static final String FIELD_TOTAL_KURSI = "totalKursi";
		@Id
		@Column(name = "id_studio")
		private String idStudio;
		
		@Column(name = "nama_studio")
		private String namaStudio;
		
		@Column(name = "total_kursi")
		private Integer totalKursi;
		
//		@OneToMany
//		@Column(name = "id_harga")
//		private HargaModel harga;
		
		

	

//		public HargaModel getHarga() {
//			return harga;
//		}
//
//		public void setHarga(HargaModel harga) {
//			this.harga = harga;
//		}

		public String getIdStudio() {
			return idStudio;
		}

		public void setIdStudio(String idStudio) {
			this.idStudio = idStudio;
		}

		public String getNamaStudio() {
			return namaStudio;
		}

		public void setNamaStudio(String namaStudio) {
			this.namaStudio = namaStudio;
		}

		public Integer getTotalKursi() {
			return totalKursi;
		}

		public void setTotalKursi(Integer totalKursi) {
			this.totalKursi = totalKursi;
		}

		@Override
		public String toString() {
			return "StudioModel [idStudio=" + idStudio + ", namaStudio=" + namaStudio + ", totalKursi=" + totalKursi
					+ "]";
		}

		

		
		
}
