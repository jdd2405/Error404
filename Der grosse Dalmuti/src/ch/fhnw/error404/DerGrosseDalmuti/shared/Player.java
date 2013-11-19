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
	
	public static Player Player1 = new Player("",1); // Erstellung der Players für den Zugriff vom GUI
	public static Player Player2 = new Player("",2);
	public static Player Player3 = new Player("",3);
	public static Player Player4 = new Player("",4);
	
	
	
	private static final long serialVersionUID = 790667502899497604L;
	public String name; 
	public int id; // unique identifier
	private boolean active; // Is it my turn?
	public Role role; // Wanna be King!
	private int rank; // oh, I have not finished first?
	private LinkedList<Card> cards; 
	public boolean passed; // set to false after every trick (engl. "Stich")!
	

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

