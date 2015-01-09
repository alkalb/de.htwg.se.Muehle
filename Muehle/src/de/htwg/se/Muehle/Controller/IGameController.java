package de.htwg.se.Muehle.Controller;

import de.htwg.se.Muehle.Model.IBoard;
import de.htwg.se.Muehle.Model.IPlayer;

public interface IGameController {

    boolean isMill(int x, IPlayer p);

	boolean isMoveAllowed();
	void nextPlayer();
	
	boolean isMoveAllowed(int x, int y);

	boolean isPlacementAllowed(int x);
	boolean isStealAllowed();
	boolean isStealAllowed(int x);
	boolean placeToken(int x);
	boolean stealToken(int x);
	boolean moveToken(int x, int y);
	
	IBoard getBoard();
	
	IPlayer getCurrPlayer();
	
	IPlayer getOppPlayer();

}