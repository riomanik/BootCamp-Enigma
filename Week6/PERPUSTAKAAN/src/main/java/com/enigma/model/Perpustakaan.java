package com.enigma.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "perpus", uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Perpustakaan {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length=20, nullable=false, unique=true)
    private Integer idBuku;
 
    @Column(name = "nama", length=100, nullable=true)
    private String namaBuku;
 
    @Column(name="author", length=100, nullable=true)
    private String authorBuku;
    
    @Column(name="genre", length=100, nullable=true)
    private String genreBuku;
    
    @Column(name="tahun_terbit", length=100, nullable=true)
    private Integer tahun_terbitBuku;
    
//    @Transient
//    @Column(name="stock_totalBuku", length=100, nullable=true)
//    private Long stock_totalBuku;
//    @Transient
    
   
    @Column(name="total_stock", length=100, nullable=true)
    private Integer total_stockBuku;
    
    @Column(name="curent_stock", length=100, nullable=true)
    private Integer curent_stockBuku;
   
    
    public Perpustakaan() {}

    
    
	public Perpustakaan(Integer idBuku, String namaBuku, String authorBuku, String genreBuku, Integer tahun_terbitBuku,
			Integer total_stockBuku, Integer curent_stockBuku) {
		super();
		this.idBuku = idBuku;
		this.namaBuku = namaBuku;
		this.authorBuku = authorBuku;
		this.genreBuku = genreBuku;
		this.tahun_terbitBuku = tahun_terbitBuku;
		this.total_stockBuku = total_stockBuku;
		this.curent_stockBuku = curent_stockBuku;
	}
	
	
	
	




	public Perpustakaan(Integer tahun_terbitBuku, Integer stock_totalBuku) {
		super();
		this.tahun_terbitBuku = tahun_terbitBuku;
		this.total_stockBuku = stock_totalBuku;
	}

	public void setStock_totalBuku(Integer stock_totalBuku) {
		this.total_stockBuku = stock_totalBuku;
	}
	
	public Integer getStock_totalBuku() {
		return total_stockBuku;
	}

	public Integer getIdBuku() {
		return idBuku;
	}

	public void setIdBuku(Integer idBuku) {
		this.idBuku = idBuku;
	}

	public String getNamaBuku() {
		return namaBuku;
	}

	public void setNamaBuku(String namaBuku) {
		this.namaBuku = namaBuku;
	}

	public String getAuthorBuku() {
		return authorBuku;
	}

	public void setAuthorBuku(String authorBuku) {
		this.authorBuku = authorBuku;
	}

	public String getGenreBuku() {
		return genreBuku;
	}

	public void setGenreBuku(String genreBuku) {
		this.genreBuku = genreBuku;
	}

	public Integer getTahun_terbitBuku() {
		return tahun_terbitBuku;
	}

	public void setTahun_terbitBuku(Integer tahun_terbitBuku) {
		this.tahun_terbitBuku = tahun_terbitBuku;
	}

	public Integer getTotal_stockBuku() {
		return total_stockBuku;
	}

	public void setTotal_stockBuku(Integer total_stockBuku) {
		this.total_stockBuku = total_stockBuku;
	}

	public Integer getCurent_stockBuku() {
		return curent_stockBuku;
	}

	public void setCurent_stockBuku(Integer curent_stockBuku) {
		this.curent_stockBuku = curent_stockBuku;
	}



	@Override
	public String toString() {
		return "Perpustakaan [idBuku=" + idBuku + ", namaBuku=" + namaBuku + ", authorBuku=" + authorBuku
				+ ", genreBuku=" + genreBuku + ", tahun_terbitBuku=" + tahun_terbitBuku + ", total_stockBuku="
				+ total_stockBuku + ", curent_stockBuku=" + curent_stockBuku + "]";
	}


    

		
		
		
	
}
