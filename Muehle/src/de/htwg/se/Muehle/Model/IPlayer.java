package de.htwg.se.Muehle.Model;

import java.awt.Color;

public interface IPlayer {
	
	public String getName();
	
	public Color getColor();
	
	public int getTokenCount();
	
	public int getPlaceableTokenCount();
	
	public void setTokenCount(int x);
	
	public void setPlaceableTokenCount(int x);
	
	public boolean equals(Object o);

}
