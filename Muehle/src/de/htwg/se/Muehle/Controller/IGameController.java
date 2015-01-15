package de.htwg.se.Muehle.Controller;

import de.htwg.se.Muehle.Model.IBoard;
import de.htwg.se.Muehle.Model.IPlayer;


/**
 * Interface for Game logic in a mill game
 * Contains logic, whether certain actions are allowed.
 * 
 * @author alkalb, fewieden
 *
 */
public interface IGameController {

	/**
	 * Checks if any other tokens build a mill together with a given position for a certain player.
	 * @param x the position which is checked.
	 * @param p the player who could have a mill.
	 * @return whether the three tokens form a mill.
	 */
    boolean isMill(int x, IPlayer p);
    
	/**
	 * 
	 * @return
	 */
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