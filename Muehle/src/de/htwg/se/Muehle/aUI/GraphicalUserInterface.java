package de.htwg.se.Muehle.aUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import de.htwg.se.Muehle.Controller.IGameController;
import de.htwg.se.Muehle.Controller.ITurnController;
import de.htwg.se.Muehle.Model.IBoard;
import de.htwg.se.Muehle.Model.IField;
import de.htwg.se.Muehle.Model.IPlayer;
import de.htwg.se.Muehle.Util.Event;
import de.htwg.se.Muehle.Util.IObserver;

public class GraphicalUserInterface extends JFrame implements ActionListener, IObserver{
	
	private static final long serialVersionUID = 1L;
	private static final int BOARDCOORD1 = 27;
	private static final int BOARDCOORD2 = 96;
	private static final int BOARDCOORD3 = 166;
	private static final int BOARDCOORD4 = 231;
	private static final int BOARDCOORD5 = 296;
	private static final int BOARDCOORD6 = 366;
	private static final int BOARDCOORD7 = 436;
	private static final int TOKENWIDTH = 38;
	private static final int BOARDXLENGTH = 500;
	private static final int BOARDYLENGTH = 500;
	private static final int GAMEXLENGTH = 550;
	private static final int GAMEYLENGTH = 500;
	
	private static final int PIXELZERO = 0;
	private static final int PIXELTWENTY = 20;
	private static final int PIXELTWENTYFIVE = 25;
	private static final int PIXELTHIRTY = 30;
	private static final int PIXELFIFTY = 50;
	private static final int PIXELNINETY = 90;
	private static final int PIXELONEHUNDRED = 100;
	private static final int PIXELONEHUNDREDTWENTY = 120;
	private static final int PIXELONEHUNDREDTWENTYFIVE = 125;
	private static final int PIXELONEHUNDREDSIXTYTHREE = 163;
	private static final int PIXELONEHUNDREDNINETYEIGHT = 198;
	private static final int PIXELTWOHUNDRED = 200;
	private static final int PIXELTWOHUNDREDTWENTY = 220;
	private static final int PIXELTWOHUNDREDFOURTY = 240;
	private static final int PIXELTWOHUNDREDFIFTY = 250;
	private static final int PIXELTWOHUNDREDSEVENTY = 270;
	private static final int PIXELTWOHUNDREDNINETY = 290;		
	private static final int PIXELTHREEHUNDREDTWENTY = 320;
	private static final int PIXELTHREEHUNDREDFOURTYFIVE = 345;
	private static final int PIXELFOURHUNDREDSEVENTY = 470;
	
	
	private IPlayer playerOne, playerTwo;
	private IBoard board;
	private ITurnController tuCon;
	
	private JLabel header, player1, player2, sourceLabel, targetLabel, player1tokens, player2tokens, boardbg, positions;
	private Map<Integer, JLabel> posList;
	private JTextField source, target;
	private JTextArea message;
	private JButton restart, help,submit;
	private JPanel main, boardP, sidebar;
	
	private final ImageIcon black = new ImageIcon(getClass().getResource("/de/htwg/se/resources/black.gif"));
	private final ImageIcon white = new ImageIcon(getClass().getResource("/de/htwg/se/resources/white.gif"));
	private final ImageIcon empty = new ImageIcon(getClass().getResource("/de/htwg/se/resources/blank.png"));
	
