package de.htwg.se.aUI;

import de.htwg.se.Muehle.Controller.IGameController;
import de.htwg.se.Muehle.Controller.Impl.GameController;
import de.htwg.se.Muehle.Model.IBoard;
import de.htwg.se.Muehle.Model.IField;

public class TextualUserInterface {
	IGameController gamCon;
	IBoard board;
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
				  "0----------1---------2 \t\t%s---------%s---------%s\n", output[6], output[5], output[4], output[14],
			  output[13], output[12], output[23], output[21], output[20], output[7], output[15],
			  output[23], output[19], output[11], output[3], output[16], output[17], output[18], output[8],
			  output[9], output[10], output[0], output[1], output[2]);
	}
	
	
	private void print(String s){
		System.out.printf(s);
	}

}
