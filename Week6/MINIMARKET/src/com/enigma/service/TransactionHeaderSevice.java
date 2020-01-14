package com.enigma.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.enigma.model.TransactionHeaderModel;

import ConnectDB.ConnectDB;

public class TransactionHeaderSevice {

	public static String generateNoTrx() {
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String noTrx = sdf.format(date) + "/" + (countRows() + 1);
		return noTrx;
	}

	public static String getDateTrx() {
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String noTrx = sdf.format(date);
		return noTrx;
	}

	public static int countRows() {
		int numOfRows = 0;
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT * FROM trx_header";
			PreparedStatement prep = con.prepareStatement(sql);
			ResultSet rs = prep.executeQuery();
			while (rs.next()) {
				numOfRows++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return numOfRows;
	}

	public static void ShowAll(String customer) {
		try {
			Connection con = ConnectDB.getConnection();
			String sql1 = "SELECT trx_id,trx_date,user_id FROM trx_header where user_id = ?";
			PreparedStatement prep = con.prepareStatement(sql1);
			prep.setString(1, customer);
			ResultSet rs = prep.executeQuery();
			if (rs.next()) {
				System.out.println("========================================");
				System.out.println("               Transaksi                   ");
				System.out.println("========================================");
				System.out.println(" No TRX \t :" + rs.getString("trx_id") + "       ");
				System.out.println(" TRX DATE \t :" + rs.getString("trx_date") + " ");
				System.out.println(" UserId \t :" + rs.getString("user_id") + "      ");
				System.out.println("========================================");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	public static void ShowAll2(String customer) {
		try {
			Connection con = ConnectDB.getConnection();
			String sql1 = "SELECT trx_id,trx_date,user_id FROM trx_header where trx_id = ?";
			PreparedStatement prep = con.prepareStatement(sql1);
			prep.setString(1, customer);
			ResultSet rs = prep.executeQuery();
			if (rs.next()) {
				System.out.println("========================================");
				System.out.println("               Transaksi                   ");
				System.out.println("========================================");
				System.out.println(" No TRX \t :" + rs.getString("trx_id") + "       ");
				System.out.println(" TRX DATE \t :" + rs.getString("trx_date") + " ");
				System.out.println(" UserId \t :" + rs.getString("user_id") + "      ");
				System.out.println("========================================");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
	}

	public static TransactionHeaderModel addUser(String name) {
		TransactionHeaderModel customer = null;
		try {
			Connection con = ConnectDB.getConnection();
			String userId = name;
			String noTrx = generateNoTrx();
			String trxDate = getDateTrx();
			con.setAutoCommit(false);
			String sql = "INSERT INTO trx_header VALUES (?,?,?)";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(1, noTrx);
			prep.setString(2, trxDate);
			prep.setString(3, userId);
			prep.executeUpdate();
			customer = new TransactionHeaderModel(noTrx, trxDate, userId);
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

}
