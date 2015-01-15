package de.htwg.se.Muehle.aUI;

import org.apache.log4j.Logger;

import de.htwg.se.Muehle.Controller.IGameController;
import de.htwg.se.Muehle.Controller.ITurnController;
import de.htwg.se.Muehle.Model.IBoard;
import de.htwg.se.Muehle.Model.IField;
import de.htwg.se.Muehle.Model.IPlayer;
import de.htwg.se.Muehle.Util.Event;
import de.htwg.se.Muehle.Util.IObserver;

public class TextualUserInterface implements IObserver{
	private IBoard board;
	private IPlayer curr, opp;
	private ITurnController tuCon;
	private static final int ZERO = 0;
	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int THREE = 3;
	private static final int FOUR = 4;
	private static final int FIVE = 5;
	private static final int SIX = 6;
	private static final int SEVEN = 7;
	private static final int EIGHT = 8;
	private static final int NINE = 9;
	private static final int TEN = 10;
	private static final int ELEVEN = 11;
	private static final int TWELVE = 12;
	private static final int THIRTEEN = 13;
	private static final int FOURTEEN = 14;
	private static final int FIFTEEN = 15;
	private static final int SIXTEEN = 16;
	private static final int SEVENTEEN = 17;
	private static final int EIGHTTEEN = 18;
	private static final int NINETEEN = 19;
	private static final int TWENTY = 20;
	private static final int TWENTYONE = 21;
	private static final int TWENTYTWO = 22;
	private static final int TWENTYTHREE = 23;
	private static final int SIZE = 24;
	
	private Logger logger = Logger.getLogger("de.htwg.se.Muehle.aUI");
	
	public TextualUserInterface(IGameController gc, ITurnController tc){
		curr = gc.getCurrPlayer();
		opp = gc.getOppPlayer();
		board = gc.getBoard();
		tuCon = tc;
		tuCon.addObserver(this);
	}
	
	public void showHelp(){
		print("/restart Startet das Spiel neu.\n"
				+ "/exit Beendet das Spiel.\n"
				+ "/help Zeigt diese Hilfe.\n"
				+ "Eingabemuster Spielsteine platzieren/Stehlen: Zahl\nEingabemuster Spielstein bewegen: Zahl/Zahl");
	}

	public void showGame(){
		
		IField[] fields = board.getFields();
		String[] output = new String[SIZE];
		
		for(int i = 0; i < SIZE; i++){
			output[i] = fields[i].getFieldColor();
		}		
		
		logger.info("6----------5---------4 \t\t" + output[SIX] + "---------" + output[FIVE] + "---------" + output[FOUR]);
		logger.info("|          |         | \t\t|         |         |");
		logger.info("|  14-----13-----12  | \t\t|  " + output[FOURTEEN] + "------" + output[THIRTEEN] + "------" + output[TWELVE] + "  |			Setzbare Spielsteine Spieler1: " + curr.getPlaceableTokenCount());
		logger.info("|  |       |      |  | \t\t|  |      |      |  |");
		logger.info("|  |  22---21--20 |  | \t\t|  |  " + output[TWENTYTWO] + "---" + output[TWENTYONE] + "---" + output[TWENTY] + "  |  |			Setzbare Spielsteine Spieler2: " + opp.getPlaceableTokenCount());
		logger.info("|  |   |       |  |  | \t\t|  |  |       |  |  |");
		logger.info("7--15--23      19-11-3 \t\t" + output[SEVEN] + "--" + output[FIFTEEN] + "--" + output[TWENTYTHREE] + "       " + output[NINETEEN] + "--" + output[ELEVEN] + "--" + output[THREE]);
		logger.info("|  |   |       |  |  | \t\t|  |  |       |  |  |");
		logger.info("|  |  16---17--18 |  | \t\t|  |  " + output[SIXTEEN] + "---" + output[SEVENTEEN] + "---" + output[EIGHTTEEN] + "  |  |");
		logger.info("|  |       |      |  | \t\t|  |      |      |  |");
		logger.info("|  8-------9------10 | \t\t|  " + output[EIGHT] + "------" + output[NINE] + "------" + output[TEN] + "  |");
		logger.info("|          |         | \t\t|         |         |");
		logger.info("0----------1---------2 \t\t" + output[ZERO] + "---------" + output[ONE] + "---------" + output[TWO]);
		
		print(tuCon.getMessage());
		print(tuCon.nextInstruction());
	}
	
	private void print(String s){
		logger.info(s);
	}

	public void sendInput(String next) {
		
		
		if(next.equals("/restart")){
			System.exit(0);
		} else if(next.equals("/help")){
			showHelp();
		} else if(next.equals("/exit")){
			System.exit(0);
		} else {
			String status = tuCon.getStatus();
			switch(status){
			case "place":
				tuCon.place(next);
				showGame();
				break;
				
			case "move":

				String[] temp = next.split("/");
				if(temp.length < TWO){
					print("Fehlerhafte Eingabe");
					print(tuCon.nextInstruction());
					break;
				}
				tuCon.move(temp[0], temp[1]);
				showGame();
				break;

			case "steal":
				tuCon.steal(next);
				showGame();
				break;

			case "lose":
				//restart
				break;
			}
		}	
	}

	@Override
	public void update(Event e) {
		showGame();
	}
}
