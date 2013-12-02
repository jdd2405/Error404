package ch.fhnw.error404.DerGrosseDalmuti.shared;

import java.io.Serializable;

/**
 * @author Jonas
 *
 */
public class Card implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 140328283554900821L;
	private CARD_TYPE cardType;
	public Card() {};
	public Card(CARD_TYPE cardType){
		this.setCardType(cardType);
	}
	
	public CARD_TYPE getCardType() {return cardType;}
	public void setCardType(CARD_TYPE cardType) {this.cardType = cardType;}
	
	
	// inner class
	public enum CARD_TYPE {
		
		DALMUTI(1, "Dalmuti"),
		ERZBISCHOF(2, "Erzbischof"),
		HOFMARSCHALL(3, "Hofmarschall"),
		BARONIN(4, "Baronin"),
		AEBTISSIN(5, "Äbtissin"),
		RITTER(6, "Ritter"),
		NAEHERIN(7, "Näherin"),
		STEINMETZ(8, "Steinmetz"),
		KOECHIN(9, "Köchin"),
		SCHAFHIRTIN(10, "Schafhirtin"),
		BERGMANN(11, "Bergmann"),
		TAGELOEHNER(12, "Tagelöhner");

		private int value;
		private String label;



		// KONSTRUKTOR mit Parameterübergabe
		private CARD_TYPE(int code, String label){
			this.value = code;
			this.label = label;
		}

		public int getValue() {return value;}
		public String getLabel() {return label;}

	}
	
}
	

		

