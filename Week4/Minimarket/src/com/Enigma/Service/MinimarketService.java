package com.Enigma.Service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.Enigma.ConnectDB.ConnectDB;
import com.Enigma.Model.MinimarketModel;

public class MinimarketService {

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
			String sql = "SELECT * FROM trc_header";
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

	public static MinimarketModel addKasir(String name) {
		MinimarketModel customer = null;
		try {
			Connection con = ConnectDB.getConnection();
			String userId = name;
			String noTrc = generateNoTrx();
			String trcDate = getDateTrx();
			con.setAutoCommit(false);
			String sql = "INSERT INTO trc_header VALUES (?,?,?)";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(1, noTrc);
			prep.setString(2, trcDate);
			prep.setString(3, userId);
			prep.executeUpdate();
			customer = new MinimarketModel(noTrc, trcDate, userId);
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	
	 
	public static void addTransaction(MinimarketModel kasir, String itemName, Integer quantity, BigDecimal price) {
		try {
			Connection con = ConnectDB.getConnection();
			Scanner scan = new Scanner(System.in);
			String noTrc = kasir.getNoTransaction();
			con.setAutoCommit(false);
			String sql = "INSERT INTO trc_detail VALUES (null,?,?,?,?)";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(1, noTrc);
			prep.setString(2, itemName);
			prep.setInt(3, quantity);
			prep.setBigDecimal(4, price);
			prep.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<MinimarketModel> displayAllTransactionByNama(String customer) {
		List<MinimarketModel> listFull = new ArrayList<MinimarketModel>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT h.trc_id, h.trc_date, h.user_id, d.detail_id, d.item_name, d.quantity, d.price\r\n" + 
							"FROM trc_header h\r\n" + 
							"JOIN trc_detail d ON d.trc_id = h.trc_id\r\n" + 
							"WHERE h.user_id = ? ";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(1, customer);
			ResultSet rs = prep.executeQuery();
			
			while(rs.next()) {
				listFull.add(new MinimarketModel(
						rs.getString("trc_id"), 
						rs.getString("trc_date"), 
						rs.getString("user_id"), 
						rs.getInt("detail_id"), 
						rs.getString("item_name"), 
						rs.getInt("quantity"), 
						rs.getBigDecimal("price")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listFull;
	}
	
	public static List<MinimarketModel> displayAllTransactionByNoTrc(String customer) {
		List<MinimarketModel> listFull = new ArrayList<MinimarketModel>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT h.trc_id, h.trc_date, h.user_id, d.detail_id, d.item_name, d.quantity, d.price\r\n" + 
							"FROM trc_header h\r\n" + 
							"JOIN trc_detail d ON d.trc_id = h.trc_id\r\n" + 
							"WHERE h.trc_id = ? ";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(1, customer);
			ResultSet rs = prep.executeQuery();
			
			while(rs.next()) {
				listFull.add(new MinimarketModel(
						rs.getString("trc_id"), 
						rs.getString("trc_date"), 
						rs.getString("user_id"), 
						rs.getInt("detail_id"), 
						rs.getString("item_name"), 
						rs.getInt("quantity"), 
						rs.getBigDecimal("price")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listFull;
	}
	
	
	public static List<MinimarketModel> displayReport() {
		List<MinimarketModel> listFull4 = new ArrayList<MinimarketModel>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT substr(h.trc_date,1,4) as Tahun, "
					+ "substr(h.trc_date,6,2) as Bulan, "
					+ "count(distinct h.trc_id) as jumlahTransaksiPerBulan, "
					+ "sum(d.price*d.quantity) as TotalJumlahTransaksi "
					+ "FROM trc_header h JOIN trc_detail d ON d.trc_id = h.trc_id "
					+ "group by Tahun,Bulan ";
			PreparedStatement prep = con.prepareStatement(sql);
			ResultSet rs = prep.executeQuery();
			
			while(rs.next()) {
				MinimarketModel list = new MinimarketModel(rs.getInt("Tahun"), rs.getInt("Bulan"), rs.getInt("jumlahTransaksiPerBulan"), rs.getInt("TotalJumlahTransaksi"));
				listFull4.add(list);
//						rs.getInt('Tahun'), 
//						rs.getInt('Bulan'),
//						rs.getInt('jumlahTransaksiPerBulan'),
//						rs.getInt('TotalJumlahTransaksi'));
				
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listFull4;
	}
	
	
	
	
	
	
}