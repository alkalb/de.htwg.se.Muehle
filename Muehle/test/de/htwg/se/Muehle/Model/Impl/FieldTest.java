package de.htwg.se.Muehle.Model.Impl;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

public class FieldTest {

	Player p1;
	Field f1;
	int index;

	@Before
	public void setUp(){
		p1 = new Player("Gustav", Color.BLACK);
		index = 1;
		f1 = new Field(p1, index);
	}

	@Test
	public void testGetPlayerOfToken(){
		assertSame(p1, f1.getPlayerOfField());
	}
}