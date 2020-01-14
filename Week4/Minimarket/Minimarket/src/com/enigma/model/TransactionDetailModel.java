package com.enigma.model;

import java.math.BigDecimal;

public class TransactionDetailModel {
	private String detailId;
	private String noTrx;
	private String itemName;
	private Integer quantity;
	private BigDecimal price;
	
	
	public TransactionDetailModel(String detailId, String noTrx, String itemName, Integer quantity, BigDecimal price) {
		super();
		this.detailId = detailId;
		this.noTrx = noTrx;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
	}
	
	public String getDetailId() {
		return detailId;
	}
	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}
	public String getNoTrx() {
		return noTrx;
	}
	public void setNoTrx(String noTrx) {
		this.noTrx = noTrx;
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
