package de.htwg.se.Muehle.Controller;

import de.htwg.se.Muehle.Model.IBoard;
import de.htwg.se.Muehle.Model.IPlayer;

public interface IGameController {

    boolean isMill(int x, IPlayer p);

	boolean isMoveAllowed();
	
	boolean isMoveAllowed(int x, int y);

	boolean isPlacementAllowed(int x);
	boolean isStealAllowed();
	boolean isStealAllowed(int x);
	boolean placeToken(int x);
	int stealToken(int x);
	
	boolean moveToken(int x, int y);
	
	IBoard getBoard();
	
	
}
