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
	private int id; // unique identifier
	private boolean active; // Is it my turn?
	private Role role; // Wanna be King!
	private int rank; // oh, I have not finished first?
	private LinkedList<Card> cards; 
	private boolean passed; // set to false after every trick (engl. "Stich")!
	

	// constructor
	public Player(String name, int id) {
		this.name = name;
		this.role = Role.BUERGER;
		this.id = id;
		this.setPassed(false);
	}
	
	
	public void setName(String name){this.name = name;}
	public String getName(){return name;}
	
	
	public void setId(int id){this.id = id;}
	public int getId() {return id;}
	
	
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


	public LinkedList<Card> getCards() {return cards;}
	public void setCards(LinkedList<Card> cards) {this.cards = cards;}


	public boolean hasPassed() {return passed;}
	public void setPassed(boolean passed) {this.passed = passed;}


	public boolean isActive() {return active;}
	public void setActive(boolean active) {this.active = active;}

	
	/*
	public void addCard(Card card){this.cards = cards;}
	public void newHand(Card card){this.cards = cards;}
	public void getHand(Card card){this.cards = cards;}
	*/
	
}

