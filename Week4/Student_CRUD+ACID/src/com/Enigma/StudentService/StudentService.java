package com.Enigma.StudentService;

import java.awt.List;
import java.sql.Connection;

import com.Enigma.ConnectDB.ConnectDB;
import com.Enigma.StudentModel.StudentModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentService {
	public static ArrayList<StudentModel> arrStudent = new ArrayList<StudentModel>();
	public static ArrayList<StudentModel> getStudentByKota(String birth_place) {
//		ArrayList<StudentModel> std = null;
		try {
			
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT id,nama,birth_place,birth_date, gender FROM ms_student where birth_place = ?";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(1, birth_place);
			ResultSet rs = prep.executeQuery();
			
			while(rs.next()) {
				arrStudent.add(new StudentModel(
						rs.getInt("id"),
						rs.getString("nama"),
						rs.getString("birth_place"),
						rs.getDate("birth_date"),
						rs.getString("gender")
						));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return arrStudent ;
	}


}
