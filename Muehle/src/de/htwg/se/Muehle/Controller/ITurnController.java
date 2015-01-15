package de.htwg.se.Muehle.Controller;

import de.htwg.se.Muehle.Util.IObservable;

public interface ITurnController extends IObservable{
	
	void place(String target);
	
	void move(String source, String target);
	
	void steal(String target);
	
	String getMessage();
	
	String getStatus();
	
	String nextInstruction();
}
