package com.mobileHeroes;

public class Tanker extends Hero{
		String nama;
		Integer hp;
		Integer damaged;
		
		
		public Tanker(String nama, Integer hp, Integer damaged) {
			this.nama = nama;
			this.hp = hp;
			this.damaged = damaged;
		}
		
		
		public String getNama() {
			return nama;
		}
		public void setNama(String nama) {
			this.nama = nama;
		}
		public Integer getHp() {
			return hp;
		}
		public void setHp(Integer hp) {
			this.hp = hp;
		}
		public Integer getDamaged() {
			return damaged;
		}
		public void setDamaged(Integer damaged) {
			this.damaged = damaged;
		}

		@Override
		public void getHit(Integer damage) {
			this.hp -= (damage * 50 / 100);
		}

		@Override
		public String toString() {
			return "Tanker [nama=" + nama + ", hp=" + hp + ", damaged=" + damaged + "]";
		}
		
		

		
		
}
