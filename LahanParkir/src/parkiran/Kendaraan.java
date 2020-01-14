package parkiran;

public class Kendaraan {
		private String Plat;
		private String Warna;
		
		public Kendaraan(String Plat, String Warna) {
			this.Plat = Plat;
			this.Warna = Warna;
		}
		
		public Kendaraan() {
			
		};
		
		
	public String getPlat() {
			return Plat;
		}


		public void setPlat(String plat) {
			Plat = plat;
		}


		public String getWarna() {
			return Warna;
		}


		public void setWarna(String warna) {
			Warna = warna;
		}
		
		public String Print() {
			return "Plat = " + Plat + "\n \n " + "Warna" + Warna;
		}

//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
