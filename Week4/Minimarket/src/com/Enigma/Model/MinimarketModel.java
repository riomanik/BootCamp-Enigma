package com.Enigma.Model;

import java.math.BigDecimal;

public class MinimarketModel {
	private String noTransaction;
	private String tanggalTransaction;
	private String userId;
	private Integer detailTransaction;
	private String itemName;
	private Integer quantity;
	private BigDecimal price;
	private Integer tahun;
	private Integer bulan;
	private Integer jumlahTransaksiperBulan;
	private Integer totalJumlahTransaksi;
	
	
	
	
	
	

	public MinimarketModel(Integer tahun, Integer bulan, Integer jumlahTransaksiperBulan,
			Integer totalJumlahTransaksi) {
		super();
		this.tahun = tahun;
		this.bulan = bulan;
		this.jumlahTransaksiperBulan = jumlahTransaksiperBulan;
		this.totalJumlahTransaksi = totalJumlahTransaksi;
	}

//	public MinimarketModel(Integer tahun, Integer bulan, Integer jumlahTransaksiperBulan,
//			Integer totalJumlahTransaksi) {
//		super();
//		setTahun(tahun);
//		setBulan(bulan);
//		this.setJumlahTransaksiperBulan(jumlahTransaksiperBulan);
//		setTotalJumlahTransaksi(totalJumlahTransaksi);
//	}

	public MinimarketModel(String noTransaction, String tanggalTransaction, String userId, Integer detailTransaction,
			String itemName, Integer quantity, BigDecimal price) {
		super();
		this.noTransaction = noTransaction;
		this.tanggalTransaction = tanggalTransaction;
		this.userId = userId;
		this.detailTransaction = detailTransaction;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
	}
	
//	public TransactionFullModel(String noTrx, String trxDate, String userId, Integer detailId, String itemName,
//			Integer quantity, BigDecimal price) {
//		super();
//		this.noTrx = noTrx;
//		this.trxDate = trxDate;
//		this.userId = userId;
//		this.detailId = detailId;
//		this.itemName = itemName;
//		this.quantity = quantity;
//		this.price = price;
//	}

	public MinimarketModel(String noTransaction, String tanggalTransaction, String userId) {
		super();
		this.noTransaction = noTransaction;
		this.tanggalTransaction = tanggalTransaction;
		this.userId = userId;
	}

	public MinimarketModel(Integer detailTransaction, String itemName, Integer quantity, BigDecimal price) {
		super();
		this.detailTransaction = detailTransaction;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
	}
	
	
	
	
	
	

	public String getNoTransaction() {
		return noTransaction;
	}

	public void setNoTransaction(String noTransaction) {
		this.noTransaction = noTransaction;
	}

	public String getTanggalTransaction() {
		return tanggalTransaction;
	}

	public void setTanggalTransaction(String tanggalTransaction) {
		this.tanggalTransaction = tanggalTransaction;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getDetailTransaction() {
		return detailTransaction;
	}

	public void setDetailTransaction(Integer detailTransaction) {
		this.detailTransaction = detailTransaction;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getTahun() {
		return tahun;
	}

	public void setTahun(Integer tahun) {
		this.tahun = tahun;
	}

	public Integer getBulan() {
		return bulan;
	}

	public void setBulan(Integer bulan) {
		this.bulan = bulan;
	}

	public Integer getJumlahTransaksiperBulan() {
		return jumlahTransaksiperBulan;
	}

	public void setJumlahTransaksiperBulan(Integer jumlahTransaksiperBulan) {
		this.jumlahTransaksiperBulan = jumlahTransaksiperBulan;
	}

	public Integer getTotalJumlahTransaksi() {
		return totalJumlahTransaksi;
	}

	public void setTotalJumlahTransaksi(Integer totalJumlahTransaksi) {
		this.totalJumlahTransaksi = totalJumlahTransaksi;
	}

}
