package de.htwg.se.Muehle.Controller;

public interface ITurnController {
	
	void place(String target);
	
	void move(String source, String target);
	
	void steal(String target);
	
	String getMessage();
	
	String getStatus();
	
	
	

}
