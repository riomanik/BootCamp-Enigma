package com.Enigma.Appilication;

import java.util.ArrayList;
import java.util.Scanner;

import com.Enigma.StudentModel.StudentModel;
import com.Enigma.StudentService.StudentService;

public class Appilication {
	private void start() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Masukkan kota yang dicari : ");
		String input = scan.nextLine();
		
		ArrayList<StudentModel> std = StudentService.getStudentByKota(input);
//		System.out.println(std);
		
		if(std != null)
		for (int i=0 ; i < std.size() ; i++){
////			System.out.println(std.toString());
			System.out.println(std.get(i).getId());
			System.out.println(std.get(i).getName());
			System.out.println(std.get(i).getBirth_place());
			System.out.println(std.get(i).getBirth_date());
			System.out.println(std.get(i).getGender());
		}else {
			System.out.println("Data tidak ditemukan");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Appilication Apl = new Appilication();
		Apl.start();
	}

}
