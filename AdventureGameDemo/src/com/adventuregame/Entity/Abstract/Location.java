package com.adventuregame.Entity.Abstract;

import com.adventuregame.Entity.Player;

public abstract class Location {
	private Player player;
	private String name;
	private String lootName;

	public Location(Player player, String name, String lootName) {
		this.lootName= lootName;
		this.player = player;
		this.name = name;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getLootName() {
		return lootName;
	}

	public void setLootName(String lootName) {
		this.lootName = lootName;
	}

	public boolean onLocation() {
		
		return false;
		
	}

}
