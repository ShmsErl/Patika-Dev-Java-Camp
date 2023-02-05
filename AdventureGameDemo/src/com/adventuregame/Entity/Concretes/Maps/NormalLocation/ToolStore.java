package com.adventuregame.Entity.Concretes.Maps.NormalLocation;

import com.adventuregame.Entity.Player;

public class ToolStore extends NormalLocation {

	public ToolStore(Player player) {
		super(player, "Eşya Mağazası");
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean onLocation() {
		System.out.println("Mağazaya hoşgeldiniz");
		return true;
	}

}
