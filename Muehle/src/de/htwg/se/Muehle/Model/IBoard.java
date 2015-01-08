package de.htwg.se.Muehle.Model;

import java.util.Map;

public interface IBoard {
	
	public boolean isPositionEmpty(int x);

	public IField[] getFields();
	
	public void setPosition(int x, IPlayer p);
	
	public Map<Integer, int[]> getConnections();

}