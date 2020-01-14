package com.app;

import java.util.Scanner;

public class HeroesKu {
	Scanner in = new Scanner(System.in);
	int jumlahArray = 5;
	Heroes arrHero[] = new Heroes[jumlahArray];
	int i;

	public static void main(String[] args) {
		HeroesKu c = new HeroesKu();
		for (int i = 0; i < 5; i++) {
			c.arrHero[i] = new Heroes();
		}

		c.start();

	}

	public Integer printMenuAndGetInput() {
		System.out.println("|----------------------------|");
		System.out.println("|        KOLEKSI HERO        |");
		System.out.println("|----------------------------|");
		System.out.println("| 1. Tambah Hero             |");
		System.out.println("| 2. Ubah Hero               |");
		System.out.println("| 3. Lihat Semua Hero        |");
		System.out.println("| 4. Hapus Hero              |");
		System.out.println("| 5. Keluar                  |");
		System.out.println("|----------------------------|");

		System.out.println("Masukkan Input = ");
		Integer pilihan = in.nextInt();
		return pilihan;

	}

	void tambahHero() {
		System.out.println("|               KOLEKSI HERO              |");
		System.out.println("===========================================");

		for (int i = 0; i < arrHero.length; i++) {
			if (arrHero[i].getName() == null) {
				System.out.println("Masukkan Nama		: ");
				Scanner name = new Scanner(System.in);
				String nama = name.nextLine();
				System.out.println("Masukkan HP			: ");
				Scanner p = new Scanner(System.in);
				Integer hp = p.nextInt();
				System.out.println("Masukkan Mana		: ");
				Scanner mn = new Scanner(System.in);
				Integer mana = mn.nextInt();
				System.out.println("Masukkan Damaged	: ");
				Scanner dmg = new Scanner(System.in);
				Integer damaged = dmg.nextInt();
				arrHero[i] = new Heroes(nama, hp, mana, damaged);
				break;
			}
		}
		
	}
	void daftarHero() {
		System.out.println("+---------------------------------------");
		System.out.println("|        DAFTAR  HERO                  |");
		System.out.println("+--------------------------------------+");
		for (int i = 0; i < arrHero.length; i++) {
			if (arrHero[i].getName() != null) {
				System.out.println("| Nama\t\t : " + arrHero[i].getName());
				System.out.println("| HP\t\t : " + arrHero[i].getHp());
				System.out.println("| Mana\t\t : " + arrHero[i].getMana());
				System.out.println("| Damaged\t : " + arrHero[i].getDamage());
				System.out.println("\n");
			}
		}
		System.out.println("+---------------------------------------");

	}

	void hapusArray() {
		int i;
		System.out.println("Masukkan nama array yang mau di Hapus = ");
		Scanner out = new Scanner(System.in);
		String del = out.nextLine();
		for (i = 0; i < arrHero.length; i++) {
			if (arrHero[i].getName() != null && arrHero[i].getName().equals(del)) {
				arrHero[i] = new Heroes(); 

			}
		}
	}

	void UpdateArray() {
		int i;
		System.out.println("Masukkan nama array yang mau di rubah = ");
		Scanner out = new Scanner(System.in);
		String del = out.nextLine();
		for (i = 0; i < arrHero.length; i++) {
			if (arrHero[i].getName() != null && arrHero[i].getName().equals(del)) {
				System.out.println("Masukkan Nama		: ");
				Scanner name = new Scanner(System.in);
				String nama = name.nextLine();
				System.out.println("Masukkan HP			: ");
				Scanner p = new Scanner(System.in);
				Integer hp = p.nextInt();
				System.out.println("Masukkan Mana		: ");
				Scanner mn = new Scanner(System.in);
				Integer mana = mn.nextInt();
				System.out.println("Masukkan Damaged	: ");
				Scanner dmg = new Scanner(System.in);
				Integer damaged = dmg.nextInt();
				arrHero[i] = new Heroes(nama, hp, mana, damaged);
				;
			}
		}
	}

	public void start() {
		Integer pilihan;
		do {
			pilihan = printMenuAndGetInput();

			switch (pilihan) {
			case 1:
				tambahHero();
				break;
			case 2:
				UpdateArray();
				break;
			case 3:
				daftarHero();
				break;
			case 4:
				hapusArray();
				break;

			default:
				System.out.println("Tidak Valid");
				System.exit(0);

			}
		} while (pilihan != 5);
		System.out.println("System Keluar");
		System.exit(0);

	}

//	public String printArray() {
//		;
//	}

}