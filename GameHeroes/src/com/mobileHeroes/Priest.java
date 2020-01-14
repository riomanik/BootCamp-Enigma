package com.mobileHeroes;

public class Priest extends Hero{
	String nama;
	Integer hp;
	Integer damaged;
	
	public Priest(String nama, Integer hp, Integer damaged) {
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
	
	public void Heal(Hero hero) {
		hero.getHeal();
		System.out.println(hero.getName() + " healing...");
	}

	
	@Override
	public String toString() {
		return "Priest [nama=" + nama + ", hp=" + hp + ", damaged=" + damaged + "]";
	}
	
	
	
	
	
}
