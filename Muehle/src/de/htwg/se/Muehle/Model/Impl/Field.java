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

	public String getFieldColor(){
		if(this.playerOfField.getName().equals("error")){
			return " ";
		} else {
			return playerOfField.getColor();
		}
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
			
			
			if(temp.getFieldIndex() == this.getFieldIndex() &&  p1.getName().equals(p2.getName())){
					return true;
			}
		}
		return false;
	}
	@Override
	public int hashCode(){
		return playerOfField.hashCode() * 100 + fieldIndex;
	}
	
}