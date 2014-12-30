package de.htwg.se.Muehle.Model.Impl;

public class Field {
	private Player playerOfToken;
	private int fieldIndex;

	public Field(Player playerOfToken, int index){
		this.playerOfToken = playerOfToken;
		this.fieldIndex = index;
	}

	public Player getPlayerOfField(){
		return playerOfToken;
	}

	public int getFieldIndex(){
		return fieldIndex;
	}
	public void setPlayerOfField(Player p){
		playerOfToken = p;
	}

	public void setFieldIndex(int i){
		fieldIndex = i;
	}
	
}