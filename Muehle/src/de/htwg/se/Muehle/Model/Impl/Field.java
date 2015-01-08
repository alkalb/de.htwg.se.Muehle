package de.htwg.se.Muehle.Model.Impl;

public class Field {
	private Player playerOfField;
	private int fieldIndex;

	public Field(Player pof, int index){
		this.playerOfField = pof;
		this.fieldIndex = index;
	}

	public Player getPlayerOfField(){
		return playerOfField;
	}

	public int getFieldIndex(){
		return fieldIndex;
	}
	public void setPlayerOfField(Player p){
		playerOfField = p;
	}

	/*
	public void setFieldIndex(int i){
		fieldIndex = i;
	}*/
	
}