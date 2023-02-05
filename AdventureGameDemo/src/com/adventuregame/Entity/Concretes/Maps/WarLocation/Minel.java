package com.adventuregame.Entity.Concretes.Maps.WarLocation;

import com.adventuregame.Entity.Player;
import com.adventuregame.Entity.Abstract.GameMap;

public class Minel extends GameMap {

	public Minel(Player player, int monsterQuantity) {
		super(player, "Maden", 4, "Maden", "War", "Yılan", monsterQuantity, "Health-Potion");
		
	}
	
	@Override
	public boolean onLocation() {
		
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println("Savaş arenasına Hoşgeldin Nehir haritasında \n " + getMonsterQuantity() + " adet "
					+ getMonsterName() + " ile savaşacaksın...");
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		return super.onLocation();
	}

}
