package de.htwg.se.Muehle.Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Board {
	
	Token board[];
	HashMap<Integer, ArrayList<Integer>> connections;
	
	public Board(){
		board = new Token[24];
		/*for(int i = 0; i < board.length; i++){
			board[i] = new Token(null, null, null);
		}*/
		
		connections = new HashMap<Integer, ArrayList<Integer>>();
		/*for(int i = 0; i < 24; i++){
			
		}*/
	}
	
	public boolean isPositionEmpty(int x){
		if(board[x] != null){
			return false;
		} else {
			return true;
		}
	}
	
	public void setPosition(int x, Token t){
		board[x] = t;
	}
}
