/**
 * 
 */
package ch.fhnw.error404.DerGrosseDalmuti.shared;

import java.io.Serializable;
import java.util.LinkedList;

import ch.fhnw.error404.DerGrosseDalmuti.shared.Role;

/**
 * @author Jonas
 *
 */
public class Player implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 790667502899497604L;
	private String name;
	private Role role;
	private int rank;
	LinkedList<Card> cards;
	

	
	public Player(String name) {
		this.name = name;
		this.role = Role.BUERGER;	
	}
	
	public Player(String name, int i) {
		this.name = name;
		switch(i){
		case(1):
			this.role = Role.GROSSERDALMUTI;
		case(2):
			this.role = Role.KLEINERDALMUTI;
		case(3):
			this.role = Role.BUERGER;
		case(4):
			this.role = Role.KLEINERDIENER;
		case(5):
			this.role = Role.GROSSERDIENER;
		}
	}
	
	public void setName(String name){this.name = name;}
	public String getName(){return name;}
	
	public void setRole(int i){		
		switch(i){
		case(1):
			this.role = Role.GROSSERDALMUTI;
		case(2):
			this.role = Role.KLEINERDALMUTI;
		case(3):
			this.role = Role.BUERGER;
		case(4):
			this.role = Role.KLEINERDIENER;
		case(5):
			this.role = Role.GROSSERDIENER;
		}
	}
	public Role getRole(){return role;}
	
	public void setRank(int rank){this.rank = rank;}
	public int getRank(){return rank;}
	
	/*
	public void addCard(Card card){this.cards = cards;}
	public void newHand(Card card){this.cards = cards;}
	public void getHand(Card card){this.cards = cards;}
	*/
	
}

