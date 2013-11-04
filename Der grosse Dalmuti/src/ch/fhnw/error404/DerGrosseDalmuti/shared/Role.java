package ch.fhnw.error404.DerGrosseDalmuti.shared;

import java.io.Serializable;

/**
 * @author Jonas
 *
 */
public class Role implements Serializable{


	public enum ROLE_TYPE{
		GROSSERDALMUTI(1, "grosser Dalmuti", false), 
		KLEINERDALMUTI(2, "kleiner Dalmuti", false), 
		BUERGER(3, "B�rger", true), 
		KLEINERDIENER(4, "kleiner Diener", false), 
		GROSSERDIENER(5, "grosser Diener", false);
		
		private  int code;
		private  String label;
		private  boolean multiUse;
		
		// Konstruktor mit Parameteruebergabe:
		ROLE_TYPE(int code, String label, boolean multiUse){
			this.code = code;
			this.label = label;
			this.multiUse = multiUse;
		}
		
	}
		
	
}
