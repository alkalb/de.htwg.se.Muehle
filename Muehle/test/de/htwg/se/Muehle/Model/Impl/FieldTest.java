package de.htwg.se.Muehle.Model.Impl;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

public class FieldTest {

	Player p1;
	Field f1;
	int index;
	Player p2;

	@Before
	public void setUp(){
		p1 = new Player("Gustav", Color.BLACK);
		index = 1;
		f1 = new Field(p1, index);
		p2 = new Player("Hans", Color.WHITE);
	}

	@Test
	public void testGetPlayerOfField(){
		assertSame(p1, f1.getPlayerOfField());
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
	
	
	
	
}