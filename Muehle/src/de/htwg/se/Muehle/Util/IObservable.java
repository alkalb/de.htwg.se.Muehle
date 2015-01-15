package de.htwg.se.Muehle.Util;

public interface IObservable {
	
	void addObserver(IObserver s);
	
	void removeObserver(IObserver s);
	
	void removeAllObserver();
	
	void notifyObservers();
	
	void notifyObservers(Event e);
}
