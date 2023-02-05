package com.adventuregame.Entity.Abstract;

import com.adventuregame.Entity.Player;

public abstract class GameMap  extends Location{
	
	
	private int id;
	private String mapName;
	private String mapType;
	private String monsterName;
	private int monsterQuantity;
	
	
	
	
	

	public GameMap(Player player, String name,int id, String mapName, String mapType, String monsterName, int monsterQuantity,
			String lootName) {
		super(player, name,lootName);
		this.id = id;
		this.mapName = mapName;
		this.mapType = mapType;
		this.monsterName = monsterName;
		this.monsterQuantity = monsterQuantity;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMapName() {
		return mapName;
	}

	public void setMapName(String mapName) {
		this.mapName = mapName;
	}

	public String getMapType() {
		return mapType;
	}

	public void setMapType(String mapType) {
		this.mapType = mapType;
	}

	public String getMonsterName() {
		return monsterName;
	}

	public void setMonsterName(String monsterName) {
		this.monsterName = monsterName;
	}

	public int getMonsterQuantity() {
		return monsterQuantity;
	}

	public void setMonsterQuantity(int monsterQuantity) {
		this.monsterQuantity = monsterQuantity;
	}

	
	@Override
	public boolean onLocation() {
		
		return false;
	}
	
	
	

}
