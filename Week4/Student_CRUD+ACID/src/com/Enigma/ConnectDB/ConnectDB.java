package com.Enigma.ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
		static final String DRIVER = "com.mysql.jdbc.Driver";
		static final String URL = "jdbc:mysql://localhost/pascal2";
		static final String USER = "root";
		static final String PASS = "";
		
		private static Connection con;
		
		private ConnectDB(){
			
		} 
		private static void openConnection() throws SQLException, ClassNotFoundException {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL,USER,PASS);
		}
		
		public static Connection getConnection() throws ClassNotFoundException, SQLException {
			if(con==null)
				openConnection();
				return con;
		
	}

}
