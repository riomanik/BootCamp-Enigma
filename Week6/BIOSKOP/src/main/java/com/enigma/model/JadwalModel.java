package com.enigma.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.criteria.Path;

import com.google.protobuf.Field;
import com.mysql.cj.x.protobuf.MysqlxCursor.Fetch;

import net.bytebuddy.agent.builder.AgentBuilder.RawMatcher.Inversion;

@Entity
@Table(name = "jadwal")
public class JadwalModel {
	
		public static final String FIELD_ID = "idJadwal";
		public static final String FIELD_TANGGAL = "tanggal";
		public static final String FIELD_JAM_MULAI = "jam_mulai";
		public static final String FIELD_JAM_SELESAI = "jam_selesai";
		public static final String FIELD_FILM = "film";
		public static final String FIELD_STUDIO = "studio";
		@Id
		@Column(name = "id_jadwal")
		private Integer idJadwal;
		
		@Column(name = "tanggal")
		private Date tanggal;
		
		@Column(name = "jam_mulai")
		private String jamMulai;
		
		@Column(name = "jam_selesai")
		private String jamSelesai;

		
		@ManyToOne
		@JoinColumn(name = "id_film")
		FilmModel film;
		
		@ManyToOne()
		@JoinColumn(name = "id_studio")
		StudioModel studio;
		
	


		
		


		public StudioModel getStudio() {
			return studio;
		}

		public void setStudio(StudioModel studio) {
			this.studio = studio;
		}

		public FilmModel getFilm() {
			return film;
		}

		public void setFilm(FilmModel film) {
			this.film = film;
		}

		public Integer getIdJadwal() {
			return idJadwal;
		}

		public void setIdJadwal(Integer idJadwal) {
			this.idJadwal = idJadwal;
		}

		public Date getTanggal() {
			return tanggal;
		}

		public void setTanggal(Date tanggal) {
			this.tanggal = tanggal;
		}

		public String getJamMulai() {
			return jamMulai;
		}

		public void setJamMulai(String jamMulai) {
			this.jamMulai = jamMulai;
		}

		public String getJamSelesai() {
			return jamSelesai;
		}

		public void setJamSelesai(String jamSelesai) {
			this.jamSelesai = jamSelesai;
		}




		@Override
		public String toString() {
			return "JadwalModel [idJadwal=" + idJadwal + ", tanggal=" + tanggal + ", jamMulai=" + jamMulai
					+ ", jamSelesai=" + jamSelesai + "]";
		}
		
		
		
	


		





		
		
}
