package com.enigma.model;

import java.math.BigDecimal;

public class TransactionFullModel {
	private String noTrx;
	private String trxDate;
	private String userId;
	private Integer detailId;
	private String itemName;
	private Integer quantity;
	private BigDecimal price;
	
	public TransactionFullModel(String noTrx, String trxDate, String userId, Integer detailId, String itemName,
			Integer quantity, BigDecimal price) {
		super();
		this.noTrx = noTrx;
		this.trxDate = trxDate;
		this.userId = userId;
		this.detailId = detailId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
	}

	public String getNoTrx() {
		return noTrx;
	}

	public void setNoTrx(String noTrx) {
		this.noTrx = noTrx;
	}

	public String getTrxDate() {
		return trxDate;
	}

	public void setTrxDate(String trxDate) {
		this.trxDate = trxDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getDetailId() {
		return detailId;
	}

	public void setDetailId(Integer detailId) {
		this.detailId = detailId;
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

	
	
	
}
