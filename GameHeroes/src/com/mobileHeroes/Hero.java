package com.mobileHeroes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Hero implements HitAble {

	private String name;
	private Integer hp;
	private Integer damaged;

	ArrayList<Hero> arrHero = new ArrayList<Hero>();
	ArrayList<Tower> arrTower = new ArrayList<Tower>();
	ArrayList<Minion> arrMinion = new ArrayList<Minion>();
	Set<Hero> addfriend = new HashSet<>();

	public Hero() {
	}

	public Hero(String name, Integer hp, Integer damaged) {
		super();
		this.name = name;
		this.hp = hp;
		this.damaged = damaged;
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

	public Integer getDamaged() {
		return damaged;
	}

	public void setDamaged(Integer damaged) {
		this.damaged = damaged;
	}

	@Override
	public String toString() {
		return "Hero [name=" + name + ", hp=" + hp + ", damaged=" + damaged + "]";
	}

	@Override
	public void getHit(Integer damage) {
		// TODO Auto-generated method stub
		this.hp -= damage;
		if (this.hp <= 0) {
			this.hp = 0;
			System.out.println("Hero Has Been Slained");
		}
	}

//	public boolean isFriends(String friends) {
//		return this.addfriend.contains(friends);
//	}

	public void attack(HitAble hitAble) {
		hitAble.getHit(this.damaged);
	}
	
	public void Heal(Hero heroes) {
		System.out.println("Cant heal, only type priest to heal...");
	}

	public void getHeal() {
		this.hp += this.hp * 25 / 100;
	}



}
