package ch.fhnw.error404.DerGrosseDalmuti.shared;

import java.io.Serializable;

/**
 * @author Jonas
 *
 */

public enum Role implements Serializable{
		GROSSERDALMUTI(1, "grosser Dalmuti", false, 2, 5, false), 
		KLEINERDALMUTI(2, "kleiner Dalmuti", false, 1, 4, false), 
		BUERGER(3, "Bürger", true), 
		KLEINERDIENER(4, "kleiner Diener", false, 1, 2, true), 
		GROSSERDIENER(5, "grosser Diener", false, 2, 1, true);
		
		private  int code;
		private  String label;
		private  boolean multiUse;
		private int NOfSwappableCards;
		private int swapTo;
		private boolean hasToBeHighest;
		
		// Konstruktor mit Parameteruebergabe:
		Role(int code, String label, boolean multiUse, int NOfSwappableCards, int swapTo, boolean hasToBeHighest){
			this.code = code;
			this.label = label;
			this.multiUse = multiUse;
			this.NOfSwappableCards = NOfSwappableCards;
			this.swapTo = swapTo;
			this.hasToBeHighest = hasToBeHighest;
		}
		
		Role(int code, String label, boolean multiUse){
			this.code = code;
			this.label = label;
			this.multiUse = multiUse;
		}
		
		public boolean getMultiUse(){return multiUse;}
		public String getLabel(){return label;}
		public int getCode(){return code;}
		public int getNOfSwappableCards(){return NOfSwappableCards;}
		public int getSwapTo(){return swapTo;}
		public boolean hasToBeHighest() {return hasToBeHighest;}
		
	}
		
	

