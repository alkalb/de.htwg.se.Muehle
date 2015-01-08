package de.htwg.se.Muehle.Model;

import java.util.Map;

public interface IBoard {
	
	boolean isPositionEmpty(int x);

	IField[] getFields();
	
	void setPosition(int x, IPlayer p);
	
	Map<Integer, int[]> getConnections();

}