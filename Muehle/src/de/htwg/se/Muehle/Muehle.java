package de.htwg.se.Muehle;

import java.awt.Color;
import java.util.Scanner;

import org.apache.log4j.PropertyConfigurator;

import de.htwg.se.Muehle.Controller.IGameController;
import de.htwg.se.Muehle.Controller.ITurnController;
import de.htwg.se.Muehle.Controller.Impl.GameController;
import de.htwg.se.Muehle.Controller.Impl.TurnController;
import de.htwg.se.Muehle.Model.IPlayer;
import de.htwg.se.Muehle.Model.Impl.Player;
import de.htwg.se.Muehle.aUI.GraphicalUserInterface;
import de.htwg.se.Muehle.aUI.TextualUserInterface;

public final class Muehle {

	private Muehle(){}
	
	public static void main(String[] args) {

		PropertyConfigurator.configure("log4j.properties");
		
		IPlayer p1 = new Player("Spieler 1", Color.BLACK);
		IPlayer p2 = new Player("Spieler 2", Color.WHITE);
		IGameController gaCo = new GameController(p1, p2);
		ITurnController tuCo = new TurnController(gaCo);
		TextualUserInterface tui = new TextualUserInterface(gaCo, tuCo);
		GraphicalUserInterface gui = new GraphicalUserInterface(gaCo, tuCo);
		
		
		tui.showHelp();
		tui.showGame();
		final Scanner in = new Scanner(System.in);
				
		while (in.hasNext()) {
			
			
			tui.sendInput(in.next());

		}
		in.close();

		
		
		
	}

}
