import java.io.IOException;
import java.util.Scanner;

public class AppProp {

	private static void start() throws IOException {
		Scanner inInt = new Scanner(System.in);
		int pilih;
		do {
			tampilMenu();
			System.out.print("Pilih menu [1-4] : ");
			pilih = inInt.nextInt();
			switch (pilih) {
			case 1:				
				PropService.print();
				break;
			case 2:
				tambahProp();
				break;
			case 3:
				ubahProp();
				break;
			case 4:
				System.out.println("Anda Keluar Aplikasi");
				break;

			default:
				System.out.println("input yang benar ya [1-4]");
				break;
			}

		} while (pilih != 4);
	}

	private static void tampilMenu() {
		System.out.println("Menu Data Config Properties");
		System.out.println("===========================");
		System.out.println("1. Print Semua Value" + "\n2. Tambah Value " + "\n3. Ubah Value " + "\n4. Exit");
	}

	private static void ubahProp() {
		System.out.println("Update value");
    	Scanner update = new Scanner(System.in);
    	System.out.println("Input key:");
		String key = update.nextLine();
		System.out.println("Input value:");
		String value = update.nextLine();
        PropService.updateValue(key, value);
	}
	

	private static void tambahProp() {
		Scanner inInt = new Scanner(System.in);
		System.out.println("Masukan jumlah properties yang diinginkan");
		Integer tot = inInt.nextInt();
		for(int i=0; i<tot; i++) {
			Scanner input = new Scanner(System.in);
        	System.out.println("Input key:");
			String key = input.nextLine();
			System.out.println("Input value:");
			String value = input.nextLine();
            PropService.updateValue(key, value);
        }
	}

	public static void main(String[] args)throws IOException {
		start();
	}



}
