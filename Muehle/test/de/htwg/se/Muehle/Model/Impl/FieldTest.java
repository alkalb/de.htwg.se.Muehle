package de.htwg.se.Muehle.Model.Impl;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

public class FieldTest {

	Player p1;
	Field f1;
	Field f1Clone;
	Field f2;
	Field f3;
	Field f4;
	int index;
	Player p2;

	@Before
	public void setUp(){
		p1 = new Player("Gustav", Color.BLACK);
		index = 1;
		f1 = new Field(p1, index);
		f1Clone = new Field(p1, index);
		p2 = new Player("Hans", Color.WHITE);
		f2 = new Field(p2, index);
		f3 = new Field(p1, 0);
		f4 = new Field(null, 5);
	}

	@Test
	public void testGetPlayerOfField(){
		assertSame(p1, f1.getPlayerOfField());
	}
	
	@Test
	public void testGetFieldColor(){
		assertEquals("\u25CB", f2.getFieldColor());
		assertSame(" ", f4.getFieldColor());
		
	}
	
	@Test
	public void testGetFieldIndex(){
		assertSame(index, f1.getFieldIndex());
	}
	
	@Test
	public void testsetPlayerOfField(){
		f1.setPlayerOfField(p2);
		assertSame(p2, f1.getPlayerOfField());
	}
	
	@Test
	public void testequals(){
		assertTrue(f1.equals(f1Clone));
		assertFalse(f1.equals(f2));
		assertFalse(f1.equals(f3));
	}
	
	
}