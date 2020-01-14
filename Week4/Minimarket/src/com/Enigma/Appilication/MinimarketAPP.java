package com.Enigma.Appilication;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import com.Enigma.ConnectDB.ConnectDB;
import com.Enigma.Model.MinimarketModel;
import com.Enigma.Service.MinimarketService;

public class MinimarketAPP {

	static String Tampung;
	MinimarketModel customer = login();
	MinimarketService MS = new MinimarketService();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimarketAPP App = new MinimarketAPP();
		App.start();
	}

	public Integer PrintMenu() {
		System.out.println("|===========================================|");
		System.out.println("|               GO-MART                     |");
		System.out.println("|===========================================|");
		System.out.println("|                                           |");
		System.out.println("| 1. CREATE TRANSAKSI                       |");
		System.out.println("| 2. SHOW ALL BY USER ID                    |");
		System.out.println("| 3. SHOW ALL BY TRANSACTION ID             |");
		System.out.println("| 4. REPORT                                 |");
		System.out.println("| 5. EXIT                                   |");
		System.out.println("|===========================================|");
		System.out.println();
		System.out.print(" Masukkan Perintah = ");
		Scanner in = new Scanner(System.in);
		Integer pilihan = in.nextInt();
		return pilihan;

	}

	public void start() {
		Integer pilihan;
		do {
			pilihan = PrintMenu();
			switch (pilihan) {
			case 1:
				transaction();
				break;
			case 2:
				displayAllByNama();
				break;
			case 3:
				displayAllById();
				break;
			case 4:
				displayReport();
				break;
			case 5:
				System.out.println("System Keluar");
				System.exit(0);
				break;
			}
		} while (pilihan != 5);
	}

	public static MinimarketModel login() {
		System.out.println("|========================================|");
		System.out.println("|               GO-MART                  |");
		System.out.println("|========================================|");
		System.out.print("| USER LOGIN  = ");
		Scanner in = new Scanner(System.in);
		Tampung = in.nextLine();
		MinimarketModel customer = null;
		return customer;

	}

	public void transaction() {
		boolean bol = true;
		boolean bol_item = true;
		boolean bol_quantity = true;
		boolean bol_price = true;
		String item;
		Integer quantity;
		BigDecimal price;
		customer = MinimarketService.addKasir(Tampung);
		do {
			try {
				Connection con = ConnectDB.getConnection();
				Scanner scan = new Scanner(System.in);
				String noTrx = customer.getNoTransaction();
				con.setAutoCommit(false);
				Scanner scan1 = new Scanner(System.in);
				do {
					System.out.println("========================================");
					System.out.println("               GO-MART                  ");
					System.out.println("========================================");
					System.out.print(" 1. Nama Item = ");
					item = scan1.nextLine();
					if(item.length() > 100) {
						System.out.println("Character tidak boleh lebih dari 100 CHaracter");
					} else {
						bol_item = false;
					}
					
				} while (bol_item);
				do {
					System.out.println("========================================");
					System.out.println("               GO-MART                  ");
					System.out.println("========================================");
					System.out.print(" 2. Quantity = ");
					quantity = scan1.nextInt();
					if(quantity.intValue() < 0 ) {
						System.out.println("Jumlah Barang tidak boleh kurang dari 0 ");
					} else {
						bol_quantity = false;
					}
				} while (bol_quantity);
				do {
					System.out.println("========================================");
					System.out.println("               GO-MART                  ");
					System.out.println("========================================");
					System.out.print(" 3. Price = ");
					price = scan1.nextBigDecimal();
					if (price.intValue() < 0 ) {
						System.out.println("Harga tidak boleh kurang dari 0");
					}else {
							bol_price = false;
						
					}
					
				} while (bol_price);
				MinimarketService.addTransaction(customer, item, quantity, price);
				System.out.println("Tekan Y untuk melanjutkan input");
				Scanner inn = new Scanner(System.in);
				String out = inn.nextLine();

				if (!out.equalsIgnoreCase("y")) {
					con.commit();
					bol = false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} while (bol);
	}

	public void displayAllByNama() {
		System.out.println("========================================");
		System.out.println("               GO-MART                  ");
		System.out.println("========================================");
		System.out.print(" Masukkan Nama Yang ingin dicari = ");
		Scanner in = new Scanner(System.in);
		String out = in.nextLine();
		try {
			Connection con = ConnectDB.getConnection();
			String sql1 = "SELECT trc_id,trc_date,user_id FROM trc_header where user_id = ?";
			PreparedStatement prep = con.prepareStatement(sql1);
			prep.setString(1, out);
			ResultSet rs = prep.executeQuery();
			if (rs.next()) {
				System.out.println("========================================");
				System.out.println("               GO-MART                  ");
				System.out.println("========================================");
				System.out.println(" No TRX \t :" + rs.getString("trc_id") + "       ");
				System.out.println(" TRX DATE \t :" + rs.getString("trc_date") + " ");
				System.out.println(" UserId \t :" + rs.getString("user_id") + "      ");
				System.out.println("========================================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<MinimarketModel> listFull = MinimarketService.displayAllTransactionByNama(out);
		Integer Jumlah = 0;
		for (int i = 0; i < listFull.size(); i++) {
			MinimarketModel temp = listFull.get(i);
			System.out.println(" " + (i + 1) + ". ");
			System.out.println(" Item Name \t :" + temp.getItemName() + "       ");
			System.out.println(" Quantity \t :" + temp.getQuantity() + " ");
			System.out.println(" Price \t\t :" + temp.getPrice() + "      ");
			Integer total = Integer.valueOf(temp.getQuantity()) * temp.getPrice().intValue();
			Jumlah += total;
		}

		System.out.println("========================================");
		System.out.println(" Total Harga \t : " + Jumlah);
	}

	public void displayAllById() {
		System.out.println("Masukkan NO TRANSACTION Yang ingin dicari = ");
		Scanner in = new Scanner(System.in);
		String out = in.nextLine();
		try {
			Connection con = ConnectDB.getConnection();
			String sql1 = "SELECT trc_id,trc_date,user_id FROM trc_header where trc_id = ?";
			PreparedStatement prep = con.prepareStatement(sql1);
			prep.setString(1, Tampung);
			ResultSet rs = prep.executeQuery();
			if (rs.next()) {
				System.out.println("========================================");
				System.out.println("               GO-MART                  ");
				System.out.println("========================================");
				System.out.println(" No TRX \t :" + rs.getString("trc_id") + "       ");
				System.out.println(" TRX DATE \t :" + rs.getString("trc_date") + " ");
				System.out.println(" UserId \t :" + rs.getString("user_id") + "      ");
				System.out.println("========================================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<MinimarketModel> listFull = MinimarketService.displayAllTransactionByNoTrc(out);
		Integer Jumlah = 0;
		for (int i = 0; i < listFull.size(); i++) {
			MinimarketModel temp = listFull.get(i);
			System.out.println(" " + (i + 1) + ". ");
			System.out.println(" Item Name \t :" + temp.getItemName() + "       ");
			System.out.println(" Quantity \t :" + temp.getQuantity() + " ");
			System.out.println(" Price \t\t :" + temp.getPrice() + "      ");
			Integer total = Integer.valueOf(temp.getQuantity()) * temp.getPrice().intValue();
			Jumlah += total;
		}

		System.out.println("========================================");
		System.out.println(" Total Harga \t : " + Jumlah);
	}
	public void displayReport() {
	List<MinimarketModel> listFull10 = MinimarketService.displayReport();

	for (int i=0; i<listFull10.size(); i++) {
		MinimarketModel temp = listFull10.get(i);
		System.out.println("|======================================================================|");
		System.out.println("|               GO-MART                                                 ");
		System.out.println("|======================================================================|");
		System.out.println("|======================================================================|");
		System.out.println("| LAPORAN TRANSAKSI DALAM KURUN WAKTU SEBULAN ");
		System.out.println("|=======================================================================");
		System.out.println("| TAHUN \t\t\t\t :" + temp.getTahun() + "       ");
		System.out.println("| BULAN \t\t\t\t :" + temp.getBulan() + "       ");
		System.out.println("| JUMLAH TRANSAKSI PER BULAN \t\t :" + temp.getJumlahTransaksiperBulan() + "       ");
		System.out.println("| TOTAL TRANSAKSI \t\t\t :" + temp.getTotalJumlahTransaksi() + "       ");
		System.out.println("|=======================================================================");
	}

	}
}
