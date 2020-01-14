package com.Enigma.ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {
		static final String DRIVER = "com.mysql.jdbc.Driver";
		static final String URL = "jdbc:mysql://localhost/minimarket";
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
