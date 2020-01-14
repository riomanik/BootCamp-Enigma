package com.mobileHeroes;

public class start {
	Display display = new Display();
	addHeroes hr = new addHeroes();
	AddFriend friend = new AddFriend();
	public void start() {
		Integer pilihan;
		do {
			pilihan = display.printMenuMain();

			switch (pilihan) {
			case 1:
				Integer pilihan2;
				do {
					pilihan2 = display.PrintCreateChar();
					switch (pilihan2) {
					case 1:
						Integer pilihan3;
						pilihan3 = display.AddHeroes();
						switch (pilihan3) {
						case 1:
							hr.AddHeroTanker();
							break;
						case 2:
							hr.AddHeroAssassin();
							break;
						case 3:
							hr.AddHeroPriest();
							break;
						}
						break;
					case 2:
						hr.AddTower();
						break;
					case 3:
						hr.AddMinion();
						break;
					case 4:
						start();
						break;
					}

				} while (pilihan != 4);
				System.out.println("SALAH");
			case 2:
				Integer pilihan3;
				do {
					pilihan3 = display.ListCharacter();
					switch (pilihan3) {
					case 1:
						hr.ListHeroes();
						break;
					case 2:
						hr.ListTower();
						break;
					case 3:
						hr.ListMinion();
						break;
					case 4:
						start();
					}

				} while (pilihan != 4);
				System.out.println("SALAH");
				System.exit(0);
				break;
			
			case 3:
				hr.AddFriends(hr.TakeHero(), hr.GetHero());
				break;
			case 4:
				hr.List();
				break;
			case 5:
				hr.chooseAttack();
				break;
				

			case 6:
//				System.out.println("Terimakasih Telah Bermain ");
//				System.exit(0);
				break;	
			}
		} while (pilihan != 6);

	}
}
