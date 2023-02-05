package com.adventuregame.Entity.Concretes.Maps.WarLocation;

import com.adventuregame.Entity.Player;
import com.adventuregame.Entity.Abstract.GameMap;

public class Cavern extends GameMap {

	public Cavern(Player player,int monsterQuantity) {
		super(player,"Cavern",1, "Cavern", "War","Zombie", monsterQuantity, "Food");
	
	}
	
	@Override
	public boolean onLocation() {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(
				"Savaş arenasına Hoşgeldin Nehir haritasında \n" + this.getMonsterQuantity() + " adet "+ getMonsterName() +" ile savaşacaksın..."
						);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		return true;
	}
	

}
