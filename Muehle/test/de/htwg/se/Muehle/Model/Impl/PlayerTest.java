package de.htwg.se.Muehle.Model.Impl;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
	
	Player p1;
	Player p1Clone;
	Player p2;
	
	@Before
	public void setUp() throws Exception{
		p1 = new Player("Hans", Color.WHITE);
		p1Clone = new Player("Hans", Color.WHITE);
		p2 = new Player("Guenther", Color.BLACK);
	}
	
	@Test
	public void testGetName(){
		assertSame("Hans", p1.getName());
	}
	
	@Test
	public void testGetColor(){
		assertSame("W", p1.getColor());
		assertNotSame("W", p2.getColor());
	}
	
	@Test
	public void testGetTokenCount(){
		assertSame(0, p1.getTokenCount());
	}
	
	@Test
	public void testGetPlaceableTokenCount(){
		assertSame(9, p1.getPlaceableTokenCount());
	}
	
	@Test
	public void testSetTokenCount(){
		assertSame(0, p1.getTokenCount());
		p1.setTokenCount(p1.getTokenCount() + 1);
		assertSame(1, p1.getTokenCount());
	}
	
	@Test
	public void testSetPlaceableTokenCount(){
		assertSame(9, p1.getPlaceableTokenCount());
		p1.setPlaceableTokenCount(p1.getPlaceableTokenCount() - 1);
		assertSame(8, p1.getPlaceableTokenCount());
	}
	
	@Test
	public void testEquals(){
		assertFalse(p1.equals(p2));
	}

}