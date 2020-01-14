package com.enigma.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.enigma.model.TransactionFullModel;
import com.enigma.model.TransactionHeaderModel;

import ConnectDB.ConnectDB;

public class TransactionFull {
	public static List<TransactionFullModel> displayAllTransaction(TransactionHeaderModel customer) {
		List<TransactionFullModel> listFull = new ArrayList<TransactionFullModel>();
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT h.trx_id, h.trx_date, h.user_id, d.detail_id, d.item_name, d.quantity, d.price "
					+ "FROM trx_header h "
					+ "JOIN trx_detail d ON d.trx_id = h.trx_id "
					+ "WHERE h.user_id = ?";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(1, customer.getUserId());
			ResultSet rs = prep.executeQuery();
			
			while(rs.next()) {
				listFull.add(new TransactionFullModel(
						rs.getString("trx_id"), 
						rs.getString("trx_date"), 
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

	

		public static List<TransactionFullModel> displayAllTransactionById(String temp) {
			List<TransactionFullModel> listFull = new ArrayList<TransactionFullModel>();
			try {
				Connection con = ConnectDB.getConnection();
				String sql = "SELECT h.trx_id, h.trx_date, h.user_id, d.detail_id, d.item_name, d.quantity, d.price "
						+ "FROM trx_header h "
						+ "JOIN trx_detail d ON d.trx_id = h.trx_id "
						+ "WHERE d.trx_id = ?";
				PreparedStatement prep = con.prepareStatement(sql);
				prep.setString(1, temp);
				ResultSet rs = prep.executeQuery();
				
				while(rs.next()) {
					listFull.add(new TransactionFullModel(
							rs.getString("trx_id"), 
							rs.getString("trx_date"), 
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

	
		
		public static List<TransactionFullModel> displayAllTransactionALL() {
			
			List<TransactionFullModel> listFull = new ArrayList<TransactionFullModel>();
			try {
				Connection con = ConnectDB.getConnection();
				String sql = "SELECT h.trx_id, h.trx_date, h.user_id, d.detail_id, d.item_name, d.quantity, d.price "
						+ "FROM trx_header h "
						+ "JOIN trx_detail d ON d.trx_id = h.trx_id "
						+ "WHERE h.trx_date between '2019-10-17' and '2020-10-17' ";
				PreparedStatement prep = con.prepareStatement(sql);
				ResultSet rs = prep.executeQuery();
				
				while(rs.next()) {
					listFull.add(new TransactionFullModel(
							rs.getString("trx_id"), 
							rs.getString("trx_date"), 
							rs.getString("user_id"), 
							rs.getInt("detail_id"), 
							rs.getString("item_name"), 
							rs.getInt("quantity"), 
							rs.getBigDecimal("price")));
				}
				
				Integer Jumlah = 0;
				for (int i=0; i<listFull.size(); i++) {
					TransactionFullModel temp = listFull.get(i);
					System.out.println(" "+(i+1)+". ");
					System.out.println(" NO TRX \t :" + temp.getNoTrx() + "       ");
					System.out.println(" TANGGAL TRX \t :" + temp.getTrxDate() + "       ");
					System.out.println(" USER ID \t :" + temp.getUserId() + "       ");
					System.out.println(" Item Name \t :" + temp.getItemName() + "       ");
					System.out.println(" Quantity \t :" + temp.getQuantity() + " ");
					System.out.println(" Price \t\t :" + temp.getPrice() + "      ");
					Integer total = Integer.valueOf(temp.getQuantity())*temp.getPrice().intValue();
					Jumlah += total;
				}
				
					System.out.println("========================================");
					System.out.println(" Total Harga \t : "+Jumlah);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return listFull;
		}
		
		
	
}
