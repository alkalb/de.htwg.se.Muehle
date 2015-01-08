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


	@Override
	public boolean equals(Object o) {
		if(o instanceof Field){
			Field temp = (Field) o;
			Player p1 = this.getPlayerOfField();
			Player p2 = temp.getPlayerOfField();
			
			
			if(temp.getFieldIndex() == this.getFieldIndex()){
				if(p1 == p2 || p1.equals(p2)){
					return true;
				}
				
			}
		}
		return false;
	}
	
	
}