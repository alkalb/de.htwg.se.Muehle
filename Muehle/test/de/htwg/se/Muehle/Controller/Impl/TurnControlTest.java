package de.htwg.se.Muehle.Controller.Impl;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.Muehle.Controller.IGameController;
import de.htwg.se.Muehle.Controller.ITurnController;
import de.htwg.se.Muehle.Model.IPlayer;
import de.htwg.se.Muehle.Model.Impl.Player;

public class TurnControlTest {
	
	IPlayer p1, p2;
	IGameController cont;
	ITurnController turn;
	

	@Before
	public void setUp(){
		p1 = new Player("Heidi", Color.WHITE);
		p2 = new Player("Franz", Color.WHITE);
		cont = new GameController(p1, p2);
	}
	
	
	@Test
	public void test() {
		assertTrue(true);
	}

}
