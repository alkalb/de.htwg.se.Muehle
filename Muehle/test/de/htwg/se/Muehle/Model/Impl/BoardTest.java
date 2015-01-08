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
	Field fields[];
	final int FIELDCOUNT = 24;
	int[] connectionsAtFive;
	
	@Before
	public void setUp(){
		b = new Board();
		p1 = new Player("Gustav", Color.BLACK);
		index = 1;
		f1 = new Field(p1, index);
		
		fields = new Field[FIELDCOUNT];
		for(int i = 0; i < fields.length; i++){
			fields[i] = new Field(null, i);
		}
		fields[1].setPlayerOfField(p1);
		connectionsAtFive = new int[]{-1,4,13,6};
		
	}

	@Test
	public void testIsPositionEmpty(){
		assertSame(true, b.isPositionEmpty(1));
	}
	
	

	@Test
	public void testSetPosition(){
		assertSame(true, b.isPositionEmpty(1));
		b.setPosition(1, p1);
		assertSame(false, b.isPositionEmpty(1));
	}
	
	@Test
	public void testGetFields(){

		fields[1].setPlayerOfField(p1);
		b.setPosition(1, p1);
	
		assertArrayEquals(fields, b.getFields());
	}
	
	
	@Test
	public void testGetConnections(){
		assertArrayEquals(connectionsAtFive, b.getConnections().get(5));
	}
	

}