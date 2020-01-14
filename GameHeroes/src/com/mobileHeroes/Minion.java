package com.mobileHeroes;

public class Minion implements HitAble{
		Integer hp;

		public Minion(Integer hp) {
			super();
			this.hp = hp;
		}

		public Integer getHp() {
			return hp;
		}

		public void setHp(Integer hp) {
			this.hp = hp;
		}
		
		

		@Override
		public String toString() {
			return "Minion [hp=" + hp + "]";
		}

		@Override
		public void getHit(Integer damage) {
			// TODO Auto-generated method stub
			
		}
		
		
		
		
		
		
		
		
}
