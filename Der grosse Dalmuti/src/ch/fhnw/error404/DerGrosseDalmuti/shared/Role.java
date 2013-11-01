package ch.fhnw.error404.DerGrosseDalmuti.shared;
/**
 * @author Jonas
 *
 */
public class Role {


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
		
		String getLabel(){return label;}
		int getCode(){return code;}
		int getMultiUse(){return multiUse;}
	}

	
	Role Role(int code) {
		return null;
	}
		
	
}