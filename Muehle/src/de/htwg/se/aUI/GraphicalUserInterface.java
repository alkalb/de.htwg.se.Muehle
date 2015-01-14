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
	
	private final ImageIcon BLACK = new ImageIcon(getClass().getResource("/de/htwg/se/resources/black.gif"));
	private final ImageIcon WHITE = new ImageIcon(getClass().getResource("/de/htwg/se/resources/white.gif"));
	private final ImageIcon EMPTY = new ImageIcon(getClass().getResource("/de/htwg/se/resources/black2.gif"));
	
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
		pos0.setIcon(EMPTY);
		pos0.setBounds(27, 435, 38, 38);
		
		pos1 = new JLabel();
		pos1.setIcon(EMPTY);
		pos1.setBounds(231, 435, 38, 38);
		
		pos2 = new JLabel();
		pos2.setIcon(EMPTY);
		pos2.setBounds(436, 436, 38, 38);
		
		pos3 = new JLabel();
		pos3.setIcon(EMPTY);
		pos3.setBounds(436, 231, 38, 38);

		pos4 = new JLabel();
		pos4.setIcon(EMPTY);
		pos4.setBounds(436, 26, 38, 38);

		pos5 = new JLabel();
		pos5.setIcon(EMPTY);
		pos5.setBounds(231, 26, 38, 38);
		
		pos6 = new JLabel();
		pos6.setIcon(EMPTY);
		pos6.setBounds(27, 27, 38, 38);
		
		pos7 = new JLabel();
		pos7.setIcon(EMPTY);
		pos7.setBounds(27, 235, 38, 38);
		
		pos8 = new JLabel();
		pos8.setIcon(EMPTY);
		pos8.setBounds(96, 366, 38, 38);
		
		pos9 = new JLabel();
		pos9.setIcon(EMPTY);
		pos9.setBounds(231, 366, 38, 38);
		
		pos10 = new JLabel();
		pos10.setIcon(EMPTY);
		pos10.setBounds(366, 366, 38, 38);

		pos11 = new JLabel();
		pos11.setIcon(EMPTY);
		pos11.setBounds(366, 231, 38, 38);

		pos12 = new JLabel();
		pos12.setIcon(EMPTY);
		pos12.setBounds(366, 96, 38, 38);

		pos13 = new JLabel();
		pos13.setIcon(EMPTY);
		pos13.setBounds(231, 96, 38, 38);
		
		pos14 = new JLabel();
		pos14.setIcon(EMPTY);
		pos14.setBounds(96, 96, 38, 38);
		
		pos15 = new JLabel();
		pos15.setIcon(EMPTY);
		pos15.setBounds(96, 231, 38, 38);
		
		pos16 = new JLabel();
		pos16.setIcon(EMPTY);
		pos16.setBounds(166, 296, 38, 38);
		
		pos17 = new JLabel();
		pos17.setIcon(EMPTY);
		pos17.setBounds(231, 296, 38, 38);
		
		pos18 = new JLabel();
		pos18.setIcon(EMPTY);
		pos18.setBounds(296, 296, 38, 38);

		pos19 = new JLabel();
		pos19.setIcon(EMPTY);
		pos19.setBounds(296, 231, 38, 38);

		pos20 = new JLabel();
		pos20.setIcon(EMPTY);
		pos20.setBounds(296, 166, 38, 38);

		pos21 = new JLabel();
		pos21.setIcon(EMPTY);
		pos21.setBounds(231, 166, 38, 38);
		
		pos22 = new JLabel();
		pos22.setIcon(EMPTY);
		pos22.setBounds(166, 166, 38, 38);
		
		pos23 = new JLabel();
		pos23.setIcon(EMPTY);
		pos23.setBounds(166, 231, 38, 38);
		
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
		for(int i = 0; i<=fields.length; i++){
			IPlayer temp = fields[i].getPlayerOfField();
			if(temp.getName().equals("error")){
				posList.get(i).setIcon(EMPTY);
			} else if(temp.getColor().equals("B")){
				posList.get(i).setIcon(BLACK);
			} else {
				posList.get(i).setIcon(WHITE);
			}
		}
		
		message.setText(tuCon.getMessage() + " " + tuCon.nextInstruction());
		player1tokens.setText(new Integer(playerOne.getPlaceableTokenCount()).toString());
		player2tokens.setText(new Integer(playerTwo.getPlaceableTokenCount()).toString());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == help){
			showHelp();
			
		} else if(source == restart){
			message.setText("restart");
		} else {
			message.setText("TODO");
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
			print(tuCon.getMessage());
			print(tuCon.nextInstruction());
			break;

		case "steal":
			tuCon.steal(next);
			showGame();
			print(tuCon.getMessage());
			print(tuCon.nextInstruction());
			break;

		case "lose":
			//restart
			break;
		}
	}
	

}
