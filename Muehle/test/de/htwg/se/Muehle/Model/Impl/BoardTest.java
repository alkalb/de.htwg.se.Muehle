package de.htwg.se.Muehle.Model.Impl;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {

	Board b;
	Field f1;
	int index;
	Player p1;

	@Before
	public void setUp(){
		b = new Board();
		p1 = new Player("Gustav", Color.BLACK);
		index = 1;
		f1 = new Field(p1, index);
	}

	@Test
	public void testIsPositionEmpty(){
		assertSame(true, b.isPositionEmpty(1));
	}
	
	public void testGetFields(){
		
	}

	@Test
	public void testSetPosition(){
		assertSame(true, b.isPositionEmpty(1));
		b.setPosition(1, p1);
		assertSame(false, b.isPositionEmpty(1));
	}
	
	
	
	
	
}