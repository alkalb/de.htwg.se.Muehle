package de.htwg.se.Muehle.Controller.Impl;

import de.htwg.se.Muehle.Controller.ITurnController;
import de.htwg.se.Muehle.Controller.IGameController;


public class TurnController implements ITurnController {
	
	private IGameController gameCont;
	private String status;
	private String message;
	private final static int MININDEX = 0;
	private final static int MAXINDEX = 23;
	
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
				status = "move";
				return;
			} else if(isIndexAllowed(x) && gameCont.stealToken(x)) {
				message = "Stein wurde geklaut";
				gameCont.nextPlayer();
				if(gameCont.getCurrPlayer().getTokenCount() == 2 && gameCont.getCurrPlayer().getPlaceableTokenCount() == 0){
					status = "lose";
					return;
				}
				status = "move";
				return;
			} else {
				message = "Kein stehlbarer Stein an dieser Stelle.";
				return;
			}
			
		} catch(NumberFormatException e){
			message = "Bitte eine Zahl zwischen 0 und 23 angeben.";
		}
	}

	public String getMessage(){
		return message;
	}
	
	public String getStatus(){
		return status;
	}

	private boolean isIndexAllowed(int x){
		if(x >= MININDEX && x <= MAXINDEX){
			return true;
		} else {
			return false;
		}
	}

}
