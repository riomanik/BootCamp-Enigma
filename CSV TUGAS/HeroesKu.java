package com.enigma.camp.LatihanHeroes.src.com.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.sun.glass.ui.Size;

public class HeroesKu {
	ArrayList<Heroes> arrHero = new ArrayList<Heroes>();
	private String file = "E:/heroes.csv";



	public HeroesKu() {
		FileReader fr = null;
		BufferedReader br = null;

			try {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				String str = "";

				// Looping input arraylist
				while (str != null) {
					str = br.readLine();
					if (str != null) {
						arrHero.add(new Heroes(str));
					}
				}
				
			} catch (FileNotFoundException e) {
				// TODO: handle exception
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				if (fr != null) {
					try {
						fr.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		
			
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
		Scanner in = new Scanner(System.in);
		Integer pilihan = in.nextInt();
		return pilihan;

	}

	void tambahHero() {
		System.out.println("|               KOLEKSI HERO              |");
		System.out.println("===========================================");

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
		arrHero.add(new Heroes(nama, hp, mana, damaged));
		save();

	}

	void daftarHero() {
		System.out.println("+---------------------------------------");
		System.out.println("|        DAFTAR  HERO                  |");
		System.out.println("+--------------------------------------+");
		for (Heroes heroes : arrHero) {
			System.out.println(heroes.print());
		}
		System.out.println("+---------------------------------------");

	}

	void hapusArray() {
		int i;
		daftarHero();
		System.out.println("Masukkan angka array yang mau di Hapus = ");
		Scanner out = new Scanner(System.in);
		int del = out.nextInt();

		arrHero.remove(del);
		save();

	}

	void UpdateArray() {
		int i;

		daftarHero();
		System.out.println("Masukkan nama array yang mau di rubah = ");
		Scanner out = new Scanner(System.in);
		Integer del = out.nextInt();

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

		arrHero.set(del, new Heroes(nama, hp, mana, damaged));
		save();

	}
	public void save() {
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			for (Heroes h : arrHero) {
				bw.write(h.toString() + "\n");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
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

	public static void main(String[] args) {
		HeroesKu c = new HeroesKu();

		c.start();

	}
}
