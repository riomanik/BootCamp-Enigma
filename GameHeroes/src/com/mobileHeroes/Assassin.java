package com.mobileHeroes;

public class Assassin extends Hero{
	String nama;
	Integer hp;
	Integer damaged;
	
	public Assassin(String nama, Integer hp, Integer damaged) {
		super();
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
	public String toString() {
		return "Assassin [nama=" + nama + ", hp=" + hp + ", damaged=" + damaged + "]";
	}
	
	@Override
	public void attack(HitAble hitable) {
		hitable.getHit(this.damaged + (this.damaged * 10 / 100));
	}


	
	
	
}
