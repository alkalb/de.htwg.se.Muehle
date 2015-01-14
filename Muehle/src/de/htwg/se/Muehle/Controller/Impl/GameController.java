package de.htwg.se.Muehle.Controller.Impl;

import java.awt.Color;
import java.util.Map;

import de.htwg.se.Muehle.Controller.IGameController;
import de.htwg.se.Muehle.Model.IBoard;
import de.htwg.se.Muehle.Model.IField;
import de.htwg.se.Muehle.Model.IPlayer;
import de.htwg.se.Muehle.Model.Impl.Board;
import de.htwg.se.Muehle.Model.Impl.Player;


public class GameController implements IGameController {
	private IPlayer currPlayer, oppPlayer, error;
	private IBoard board;
	private Map<Integer, int[]> connections;
	private static final int TOP = 0;
	private static final int RIGHT = 1;
	private static final int BOTTOM = 2;
	private static final int LEFT = 3;
	private static final int CORNERCHECK = 3;
	private static final int TOKENAMOUNTFORJUMP = 3;
	private static final int STEALABLECHECK = 3;
	
	public GameController(IPlayer p1, IPlayer p2) {
		error = new Player("error", Color.MAGENTA);
		
		this.currPlayer = p1;
		this.oppPlayer = p2;
		this.board = new Board();
		this.connections = board.getConnections();
	}
	

	public void nextPlayer(){
		IPlayer temp = currPlayer;
		currPlayer = oppPlayer;
		oppPlayer = temp;
	}
	
	public boolean isMill(int x, IPlayer p){
		if(x % 2 == 0){
			return checkCorner(x, p);
		} else {
			return checkBetween(x, p);
		}
	}
	
	
	
	private boolean checkBetween(int x, IPlayer p){
		return checkVertical(x, p) || checkHorizontal(x, p);
	}
	
	private boolean checkVertical(int x, IPlayer p){
		IField[] fields = board.getFields();
		int temp[] = connections.get(x);
		if(temp[TOP] == -1){
			if(fields[temp[BOTTOM]].getPlayerOfField().equals(p) && fields[connections.get(temp[BOTTOM])[BOTTOM]].getPlayerOfField().equals(p)){
				return true;
			}
		} else if (temp[BOTTOM] == -1){
			if(fields[temp[TOP]].getPlayerOfField().equals(p) && fields[connections.get(temp[TOP])[TOP]].getPlayerOfField().equals(p)){
				return true;
			}
		} else {
			if(fields[temp[TOP]].getPlayerOfField().equals(p) && fields[temp[BOTTOM]].getPlayerOfField().equals(p)){
				return true;
			}
		}
		
		return false;
	}
	
	private boolean checkHorizontal(int x, IPlayer p){
		IField[] fields = board.getFields();
		int temp[] = connections.get(x);
		if(temp[RIGHT] == -1){
			if(fields[temp[LEFT]].getPlayerOfField().equals(p) && fields[connections.get(temp[LEFT])[LEFT]].getPlayerOfField().equals(p)){
				return true;
			}
		} else if (temp[LEFT] == -1){
			if(fields[temp[RIGHT]].getPlayerOfField().equals(p) && fields[connections.get(temp[RIGHT])[RIGHT]].getPlayerOfField().equals(p)){
				return true;
			}
		} else {
			if(fields[temp[RIGHT]].getPlayerOfField().equals(p) && fields[temp[LEFT]].getPlayerOfField().equals(p)){
				return true;
			}
		}
		
		return false;
	}
	
	
	private boolean checkCorner(int x, IPlayer p){
		
		IField[] fields = board.getFields();
		int temp[] = connections.get(x);
		for(int i= 0; i<=CORNERCHECK; i++){
			
			if(temp[i] != -1 && fields[temp[i]].getPlayerOfField().equals(p) && fields[connections.get(temp[i])[i]].getPlayerOfField().equals(p)){
				return true;
			}
		}
		return false;
	}

	
	public boolean isMoveAllowed(){
		if(currPlayer.getTokenCount() == TOKENAMOUNTFORJUMP){
			return true;
		}
		
		IField[] fields = board.getFields();
		for(IField f : fields){
			if(f.getPlayerOfField().equals(currPlayer)){
				int temp[] = connections.get(f.getFieldIndex());
				for(int i = 0; i< temp.length; i++){
					if(temp[i] != -1 && isMoveAllowed(f.getFieldIndex(), temp[i])){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean isMoveAllowed(int x, int y){
		IField[] fields = board.getFields();
		if(!fields[x].getPlayerOfField().equals(currPlayer)){
			return false;
		}
		
		return isTargetEmpty(x, y);
	}
	
	private boolean isTargetEmpty(int x, int y){
		if(!board.isPositionEmpty(y)){
			return false;
		}
		
		return isJumpAllowed(x, y);
	}
	
	private boolean isJumpAllowed(int x, int y){
		if(currPlayer.getTokenCount() == TOKENAMOUNTFORJUMP){
			return true;
		}
		
		
		return isConnectionAvailable(x, y);
	}
	
	private boolean isConnectionAvailable(int x, int y){
		for(int i: connections.get(x)){
			if(i == y){
				return true;
			}
		}
		return false;
	}
	
	public boolean isPlacementAllowed(int x){
		return board.isPositionEmpty(x);
	}
	
	public boolean isStealAllowed(){
		for(IField f : board.getFields()){
			if(isStealAllowed(f.getFieldIndex())){
				return true;
			}
		}
		return false;
	}
	
	public boolean isStealAllowed(int x){
		IField[] fields = board.getFields();
		if(fields[x].getPlayerOfField().equals(oppPlayer)){
			return isTokenStealable(x);
		}
		return false;
	}

	private boolean isTokenStealable(int x) {
		if(isMill(x, oppPlayer) && (oppPlayer.getTokenCount() > STEALABLECHECK || oppPlayer.getTokenCount() == STEALABLECHECK && oppPlayer.getPlaceableTokenCount() > 0)){
			return false;
		}
		
		return true;
	}
	
	public boolean placeToken(int x){
		if(isPlacementAllowed(x) && currPlayer.getPlaceableTokenCount() > 0){
			board.setPosition(x, currPlayer);
			currPlayer.setPlaceableTokenCount(currPlayer.getPlaceableTokenCount() - 1);
			currPlayer.setTokenCount(currPlayer.getTokenCount() + 1);
			return true;
		}
		return false;
	}
	
	public boolean stealToken(int x){
		if(isStealAllowed(x)) {
			board.setPosition(x, error);
			oppPlayer.setTokenCount(oppPlayer.getTokenCount() - 1);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean moveToken(int x, int y){
		if(isMoveAllowed(x, y)){
			board.setPosition(x, error);
			board.setPosition(y, currPlayer);
			return true;
		}
		return false;
	}
	
	public IBoard getBoard(){
		return board;
	}
	
	public IPlayer getCurrPlayer(){
		return currPlayer;
	}
	
	public IPlayer getOppPlayer(){
		return oppPlayer;
	}
	
	
}
