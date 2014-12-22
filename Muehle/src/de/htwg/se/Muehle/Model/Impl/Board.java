package de.htwg.se.Muehle.Model.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Board {

 private final static int tokenCount = 24;
 private Token board[];
 private Map<Integer, ArrayList<Integer>> connections;

 public Board(){
 board = new Token[tokenCount];
 /*for(int i = 0; i < board.length; i++){
	board[i] = new Token(null, null, null);
	}*/

 connections = new HashMap<Integer, ArrayList<Integer>>();
 /*for(int i = 0; i < 24; i++){
	
	}*/
 }

 public boolean isPositionEmpty(int x){

 return (board[x] == null);

 }

 public void setPosition(int x, Token t){
 board[x] = t;
 }
}