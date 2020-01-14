package com.enigma.main;

import java.util.Scanner;

public class MainMenu {
	static public Integer printMenu() {
		System.out.println("|===========================================|");
		System.out.println("|              BIOSKOP                      |");
		System.out.println("|===========================================|");
		System.out.println("|                                           |");
		System.out.println("| 1. LIST FILM                              |");
		System.out.println("| 2. LIST JADWAL                            |");
		System.out.println("| 3. LIST STUDIO                            |");
		System.out.println("| 4. ALL TRANSACTION                        |");
		System.out.println("| 5. EXIT                                   |");
		System.out.println("|===========================================|");
		System.out.println();
		System.out.print(" Masukkan Perintah = ");
		Scanner in = new Scanner(System.in);
		Integer pilihan = in.nextInt();
		return pilihan;

	}
	
	static public Integer printMenuAwal() {
		System.out.println("|===========================================|");
		System.out.println("|              BIOSKOP                      |");
		System.out.println("|===========================================|");
		System.out.println("|                                           |");
		System.out.println("| 1. FILM                                   |");
		System.out.println("| 2. JADWAL                                 |");
		System.out.println("| 3. STUDIO                                 |");
		System.out.println("| 4. BELI TICKET                            |");
		System.out.println("| 5. SHOW LIST                              |");
		System.out.println("| 6. EXIT                                   |");
		System.out.println("|===========================================|");
		System.out.println();
		System.out.print(" Masukkan Perintah = ");
		Scanner in = new Scanner(System.in);
		Integer pilihan = in.nextInt();
		return pilihan;

	}
	
	
}
