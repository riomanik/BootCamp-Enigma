package com.mobileHeroes;

import java.util.Scanner;

public class Display {
	
	public Integer printMenuMain() {
    	System.out.println("|------------------------------|");
    	System.out.println("|         Game Hero            |");
    	System.out.println("|------------------------------|");
    	System.out.println("|                              |");
    	System.out.println("| 1. Create Character          |");
    	System.out.println("| 2. List Character            |");
    	System.out.println("| 3. Hero add Friends          |");
    	System.out.println("| 4. List Friends              |");
    	System.out.println("| 5. Attack                    |");
    	System.out.println("| 6. Exit                      |");
    	System.out.println();
    	System.out.print  ("Masukkan Perintah = ");
    	Scanner in = new Scanner(System.in);
    	Integer pilihan = in.nextInt();
    	return pilihan;
	}
	
	public Integer PrintCreateChar() {
    	System.out.println("|----------------------------|");
		System.out.println("|     CREATE CHARACTER       |");
		System.out.println("|----------------------------|");
		System.out.println("| 1. Create Heroes           |");
		System.out.println("| 2. Create Tower            |");
		System.out.println("| 3. Create Minion           |");
		System.out.println("| 4. EXIT                    |");
		System.out.println("|----------------------------|");
		System.out.println();

		System.out.println("Masukkan Input = ");
		Scanner in = new Scanner(System.in);
		Integer pilihan = in.nextInt();
		return pilihan;
    }
	
	public Integer ChoseCharacter() {
		System.out.println("|----------------------------|");
		System.out.println("|     CREATE CHARACTER       |");
		System.out.println("|----------------------------|");
		System.out.println("| 1. Tank                    |");
		System.out.println("| 2. Assassin                |");
		System.out.println("| 3. Priest                  |");
		System.out.println("| 4. EXIT                    |");
		System.out.println("|----------------------------|");
		System.out.println();

		System.out.println("Masukkan Input = ");
		Scanner in = new Scanner(System.in);
		Integer pilihan = in.nextInt();
		return pilihan;
		
	};
	
	public Integer ListCharacter() {
		System.out.println("|----------------------------|");
		System.out.println("|     LIST CHARACTER         |");
		System.out.println("|----------------------------|");
		System.out.println("| 1. HEROES                  |");
		System.out.println("| 2. TOWER                   |");
		System.out.println("| 3. MINION                  |");
		System.out.println("| 4. EXIT                    |");
		System.out.println("|----------------------------|");
		System.out.println();

		System.out.println("Masukkan Input = ");
		Scanner in = new Scanner(System.in);
		Integer pilihan = in.nextInt();
		return pilihan;
	}
	
	public Integer AddHeroes() {
		System.out.println("|----------------------------|");
		System.out.println("|     PILIH  CHARACTER       |");
		System.out.println("|----------------------------|");
		System.out.println("| 1. Tank                    |");
		System.out.println("| 2. Assassin                |");
		System.out.println("| 3. Priest                  |");
		System.out.println("| 4. EXIT                    |");
		System.out.println("|----------------------------|");
		System.out.println();

		System.out.println("Masukkan Input = ");
		Scanner in = new Scanner(System.in);
		Integer pilihan = in.nextInt();
		return pilihan;
}
	public Integer PreAttack() {
		System.out.println("|----------------------------|");
		System.out.println("|     PILIH  CHARACTER       |");
		System.out.println("|----------------------------|");
		System.out.println("| 1. Tank                    |");
		System.out.println("| 2. Assassin                |");
		System.out.println("| 3. Priest                  |");
		System.out.println("| 4. EXIT                    |");
		System.out.println("|----------------------------|");
		System.out.println();

		System.out.println("Pilih Character yang mau Attack = ");
		Scanner in = new Scanner(System.in);
		Integer pilihan = in.nextInt();
		return pilihan;
	}
	
}

