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
	 * Checks if the current player can move any stone at all.
	 * @return false if he can't move any stone and therefore loses.
	 */
	boolean isMoveAllowed();
	
	/**
	 * Switches the current Player.
	 * 
	 */
	void nextPlayer();
	
	/**
	 * Checks if a move from one position to another is allowed for the current player.
	 * @param x the source position.
	 * @param y the target position.
	 * @return true, if it is allowed according to mill rules.
	 */
	boolean isMoveAllowed(int x, int y);

	/**
	 * Checks if placement of a token on a field is allowed.
	 * @param x the target position.
	 * @return true, if the field is not occupied.
	 */
	boolean isPlacementAllowed(int x);
	
	/**
	 * Checks if the current player can steal any tokens on the gamefield.
	 * @return false if the opponent player has only mills and is not in jumping phase.
	 */
	boolean isStealAllowed();
	
	/**
	 * Checks if a token on a specific position can be stolen for the current player.
	 * @param x the target position.
	 * @return whether there is an opponents token which can be stolen.
	 */
	boolean isStealAllowed(int x);
	
	/**
	 * Tries to place a token on a specific field for the current player.
	 * @param x the target position.
	 * @return true if the token was successfully placed.
	 */
	boolean placeToken(int x);
	
	/**
	 * Tries to steal a token on a specific field from the opposing player.
	 * @param x the target position.
	 * @return true, if the token was taken successfully.
	 */
	boolean stealToken(int x);
	
	/**
	 *  Tries to move a token from one position to another.
	 * @param x source position.
	 * @param y target position.
	 * @return 
	 */
	boolean moveToken(int x, int y);
	
	/**
	 * 
	 * @return a board instance to get the gamestate.
	 */
	IBoard getBoard();
	
	/**
	 * 
	 * @return the current player.
	 */
	IPlayer getCurrPlayer();
	
	/**
	 * 
	 * @return the opposing player.
	 */
	IPlayer getOppPlayer();

}