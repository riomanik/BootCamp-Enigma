package com.enigma.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "harga")
public class HargaModel {
	public static final String FIELD_ID = "idHarga";
	public static final String FIELD_HARGA= "Harga";
	public static final String FIELD_HARI = "Hari";
	public static final String FIELD_STUDIO= "Studio";
		@Id
		@Column(name = "id_harga")
		private Integer idHarga;		

		
		@Column(name = "harga")
		private float Harga;
		
		@Column(name = "hari")
		private String Hari;
		
		@ManyToOne
		@JoinColumn(name = "id_studio")
		StudioModel studio;


		
		public StudioModel getStudio() {
			return studio;
		}

		public void setStudio(StudioModel studio) {
			this.studio = studio;
		}

		public Integer getIdHarga() {
			return idHarga;
		}

		public void setIdHarga(Integer idHarga) {
			this.idHarga = idHarga;
		}
		
		public float getHarga() {
			return Harga;
		}

		public void setHarga(float harga) {
			Harga = harga;
		}

		public String getHari() {
			return Hari;
		}

		public void setHari(String hari) {
			Hari = hari;
		}

		@Override
		public String toString() {
			return "HargaModel [idHarga=" + idHarga + ", idStudio=" + ", Harga=" + Harga + ", Hari=" + Hari
					+ "]";
		}
		
		
		
		
		
		
}
