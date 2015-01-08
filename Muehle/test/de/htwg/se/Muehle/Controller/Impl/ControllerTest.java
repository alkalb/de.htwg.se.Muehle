package de.htwg.se.Muehle.Controller.Impl;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.Muehle.Model.Impl.Field;
import de.htwg.se.Muehle.Model.Impl.Player;

public class ControllerTest {
	GameController cont;
	Player p1;
	Player p2;
	
	
	@Before
	public void setUp(){
		cont = new GameController(p1, p2);
		
	}

	@Test
	public void test() {
		assertTrue(1 == 1);
	}

}
