package com.enigma;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.omg.IOP.TransactionService;

import com.enigma.model.TransactionDetailModel;
import com.enigma.model.TransactionFullModel;
import com.enigma.model.TransactionHeaderModel;
import com.enigma.service.TransactionDetailService;
import com.enigma.service.TransactionFull;
import com.enigma.service.TransactionHeaderSevice;

import ConnectDB.ConnectDB;

public class Appilication {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Appilication apl = new Appilication();
		apl.start();
	}
static //	
	String Tampung;
	String TRX;
	
	
		public void start() {
		TransactionHeaderModel customer = login();
		Integer pilihan;
		do {
			pilihan = PrintMenu();
			
			switch (pilihan) {
			case 1:		
				break;			
			case 2:
				TransactionHeaderSevice.ShowAll(Tampung);
						
				List<TransactionFullModel> listFull = TransactionFull.displayAllTransaction(customer);
				Integer Jumlah = 0;
				for (int i=0; i<listFull.size(); i++) {
					TransactionFullModel temp = listFull.get(i);
					System.out.println(" "+(i+1)+". ");
					System.out.println(" Item Name \t :" + temp.getItemName() + "       ");
					System.out.println(" Quantity \t :" + temp.getQuantity() + " ");
					System.out.println(" Price \t\t :" + temp.getPrice() + "      ");
					Integer total = Integer.valueOf(temp.getQuantity())*temp.getPrice().intValue();
					Jumlah += total;
				}
				
					System.out.println("========================================");
					System.out.println(" Total Harga \t : "+Jumlah);

				break;
			case 3:
				TransactionFull.displayAllTransactionALL();
				
				break;
			case 4:
				System.out.println("Masukkan ID = ");
				Scanner in = new Scanner(System.in);
				String temp1 = in.nextLine();
				
				TransactionHeaderSevice.ShowAll2(temp1);
				
				List<TransactionFullModel> listFullid = TransactionFull.displayAllTransactionById(temp1);
				Integer Jumlah2 = 0;
				for (int i=0; i<listFullid.size(); i++) {
					TransactionFullModel temp = listFullid.get(i);
					System.out.println(" "+(i+1)+". ");
					System.out.println(" Item Name \t :" + temp.getItemName() + "       ");
					System.out.println(" Quantity \t :" + temp.getQuantity() + " ");
					System.out.println(" Price \t\t :" + temp.getPrice() + "      ");
					Integer total = Integer.valueOf(temp.getQuantity())*temp.getPrice().intValue();
					Jumlah2 += total;
				}
				
					System.out.println("========================================");
					System.out.println(" Total Harga \t : "+Jumlah2);
//				
				break;
			case 5:
				break;
			}
		} while (pilihan != 4);
	}
	
//	public void CreateTrx() {
//
//		TransactionHeaderModel customer = login();
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
//		
//	}
		public static TransactionHeaderModel login() {
			System.out.println("LOGIN = ");
			Scanner in = new Scanner(System.in);
			Tampung = in.nextLine();
			TransactionHeaderModel customer = null;
			customer = TransactionHeaderSevice.addUser(Tampung);
			return customer;
			
		}
		
		public void transaction() {
			try {
				Connection con = ConnectDB.getConnection();
				Scanner scan = new Scanner(System.in);
				String noTrx = login().getNoTrx();
				con.setAutoCommit(false);
				do {
					Scanner scan1 = new Scanner(System.in);
					System.out.println("Nama Item = ");
					String item = scan1.nextLine();
					System.out.println("Quantity = ");
					Integer quantity = scan1.nextInt();
					System.out.println("Price = ");
					BigDecimal price = scan1.nextBigDecimal();
					TransactionDetailService.addTransaction(login(), item, quantity, price);
					System.out.println("Select 1 next Item or Select 2 End of Transaction ");
					for
					
					con.commit();
					
				} while (condition);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	public Integer PrintMenu() {
		System.out.println("|===========================================|");
    	System.out.println("|          MINIMARKET                       |");
    	System.out.println("|===========================================|");
    	System.out.println("|                                           |");
    	System.out.println("| 1. CREATE TRANSAKSI                       |");
    	System.out.println("| 2. DISPLAY TRANSAKSI                      |");
    	System.out.println("| 3. REPORT                                 |");
    	System.out.println("| 4. SHOW BY ID                             |");
    	System.out.println("| 5. EXIT                                   |");
    	System.out.println("|===========================================|");
    	System.out.println();
    	System.out.print  (" Masukkan Perintah = ");
    	Scanner in = new Scanner(System.in);
    	Integer pilihan = in.nextInt();
    	return pilihan;

	}
	
	

}
