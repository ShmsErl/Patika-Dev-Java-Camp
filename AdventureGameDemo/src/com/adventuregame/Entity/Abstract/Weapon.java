package com.adventuregame.Entity.Abstract;

public class Weapon extends Item {
	private int damage;

	

	public Weapon(int id, String name, int damage, int price) {
		super(id, name, price);
		this.damage = damage;
		// TODO Auto-generated constructor stub
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	
}