package de.htwg.se.Muehle.Model;

/**
 * An interface for a Player class for mill
 * Gives Information about the player and can manipulate the numbers of the tokens he has available. 
 * @author alkalb, fewieden
 *
 */
public interface IPlayer {
	
	/**
	 * 
	 * @return the name of the player
	 */
	String getName();
	
	/**
	 * @return the color of the player as a control-string.
	 */
	String getColor();
	
	/**
	 * 
	 * @return the amount of tokens the player has already placed.
	 */
	int getTokenCount();
	
	/**
	 * 
	 * @return the amount of tokens the player can still place.
	 */
	int getPlaceableTokenCount();
	
	/**
	 * Sets the amount of placed tokens, normally decrement by 1.
	 * @param x the desired amount.
	 */
	void setTokenCount(int x);
	
	/**
	 * Sets the amount of placeable tokens, normally decrement by 1.
	 * @param x the desired amount.
	 */
	void setPlaceableTokenCount(int x);
	
}
