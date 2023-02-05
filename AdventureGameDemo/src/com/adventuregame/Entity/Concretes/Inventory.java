package com.adventuregame.Entity.Concretes;

import java.util.ArrayList;
import java.util.List;

import com.adventuregame.Entity.Abstract.Armor;
import com.adventuregame.Entity.Abstract.Weapon;

public class Inventory {
	private List<String> loots;
	private Weapon weapon;
	private Armor armor;

	public Inventory() {
		this.weapon = new Weapon(0, "Yumruk", 2, 0);
		this.armor = new Armor(0, "Yelek", 2, 0);
		this.loots= new ArrayList<String>();
		this.loots.add("Basket");
		
	}

	public Inventory(List<String> loots, Weapon weapon, Armor armor) {
		this.loots = loots;
		this.weapon = weapon;
		this.armor = armor;
	}

	

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	public List<String> getLoots() {
		return loots;
	}

	public void setLoots(List<String> loots) {
		this.loots = loots;
	}

}
