package de.htwg.se.Muehle.Controller.Impl;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.Muehle.Controller.IGameController;
import de.htwg.se.Muehle.Controller.ITurnController;
import de.htwg.se.Muehle.Model.IPlayer;
import de.htwg.se.Muehle.Model.Impl.Player;

public class TurnControlTest {
	
	IPlayer p1, p2;
	IGameController cont;
	ITurnController turn;
	

	@Before
	public void setUp(){
		p1 = new Player("Heidi", Color.WHITE);
		p2 = new Player("Franz", Color.WHITE);
		cont = new GameController(p1, p2);
		turn = new TurnController(cont);
	}
	
	 
	@Test
	public void test() {
		turn.place("-1");
		turn.place("25");
		assertEquals(turn.getMessage(), "Ungültiges Feld zum platzieren angegeben, bitte Spielfeld beachten.");
		
		turn.place("hallo");
		assertEquals(turn.getMessage(), "Bitte Zahl zwischen 0 und 23 angeben.");
		turn.place("0");
		assertEquals(turn.getMessage(), "Stein erfolgreich gesetzt.");
		assertEquals(turn.getStatus(), "place");
		turn.place("20");
		turn.place("0");
		assertEquals(turn.getMessage(), "Ungültiges Feld zum platzieren angegeben, bitte Spielfeld beachten.");
		assertEquals(turn.nextInstruction(), cont.getCurrPlayer().getName() + ": Setzen sie einen Stein.");
		turn.place("1");
		turn.place("21");
		turn.place("7");
		turn.place("22");
		assertEquals(turn.getStatus(), "steal");
		assertEquals(turn.nextInstruction(), cont.getCurrPlayer().getName() + ": Stehlen sie einen Stein.");
		turn.steal("hallo");
		assertEquals(turn.getMessage(), "Bitte Zahl zwischen 0 und 23 angeben.");
		turn.steal("-1");
		assertEquals(turn.getMessage(), "Kein stehlbarer Stein an dieser Stelle.");
		turn.steal("20");
		assertEquals(turn.getMessage(), "Kein stehlbarer Stein an dieser Stelle.");
		turn.steal("1");
		assertEquals(turn.getStatus(), "place");
		turn.place("6");
		turn.steal("20");
		turn.place("5");
		cont.nextPlayer();
		turn.place("1");
		cont.nextPlayer();
		cont.getOppPlayer().setPlaceableTokenCount(0);
		cont.getOppPlayer().setTokenCount(5);
		turn.place("15");
		assertEquals(turn.nextInstruction(), cont.getCurrPlayer().getName() + ": Bewegen sie einen Stein.");
		cont.nextPlayer();
		
		//only mills on opp Player, but more than 3 tokens, move phase
		turn.steal("6");
		assertEquals(turn.getStatus(), "move");
		turn.move("0", "1");
		assertEquals(turn.getStatus(), "lose");
		assertEquals(turn.nextInstruction(), cont.getCurrPlayer().getName() + ": Sie haben verloren.");
		cont.nextPlayer();
		turn.place("18");
		cont.nextPlayer();
		
		cont.getOppPlayer().setTokenCount(3);
		turn.steal("0");
		assertEquals(turn.getStatus(), "lose");
		cont.nextPlayer();
		cont.getOppPlayer().setTokenCount(6);
		turn.steal("7");
		assertEquals(turn.getStatus(), "move");
		
		turn.move("asdasd", "asd");
		assertEquals(turn.getMessage(), "Bitte 2 Zahlen zwischen 0 und 23 angeben.");
		turn.move("-1", "6");
		turn.move("6", "-1");
		assertEquals(turn.getMessage(), "Zug nicht möglich, bitte Spielfeld beachten.");
		turn.move("6", "3");
		assertEquals(turn.getMessage(), "Zug nicht möglich, bitte Spielfeld beachten.");
		turn.move("6", "5");
		assertEquals(turn.getMessage(), "Zug nicht möglich, bitte Spielfeld beachten.");
		turn.move("6", "7");
		cont.nextPlayer();
		turn.steal("1");
		cont.nextPlayer();
		cont.getCurrPlayer().setPlaceableTokenCount(2);
		turn.place("6");
		cont.nextPlayer();
		turn.place("1");
		cont.nextPlayer();
		turn.move("1", "0");
		assertEquals(turn.getStatus(), "steal");
		
	}

}
