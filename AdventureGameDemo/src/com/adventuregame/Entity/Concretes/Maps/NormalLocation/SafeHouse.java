package com.adventuregame.Entity.Concretes.Maps.NormalLocation;

import com.adventuregame.Entity.Player;

public class SafeHouse extends NormalLocation {

	public SafeHouse(Player player) {
		super(player, "Güvenli Ev");
		
	}
	@Override
	public boolean onLocation() {
		System.out.println("Güvenli Evdesiniz\n Canınız Yenileniyor%%%%");
		return true;
	}

}
