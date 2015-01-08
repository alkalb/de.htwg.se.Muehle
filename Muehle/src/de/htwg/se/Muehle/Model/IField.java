package de.htwg.se.Muehle.Model;

public interface IField {
	
	public IPlayer getPlayerOfField();

	public int getFieldIndex();
	
	public void setPlayerOfField(IPlayer p);

	public boolean equals(Object o);

}
