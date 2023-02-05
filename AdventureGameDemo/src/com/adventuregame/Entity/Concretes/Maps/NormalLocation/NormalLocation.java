package com.adventuregame.Entity.Concretes.Maps.NormalLocation;

import com.adventuregame.Entity.Player;
import com.adventuregame.Entity.Abstract.Location;

public abstract class NormalLocation extends Location {

	public NormalLocation(Player player, String name) {
		super(player, name,null);
		
	}
	@Override
	public boolean onLocation() {
		
		return true;
	}
	

}
