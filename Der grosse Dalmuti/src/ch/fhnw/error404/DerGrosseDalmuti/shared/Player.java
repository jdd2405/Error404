/**
 * 
 */
package ch.fhnw.error404.DerGrosseDalmuti.shared;

import java.io.Serializable;
import java.util.ArrayList;

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
	private int rank = 0; // oh, I have not finished first?
	private ArrayList<Card> cards;
	private Card swappedCard;
	public boolean passed; // set to false after every trick (engl. "Stich")!
	//private boolean passed; // set to false after every trick (engl. "Stich")!
	
	// constructor
	public Player(String name, int id, Role role) {
		this.name = name;
		this.role = role;
		this.id = id;
		this.setPassed(false);
	}
	
	
	public void setName(String name){this.name = name;}
	public String getName(){return name;}
	
	
	public void setId(int id){this.id = id;}
	public  int getId() {return id;}
	public void setRole(int i){		
		switch(i){
		case(1):
			this.role = Role.GROSSERDALMUTI;
		case(2):
			this.role = Role.KLEINERDALMUTI;
		case(3):
			this.role = Role.KLEINERDIENER;
		case(4):
			this.role = Role.GROSSERDIENER;
		}
	}
	public Role getRole(){return role;}

	
	public void setRank(int rank){this.rank = rank;}
	public int getRank(){return rank;}


	public ArrayList<Card> getCards() {return cards;}
	public void addCard(Card card) {this.cards.add(card);}


	public boolean hasPassed() {return passed;}
	public void setPassed(boolean passed) {this.passed = passed;}


	public boolean isActive() {return active;}
	public void setActive(boolean active) {this.active = active;}


	public Card getSwappedCard() {return swappedCard;}
	public void setSwappedCard(Card swappedCard) {this.swappedCard = swappedCard;}

	
	/*
	public void addCard(Card card){this.cards = cards;}
	public void newHand(Card card){this.cards = cards;}
	public void getHand(Card card){this.cards = cards;}
	*/
	
}

