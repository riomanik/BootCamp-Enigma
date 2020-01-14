package konversi;

import java.util.Scanner;

public class conversi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		conversi c = new conversi();
		c.start();
	}
		
		public Integer Menu() {
			System.out.println("Apilikasi Conversi");
			System.out.println(" 1. Decimal To Binner ");
			System.out.println(" 2. Biner To Decimal ");
			System.out.println(" 3. Decimal To Octal");
			System.out.println(" 4. Octal to Decimal");
			System.out.println(" 5. Decimal to Hexadecimal");
			System.out.println(" 6. Hexadecimal to Decimal");
			System.out.println("");
			
			System.out.println("Masukkan Inputan = ");
			Scanner in = new Scanner(System.in);
			Integer temp = in.nextInt();
			return temp;
		}
		void start() {
			Integer pilihan;
			do {
				pilihan = Menu();
				switch (pilihan) {
				case 1:
					decimalToBinner();
					break;
				case 2:
					binarytodecimal();
					break;
				case 3:
					decimalToOctal();
					break;
				case 4:
					OctaltoDecimal();
					break;
				case 5:
					decimalToHexadecimal();
					break;
				case 6:
					HexadecimalToDecimal();
					break;
				}
			} while (pilihan !=7);
		}
		
		
// 1. Decimal TO Binner
		public void decimalToBinner() {
		
		int n, count = 0, a;
		String x = "";
		Scanner s = new Scanner(System.in);
		System.out.print("Enter any decimal number:");
		n = s.nextInt();
		while (n > 0) {
			a = n % 2;
			if (a == 1) {
				count++;
			}
			x = a + "" + x;
			n = n / 2;
		}
		System.out.println("Binary number:" + x);
		System.out.println("No. of 1s:" + count);
		
}
// 2 . Binner To Decimal
		void binarytodecimal() {
			System.out.println();
			System.out.println("Masukkan Angka Binner = ");
			Scanner in = new Scanner(System.in);
			Integer out = in.nextInt();
			System.out.println(binaryToDecimal(out));
		}
// 3 . Decimal To Octal		
		void decimalToOctal() {
			System.out.println();
			System.out.println("Masukkan Angka Decimal = ");
			Scanner in = new Scanner(System.in);
			Integer out = in.nextInt();
			System.out.println(toOctal(out));
		}

// 4 . Octal To Decimal
		void OctaltoDecimal() {
			System.out.println();
			System.out.println("Masukkan Bilangan Octal = ");
			Scanner in = new Scanner(System.in);
			int octal = in.nextInt();
			   
			System.out.println(getDecimal(octal));  
		}
		
// 5 . Decimal To Hecadecimal
		void decimalToHexadecimal() {
			System.out.println();
			System.out.println("Masukkan Angka Decimal = ");
			Scanner in = new Scanner(System.in);
			Integer out = in.nextInt();
			System.out.println(toHex(out));
		}

// 6 . Hexadecimal To Decimal
		void HexadecimalToDecimal() {
			System.out.println();
			System.out.println("Masukkan Angka HexaDecimal = ");
			Scanner in = new Scanner(System.in);
			String out = in.nextLine();
			
	 
			System.out.println(getDecimal(out));  
		}

	

// 2 . Method Binner To Decimal
	static int binaryToDecimal(int n) {
		int num = n;
		int dec_value = 0;

		// Initializing base
		// value to 1, i.e 2^0
		int base = 1;

		int temp = num;
		while (temp > 0) {
			int last_digit = temp % 10;
			temp = temp / 10;

			dec_value += last_digit * base;

			base = base * 2;
		}

		return dec_value;
	}
	

	// 3 . Method Decimal To Octal
	public static String toOctal(int decimal) {
		int rem; // declaring variable to store remainder
		String octal = ""; // declareing variable to store octal
		// declaring array of octal numbers
		char octalchars[] = { '0', '1', '2', '3', '4', '5', '6', '7' };
		// writing logic of decimal to octal conversion
		while (decimal > 0) {
			rem = decimal % 8;
			octal = octalchars[rem] + octal;
			decimal = decimal / 8;
		}
		return octal;
	}
	
	// 4 . Method Octal To Decimal
	public static int getDecimal(int octal){    
	    //Declaring variable to store decimal number  
	    int decimal = 0;    
	    //Declaring variable to use in power  
	    int n = 0;    
	    //writing logic   
	    while(true){    
	      if(octal == 0){    
	        break;    
	      } else {    
	          int temp = octal%10;    
	          decimal += temp*Math.pow(8, n);    
	          octal = octal/10;    
	          n++;    
	       }    
	    }    
	    return decimal;    
	}    

	// 5 . Method Decimal To Hecadecimal
	public String toHex(int decimal){    
	     int rem;  
	     String hex="";   
	     char hexchars[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};  
	    while(decimal>0)  
	     {  
	       rem=decimal%16;   
	       hex=hexchars[rem]+hex;   
	       decimal=decimal/16;  
	     }  
	    return hex;  
	}    
	
	// 6 . Method Hexadecimal To Decimal
	public static int getDecimal(String hex){  
	    String digits = "0123456789ABCDEF";  
	             hex = hex.toUpperCase();  
	             int val = 0;  
	             for (int i = 0; i < hex.length(); i++)  
	             {  
	                 char c = hex.charAt(i);  
	                 int d = digits.indexOf(c);  
	                 val = 16*val + d;  
	             }  
	             return val;  
	}  
//	
//
//
	
//	}	
}
