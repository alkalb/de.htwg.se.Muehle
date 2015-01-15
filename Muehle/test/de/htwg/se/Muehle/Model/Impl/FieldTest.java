package de.htwg.se.Muehle.Model.Impl;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.Muehle.Model.IField;
import de.htwg.se.Muehle.Model.IPlayer;

public class FieldTest {

	IPlayer p1, error, p2;
	IField f1, f1Clone, f2, f3, f4;
	int index;

	@Before
	public void setUp(){
		p1 = new Player("Gustav", Color.BLACK);
		error = new Player("error", Color.MAGENTA);
		index = 1;
		f1 = new Field(p1, index);
		f1Clone = new Field(p1, index);
		p2 = new Player("Hans", Color.WHITE);
		f2 = new Field(p2, index);
		f3 = new Field(p1, 0);
		f4 = new Field(error, 5);
	}

	@Test
	public void testGetPlayerOfField(){
		assertSame(p1, f1.getPlayerOfField());
	}
	
	@Test
	public void testGetFieldColor(){
		assertEquals("W", f2.getFieldColor());
		assertSame(" ", f4.getFieldColor());
		
	}
	
	@Test
	public void testequals(){
		String a = new String("hi");
		assertFalse(f1.equals(a));
		assertFalse(f1.equals(f2));
		
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
	public void testHash(){
		assertEquals(f1.hashCode(), f1Clone.hashCode());
	}

}