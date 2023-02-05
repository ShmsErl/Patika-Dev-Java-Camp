package com.adventuregame.Entity.Concretes.Maps.WarLocation;

import com.adventuregame.Entity.Player;
import com.adventuregame.Entity.Abstract.GameMap;

public class Forest extends GameMap {
	
	public Forest(Player player, int monsterQuantity) {
		super(player, "Forest",2, "Forest", "War", "\r\n"
				+ "vampire", monsterQuantity, "FireWood");
		
	}
	
	@Override
	public boolean onLocation() {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(
				"Savaş arenasına Hoşgeldin Nehir haritasında \n" + this.getMonsterQuantity() + " adet"+ this.getMonsterName() +" ile savaşacaksın..."
						);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		return true;
	}
	

}
