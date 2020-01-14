package com.mobileHeroes;

public class Tower implements HitAble {
    Integer hp;
    Integer damaged;
//    Integer attack;

  

    public Tower(Integer hp, Integer damaged) {

		this.hp = hp;
		this.damaged = damaged;
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
	public String toString() {
		return "Tower [hp=" + hp + ", damaged=" + damaged + "]";
	}

	@Override
	public void getHit(Integer damage) {
        this.hp -=  damage;
    }



	public void attack(HitAble hero) {
		// TODO Auto-generated method stub
		
	}

}
