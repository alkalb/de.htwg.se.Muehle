package de.htwg.se.Muehle.Model.Impl;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import de.htwg.se.Muehle.Model.IBoard;
import de.htwg.se.Muehle.Model.IField;
import de.htwg.se.Muehle.Model.IPlayer;

public class Board implements IBoard{

	private static final int NOCONNECTION = -1;
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
	private static final int FIELDCOUNT = 24;
	private IField fields[];
	private Map<Integer, int[]> connections;
	
	public Board(){
		IPlayer error = new Player("error", Color.MAGENTA);
		
		
		fields = new Field[FIELDCOUNT];
		for(int i = 0; i < fields.length; i++){
			fields[i] = new Field(error, i);
		}

		connections = new HashMap<Integer, int[]>();
		connections.put(FIELDZERO, new int[]{FIELDSEVEN, FIELDONE, NOCONNECTION, NOCONNECTION});
		connections.put(FIELDONE, new int[]{FIELDNINE, FIELDTWO, NOCONNECTION, FIELDZERO});
		connections.put(FIELDTWO, new int[]{FIELDTHREE, NOCONNECTION, NOCONNECTION, FIELDONE});
		connections.put(FIELDTHREE, new int[]{FIELDFOUR, NOCONNECTION, FIELDTWO, FIELDELEVEN});
		connections.put(FIELDFOUR, new int[]{NOCONNECTION, NOCONNECTION, FIELDTHREE, FIELDFIVE});
		connections.put(FIELDFIVE, new int[]{NOCONNECTION, FIELDFOUR, FIELDTHIRTEEN, FIELDSIX});
		connections.put(FIELDSIX, new int[]{NOCONNECTION, FIELDFIVE, FIELDSEVEN, NOCONNECTION});
		connections.put(FIELDSEVEN, new int[]{FIELDSIX, FIELDFIFTEEN, FIELDZERO, NOCONNECTION});
		connections.put(FIELDEIGHT, new int[]{FIELDFIFTEEN, FIELDNINE, NOCONNECTION, NOCONNECTION});
		connections.put(FIELDNINE, new int[]{FIELDSEVENTEEN, FIELDTEN, FIELDONE, FIELDEIGHT});
		connections.put(FIELDTEN, new int[]{FIELDELEVEN, NOCONNECTION, NOCONNECTION, FIELDNINE});
		connections.put(FIELDELEVEN, new int[]{FIELDTWELVE, FIELDTHREE, FIELDTEN, FIELDNINETEEN});
		connections.put(FIELDTWELVE, new int[]{NOCONNECTION, NOCONNECTION, FIELDELEVEN, FIELDTHIRTEEN});
		connections.put(FIELDTHIRTEEN, new int[]{FIELDFIVE, FIELDTWELVE, FIELDTWENTYONE, FIELDFOURTEEN});
		connections.put(FIELDFOURTEEN, new int[]{NOCONNECTION, FIELDTHIRTEEN, FIELDFIFTEEN, NOCONNECTION});
		connections.put(FIELDFIFTEEN, new int[]{FIELDFOURTEEN, FIELDTWENTYTHREE, FIELDEIGHT, FIELDSEVEN});
		connections.put(FIELDSIXTEEN, new int[]{FIELDTWENTYTHREE, FIELDSEVENTEEN, NOCONNECTION, NOCONNECTION});
		connections.put(FIELDSEVENTEEN, new int[]{NOCONNECTION, FIELDEIGHTTEEN, FIELDNINE, FIELDSIXTEEN});
		connections.put(FIELDEIGHTTEEN, new int[]{FIELDNINETEEN, NOCONNECTION, NOCONNECTION, FIELDSEVENTEEN});
		connections.put(FIELDNINETEEN, new int[]{FIELDTWENTY, FIELDELEVEN, FIELDEIGHTTEEN, NOCONNECTION});
		connections.put(FIELDTWENTY, new int[]{NOCONNECTION, NOCONNECTION, FIELDNINETEEN, FIELDTWENTYONE});
		connections.put(FIELDTWENTYONE, new int[]{FIELDTHIRTEEN, FIELDTWENTY, NOCONNECTION, FIELDTWENTYTWO});
		connections.put(FIELDTWENTYTWO, new int[]{NOCONNECTION, FIELDTWENTYONE, FIELDTWENTYTHREE, NOCONNECTION});
		connections.put(FIELDTWENTYTHREE, new int[]{FIELDTWENTYTWO, NOCONNECTION, FIELDSIXTEEN, FIELDFIFTEEN});
		
	}

	public boolean isPositionEmpty(int x){

		return (fields[x].getPlayerOfField().getName().equals("error"));

	}

	public IField[] getFields(){
		return fields;
	}
	
	public void setPosition(int x, IPlayer p){
		IField f = new Field(p, x);
		fields[x] = f;
		
	}
	
	public Map<Integer, int[]> getConnections(){
		return connections;
	}
	
	
}