	public GraphicalUserInterface(IGameController gc, ITurnController tc){
		
		playerOne = gc.getCurrPlayer();
		playerTwo = gc.getOppPlayer();
		board = gc.getBoard();
		tuCon = tc;
		tuCon.addObserver(this);
		posList = new HashMap<Integer, JLabel>();
		
		this.setTitle("Mühle");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		header = new JLabel("Setzbare Spielsteine");
		player1 = new JLabel("Spieler 1:");
		player2 = new JLabel("Spieler 2:");
		message = new JTextArea("");
		positions = new JLabel();
		sourceLabel = new JLabel("Start");
		targetLabel = new JLabel("Ziel");
		player1tokens = new JLabel("9");
		player2tokens = new JLabel("9");
		boardbg = new JLabel();
			
		
		source = new JTextField("");
		target = new JTextField("");
		source.setEditable(false);
		
		restart = new JButton("Neustart");
		restart.addActionListener(this);
		help = new JButton("Hilfe");
		help.addActionListener(this);
		submit = new JButton("Senden");
		submit.addActionListener(this);
		
		sidebar = new JPanel();
		sidebar.setLayout(null);
		positions.setIcon(new ImageIcon(getClass().getResource("/de/htwg/se/resources/positions.PNG")));
		positions.setBounds(PIXELZERO, PIXELZERO, PIXELONEHUNDREDSIXTYTHREE, PIXELONEHUNDREDNINETYEIGHT);
		header.setBounds(PIXELZERO, PIXELTWOHUNDRED, PIXELTWOHUNDRED, PIXELTWENTY);
		player1.setBounds(PIXELZERO, PIXELTWOHUNDREDTWENTY, PIXELONEHUNDRED, PIXELTWENTY);
		player2.setBounds(PIXELZERO, PIXELTWOHUNDREDFOURTY, PIXELONEHUNDRED, PIXELTWENTY);
		player1tokens.setBounds(PIXELONEHUNDREDTWENTY, PIXELTWOHUNDREDTWENTY, PIXELFIFTY, PIXELTWENTY);
		player2tokens.setBounds(PIXELONEHUNDREDTWENTY, PIXELTWOHUNDREDFOURTY, PIXELFIFTY, PIXELTWENTY);
		sourceLabel.setBounds(PIXELZERO, PIXELTWOHUNDREDSEVENTY, PIXELONEHUNDRED, PIXELTWENTY);
		targetLabel.setBounds(PIXELONEHUNDRED, PIXELTWOHUNDREDSEVENTY, PIXELONEHUNDRED, PIXELTWENTY);
		source.setBounds(PIXELZERO, PIXELTWOHUNDREDNINETY, PIXELNINETY, PIXELTWENTYFIVE);
		target.setBounds(PIXELONEHUNDRED, PIXELTWOHUNDREDNINETY, PIXELNINETY, PIXELTWENTYFIVE);
		submit.setBounds(PIXELFIFTY, PIXELTHREEHUNDREDTWENTY, PIXELONEHUNDRED, PIXELTWENTYFIVE);
		message.setBounds(PIXELZERO, PIXELTHREEHUNDREDFOURTYFIVE, PIXELTWOHUNDREDFIFTY, PIXELONEHUNDREDTWENTYFIVE);
		help.setBounds(PIXELZERO, PIXELFOURHUNDREDSEVENTY, PIXELNINETY, PIXELTHIRTY);
		restart.setBounds(PIXELONEHUNDRED, PIXELFOURHUNDREDSEVENTY, PIXELNINETY, PIXELTHIRTY);
		message.setEditable(false);
		
		
		sidebar.add(header);
		sidebar.add(player1);
		sidebar.add(player2);
		sidebar.add(player1tokens);
		sidebar.add(player2tokens);
		sidebar.add(sourceLabel);
		sidebar.add(targetLabel);
		sidebar.add(source);
		sidebar.add(target);
		sidebar.add(submit);
		sidebar.add(message);
		sidebar.add(help);
		sidebar.add(restart);
		sidebar.add(positions);
		sidebar.setPreferredSize(new Dimension(250, GAMEYLENGTH));
		
		
		JLabel pos0 = new JLabel();
		pos0.setIcon(empty);
		pos0.setBounds(BOARDCOORD1, BOARDCOORD7, TOKENWIDTH, TOKENWIDTH);
		
		JLabel pos1 = new JLabel();
		pos1.setIcon(empty);
		pos1.setBounds(BOARDCOORD4, BOARDCOORD7, TOKENWIDTH, TOKENWIDTH);
		
		JLabel pos2 = new JLabel();
		pos2.setIcon(empty);
		pos2.setBounds(BOARDCOORD7, BOARDCOORD7, TOKENWIDTH, TOKENWIDTH);
		
		JLabel pos3 = new JLabel();
		pos3.setIcon(empty);
		pos3.setBounds(BOARDCOORD7, BOARDCOORD4, TOKENWIDTH, TOKENWIDTH);

		JLabel pos4 = new JLabel();
		pos4.setIcon(empty);
		pos4.setBounds(BOARDCOORD7, BOARDCOORD1, TOKENWIDTH, TOKENWIDTH);

		JLabel pos5 = new JLabel();
		pos5.setIcon(empty);
		pos5.setBounds(BOARDCOORD4, BOARDCOORD1, TOKENWIDTH, TOKENWIDTH);
		
		JLabel pos6 = new JLabel();
		pos6.setIcon(empty);
		pos6.setBounds(BOARDCOORD1, BOARDCOORD1, TOKENWIDTH, TOKENWIDTH);
		
		JLabel pos7 = new JLabel();
		pos7.setIcon(empty);
		pos7.setBounds(BOARDCOORD1, BOARDCOORD4, TOKENWIDTH, TOKENWIDTH);
		
		JLabel pos8 = new JLabel();
		pos8.setIcon(empty);
		pos8.setBounds(BOARDCOORD2, BOARDCOORD6, TOKENWIDTH, TOKENWIDTH);
		
		JLabel pos9 = new JLabel();
		pos9.setIcon(empty);
		pos9.setBounds(BOARDCOORD4, BOARDCOORD6, TOKENWIDTH, TOKENWIDTH);
		
		JLabel pos10 = new JLabel();
		pos10.setIcon(empty);
		pos10.setBounds(BOARDCOORD6, BOARDCOORD6, TOKENWIDTH, TOKENWIDTH);

		JLabel pos11 = new JLabel();
		pos11.setIcon(empty);
		pos11.setBounds(BOARDCOORD6, BOARDCOORD4, TOKENWIDTH, TOKENWIDTH);

		JLabel pos12 = new JLabel();
		pos12.setIcon(empty);
		pos12.setBounds(BOARDCOORD6, BOARDCOORD2, TOKENWIDTH, TOKENWIDTH);

		JLabel pos13 = new JLabel();
		pos13.setIcon(empty);
		pos13.setBounds(BOARDCOORD4, BOARDCOORD2, TOKENWIDTH, TOKENWIDTH);
		
		JLabel pos14 = new JLabel();
		pos14.setIcon(empty);
		pos14.setBounds(BOARDCOORD2, BOARDCOORD2, TOKENWIDTH, TOKENWIDTH);
		
		JLabel pos15 = new JLabel();
		pos15.setIcon(empty);
		pos15.setBounds(BOARDCOORD2, BOARDCOORD4, TOKENWIDTH, TOKENWIDTH);
		
		JLabel pos16 = new JLabel();
		pos16.setIcon(empty);
		pos16.setBounds(BOARDCOORD3, BOARDCOORD5, TOKENWIDTH, TOKENWIDTH);
		
		JLabel pos17 = new JLabel();
		pos17.setIcon(empty);
		pos17.setBounds(BOARDCOORD4, BOARDCOORD5, TOKENWIDTH, TOKENWIDTH);
		
		JLabel pos18 = new JLabel();
		pos18.setIcon(empty);
		pos18.setBounds(BOARDCOORD5, BOARDCOORD5, TOKENWIDTH, TOKENWIDTH);

		JLabel pos19 = new JLabel();
		pos19.setIcon(empty);
		pos19.setBounds(BOARDCOORD5, BOARDCOORD4, TOKENWIDTH, TOKENWIDTH);

		JLabel pos20 = new JLabel();
		pos20.setIcon(empty);
		pos20.setBounds(BOARDCOORD5, BOARDCOORD3, TOKENWIDTH, TOKENWIDTH);

		JLabel pos21 = new JLabel();
		pos21.setIcon(empty);
		pos21.setBounds(BOARDCOORD4, BOARDCOORD3, TOKENWIDTH, TOKENWIDTH);
		
		JLabel pos22 = new JLabel();
		pos22.setIcon(empty);
		pos22.setBounds(BOARDCOORD3, BOARDCOORD3, TOKENWIDTH, TOKENWIDTH);
		
		JLabel pos23 = new JLabel();
		pos23.setIcon(empty);
		pos23.setBounds(BOARDCOORD3, BOARDCOORD4, TOKENWIDTH, TOKENWIDTH);
		
		posList.put(0, pos0);
		posList.put(1, pos1);
		posList.put(2, pos2);
		posList.put(3, pos3);
		posList.put(4, pos4);
		posList.put(5, pos5);
		posList.put(6, pos6);
		posList.put(7, pos7);
		posList.put(8, pos8);
		posList.put(9, pos9);
		posList.put(10, pos10);
		posList.put(11, pos11);
		posList.put(12, pos12);
		posList.put(13, pos13);
		posList.put(14, pos14);
		posList.put(15, pos15);
		posList.put(16, pos16);
		posList.put(17, pos17);
		posList.put(18, pos18);
		posList.put(19, pos19);
		posList.put(20, pos20);
		posList.put(21, pos21);
		posList.put(22, pos22);
		posList.put(23, pos23);
		
		boardP = new JPanel();
		boardP.setLayout(null);
		boardbg.setIcon(new ImageIcon(getClass().getResource("/de/htwg/se/resources/board.gif")));
		boardP.setPreferredSize(new Dimension(GAMEXLENGTH, GAMEYLENGTH));
		boardbg.setBounds(0, 0, BOARDXLENGTH, BOARDYLENGTH);		
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
		boardP.setBackground(Color.WHITE);
		sidebar.setBackground(Color.WHITE);
		main.add(boardP);
		main.add(sidebar);
		main.setPreferredSize(new Dimension(800, GAMEYLENGTH));
		message.setText(tuCon.getMessage() + "\n" + tuCon.nextInstruction());
		
		
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
		IField[] fields = board.getFields();
		for(int i = 0; i<fields.length; i++){
			IPlayer temp = fields[i].getPlayerOfField();
			if(temp.getName().equals("error")){
				posList.get(i).setIcon(empty);
			} else if(temp.getColor().equals("B")){
				posList.get(i).setIcon(black);
			} else {
				posList.get(i).setIcon(white);
			}
		}
		
		message.setText(tuCon.getMessage() + "\n" + tuCon.nextInstruction());
		player1tokens.setText(Integer.valueOf(playerOne.getPlaceableTokenCount()).toString());
		player2tokens.setText(Integer.valueOf(playerTwo.getPlaceableTokenCount()).toString());
		
		if(tuCon.getStatus().equals("move")){
			source.setEditable(true);
		} else if(tuCon.getStatus().equals("lose")){
			source.setEditable(false);
			target.setEditable(false);
			submit.setEnabled(false);
		} else {
			source.setEditable(false);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src.equals(help)){
			showHelp();
			
		} else if(src.equals(restart)){
			message.setText("restart\n restart");
		} else {
			sendInput();
		}
	}
	
	public void sendInput(){
		String status = tuCon.getStatus();
		switch(status){
		case "place":
			tuCon.place(target.getText());
			showGame();
			break;
			
		case "move":

			tuCon.move(source.getText(), target.getText());
			showGame();
			break;

		case "steal":
			tuCon.steal(target.getText());
			showGame();
			break;

		case "lose":
			break;
		}
	}

	@Override
	public void update(Event e) {
		showGame();
	}
	

}
