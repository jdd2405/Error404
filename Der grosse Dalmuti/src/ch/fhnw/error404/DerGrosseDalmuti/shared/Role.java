package ch.fhnw.error404.DerGrosseDalmuti.shared;

import java.io.Serializable;

/**
 * @author Jonas
 *
 */

public enum Role implements Serializable{
		GROSSERDALMUTI("grosser Dalmuti", false, 2, 5, false), 
		KLEINERDALMUTI("kleiner Dalmuti", false, 1, 4, false), 
		KLEINERDIENER("kleiner Diener", false, 1, 2, true), 
		GROSSERDIENER("grosser Diener", false, 2, 1, true);
		
		private  String label;
		private  boolean multiUse;
		private int NOfSwappableCards;
		private int swapTo;
		private boolean hasToBeHighest;
		
		// Konstruktor mit Parameteruebergabe:
		Role(String label, boolean multiUse, int NOfSwappableCards, int swapTo, boolean hasToBeHighest){
			this.label = label;
			this.multiUse = multiUse;
			this.NOfSwappableCards = NOfSwappableCards;
			this.swapTo = swapTo;
			this.hasToBeHighest = hasToBeHighest;
		}
		
		Role(String label, boolean multiUse){
			this.label = label;
			this.multiUse = multiUse;
		}
		
		public boolean getMultiUse(){return multiUse;}
		public String getLabel(){return label;}
		public int getNOfSwappableCards(){return NOfSwappableCards;}
		public int getSwapTo(){return swapTo;}
		public boolean hasToBeHighest() {return hasToBeHighest;}
		
	}
		
	

