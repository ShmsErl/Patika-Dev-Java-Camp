package com.adventuregame.Entity.Abstract;

public class Armor extends Item {
	private int armor;

	public Armor(int id, String name, int armor, int price) {
		super(id, name, price);
		this.armor = armor;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

}
