package de.htwg.se.Muehle.Model.Impl;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {

 Board b;
 Token t1;
 Position pos;
 Player p1;

 @Before
 public void setUp(){
 b = new Board();
 p1 = new Player("Gustav", Color.BLACK);
 pos = new Position(111);
 t1 = new Token(p1, pos, "ready");
 }

 @Test
 public void testIsPositionEmpty(){
 assertSame(true, b.isPositionEmpty(1));
 }

 @Test
 public void testSetPosition(){
 assertSame(true, b.isPositionEmpty(1));
 b.setPosition(1, t1);
 assertSame(false, b.isPositionEmpty(1));
 }

}