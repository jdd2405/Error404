/**
 * 
 */
package ch.fhnw.error404.DerGrosseDalmuti.shared;

import java.io.Serializable;
import java.util.List;

import ch.fhnw.error404.DerGrosseDalmuti.shared.Role.ROLE_TYPE;

/**
 * @author Jonas
 *
 */
public class Player implements Serializable{
	
	private String name;
	private ROLE_TYPE role;
	private int rank;
	private List<Card> cards;
	

	
	public Player(String name) {
		this.name = name;
		this.role = ROLE_TYPE.BUERGER;	
	}
	
	public Player(String name, int i) {
		this.name = name;
		switch(i){
		case(1):
			this.role = ROLE_TYPE.GROSSERDALMUTI;
		case(2):
			this.role = ROLE_TYPE.KLEINERDALMUTI;
		case(3):
			this.role = ROLE_TYPE.BUERGER;
		case(4):
			this.role = ROLE_TYPE.KLEINERDIENER;
		case(5):
			this.role = ROLE_TYPE.GROSSERDIENER;
		}
	}
	
	public void setName(String name){this.name = name;}
	public String getName(){return name;}
	
	public void setRole(int i){		
		switch(i){
		case(1):
			this.role = ROLE_TYPE.GROSSERDALMUTI;
		case(2):
			this.role = ROLE_TYPE.KLEINERDALMUTI;
		case(3):
			this.role = ROLE_TYPE.BUERGER;
		case(4):
			this.role = ROLE_TYPE.KLEINERDIENER;
		case(5):
			this.role = ROLE_TYPE.GROSSERDIENER;
		}
	}
	public ROLE_TYPE getRole(){return role;}
	
	public void setRank(int rank){this.rank = rank;}
	public int getRank(){return rank;}
	
	public void addCard(Card card){this.cards = cards;}
	public void newHand(Card card){this.cards = cards;}
	public void getHand(Card card){this.cards = cards;}

	
}

// Fuck Dr Java
