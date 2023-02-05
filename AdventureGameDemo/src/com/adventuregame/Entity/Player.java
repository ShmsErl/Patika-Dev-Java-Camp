package com.adventuregame.Entity;

import java.lang.invoke.VarHandle;
import java.util.List;

import com.adventuregame.Entity.Abstract.Armor;
import com.adventuregame.Entity.Abstract.CharacterGame;
import com.adventuregame.Entity.Abstract.Item;
import com.adventuregame.Entity.Abstract.Location;
import com.adventuregame.Entity.Abstract.Weapon;
import com.adventuregame.Entity.Concretes.Inventory;
import com.adventuregame.Entity.Concretes.Characters.Archer;

public class Player {
	private int damage;
	private int healty;
	private int armor;
	private int money;
	private String charName;
	private String playerName;
	private Inventory inventory;

	public Player() {
		this.inventory = new Inventory();
	}

	public Player(int damage, int healty, int armor, int money, String charName, String playerName) {
		super();
		this.damage = damage;
		this.healty = healty;
		this.armor = armor;
		this.money = money;
		this.charName = charName;
		this.playerName = playerName;
		this.inventory = new Inventory();
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
		if (healty < 0) {
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

	public String getCharName() {
		return charName;
	}

	public void setCharName(String charName) {
		this.charName = charName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public void initPlayer(CharacterGame characterGame, Player player) {
		CharacterGame hero = characterGame;
		player.setCharName(hero.getName());
		player.setDamage(hero.getDamage());
		player.setHealty(hero.getHealty());
		player.setArmor(hero.getArmor());
		player.setMoney(hero.getMoney());
		System.out.println("Karakter Seçimi Başarılı: " + player.getCharName());
		playerİnfo();

	}

	// if the player buys an item check items and confirm the transaction
	public void isCheckWeapon(Player player, Weapon weapon) {
		if (player.getInventory().getWeapon().getName().equals(weapon.getName())) {
			System.out.println("Bu Ürün Envanterinizde Mevcuttur Satın Alamazsınız");
		} else if (player.getMoney() >= weapon.getPrice()) {
			player.setMoney(player.getMoney() - weapon.getPrice());
			player.setDamage(player.getDamage() + weapon.getDamage());
			player.getInventory().setWeapon(weapon);

			System.out.println(
					weapon.getName() + " Ürünün Başarı ile Satın aldınız " + " Kalan Bakiyeniz : " + player.getMoney());
			playerİnfo();

		} else {
			System.out.println("Yeterli Bakiyeniz Bulunamadığı için Ürünü Satın Alamazsınız " + player.getMoney());

		}

	}

	public void isCheckArmor(Player player, Armor armor) {
		if (player.getInventory().getArmor().getName().equals(armor.getName())) {
			System.out.println("Bu Ürün Envanterinizde Mevcuttur Satın Alamazsınız");
		} else if (player.getMoney() >= armor.getPrice()) {
			player.setMoney(player.getMoney() - armor.getPrice());
			player.setArmor(player.getArmor() + armor.getArmor());
			player.getInventory().setArmor(armor);

			System.out.println(
					armor.getName() + " Ürünün Başarı ile Satın aldınız " + " Kalan Bakiyeniz : " + player.getMoney());
			playerİnfo();

		} else {
			System.out.println("Yeterli Bakiyeniz Bulunamadığı için Ürünü Satın Alamazsınız " + player.getMoney());

		}

	}

	public boolean inventoryCheck(Player player, Location location) {
		boolean result = true;
		List<String> loots = player.getInventory().getLoots();
		for (String playerLoot : loots) {

			if (location.getLootName().equals(playerLoot)) {

				result = false;

			}
		}
		return result;
	}

	public void playerİnfo() {
		System.out.println(
				"***********************************************************************************************");
		System.out.println(" Oyuncu Karakteri : " + this.getCharName()

				+ "\n Oyuncu Adı : " + this.getPlayerName() + "\n Oyuncu Hasarı :" + this.getDamage()
				+ "\n Oyuncu Can : " + this.getHealty() + "\n Oyuncu Zırh :" + this.getArmor() + "\n Oyuncu Para: "
				+ this.getMoney() + "\n Oyuncu Silahı : " + this.getInventory().getWeapon().getName());
		System.out.println(
				"***********************************************************************************************");

	}

}
