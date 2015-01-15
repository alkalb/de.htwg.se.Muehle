package de.htwg.se.Muehle.Controller.Impl;

import de.htwg.se.Muehle.Controller.ITurnController;
import de.htwg.se.Muehle.Controller.IGameController;
import de.htwg.se.Muehle.Util.Impl.Observable;


public class TurnController extends Observable implements ITurnController{
	
	private IGameController gameCont;
	private String status;
	private String message;
	private static final String PLACE ="place";
	private static final String MOVE ="move";
	private static final String STEAL ="steal";
	private static final String LOSE ="lose";
	private static final int MININDEX = 0;
	private static final int MAXINDEX = 23;
	
	public TurnController(IGameController gc){
		gameCont = gc;
		status = PLACE;
		message = "Spielstart";
	}
	
	
	

	public void place(String target) {
		try{
			int x = Integer.parseInt(target);
			if(isIndexAllowed(x) && gameCont.placeToken(x)){
				if(gameCont.isMill(x, gameCont.getCurrPlayer())){
					status = STEAL;
					message = "Sie haben eine Mühle.";
					notifyObservers();
					return;
				} else {
					gameCont.nextPlayer();
					message = "Stein erfolgreich gesetzt.";
					if(gameCont.getCurrPlayer().getPlaceableTokenCount() == 0){
						status = MOVE;
						message = "Stein erfolgreich gesetzt,\nSetzphase beendet";
					}
					notifyObservers();
					return;
				}
			} else {
				message = "Ungültiges Feld zum platzieren angegeben,\nbitte Spielfeld beachten.";
				notifyObservers();
				return;
			}
		} catch(NumberFormatException e) {
			message = "Bitte Zahl zwischen 0 und 23 angeben.";
			notifyObservers();
		}
	}


	public void move(String source, String target) {
		try{
			int x = Integer.parseInt(source);
			int y = Integer.parseInt(target);
			
			if(!gameCont.isMoveAllowed()){
				status = LOSE;
				notifyObservers();
				return;
			} else if(isIndexAllowed(x) && isIndexAllowed(y) && gameCont.moveToken(x, y)) {
				
				
				if(gameCont.isMill(y, gameCont.getCurrPlayer())){
					status = STEAL;
					message = "Sie haben eine Mühle.";
					notifyObservers();
					return;
				} else {
					gameCont.nextPlayer();
					message = "Der Stein wurde erfolgreich gesetzt.";
					notifyObservers();
					return;
				}
				
				
				
			} else {
				message = "Zug nicht möglich, bitte Spielfeld beachten.";
				notifyObservers();
				return;
			}
		} catch(NumberFormatException e){
			message = "Bitte 2 Zahlen zwischen 0 und 23 angeben.";
			notifyObservers();
		}
	}
  

	public void steal(String target) {
		try{
			int x = Integer.parseInt(target);
			if(!gameCont.isStealAllowed()){
				message = "Kein Stein kann gestohlen werden.";
				gameCont.nextPlayer();
				
				if(gameCont.getCurrPlayer().getPlaceableTokenCount() == 0){
					status = MOVE;
					notifyObservers();
					return;
				}
				status = PLACE;
				notifyObservers();
				return;
			} else if(isIndexAllowed(x) && gameCont.stealToken(x)) {
				message = "Stein wurde geklaut";
				gameCont.nextPlayer();
				
				
				if(gameCont.getCurrPlayer().getTokenCount() == 2 && gameCont.getCurrPlayer().getPlaceableTokenCount() == 0){
					status = LOSE;
					notifyObservers();
					return;
				}
				if(gameCont.getCurrPlayer().getPlaceableTokenCount() == 0){
					status = MOVE;
					notifyObservers();
					return;
				}
				status = PLACE;
				notifyObservers();
				return;
			} else {
				message = "Kein stehlbarer Stein an dieser Stelle.";
				notifyObservers();
				return;
			}
			
		} catch(NumberFormatException e){
			message = "Bitte Zahl zwischen 0 und 23 angeben.";
			notifyObservers();
		}
	}

	public String getMessage(){
		return message;
	}
	
	public String getStatus(){
		return status;
	}

	private boolean isIndexAllowed(int x){
		return(x >= MININDEX && x <= MAXINDEX);
	}

	public String nextInstruction(){
		String stat = getStatus();
		switch(stat){
		case PLACE:
			return gameCont.getCurrPlayer().getName() + ": Setzen sie einen Stein.";
		case MOVE:
			return gameCont.getCurrPlayer().getName() + ": Bewegen sie einen Stein.";
		case STEAL:
			return gameCont.getCurrPlayer().getName() + ": Stehlen sie einen Stein.";
		default:
			return gameCont.getCurrPlayer().getName() + ": Sie haben verloren.";
		}
	}
}
