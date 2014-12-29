package de.htwg.se.Muehle.Model.Impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PositionTest {

	Position p;

	@Before
	public void setUp(){
		p = new Position(123);
	}

	@Test
	public void testGetPosition(){
		assertSame(123, p.getPosition());
	}
}