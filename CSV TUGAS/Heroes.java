package com.enigma.camp.LatihanHeroes.src.com.app;

public class Heroes {
	private String name;
	private Integer hp;
	private Integer mana;
	private Integer damage;
	
	public Heroes() {
	
	}
	
	public Heroes(String a) {
		String data[] = a.split(",");
		this.name = data[0];
		this.hp = Integer.parseInt(data[1]);
		this.mana = Integer.parseInt(data[2]);
		this.damage = Integer.parseInt(data[3]);
	}
	
	 
	public Heroes(String name, Integer hp, Integer mana, Integer damage) {
		this.name = name;
		this.hp = hp;
		this.mana = mana;
		this.damage = damage;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getHp() {
		return hp;
	}
	public void setHp(Integer hp) {
		this.hp = hp;
	}
	public Integer getMana() {
		return mana;
	}
	public void setMana(Integer mana) {
		this.mana = mana;
	}
	public Integer getDamage() {
		return damage;
	}
	public void setDamage(Integer damage) {
		this.damage = damage;
	}
	
	public String print() {
		return "Hero = "+ name+"\n \n"+" Hp =" + "hp \n mana = " + mana+" baseDamage ="+ damage;
	}


	@Override
	public String toString() {
		return name + "," + hp + "," +  mana + "," + damage;
	}
	
	
} 
