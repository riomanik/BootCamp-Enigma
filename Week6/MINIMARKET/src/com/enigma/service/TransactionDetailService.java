package com.enigma.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Scanner;

import com.enigma.model.TransactionHeaderModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ConnectDB.ConnectDB;

public class TransactionDetailService {
	public static void addTransaction(TransactionHeaderModel customer, String itemName, int quantity, BigDecimal price) {
		try {
			Connection con = ConnectDB.getConnection();
			Scanner scan = new Scanner(System.in);
			String noTrx = customer.getNoTrx();
			con.setAutoCommit(false);
			String sql = "INSERT INTO trx_detail VALUES (null,?,?,?,?)";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(1, noTrx);
			prep.setString(2, itemName);
			prep.setInt(3, quantity);
			prep.setBigDecimal(4, price);
			prep.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
