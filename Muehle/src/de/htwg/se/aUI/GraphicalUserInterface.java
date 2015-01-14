package de.htwg.se.aUI;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

public class GraphicalUserInterface extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private JLabel header, player1, player2, message, sourceLabel, targetLabel, player1tokens, player2tokens, blank, boardbg, positions;
	private JTextField source, target;
	private JButton restart, help,submit;
	private JPanel main, board, infos, commands, buttons, sidebar;
	private static final int XINFOS = 150;
	private static final int YINFOS = 200;
	private static final int SIDEBARTHREE = 3;
	
	public GraphicalUserInterface(){
		this.setTitle("M�hle");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		header = new JLabel("Setzbare Steine");
		player1 = new JLabel("Spieler 1:");
		player2 = new JLabel("Spieler 2:");
		message = new JLabel("");
		positions = new JLabel();
		positions.setPreferredSize(new Dimension(230, 230));
		sourceLabel = new JLabel("Start");
		targetLabel = new JLabel("Ziel");
		player1tokens = new JLabel("9");
		player2tokens = new JLabel("9");
		blank = new JLabel();
		boardbg = new JLabel();
		
		source = new JTextField("", 2);
		target = new JTextField("", 2);
		
		restart = new JButton("Neustart");
		help = new JButton("Hilfe");
		submit = new JButton("Senden");
		
		buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
		buttons.add(restart);
		buttons.add(help);
		
		commands = new JPanel();
		commands.setLayout(new GridLayout(SIDEBARTHREE, 2));
		commands.add(sourceLabel);
		commands.add(targetLabel);
		commands.add(source);
		commands.add(target);
		commands.add(submit);
		commands.add(blank);
		
		
		infos = new JPanel();
		infos.setLayout(new GridLayout(SIDEBARTHREE,2));
		infos.setPreferredSize(new Dimension(XINFOS, YINFOS));
		infos.add(header);
		infos.add(blank);
		infos.add(player1);
		infos.add(player1tokens);
		infos.add(player2);
		infos.add(player2tokens);
				
		sidebar = new JPanel();
		sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
		sidebar.add(infos);
		sidebar.add(message);
		sidebar.add(commands);
		JPanel pos = new JPanel();
		pos.setLayout(new GridLayout(1, 1));
		positions.setIcon(new ImageIcon(getClass().getResource("/de/htwg/se/resources/positions.PNG")));
		pos.add(positions);
		sidebar.add(pos);
		sidebar.add(buttons);
		sidebar.setPreferredSize(new Dimension(200, 500));
		
		board = new JPanel();
		boardbg.setIcon(new ImageIcon(getClass().getResource("/de/htwg/se/resources/board.gif")));
		board.setPreferredSize(new Dimension(550, 500));
		board.add(boardbg);
		
		main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.X_AXIS));
		main.add(board);
		main.add(sidebar);
		main.setPreferredSize(new Dimension(750, 510));
		
		
		this.add(main);
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}

}
