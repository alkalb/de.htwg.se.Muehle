package de.htwg.se.Muehle.Controller;

import de.htwg.se.Muehle.Model.IBoard;
import de.htwg.se.Muehle.Model.IPlayer;

public interface IGameController {

	public boolean isMill(int x, IPlayer p);

	public boolean isMoveAllowed();
	
	public boolean isMoveAllowed(int x, int y);

	public boolean isPlacementAllowed(int x);
	public boolean isStealAllowed();
	public boolean isStealAllowed(int x);
	public boolean placeToken(int x);
	public int stealToken(int x);
	
	public boolean moveToken(int x, int y);
	
	public IBoard getBoard();
	
	
}
