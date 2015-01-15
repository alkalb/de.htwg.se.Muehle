package de.htwg.se.Muehle.Model;


/**
 * Interface for a class, which contains Information about a single field on a Mill game
 * @author alkalb, fewieden
 *
 */
public interface IField {
	
	/**
	 * Gives Information of the player, who occupies this field.
	 * @return the player
	 */
	IPlayer getPlayerOfField();

	/**
	 * Gives Information whether the Player, who occupies the field has the color black or white.
	 * @return an empty String if there is no player, else
	 * @see src.de.htwg.Muehle.Model.IPlayer
	 */
	String getFieldColor();
	
	int getFieldIndex();
	
	void setPlayerOfField(IPlayer p);

}
