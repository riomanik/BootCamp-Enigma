package com.app;
//public class Heroes {
//	  public static void main(String[] args) {
//		  
//		  System.out.println((int)(Math.random()*10)+1);  
//	  }
//	}



public class Heroes {
	private String name;
	private Integer hp;
	private Integer mana;
	private Integer damage;
	
	public Heroes() {
	
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
} 
