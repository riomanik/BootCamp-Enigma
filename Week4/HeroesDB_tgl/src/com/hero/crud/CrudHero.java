package com.hero.crud;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CrudHero {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/hero";
	static final String USER = "root";
	static final String PASS = "";
	
	static Connection conn;
	static Statement stat;
	static PreparedStatement stmt;
	static ResultSet rs;
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CrudHero c = new CrudHero();
		c.start();
	}

	
	public Integer printMenuMain() {
    	System.out.println("|------------------------------|");
    	System.out.println("|          Heroes              |");
    	System.out.println("|------------------------------|");
    	System.out.println("|                              |");
    	System.out.println("| 1. INSERT HERO               |");
    	System.out.println("| 2. SHOW HERO / READ ALL      |");
    	System.out.println("| 3. SHOW HERO BY NAMA         |");
    	System.out.println("| 4. UPDATE                    |");
    	System.out.println("| 5. DELETE                    |");
    	System.out.println("| 6. Exit                      |");
    	System.out.println();
    	System.out.print  ("Masukkan Perintah = ");
    	Scanner in = new Scanner(System.in);
    	Integer pilihan = in.nextInt();
    	return pilihan;
	}
	
	public void start() {
		CrudHero c = new CrudHero();
		Integer pilihan;
		do {
			pilihan = printMenuMain();
			switch (pilihan) {
			case 1:
				c.Create();
				break;
			case 2:
				c.ShowAll();
				break;
			case 3:
				c.ShowByNama();
				break;
			case 4:
				c.Update();
				break;
			case 5:
				c.Delete();
				break;
			case 6:
				System.out.println("Sistem Log Out");
				System.exit(0);
				break;
			}
			
		} while (pilihan != 6 );
	}
	
	public void Create() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stat = conn.createStatement();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Masukkan ID Heroes = ");
			String keyword5 = reader.readLine();
			System.out.print("Masukkan Nama Heroes = ");
			String keyword = reader.readLine();
			System.out.print("Masukkan HP = ");
			String keyword2 = reader.readLine();
			System.out.print("Masukkan Damaged = ");
			String keyword3 = reader.readLine();
			String sql = "INSERT INTO listhero(id,nama,hp,damaged) values(?,?,?,?)";
//			stmt = conn.prepareStatement(sql);
			stmt.setString(1, keyword5);
			stmt.setString(2, keyword);
			stmt.setString(3, keyword2);
			stmt.setString(4, keyword3);
			stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
	}
	public void ShowAll() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stat = conn.createStatement();
			String sql1 = "SELECT * FROM listhero";
			stmt = conn.prepareStatement(sql1);
			rs = stmt.executeQuery(sql1);
			while(rs.next()) {
				System.out.println("----------------------------------------");
				System.out.println("               HEROES                   ");
				System.out.println("----------------------------------------");
				System.out.println(" id Hero \t :" + rs.getInt("id")+ "       ");
				System.out.println(" nama Hero \t :" + rs.getString("nama")+" ");
				System.out.println(" HP Hero \t :" + rs.getInt("hp") + "      ");
				System.out.println(" Damaged Hero \t :" + rs.getInt("hp")+ "  ");
				System.out.print("----------------------------------------");
				System.out.println();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
			
		}
	}
	
	public void ShowByNama() {		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stat = conn.createStatement();
			System.out.print("Masukkan Nama Heroes Yang Ingin Di tampilkan = ");
			Scanner in = new Scanner(System.in);
			String keyword = in.nextLine();
			String query = "select * from listhero where nama like  ? ";
		    stmt = conn.prepareStatement(query);
		    stmt.setString(1, "%"+keyword+"%");
			rs = stmt.executeQuery();
			while(rs.next()) {
				System.out.println("---------------------------------------------");
				System.out.println("                   HEROES                    ");
				System.out.println("---------------------------------------------");
				System.out.println("id hero \t: " + rs.getInt("id")+"            ");
				System.out.println("nama hero \t: " + rs.getString("nama")+"     ");
				System.out.println(("hp hero \t: " + rs.getInt("hp"))+"          ");
				System.out.println(("damaged hero \t: " + rs.getInt("damaged"))+"");
				System.out.print("----------------------------------------");
				System.out.println();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
	}
	
	

	public void Update() {
		CrudHero c = new CrudHero();
		c.ShowAll();
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stat = conn.createStatement();
			System.out.print("Masukkan ID Heroes Yang Ingin Di Ubah = ");
			Scanner in = new Scanner(System.in);
			Integer keyword = in.nextInt();
			System.out.print("Masukkan Nama Heroes = ");
			Scanner in2 = new Scanner(System.in);
			String keyword3 = in2.nextLine();
			System.out.print("Masukkan HP = ");
			Scanner in3 = new Scanner(System.in);
			String keyword4 = in3.nextLine();
			System.out.print("Masukkan Damaged = ");
			Scanner in4 = new Scanner(System.in);
			String keyword5 = in4.nextLine();
			String query = "update listhero set nama = ? , hp = ? , damaged = ? where id like ?";
		    stmt = conn.prepareStatement(query);
		    stmt.setString(1, keyword3);
		    stmt.setString(2, keyword4);
		    stmt.setString(3, keyword5);
		    stmt.setInt(4, keyword);
			stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
	}
	
	public void Delete() {
		CrudHero c = new CrudHero();
		c.ShowAll();
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stat = conn.createStatement();
			System.out.print("Masukkan ID Heroes Yang Ingin Di Hapus = ");
			Scanner in = new Scanner(System.in);
			Integer keyword = in.nextInt();
			String query = "Delete from listhero where id like ? ";
		    stmt = conn.prepareStatement(query);
		    stmt.setInt(1, keyword);
			stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
	}
	
}
