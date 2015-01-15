package de.htwg.se.aUI;

import java.awt.Dimension;
import java.awt.GridLayout;
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

public class GraphicalUserInterface extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private static final int BOARDCOORD1 = 27;
	private static final int BOARDCOORD2 = 96;
	private static final int BOARDCOORD3 = 166;
	private static final int BOARDCOORD4 = 231;
	private static final int BOARDCOORD5 = 296;
	private static final int BOARDCOORD6 = 366;
	private static final int BOARDCOORD7 = 436;
	private static final int TOKENWIDTH = 38;
	
	private IPlayer playerOne, playerTwo;
	private IBoard board;
	private ITurnController tuCon;
	
	private JLabel header, player1, player2, message, sourceLabel, targetLabel, player1tokens, player2tokens, blank, boardbg, positions;
	private JLabel pos0, pos1, pos2, pos3, pos4, pos5, pos6, pos7, pos8, pos9, pos10, pos11, pos12, pos13, pos14, pos15, pos16, pos17, pos18, pos19, pos20, pos21, pos22, pos23;
	private Map<Integer, JLabel> posList;
	private JTextField source, target;
	private JButton restart, help,submit;
	private JPanel main, boardP, infos, commands, buttons, sidebar;
	private static final int XINFOS = 150;
	private static final int YINFOS = 200;
	private static final int SIDEBARTHREE = 3;
	
	private final ImageIcon black = new ImageIcon(getClass().getResource("/de/htwg/se/resources/black.gif"));
	private final ImageIcon white = new ImageIcon(getClass().getResource("/de/htwg/se/resources/white.gif"));
	private final ImageIcon empty = new ImageIcon(getClass().getResource("/de/htwg/se/resources/blank.png"));
	
	public GraphicalUserInterface(IGameController gc, ITurnController tc){
		
		playerOne = gc.getCurrPlayer();
		playerTwo = gc.getOppPlayer();
		board = gc.getBoard();
		tuCon = tc;
		posList = new HashMap<Integer, JLabel>();
		
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
		restart.addActionListener(this);
		help = new JButton("Hilfe");
		help.addActionListener(this);
		submit = new JButton("Senden");
		submit.addActionListener(this);
		
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
		
		
		pos0 = new JLabel();
		pos0.setIcon(empty);
		pos0.setBounds(BOARDCOORD1, BOARDCOORD7, TOKENWIDTH, TOKENWIDTH);
		
		pos1 = new JLabel();
		pos1.setIcon(empty);
		pos1.setBounds(BOARDCOORD4, BOARDCOORD7, TOKENWIDTH, TOKENWIDTH);
		
		pos2 = new JLabel();
		pos2.setIcon(empty);
		pos2.setBounds(BOARDCOORD7, BOARDCOORD7, TOKENWIDTH, TOKENWIDTH);
		
		pos3 = new JLabel();
		pos3.setIcon(empty);
		pos3.setBounds(BOARDCOORD7, BOARDCOORD4, TOKENWIDTH, TOKENWIDTH);

		pos4 = new JLabel();
		pos4.setIcon(empty);
		pos4.setBounds(BOARDCOORD7, BOARDCOORD1, TOKENWIDTH, TOKENWIDTH);

		pos5 = new JLabel();
		pos5.setIcon(empty);
		pos5.setBounds(BOARDCOORD4, BOARDCOORD1, TOKENWIDTH, TOKENWIDTH);
		
		pos6 = new JLabel();
		pos6.setIcon(empty);
		pos6.setBounds(BOARDCOORD1, BOARDCOORD1, TOKENWIDTH, TOKENWIDTH);
		
		pos7 = new JLabel();
		pos7.setIcon(empty);
		pos7.setBounds(BOARDCOORD1, BOARDCOORD4, TOKENWIDTH, TOKENWIDTH);
		
		pos8 = new JLabel();
		pos8.setIcon(empty);
		pos8.setBounds(BOARDCOORD2, BOARDCOORD6, TOKENWIDTH, TOKENWIDTH);
		
		pos9 = new JLabel();
		pos9.setIcon(empty);
		pos9.setBounds(BOARDCOORD4, BOARDCOORD6, TOKENWIDTH, TOKENWIDTH);
		
		pos10 = new JLabel();
		pos10.setIcon(empty);
		pos10.setBounds(BOARDCOORD6, BOARDCOORD6, TOKENWIDTH, TOKENWIDTH);

		pos11 = new JLabel();
		pos11.setIcon(empty);
		pos11.setBounds(BOARDCOORD6, BOARDCOORD4, TOKENWIDTH, TOKENWIDTH);

		pos12 = new JLabel();
		pos12.setIcon(empty);
		pos12.setBounds(BOARDCOORD6, BOARDCOORD2, TOKENWIDTH, TOKENWIDTH);

		pos13 = new JLabel();
		pos13.setIcon(empty);
		pos13.setBounds(BOARDCOORD4, BOARDCOORD2, TOKENWIDTH, TOKENWIDTH);
		
		pos14 = new JLabel();
		pos14.setIcon(empty);
		pos14.setBounds(BOARDCOORD2, BOARDCOORD2, TOKENWIDTH, TOKENWIDTH);
		
		pos15 = new JLabel();
		pos15.setIcon(empty);
		pos15.setBounds(BOARDCOORD2, BOARDCOORD4, TOKENWIDTH, TOKENWIDTH);
		
		pos16 = new JLabel();
		pos16.setIcon(empty);
		pos16.setBounds(BOARDCOORD3, BOARDCOORD5, TOKENWIDTH, TOKENWIDTH);
		
		pos17 = new JLabel();
		pos17.setIcon(empty);
		pos17.setBounds(BOARDCOORD4, BOARDCOORD5, TOKENWIDTH, TOKENWIDTH);
		
		pos18 = new JLabel();
		pos18.setIcon(empty);
		pos18.setBounds(BOARDCOORD5, BOARDCOORD5, TOKENWIDTH, TOKENWIDTH);

		pos19 = new JLabel();
		pos19.setIcon(empty);
		pos19.setBounds(BOARDCOORD5, BOARDCOORD4, TOKENWIDTH, TOKENWIDTH);

		pos20 = new JLabel();
		pos20.setIcon(empty);
		pos20.setBounds(BOARDCOORD5, BOARDCOORD3, TOKENWIDTH, TOKENWIDTH);

		pos21 = new JLabel();
		pos21.setIcon(empty);
		pos21.setBounds(BOARDCOORD4, BOARDCOORD3, TOKENWIDTH, TOKENWIDTH);
		
		pos22 = new JLabel();
		pos22.setIcon(empty);
		pos22.setBounds(BOARDCOORD3, BOARDCOORD3, TOKENWIDTH, TOKENWIDTH);
		
		pos23 = new JLabel();
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
		
		message.setText(tuCon.getMessage() + " " + tuCon.nextInstruction());
		player1tokens.setText(Integer.valueOf(playerOne.getPlaceableTokenCount()).toString());
		player2tokens.setText(Integer.valueOf(playerTwo.getPlaceableTokenCount()).toString());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source.equals(help)){
			showHelp();
			
		} else if(source.equals(restart)){
			message.setText("restart");
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
	

}
