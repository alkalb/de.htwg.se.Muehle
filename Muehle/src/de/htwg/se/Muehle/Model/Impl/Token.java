package de.htwg.se.Muehle.Model.Impl;

public class Token {
	private Player playerOfToken;
	private Position tokenPosition;
	private String tokenState;

	public Token(Player playerOfToken, Position position, String tokenState){
		this.playerOfToken = playerOfToken;
		this.tokenPosition = position;
		this.tokenState = tokenState;
	}

	public Player getPlayerOfToken(){
		return playerOfToken;
	}

	public Position getTokenPosition(){
		return tokenPosition;
	}

	public String getTokenState(){
		return tokenState;
	}

	public void setTokenState(String s){
		tokenState = s;
	}
}