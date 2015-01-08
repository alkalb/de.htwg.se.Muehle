package de.htwg.se.aUI;

import de.htwg.se.Muehle.Controller.IGameController;
import de.htwg.se.Muehle.Controller.Impl.GameController;
import de.htwg.se.Muehle.Model.IBoard;
import de.htwg.se.Muehle.Model.IField;

public class TextualUserInterface {
	IGameController gamCon;
	IBoard board;
	private static final int FIELDZERO = 0;
	private static final int FIELDONE = 1;
	private static final int FIELDTWO = 2;
	private static final int FIELDTHREE = 3;
	private static final int FIELDFOUR = 4;
	private static final int FIELDFIVE = 5;
	private static final int FIELDSIX = 6;
	private static final int FIELDSEVEN = 7;
	private static final int FIELDEIGHT = 8;
	private static final int FIELDNINE = 9;
	private static final int FIELDTEN = 10;
	private static final int FIELDELEVEN = 11;
	private static final int FIELDTWELVE = 12;
	private static final int FIELDTHIRTEEN = 13;
	private static final int FIELDFOURTEEN = 14;
	private static final int FIELDFIFTEEN = 15;
	private static final int FIELDSIXTEEN = 16;
	private static final int FIELDSEVENTEEN = 17;
	private static final int FIELDEIGHTTEEN = 18;
	private static final int FIELDNINETEEN = 19;
	private static final int FIELDTWENTY = 20;
	private static final int FIELDTWENTYONE = 21;
	private static final int FIELDTWENTYTWO = 22;
	private static final int FIELDTWENTYTHREE = 23;
	final int size = 24;
	
	public TextualUserInterface(IGameController gc){
		gamCon = gc;
		board = gamCon.getBoard();
	}
	
	
	
	
	
	
	
	
	
	
	public void printHelp(){
		print("/restart Restarts the game\n"
				+ "/exit Exits the game\n"
				+ "/help Shows this text\n");
	}
	

	

	public void printGame(){
		
		IField[] fields = board.getFields();
		String[] output = new String[size];
		
		for(int i = 0; i < size; i++){
			output[i] = fields[i].getFieldColor();
		}		
		

		
		
		System.out.printf("\n6----------5---------4 \t\t%s---------%s---------%s\n" +
				  "|          |         | \t\t|         |         |\n" +
				  "|  14-----13-----12  | \t\t|  %s------%s------%s  |\n" +
				  "|  |       |      |  | \t\t|  |      |      |  |\n" +
				  "|  |  22---21--20 |  | \t\t|  |  %s---%s---%s  |  |\n" +
				  "|  |   |       |  |  | \t\t|  |  |       |  |  |\n" +
				  "7--15--23      19-11-3 \t\t%s--%s--%s       %s--%s--%s\n" +
				  "|  |   |       |  |  | \t\t|  |  |       |  |  |\n" +
				  "|  |  16---17--18 |  | \t\t|  |  %s---%s---%s  |  |\n" +
				  "|  |       |      |  | \t\t|  |      |      |  |\n" +
				  "|  8-------9------10 | \t\t|  %s------%s------%s  |\n" +
				  "|          |         | \t\t|         |         |\n" +
				  "0----------1---------2 \t\t%s---------%s---------%s\n", output[FIELDSIX], output[FIELDFIVE], output[FIELDFOUR], output[FIELDFOURTEEN],
			  output[FIELDTHIRTEEN], output[FIELDTWELVE], output[FIELDTWENTYTWO], output[FIELDTWENTYONE], output[FIELDTWENTY], output[FIELDSEVEN], output[FIELDFIFTEEN],
			  output[FIELDTWENTYTHREE], output[FIELDNINETEEN], output[FIELDELEVEN], output[FIELDTHREE], output[FIELDSIXTEEN], output[FIELDSEVENTEEN], output[FIELDEIGHTTEEN], output[FIELDEIGHT],
			  output[FIELDNINE], output[FIELDTEN], output[FIELDZERO], output[FIELDONE], output[FIELDTWO]);
	}
	
	
	private void print(String s){
		System.out.printf(s);
	}

}
