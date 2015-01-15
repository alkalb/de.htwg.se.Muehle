package de.htwg.se.Muehle.Model;

import java.util.Map;

/**
 * Interface for a class, which contains information about the tokens and players of a mill game.
 * 
 * @author alkalb, fewieden
 * 
 */


public interface IBoard {
	
	/**
	 * Asks whether a field on the board is empty.
	 * @param x The position on the field which is to be checked.
	 * @return boolean value.
	 */
	
	boolean isPositionEmpty(int x);

	
	/**
	 * Gives all fields of the Board with the current information.
	 * @return an array of IFields
	 */
	IField[] getFields();
	
	
	/**
	 * Sets the Token of a player on a position on the board.
	 * @param x The position on which the token should be placed. 
	 * @param p the player to whom the token belongs.
	 */
	void setPosition(int x, IPlayer p);
	
	
	/**
	 * Gives information about which fields are adjacent to each other.
	 * @return a Map, the key is the position on the field. The value is an int array of length 4, in which each adjacent field is saved in the order:Up, right, down, left. If there is no connection the value is -1.
	 * 
	 */
	Map<Integer, int[]> getConnections();

}