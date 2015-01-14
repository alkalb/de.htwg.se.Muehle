package de.htwg.se.aUI;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

import de.htwg.se.Muehle.Controller.IGameController;
import de.htwg.se.Muehle.Controller.ITurnController;
import de.htwg.se.Muehle.Model.IBoard;
import de.htwg.se.Muehle.Model.IPlayer;

public class GraphicalUserInterface extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private IPlayer curr, opp;
	private IBoard board;
	private ITurnController tuCon;
	
	private JLabel header, player1, player2, message, sourceLabel, targetLabel, player1tokens, player2tokens, blank, boardbg, positions;
	private JTextField source, target;
	private JButton restart, help,submit;
	private JPanel main, boardP, infos, commands, buttons, sidebar;
	private static final int XINFOS = 150;
	private static final int YINFOS = 200;
	private static final int SIDEBARTHREE = 3;
	
	public GraphicalUserInterface(IGameController gc, ITurnController tc){
		
		curr = gc.getCurrPlayer();
		opp = gc.getOppPlayer();
		board = gc.getBoard();
		tuCon = tc;
		
		this.setTitle("Mühle");
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
		
		
		JLabel pos0 = new JLabel();
		pos0.setIcon(new ImageIcon(getClass().getResource("/de/htwg/se/resources/black.gif")));
		pos0.setBounds(27, 435, 38, 38);
		
		JLabel pos1 = new JLabel();
		pos1.setIcon(new ImageIcon(getClass().getResource("/de/htwg/se/resources/black.gif")));
		pos1.setBounds(231, 435, 38, 38);
		
		JLabel pos2 = new JLabel();
		pos2.setIcon(new ImageIcon(getClass().getResource("/de/htwg/se/resources/black.gif")));
		pos2.setBounds(436, 436, 38, 38);
		
		JLabel pos3 = new JLabel();
		pos3.setIcon(new ImageIcon(getClass().getResource("/de/htwg/se/resources/black.gif")));
		pos3.setBounds(436, 231, 38, 38);

		JLabel pos4 = new JLabel();
		pos4.setIcon(new ImageIcon(getClass().getResource("/de/htwg/se/resources/black.gif")));
		pos4.setBounds(436, 26, 38, 38);

		JLabel pos5 = new JLabel();
		pos5.setIcon(new ImageIcon(getClass().getResource("/de/htwg/se/resources/black.gif")));
		pos5.setBounds(231, 26, 38, 38);
		
		JLabel pos6 = new JLabel();
		pos6.setIcon(new ImageIcon(getClass().getResource("/de/htwg/se/resources/black.gif")));
		pos6.setBounds(27, 27, 38, 38);
		
		JLabel pos7 = new JLabel();
		pos7.setIcon(new ImageIcon(getClass().getResource("/de/htwg/se/resources/black.gif")));
		pos7.setBounds(27, 235, 38, 38);
		
		JLabel pos8 = new JLabel();
		pos8.setIcon(new ImageIcon(getClass().getResource("/de/htwg/se/resources/black.gif")));
		pos8.setBounds(96, 366, 38, 38);
		
		JLabel pos9 = new JLabel();
		pos9.setIcon(new ImageIcon(getClass().getResource("/de/htwg/se/resources/black.gif")));
		pos9.setBounds(231, 366, 38, 38);
		
		JLabel pos10 = new JLabel();
		pos10.setIcon(new ImageIcon(getClass().getResource("/de/htwg/se/resources/black.gif")));
		pos10.setBounds(366, 366, 38, 38);

		JLabel pos11 = new JLabel();
		pos11.setIcon(new ImageIcon(getClass().getResource("/de/htwg/se/resources/black.gif")));
		pos11.setBounds(366, 231, 38, 38);

		JLabel pos12 = new JLabel();
		pos12.setIcon(new ImageIcon(getClass().getResource("/de/htwg/se/resources/black.gif")));
		pos12.setBounds(366, 96, 38, 38);

		JLabel pos13 = new JLabel();
		pos13.setIcon(new ImageIcon(getClass().getResource("/de/htwg/se/resources/black.gif")));
		pos13.setBounds(231, 96, 38, 38);
		
		JLabel pos14 = new JLabel();
		pos14.setIcon(new ImageIcon(getClass().getResource("/de/htwg/se/resources/black.gif")));
		pos14.setBounds(96, 96, 38, 38);
		
		JLabel pos15 = new JLabel();
		pos15.setIcon(new ImageIcon(getClass().getResource("/de/htwg/se/resources/black.gif")));
		pos15.setBounds(96, 231, 38, 38);
		
		JLabel pos16 = new JLabel();
		pos16.setIcon(new ImageIcon(getClass().getResource("/de/htwg/se/resources/black.gif")));
		pos16.setBounds(166, 296, 38, 38);
		
		JLabel pos17 = new JLabel();
		pos17.setIcon(new ImageIcon(getClass().getResource("/de/htwg/se/resources/black.gif")));
		pos17.setBounds(231, 296, 38, 38);
		
		JLabel pos18 = new JLabel();
		pos18.setIcon(new ImageIcon(getClass().getResource("/de/htwg/se/resources/black.gif")));
		pos18.setBounds(296, 296, 38, 38);

		JLabel pos19 = new JLabel();
		pos19.setIcon(new ImageIcon(getClass().getResource("/de/htwg/se/resources/black.gif")));
		pos19.setBounds(296, 231, 38, 38);

		JLabel pos20 = new JLabel();
		pos20.setIcon(new ImageIcon(getClass().getResource("/de/htwg/se/resources/black.gif")));
		pos20.setBounds(296, 166, 38, 38);

		JLabel pos21 = new JLabel();
		pos21.setIcon(new ImageIcon(getClass().getResource("/de/htwg/se/resources/black.gif")));
		pos21.setBounds(231, 166, 38, 38);
		
		JLabel pos22 = new JLabel();
		pos22.setIcon(new ImageIcon(getClass().getResource("/de/htwg/se/resources/black.gif")));
		pos22.setBounds(166, 166, 38, 38);
		
		JLabel pos23 = new JLabel();
		pos23.setIcon(new ImageIcon(getClass().getResource("/de/htwg/se/resources/black.gif")));
		pos23.setBounds(166, 231, 38, 38);
		
		boardP = new JPanel();
		boardP.setLayout(null);
		boardbg.setIcon(new ImageIcon(getClass().getResource("/de/htwg/se/resources/board.gif")));
		boardP.setPreferredSize(new Dimension(550, 500));
		boardbg.setBounds(0, 0, 500, 500);		
		boardP.add(pos0);
		boardP.add(pos1);
		boardP.add(pos2);
		boardP.add(pos3);
		boardP.add(pos4);
		boardP.add(pos5);
		boardP.add(pos6);
		boardP.add(pos7);
		boardP.add(pos8);
		boardP.add(pos9);
		boardP.add(pos10);
		boardP.add(pos11);
		boardP.add(pos12);
		boardP.add(pos13);
		boardP.add(pos14);
		boardP.add(pos15);
		boardP.add(pos16);
		boardP.add(pos17);
		boardP.add(pos18);
		boardP.add(pos19);
		boardP.add(pos20);
		boardP.add(pos21);
		boardP.add(pos22);
		boardP.add(pos23);
		boardP.add(boardbg);
		
		
		main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.X_AXIS));
		main.add(boardP);
		main.add(sidebar);
		main.setPreferredSize(new Dimension(750, 510));
		
		
		
		this.add(main);
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void showHelp(){
		JOptionPane.showMessageDialog(
				main,
				"Die Nummer der Positionen finden Sie unter den zugehörigen Eingabefelder.\n"
				); 
	}
	
	public void showGame(){
		
	}

}
