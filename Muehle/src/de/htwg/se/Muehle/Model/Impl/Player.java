package de.htwg.se.Muehle.Model.Impl;


import java.awt.Color;

public class Player {
	private String name;
	private Color color;
	private int tokenCount;
	private int placeableTokenCount;
	private static final int MAXTOKEN = 9;
	
	public Player(String name, Color color){
		this.name = name;
		this.color = color;
		this.tokenCount = 0;
		this.placeableTokenCount = MAXTOKEN;
	}
	
	public String getName(){
		return name;
	}
	
	public Color getColor(){
		return color;
	}
	
	public int getTokenCount(){
		return tokenCount;
	}
	
	public int getPlaceableTokenCount(){
		return placeableTokenCount;
	}
	
	public void setTokenCount(int x){
		tokenCount = x;
	}
	
	public void setPlaceableTokenCount(int x){
		placeableTokenCount = x;
	}
}
