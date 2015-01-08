package de.htwg.se.Muehle.Model;

import java.awt.Color;

public interface IPlayer {
	
	String getName();
	
	Color getColor();
	
	int getTokenCount();
	
	int getPlaceableTokenCount();
	
	void setTokenCount(int x);
	
	void setPlaceableTokenCount(int x);
	
	boolean equals(Object o);

}
