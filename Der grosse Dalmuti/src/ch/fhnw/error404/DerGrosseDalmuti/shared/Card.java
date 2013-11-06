package ch.fhnw.error404.DerGrosseDalmuti.shared;

import java.io.Serializable;

/**
 * @author Jonas
 *
 */
public class Card implements Serializable{

	public enum CARD_TYPE{
		
		DALMUTI(1, "Dalmuti"),
		ERZBISCHOF(2, "Erzbischof"),
		HOFMARSCHALL(3, "Hofmarschall"),
		BARONIN(4, "Baronin"),
		AEBTISSIN(5, "�btissin"),
		RITTER(6, "Ritter"),
		NAEHERIN(7, "N�herin"),
		STEINMETZ(8, "Steinmetz"),
		KOECHIN(9, "K�chin"),
		SCHAFHIRTIN(10, "Schafhirtin"),
		BERGMANN(11, "Bergmann"),
		TAGELOEHNER(12, "Tagel�hner");
		
		private int code;
		private String label;
		
		
		// KONSTRUKTOR mit Parameter�bergabe
		CARD_TYPE(int code, String label){
			this.code = code;
			this.label = label;
		}
	}
	
}
