package de.htwg.se.Muehle.Controller.Impl;

import de.htwg.se.Muehle.Controller.ITurnController;
import de.htwg.se.Muehle.Controller.IGameController;
import de.htwg.se.Muehle.Model.IBoard;
import de.htwg.se.Muehle.Model.IPlayer;

public class TurnController implements ITurnController {
	
	private IGameController gameCont;
	private IBoard board;
	private String status;
	private String message;
	
	public TurnController(IGameController gc){
		gameCont = gc;
		board = gc.getBoard();
		status = "place";
	}
	
	
	

	public void place(String target) {
		try{
			int x = Integer.parseInt(target);
			if(x >= 0 && x <= 23 && gameCont.placeToken(x)){
				
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
			} else if(x >= 0 && x <= 23 && y >= 0 && y <= 23 && gameCont.moveToken(x, y)) {
				if(gameCont.isMill(y, gameCont.getCurrPlayer())){
					status = "steal";
					message = "Sie haben eine Mühle.";
					return;
				} else {
					gameCont.nextPlayer();
					message = "Stein erfolgreich gesetzt.";
					status = "move";
				}
				
				
			}
			
			
			
			
			
		} catch(NumberFormatException e){
			message = "Bitte 2 Zahlen zwischen 0 und 23 angeben.";
		}
			
			
			
	}


	public void steal(String target) {
		// TODO Auto-generated method stub

	}

	public String getMessage(){
		return message;
	}
	
	public String getStatus(){
		return status;
	}


}
