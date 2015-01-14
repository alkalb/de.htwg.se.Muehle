package de.htwg.se.Muehle.Controller.Impl;

import de.htwg.se.Muehle.Controller.ITurnController;
import de.htwg.se.Muehle.Controller.IGameController;


public class TurnController implements ITurnController {
	
	private IGameController gameCont;
	private String status;
	private String message;
	private static final int MININDEX = 0;
	private static final int MAXINDEX = 23;
	
	public TurnController(IGameController gc){
		gameCont = gc;
		status = "place";
	}
	
	
	

	public void place(String target) {
		try{
			int x = Integer.parseInt(target);
			if(isIndexAllowed(x) && gameCont.placeToken(x)){
				if(gameCont.isMill(x, gameCont.getCurrPlayer())){
					status = "steal";
					message = "Sie haben eine Mühle.";
					return;
				} else {
					gameCont.nextPlayer();
					message = "Stein erfolgreich gesetzt.";
					if(gameCont.getCurrPlayer().getPlaceableTokenCount() == 0){
						status = "move";
						message = "Stein erfolgreich gesetzt, Setzphase beendet";
					}
					return;
				}
			} else {
				message = "Ungültiges Feld zum platzieren angegeben, bitte Spielfeld beachten.";
				return;
			}
		} catch(NumberFormatException e) {
			message = "Bitte Zahl zwischen 0 und 23 angeben.";
		}
	}


	public void move(String source, String target) {
		try{
			int x = Integer.parseInt(source);
			int y = Integer.parseInt(target);
			
			if(!gameCont.isMoveAllowed()){
				status = "lose";
				return;
			} else if(isIndexAllowed(x) && isIndexAllowed(y) && gameCont.moveToken(x, y)) {
				
				
				if(gameCont.isMill(y, gameCont.getCurrPlayer())){
					status = "steal";
					message = "Sie haben eine Mühle.";
					return;
				} else {
					gameCont.nextPlayer();
					message = "Stein erfolgreich gesetzt.";
					return;
				}
				
				
				
			} else {
				message = "Zug nicht möglich, bitte Spielfeld beachten.";
				return;
			}
		} catch(NumberFormatException e){
			message = "Bitte 2 Zahlen zwischen 0 und 23 angeben.";
		}
	}
  

	public void steal(String target) {
		try{
			int x = Integer.parseInt(target);
			if(!gameCont.isStealAllowed()){
				message = "Kein Stein kann gestohlen werden.";
				gameCont.nextPlayer();
				
				if(gameCont.getCurrPlayer().getPlaceableTokenCount() == 0){
					status = "move";
					return;
				}
				status = "place";
				return;
			} else if(isIndexAllowed(x) && gameCont.stealToken(x)) {
				message = "Stein wurde geklaut";
				gameCont.nextPlayer();
				
				
				if(gameCont.getCurrPlayer().getTokenCount() == 2 && gameCont.getCurrPlayer().getPlaceableTokenCount() == 0){
					status = "lose";
					return;
				}
				if(gameCont.getCurrPlayer().getPlaceableTokenCount() == 0){
					status = "move";
					return;
				}
				status = "place";
				return;
			} else {
				message = "Kein stehlbarer Stein an dieser Stelle.";
				return;
			}
			
		} catch(NumberFormatException e){
			message = "Bitte Zahl zwischen 0 und 23 angeben.";
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
		case "place":
			return gameCont.getCurrPlayer().getName() + ": Setzen sie einen Stein.";
		case "move":
			return gameCont.getCurrPlayer().getName() + ": Bewegen sie einen Stein.";
		case "steal":
			return gameCont.getCurrPlayer().getName() + ": Stehlen sie einen Stein.";
		default:
			return gameCont.getCurrPlayer().getName() + ": Sie haben verloren.";
		}
	}
	
}
