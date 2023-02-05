package com.adventuregame.Entity.Concretes.Maps.WarLocation;

import java.util.Random;

import com.adventuregame.Entity.Player;
import com.adventuregame.Entity.Abstract.GameMap;

public class River extends GameMap {
	int c, d;
	Random random = new Random();
	int a = random.nextInt(5);

	public River(Player player, int monsterQuantity) {
		super(player, "River", 3, "River", "War", "Bear", monsterQuantity, "Water");
		// TODO Auto-generated constructor stub
	}

	public void monster() {
		System.out.println(getMonsterQuantity());
	}

	@Override
	public boolean onLocation() {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("Savaş arenasına Hoşgeldin Nehir haritasında \n " + getMonsterQuantity() + " adet "
				+ getMonsterName() + " ile savaşacaksın...");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		return true;
	}

}
