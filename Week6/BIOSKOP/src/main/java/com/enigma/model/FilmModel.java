package com.enigma.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "film")
public class FilmModel {
	public static final String FIELD_ID = "idFilm";
	public static final String FIELD_NAMA_FILM = "namaFilm";
		@Id
		@Column(name = "id_film")
		private Integer idFilm;
		
		@Column(name = "nama_film")
		private String namaFilm;

		public Integer getIdFilm() {
			return idFilm;
		}

		public void setIdFilm(Integer idFilm) {
			this.idFilm = idFilm;
		}

		public String getNamaFilm() {
			return namaFilm;
		}

		public void setNamaFilm(String namaFilm) {
			this.namaFilm = namaFilm;
		}

		@Override
		public String toString() {
			return "FilmModel [idFilm=" + idFilm + ", namaFilm=" + namaFilm + "]";
		}

		
		
		
		
}



