package de.htwg.se.Muehle.Util.Impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.htwg.se.Muehle.Util.Event;
import de.htwg.se.Muehle.Util.IObservable;
import de.htwg.se.Muehle.Util.IObserver;

public class Observable implements IObservable{

	private List<IObserver> subscribers = new ArrayList<IObserver>();
	
	@Override
	public void addObserver(IObserver s) {
		subscribers.add(s);
	}

	@Override
	public void removeObserver(IObserver s) {
		subscribers.remove(s);
	}

	@Override
	public void removeAllObserver() {
		subscribers.clear();
	}

	@Override
	public void notifyObservers() {
		notifyObservers(null);
	}

	@Override
	public void notifyObservers(Event e) {
		for(Iterator<IObserver> iterator = subscribers.iterator(); iterator.hasNext();){
			IObserver observer = iterator.next();
			observer.update(e);
		}
	}
	
	

}
