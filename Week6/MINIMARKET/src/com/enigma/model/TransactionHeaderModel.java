package com.enigma.model;

public class TransactionHeaderModel {

	private String noTrx;
	private String trxDate;
	private String userId;
	
	
	public TransactionHeaderModel(String noTrx, String trxDate, String userId) {
		super();
		this.noTrx = noTrx;
		this.trxDate = trxDate;
		this.userId = userId;
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

	
	
	
	
}
