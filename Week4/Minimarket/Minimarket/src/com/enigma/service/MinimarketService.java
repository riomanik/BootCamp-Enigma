//package com.enigma.service;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//
//import ConnectDB.ConnectDB;
//
//public class MinimarketService {
//
//
//	private static Statement stat;
//	private static PreparedStatement stmt;
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Date dt = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//		String ds = sdf.format(dt);
//		
//		String query = "SELECT no_trx FROM transaction_header where no_trx LIKE ?";
//		
//		try {
//			PreparedStatement psmt = ConnectDB.getConnection().prepareStatement(query);
//			psmt.setString(1, ds + "%");
//			ResultSet rs = psmt.executeQuery();
//			
//			ArrayList<String> list = new ArrayList<String>();
//			
//			while(rs.next()) {
//				list.add(rs.getString("no_trx"));
//			}
//			
//			System.out.println(ds + String.format("/%3d", list.size()+ 1).replaceAll(" ", "0"));
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//
//	}
//	
//	
//	public void CreateTrx() {
//		try {
//			Connection con = ConnectDB.getConnection();
//			con.setAutoCommit(false);
//			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//			System.out.println("||===============================||");
//			System.out.println("||        DAFTAR TRANSAKSI       ||");
//			System.out.println("||===============================||");
//			System.out.print("|| 1.Nama Item = ");
//			String itemName = reader.readLine();
//			System.out.print("|| 2.Quantity = ");
//			String quantity = reader.readLine();
//			System.out.print("|| 3.Price = ");
//			String price = reader.readLine();
//				
//				TransactionDetailService.addTransaction(customer, itemName, quantity, price);
//			}
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("MAAF TRANSAKSI GAGAL DI PROSES KARENA SALAH INPUT");
//		}
//		
//		
//	}
//	
//	public static List<CustomerTransactionModel> displayAllTransaction(CustomerModel customer) {
//		List<CustomerTransactionModel> listCustTransServ = new ArrayList<CustomerTransactionModel>();
//		try {
//			Connection con = ConnectDB.getConnection();
//			String sql = "SELECT h.trx_id, h.trx_date, h.user_id, d.detail_id, d.item_name, d.quantity, d.price FROM trx_header h "
//					+ "JOIN trx_detail d "
//					+ "ON d.trx_id = h.trx_id "
//					+ "WHERE d.trx_id = ?";
//			PreparedStatement prep = con.prepareStatement(sql);
//			prep.setString(1, customer.getNoTrx());
//			ResultSet rs = prep.executeQuery();
//			
//			while(rs.next()) {
//				listCustTransServ.add(new CustomerTransactionModel(rs.getString("trx_id"), rs.getString("trx_date"), rs.getString("user_id"), rs.getInt("detail_id"), rs.getString("item_name"), rs.getInt("quantity"), rs.getBigDecimal("price")));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return listCustTransServ;
//	}
//
//	
//	
//}
