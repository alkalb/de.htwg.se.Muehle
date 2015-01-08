package de.htwg.se.Muehle;

import java.awt.Color;

import de.htwg.se.Muehle.Controller.IGameController;
import de.htwg.se.Muehle.Controller.Impl.GameController;
import de.htwg.se.Muehle.Model.IPlayer;
import de.htwg.se.Muehle.Model.Impl.Player;
import de.htwg.se.aUI.TextualUserInterface;

public class Muehle {

	private Muehle(){}
	
	public static void main(String[] args) {

		IPlayer p1 = new Player("Alex", Color.BLACK);
		IPlayer p2 = new Player("Felix", Color.WHITE);
		IGameController gaCo = new GameController(p1, p2);
		TextualUserInterface tui = new TextualUserInterface(gaCo);
		
		tui.printHelp();
		tui.printGame();
		
		
		
		
	}

}
