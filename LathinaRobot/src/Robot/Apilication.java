package Robot;
import java.util.Random;
import java.util.Scanner;

public class Apilication {
	int X ;
	int Y ;
	int E ;
	Scanner in = new Scanner(System.in);
	
	public int Display() {
		
		System.out.println("X = " + X);
		System.out.println("Y = " + Y);
		System.out.println("Fuel = " + E);
		
		System.out.println();
		System.out.println("---------MENU---------");
		System.out.println("1.   Utara");
		System.out.println("2.   Selatan");
		System.out.println("3.   Barat");
		System.out.println("4.   Timur");
		System.out.println("5.   COMBO");
		System.out.println("5.   Keluar");
		
		System.out.println("Masukkan perintah : ");
		Scanner input = new Scanner(System.in);
		int perintah = input.nextInt();
		return perintah;
		
				
	}
	public void Utara() {
		if (Y >= 10) {
			System.out.println("PERHATIAN! Batas Limit Utara Tercapai");
		} else if (E == 0 ) {
			System.out.println("Bensin Habis");
		} else {
			this.Y += 1;
			this.E -= 1;
		}
		
	}
	
	public void Selatan() {
		if (Y <= -10) {
			System.out.println("PERHATIAN! Batas Limit Selatan Tercapai");
		} else if (E == 0 ) {
			System.out.println("Bensin Habis");
		} else {
			this.Y -= 1;
			this.E -= 1;
		}
		
	}
	
	public void Barat() {
		if (X >= 10) {
			System.out.println("PERHATIAN! Batas Limit Barat Tercapai");
		} else if (E == 0 ) {
			System.out.println("Bensin Habis");
		} else {
			this.X += 1;
			this.X -= 1;
		}
		
	}
	public void Timur() {
		if (X >= 10) {
			System.out.println("PERHATIAN! Batas Limit Timur Tercapai");
			System.out.println("you are out of Fuel");
		} else {
			this.X -= 1;
			this.E -= 1;
		}
		
	}
	public void Combo() {
		
	}
	
	
	
	public void mulai() {
		
		X = new Random().nextInt(10) +1;
		Y = new Random().nextInt(10) +1;
		E = new Random().nextInt(16) +5;
		
		int pilihan;
		do {
			
				
		pilihan = Display();
		
		switch (pilihan) {
		case 1:
			Utara();
			break;
		case 2:
			Selatan();
			break;
		case 3:
			Barat();
			break;
		case 4:
			Timur();
			break;
		case 5:
			Combo();
			break;
		case 6:
			System.out.println("SEE YOU ON NEXT TRIP");
			System.exit(0);
		}
	} while (pilihan !=6); {
		System.out.println("You are out of range");
	}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Apilication A = new Apilication();
			A.mulai();
		
	}

}
