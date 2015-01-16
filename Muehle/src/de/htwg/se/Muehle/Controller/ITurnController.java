package de.htwg.se.Muehle.Controller;

import de.htwg.se.Muehle.Util.IObservable;


/**
 * Interface for turn logic and input instructions in the mill game.
 * 
 * @author alkalb, fewieden
 *
 */
public interface ITurnController extends IObservable{
	
	/**
	 * Tries to place a Token on a specific position.
	 * Handles false input, switches players and sets messages/state depending on success and the situation on the board.
	 * @param target the target position.
	 */
	void place(String target);
	
	/**
	 * Tries to move a token from one position to another.
	 * Handles false input, switches players and sets internal states depending on success and current position on the board.
	 * @param source source position.
	 * @param target target position.
	 */
	void move(String source, String target);
	
	/**
	 * Tries to take a token from the opposing player from the board
	 * Handles false input, switches players and sets internal states depending on success and current position on the board.
	 * @param target target position.
	 */
	void steal(String target);
	
	/**
	 * Gets a message with feedback.
	 * @return a message about the correctness of the last input.
	 */
	String getMessage();
	
	/**
	 * Gets a state which gets used in internal if clauses.
	 * @return a state as predefined String.
	 */
	String getStatus();
	
	
	/**
	 * Gets a message about what to do next.
	 * @return the current player and what kind of action he has do to, e.g. place or steal.
	 */
	String nextInstruction();
}
