package parkiran;

import java.util.Scanner;

import com.app.Heroes;

public class LahanParkir {
	Kendaraan Slot[] = new Kendaraan[5];
	int Tampung = 5;
	int i;

	public Integer PrintLahanParkir() {
		System.out.println("--------Lahan Parkir--------");
		System.out.println("--------Masukkan Data--------");
		System.out.println("Jumlah Slot yang Tersedia =  " + Tampung);
		System.out.println();
		System.out.println("1 . Daftarkan Kendaraan  ");
		System.out.println("2 . Daftar Kendaraan yang ada di dalam");
		System.out.println("3 . Keluar dari Parkir ");
		System.out.println("Masukkan Perintah = ");
		Scanner in = new Scanner(System.in);
		Integer No = in.nextInt();
		return No;
	}

	public void TambahMotor() {
		for (int i = 0; i < Slot.length; i++) {
			if (Slot[i].getPlat() == null && Tampung != 0) {
				System.out.println("Daftarkan Motor Anda ");
				System.out.println();
				System.out.println("Masukkan Plat Motor Anda = ");
				Scanner in = new Scanner(System.in);
				String number = in.nextLine();
				System.out.println("Masukkan Warna Motor Anda = ");
				Scanner out = new Scanner(System.in);
				String color = out.nextLine();
				Slot[i] = new Kendaraan(number, color);

				Tampung -= 1;
				break;
			}
		}
		System.out.println("Maaf Parkiran Sudah Penuh");
	}

	public void DaftarKendaraan() {
		System.out.println("+---------------------------------------");
		System.out.println("|        DAFTAR  KENDARAAN             |");
		System.out.println("+--------------------------------------+");
		for (int i = 0; i < Slot.length; i++) {
			if (Slot[i].getPlat() != null) {
				System.out.println("| Plat Nomor\t\t : " + Slot[i].getPlat());
				System.out.println("| Warna Kendaraan\t\t : " + Slot[i].getWarna());
				System.out.println("\n");
			}
		}

	}

	public void KeluarParkir() {

		int i;
		System.out.println("Masukkan Plat Motor Anda = ");
		Scanner out = new Scanner(System.in);
		String plat = out.nextLine();
		System.out.println("Masukkan Warna Motor Anda = ");
		Scanner in = new Scanner(System.in);
		String warna = in.nextLine();
		for (i = 0; i < Slot.length; i++) {
			if (Slot[i].getPlat() != null && Slot[i].getPlat().equals(plat) && Slot[i].getWarna().equals(warna)) {
				Slot[i] = new Kendaraan();

				Tampung += 1;
				System.out.println("Kendaraan Keluar Parkir");

			} 
			System.out.println("TIDAK ADA KENDARAAN");
		}
//		System.out.println("Cari Motor Anda ");
//		System.out.println();
//		System.out.println("Masukkan Plat Motor Anda = ");
//		Scanner in = new Scanner(System.in);
//		String nomor = in.nextLine();
//		System.out.println("Masukkan Warna Motor Anda = ");
//		Scanner out = new Scanner(System.in);
//		String warna = out.nextLine();
//		for (int i = 0; i < Slot.length; i++) {
//			if (Slot[i].getPlat() == null) {
//				Tampung += 1;
//			}
//		} System.out.println("Kendaraan Tidak ditemukan");
//		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LahanParkir l = new LahanParkir();
		for (int i = 0; i < 5; i++) {
			l.Slot[i] = new Kendaraan();
		}
//		l.Slot[0] = new Kendaraan();
//		l.Slot[1] = new Kendaraan();
//		l.Slot[2] = new Kendaraan();
//		l.Slot[3] = new Kendaraan();
//		l.Slot[4] = new Kendaraan();
		l.start();
	}

	public void start() {
		Integer Pilihan;
		do {
			Pilihan = PrintLahanParkir();
			switch (Pilihan) {
			case 1:
				TambahMotor();
				break;
			case 2:
				DaftarKendaraan();
				break;
			case 3:
				KeluarParkir();
				break;
			case 4:
				break;
			}
		} while (Pilihan != 5);
		System.out.println("Balik");

	}

}
