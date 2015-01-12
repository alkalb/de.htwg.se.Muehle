package de.htwg.se.aUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

public class GraphicalUserInterface extends JFrame{
	
	private JLabel header, player1, player2, message, sourceLabel, targetLabel, player1tokens, player2tokens, blank;
	private JTextField source, target;
	private JButton restart, help;
	private JPanel main, board, infos, commands, buttons, sidebar;
	private JTextArea positions;
	
	public GraphicalUserInterface(){
		this.setTitle("Mühle");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setSize(1024, 1024);
		
		header = new JLabel("Platzierbare Steine");
		player1 = new JLabel("Spieler 1:");
		player2 = new JLabel("Spieler 2:");
		message = new JLabel("");
		positions = new JTextArea("6----------5---------4\n" +
								"|          |         |\n" +
								"|  14-----13-----12  |\n" +
								"|  |       |      |  |\n" +
								"|  |  22---21--20 |  |\n" +
								"|  |   |       |  |  |\n" +
								"7--15--23      19-11-3\n" +
								"|  |   |       |  |  |\n" +
								"|  |  16---17--18 |  |\n" +
								"|  |       |      |  |\n" +
								"|  8-------9------10 |\n" +
								"|          |         |\n" +
								"0----------1---------2");
		positions.setEditable(false);
		positions.setBackground(new Color(254, 219, 179, 255));
		sourceLabel = new JLabel("Start");
		targetLabel = new JLabel("Ziel");
		player1tokens = new JLabel("9");
		player2tokens = new JLabel("9");
		blank = new JLabel("");
		
		source = new JTextField("", 2);
		source.setBackground(new Color(254, 219, 179, 255));
		target = new JTextField("", 2);
		target.setBackground(new Color(254, 219, 179, 255));
		
		restart = new JButton("Neustart");
		help = new JButton("Hilfe");
		
		buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
		buttons.add(restart);
		buttons.add(help);
		
		commands = new JPanel();
		commands.setLayout(new GridLayout(2, 2));
		commands.setBackground(new Color(254, 219, 179, 255));
		commands.add(sourceLabel);
		commands.add(targetLabel);
		commands.add(source);
		commands.add(target);
		
		infos = new JPanel();
		infos.setLayout(new GridLayout(3,2));
		infos.setPreferredSize(new Dimension(350, 200));
		infos.setBackground(new Color(254, 219, 179, 255));
		infos.add(header);
		infos.add(blank);
		infos.add(player1);
		infos.add(player1tokens);
		infos.add(player2);
		infos.add(player2tokens);
				
		sidebar = new JPanel();
		sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
		sidebar.setBackground(new Color(254, 219, 179, 255));
		sidebar.add(infos);
		sidebar.add(message);
		sidebar.add(commands);
		sidebar.add(positions);
		sidebar.add(buttons);
		
		board = new JPanel();
		board.setPreferredSize(new Dimension(750, 750));
		board.setBackground(new Color(254, 219, 179, 255));
		
		main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.X_AXIS));
		main.add(board);
		main.add(sidebar);
		
		this.add(main);
		this.pack();
		this.setVisible(true);
	}

}
