package com.mobileHeroes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class addHeroes {
	Display display = new Display();
	Hero hero = new Hero();

	


		

	public void AddHeroTanker() {

		System.out.print("Masukkan Nama = ");
		Scanner in = new Scanner(System.in);
		String nama = in.nextLine();
		System.out.print("Masukkan HP = ");
		Scanner inn = new Scanner(System.in);
		Integer hp = in.nextInt();
		System.out.print("Masukkan damaged = ");
		Scanner innn = new Scanner(System.in);
		Integer damaged = innn.nextInt();

		hero.arrHero.add(new Tanker(nama, hp, damaged));
	}

	public void AddHeroAssassin() {

		System.out.print("Masukkan Nama = ");
		Scanner in = new Scanner(System.in);
		String nama = in.nextLine();
		System.out.print("Masukkan HP = ");
		Scanner inn = new Scanner(System.in);
		Integer hp = in.nextInt();
		System.out.print("Masukkan damaged = ");
		Scanner innn = new Scanner(System.in);
		Integer damaged = innn.nextInt();

		hero.arrHero.add(new Assassin(nama, hp, damaged));
	}

	public void AddHeroPriest() {

		System.out.print("Masukkan Nama = ");
		Scanner in = new Scanner(System.in);
		String nama = in.nextLine();
		System.out.print("Masukkan HP = ");
		Scanner inn = new Scanner(System.in);
		Integer hp = in.nextInt();
		System.out.print("Masukkan damaged = ");
		Scanner innn = new Scanner(System.in);
		Integer damaged = innn.nextInt();

		hero.arrHero.add(new Priest(nama, hp, damaged));
	}

	public void AddTower() {

		System.out.print("Masukkan HP = ");
		Scanner inn = new Scanner(System.in);
		Integer hp = inn.nextInt();
		System.out.print("Masukkan damaged = ");
		Scanner innn = new Scanner(System.in);
		Integer damaged = innn.nextInt();

		hero.arrTower.add(new Tower(hp, damaged));
	}

	public void AddMinion() {

		System.out.print("Masukkan HP = ");
		Scanner inn = new Scanner(System.in);
		Integer hp = inn.nextInt();

		hero.arrMinion.add(new Minion(hp));
	}


		

	public void ListHeroes() {

		for (int i = 0; i < hero.arrHero.size(); i++) {
			System.out.println("NO. "+ (i) +" " + hero.arrHero.get(i).toString());
			System.out.println();

		}
	}

	public void ListTower() {

		for (int i = 0; i < hero.arrTower.size(); i++) {
			System.out.println(i);
			System.out.println("NO. "+ (i) +" " + hero.arrTower.get(i).toString());
			System.out.println();

		}
	}

	public void ListMinion() {

		for (int i = 0; i < hero.arrMinion.size(); i++) {
			System.out.println();
			System.out.println("NO. "+ (i) +" " + hero.arrMinion.get(i).toString());
			System.out.println();

		}
	}
	public Integer GetHero(){
		for (int i = 0; i < hero.arrHero.size(); i++) {
			System.out.println(i);
			System.out.println(hero.arrHero.get(i).toString());
			System.out.println();
		}

			System.out.println("Masukkan No Hero yang mau menambahkan teman = "); 
	        
			Scanner in = new Scanner(System.in);
			Integer pilihan1 = in.nextInt();
			
			return pilihan1;
	}
	
	public Integer TakeHero(){
		for (int i = 0; i < hero.arrHero.size(); i++)
	      {
			System.out.println();
	        System.out.println("No. "+(i)+" "+hero.arrHero.get(i).toString());
	        System.out.println();
	       
	        
	      }
		System.out.println("Masukkan No Hero yang mau menambahkan teman = ");
		Scanner in = new Scanner(System.in);
		Integer pilihan2 = in.nextInt();
		return pilihan2;
	}
	
		public void AddFriends(Integer pilihan1,Integer pilihan2) {
			
			hero.arrHero.get(pilihan1).addfriend.add(hero.arrHero.get(pilihan2));
			
			}
		public Integer listFriend() {
			for (int i = 0; i < hero.arrHero.size(); i++)
		      {
				System.out.println();
		        System.out.println("No. "+(i)+" "+hero.arrHero.get(i).toString());
		        System.out.println();
		       
		        
		      }
		        System.out.println("Pilih Hero yang mau dilihat Temannya");
		        Scanner in = new Scanner(System.in);
		        Integer out = in.nextInt();
		        return out;
		    
			}
		public void List() {
	    for(Hero xc :hero.arrHero.get(listFriend()).addfriend) {
        	System.out.println();
        	System.out.println(xc);
        	System.out.println();
	    }
	}
		public void chooseAttack() {
			System.out.println(" 1. Hero to Hero");
			System.out.println(" 2. Hero to Tower");
			System.out.println(" 3. Hero to Minion");
			System.out.println(" 4. Tower to Hero");
			System.out.println(" 5. Tower to Minion");
			Scanner in = new Scanner(System.in);
			System.out.print(" Choose : ");
			int choose = in.nextInt();
			switch (choose) {
			case 1:
				attackHeroToHero();
				break;
			case 2:
				attackHeroToTower();
				break;
			case 3:
				attackHeroToMinion();
				break;
			case 4:
				attackTowerToHero();
				break;
			case 5:
				attackTowerToMinion();
				break;
			default:
				System.out.println("Invalid Input...");
				break;
			}
		}
		public void attackHeroToHero() {
			ListHeroes();
			Scanner in = new Scanner(System.in);
			System.out.print(" Choose hero   : ");
			int choose1 = in.nextInt();
			ListHeroes();
			System.out.print(" Choose attack : ");
			int choose2 = in.nextInt();
			if (hero.arrHero.get(choose1)==hero.arrHero.get(choose2)) {
				System.out.println(" Cant attack your self...");
//			} else if (hero.arrHero.get(choose1).isFriends(hero.arrHero.get(choose2).getName())) {
//				System.out.println(" Cant attack friend..");
			} else if (hero.arrHero.get(choose1).getHp() <= 0) {
				System.out.println(" Your are is dead, cant attack...");
			} else if (hero.arrHero.get(choose2).getHp() <= 0) {
				System.out.println(" Cant Hit enemy is dead");
			} else if(hero.arrHero.get(choose1)!=hero.arrHero.get(choose2)) {
				System.out.println(" Attack...");
				hero.arrHero.get(choose1).attack(hero.arrHero.get(choose2));
			}
		}

		// Attack Hero to Tower
		public void attackHeroToTower() {
			ListHeroes();
			Scanner in = new Scanner(System.in);
			System.out.print(" Choose hero   : ");
			int choose1 = in.nextInt();
			ListTower();
			System.out.print(" Choose attack : ");
			int choose2 = in.nextInt();
			if (hero.arrHero.get(choose1).getHp() <= 0) {
				System.out.println(" Your are is dead, cant attack...");
			} else if (hero.arrTower.get(choose2).getHp() <= 0) {
				System.out.println(" Cant Hit enemy is dead");
			} else {
				System.out.println(" Attack...");
				hero.arrHero.get(choose1).attack(hero.arrTower.get(choose2));
			}
		}

		// Attack Hero to Minion
		public void attackHeroToMinion() {
			ListHeroes();
			Scanner in = new Scanner(System.in);
			System.out.print(" Choose hero   : ");
			int choose1 = in.nextInt();
			ListMinion();
			System.out.print(" Choose attack : ");
			int choose2 = in.nextInt();
			if (hero.arrHero.get(choose1).getHp() <= 0) {
				System.out.println(" Your are is dead, cant attack...");
			} else if (hero.arrMinion.get(choose2).getHp() <= 0) {
				System.out.println(" Cant Hit enemy is dead");
			} else {
				System.out.println(" Attack...");
				hero.arrHero.get(choose1).attack(hero.arrMinion.get(choose2));
			}
		}

		// Attack Tower to Hero
		public void attackTowerToHero() {
			ListTower();
			Scanner in = new Scanner(System.in);
			System.out.print(" Choose Tower   : ");
			int choose1 = in.nextInt();
			ListHeroes();
			System.out.print(" Choose attack : ");
			int choose2 = in.nextInt();
			if (hero.arrTower.get(choose1 - 1).getHp() <= 0) {
				System.out.println(" Your are is dead, cant attack...");
			} else if (hero.arrHero.get(choose2 - 1).getHp() <= 0) {
				System.out.println(" Cant Hit enemy is dead");
			} else {
				System.out.println(" Attack...");
				hero.arrTower.get(choose1 - 1).attack(hero.arrHero.get(choose2 - 1));
			}
		}

		// Attack Tower to Minion
		public void attackTowerToMinion() {
			ListTower();
			Scanner in = new Scanner(System.in);
			System.out.print(" Choose Tower   : ");
			int choose1 = in.nextInt();
			ListHeroes();
			System.out.print(" Choose attack : ");
			int choose2 = in.nextInt();
			if (hero.arrTower.get(choose1 - 1).getHp() <= 0) {
				System.out.println(" Your are is dead, cant attack...");
			} else if (hero.arrMinion.get(choose2 - 1).getHp() <= 0) {
				System.out.println(" Cant Hit enemy is dead");
			} else {
				System.out.println(" Attack...");
				hero.arrTower.get(choose1 - 1).attack(hero.arrMinion.get(choose2 - 1));
			}
		}

		// Heal
		public void heal() {
			Scanner in = new Scanner(System.in);
			ListHeroes();
			System.out.print("Choose hero         : ");
			int choose1 = in.nextInt();
			ListHeroes();
			System.out.print("Choose hero to heal : ");
			int choose2 = in.nextInt();
			hero.arrHero.get(choose1 - 1).Heal(hero.arrHero.get(choose2 - 1));
		}

		// Attack or heal
		public void AttackOrHeal() {
			System.out.println(" 1. Attack");
			System.out.println(" 2. Heal");
			System.out.print(" Choose : ");
			Scanner in = new Scanner(System.in);
			int choose = in.nextInt();
			switch (choose) {
			case 1:
				chooseAttack();
				break;
			case 2:
				heal();
				break;
			default:
				System.out.println(" Invalid input...");
				break;
			}
		}
}



