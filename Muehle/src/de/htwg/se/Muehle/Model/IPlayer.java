package de.htwg.se.Muehle.Model;


public interface IPlayer {
	
	String getName();
	
	String getColor();
	
	int getTokenCount();
	
	int getPlaceableTokenCount();
	
	void setTokenCount(int x);
	
	void setPlaceableTokenCount(int x);
	
}
