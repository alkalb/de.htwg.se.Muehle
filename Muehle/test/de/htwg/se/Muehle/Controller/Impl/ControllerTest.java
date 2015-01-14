package de.htwg.se.Muehle.Controller.Impl;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.Muehle.Model.IBoard;
import de.htwg.se.Muehle.Model.IPlayer;
import de.htwg.se.Muehle.Model.Impl.Player;

public class ControllerTest {
	GameController cont;
	IPlayer p1;
	IPlayer p2;
	private static final int INDEXES = 0;
	
	@Before
	public void setUp(){
		p1 = new Player("Heidi", Color.WHITE);
		p2 = new Player("Franz", Color.WHITE);
		cont = new GameController(p1, p2);
	}

	@Test
	public void playerControlTest() {
		assertSame(p1, cont.getCurrPlayer());
		assertSame(p2, cont.getOppPlayer());
		cont.nextPlayer();
		assertNotSame(p1, cont.getCurrPlayer());
		assertNotSame(p2, cont.getOppPlayer());
		IBoard testBoard = cont.getBoard();
		for(int i = 0 ; i <= INDEXES; i++){
			assertTrue(testBoard.isPositionEmpty(i));
		}
	}

	@Test
	public void LogicTest(){
		//placelogic tests
		assertTrue(cont.placeToken(0));
		assertFalse(cont.placeToken(0));
		//ismill tests
		assertFalse(cont.isMill(0, p1));
		assertFalse(cont.isMill(1,  p1));
		cont.placeToken(2);
		cont.placeToken(6);
		cont.placeToken(4);
		assertFalse(cont.isMill(0, p1));
		assertFalse(cont.isMill(2, p1));
		assertFalse(cont.isMill(6, p1));
		assertFalse(cont.isMill(4, p1));
		cont.nextPlayer();
		assertFalse(cont.isMill(1, p2));
		assertFalse(cont.isMill(9, p2));
		cont.placeToken(1);
		cont.placeToken(9);
		assertFalse(cont.isMill(1, p2));
		assertFalse(cont.isMill(9, p2));
		cont.placeToken(17);
		cont.placeToken(12);
		cont.placeToken(13);
		cont.placeToken(14);
		assertTrue(cont.isMill(13, p2));
		assertTrue(cont.isMill(14, p2));
		assertTrue(cont.isMill(12, p2));
		assertTrue(cont.isMill(1, p2));
		assertTrue(cont.isMill(9, p2));
		assertTrue(cont.isMill(17, p2));
		cont.placeToken(19);
		assertFalse(cont.isMill(19, p2));
		cont.placeToken(3);
		assertFalse(cont.isMill(3, p2));
		cont.placeToken(11);
		assertTrue(cont.isMill(3, p2));
		assertTrue(cont.isMill(19, p2));
		//placelogic
		assertFalse(cont.placeToken(15));
		//milllogic
		cont.nextPlayer();
		cont.placeToken(21);
		cont.placeToken(22);
		cont.placeToken(23);
		assertFalse(cont.isMill(21, p1));
		assertFalse(cont.isMill(22, p1));
		assertFalse(cont.isMill(23, p1));
	}

	
	//moveTest
	@Test
	public void LogicTest2(){	
		cont = new GameController(p1, p2);
		cont.placeToken(5);
		assertFalse(cont.isMill(5, p1));
		cont.placeToken(13);
		assertFalse(cont.isMill(5, p1));
		cont.placeToken(7);
		cont.placeToken(15);
		cont.placeToken(11);
		assertFalse(cont.isMill(11, p1));
		cont.placeToken(3);
		assertFalse(cont.isMill(7, p1));
		assertFalse(cont.isMill(15, p1));
		assertFalse(cont.isMill(11, p1));
		assertFalse(cont.isMill(3, p1));
	    //milllogic finished
		
		
		cont = new GameController(p1, p2);
		//token cornered
		cont.placeToken(6);
		cont.getCurrPlayer().setTokenCount(4);
		
		cont.placeToken(16);
		assertTrue(cont.moveToken(16, 17));
		assertFalse(cont.moveToken(17, 23));
		assertFalse(cont.moveToken(7, 15));
		cont.placeToken(16);
		assertFalse(cont.moveToken(16, 17));
		cont.getCurrPlayer().setPlaceableTokenCount(0);
		cont.getCurrPlayer().setTokenCount(3);
		assertTrue(cont.moveToken(17, 2));
		assertFalse(cont.moveToken(17,3));
		assertFalse(cont.moveToken(15,3));
		assertTrue(cont.isMoveAllowed());
		cont.getCurrPlayer().setTokenCount(2);
		cont.getCurrPlayer().setPlaceableTokenCount(6);
		cont.placeToken(13);
		cont.placeToken(5);
		cont.placeToken(7);
		cont.placeToken(0);
		cont.placeToken(1);
		cont.placeToken(9);
		cont.nextPlayer();
		assertFalse(cont.isMoveAllowed());
		//cornered Token movetest
		cont.nextPlayer();
		assertTrue(cont.isMoveAllowed());
	}
	
	//steallogic tests
	@Test
	public void LogicTest3(){
		cont = new GameController(p1, p2);
		cont.placeToken(0);
		cont.placeToken(1);
		cont.placeToken(2);
		cont.placeToken(3);
		cont.placeToken(7);
		cont.nextPlayer();
		cont.placeToken(22);
		assertFalse(cont.isStealAllowed(22));
		assertFalse(cont.isStealAllowed(1));
		assertTrue(cont.isStealAllowed(7));
		
		cont.getOppPlayer().setTokenCount(3);
		
		assertFalse(cont.isStealAllowed(1));
		assertTrue(cont.isStealAllowed(7));
		
		cont.getOppPlayer().setPlaceableTokenCount(0);
		
		assertTrue(cont.isStealAllowed(1));
		assertTrue(cont.isStealAllowed(7));
		
		cont.getOppPlayer().setTokenCount(2);
		assertTrue(cont.isStealAllowed(1));
		
		
		cont.getOppPlayer().setTokenCount(5);
		cont.getOppPlayer().setPlaceableTokenCount(4);
		assertTrue(cont.isStealAllowed());
		assertTrue(cont.stealToken(7));
		assertFalse(cont.stealToken(1));
		cont.stealToken(3);
		assertFalse(cont.isStealAllowed());
		
		
	}
	
	
	
}
