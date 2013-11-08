package ch.fhnw.error404.DerGrosseDalmuti.shared;

import java.io.Serializable;

/**
 * @author Jonas
 *
 */

public enum Role implements Serializable{
		GROSSERDALMUTI(1, "grosser Dalmuti", false), 
		KLEINERDALMUTI(2, "kleiner Dalmuti", false), 
		BUERGER(3, "Bürger", true), 
		KLEINERDIENER(4, "kleiner Diener", false), 
		GROSSERDIENER(5, "grosser Diener", false);
		
		private  int code;
		private  String label;
		private  boolean multiUse;
		
		// Konstruktor mit Parameteruebergabe:
		Role(int code, String label, boolean multiUse){
			this.code = code;
			this.label = label;
			this.multiUse = multiUse;
		}
		
		public boolean getMultiUse(){return multiUse;}
		public String getLabel(){return label;}
		public int getCode(){return code;}
		
	}
		
	

