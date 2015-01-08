package de.htwg.se.Muehle.Model;

public interface IField {
	
	IPlayer getPlayerOfField();

	String getFieldColor();
	
	int getFieldIndex();
	
	void setPlayerOfField(IPlayer p);

	boolean equals(Object o);

}
