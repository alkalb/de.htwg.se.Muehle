package de.htwg.se.Muehle.Model.Impl;

import de.htwg.se.Muehle.Model.IField;
import de.htwg.se.Muehle.Model.IPlayer;

public class Field implements IField{
	private IPlayer playerOfField;
	private int fieldIndex;

	public Field(IPlayer pof, int index){
		this.playerOfField = pof;
		this.fieldIndex = index;
	}

	public IPlayer getPlayerOfField(){
		return playerOfField;
	}

	public int getFieldIndex(){
		return fieldIndex;
	}
	public void setPlayerOfField(IPlayer p){
		playerOfField = p;
	}


	@Override
	public boolean equals(Object o) {
		if(o instanceof Field){
			IField temp = (Field) o;
			IPlayer p1 = this.getPlayerOfField();
			IPlayer p2 = temp.getPlayerOfField();
			
			
			if(temp.getFieldIndex() == this.getFieldIndex() && (p1 == p2 || p1.equals(p2))){
					return true;
			}
		}
		return false;
	}
	
	
}