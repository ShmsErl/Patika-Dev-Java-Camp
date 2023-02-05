package com.adventuregame.Entity.Abstract;

public abstract class CharacterGame {

	private int id;
	private String name;
	private int damage;
	private int healty;
	private int armor;
	private int money;

	public CharacterGame(int id, String name, int damage, int healty,int armor, int money) {
		super();
		this.id = id;
		this.name = name;
		this.damage = damage;
		this.healty = healty;
		this.armor= armor;
		this.money = money;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealty() {
		return healty;
	}

	public void setHealty(int healty) {
		if(healty < 0) {
			healty = 0;
		}
		this.healty = healty;
	}
	
	

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public static void characterInfo(CharacterGame characterGame) {
		System.out.println(">><<>><<>><<>><<>><<>>><<>><<>><<>><<>><<>><<>>");
		System.out.println(" Character Adı  : " +characterGame.getName().toUpperCase()
		+ "\n Karakter Hasar : " + characterGame.getDamage()
		+ "\n Karakter Can   : " + characterGame.getHealty()
		+ "\n Karakter Armor : " + characterGame.getArmor()
		+ "\n Karakter Para  : "  + characterGame.getMoney());
		System.out.println(">><<>><<>><<>><<>><<>>><<>><<>><<>><<>><<>><<>>");
		System.out.println();
	}
	

}
