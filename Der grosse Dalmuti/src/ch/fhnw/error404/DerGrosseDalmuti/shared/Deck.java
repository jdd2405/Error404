package ch.fhnw.error404.DerGrosseDalmuti.shared;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Stack;

import ch.fhnw.error404.DerGrosseDalmuti.shared.Card.CARD_TYPE;
/**
 * @author Jonas
 *
 */
public class Deck implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4903713809034981834L;
	private Stack<Card> currentTrick;	// currently on the table (de: "Karten in diesem Stich")
	private LinkedList<Card> allPlayedCards; // all played cards of this round
	private LinkedList<Card>[] playerCards; // current hands of players. Position +1 of Array is the value of the card type
	private LinkedList<Card> notDealtCards; // not dealt cards (de: "nicht ausgeteilte Karten")
	
	/* for Stack use
	 * public boolean empty( )
	 * public Object peek( )
	 * public Object pop( )
	 * public Object push(Object o)
	 * public int search(Object o)
	 */
	
	/* for LinkedListe use
	 * public boolean isEmpty()
	 * public E get(int index)
	 * public boolean add(E e)
	 * public boolean removeLast()
	 * public boolean removeFirst()
	 */
	
	public Deck (){
		notDealtCards.push(new Card(CARD_TYPE.DALMUTI)); 	/* just pushed one card. 
															 *  Now we have to create random Card 
															 *  until the amount of a specific CARD_TYPE 
															 *  reaches its value
															 */
		notDealtCards.push(new Card(CARD_TYPE.ERZBISCHOF));
		notDealtCards.push(new Card(CARD_TYPE.ERZBISCHOF));
		
		notDealtCards.push(new Card(CARD_TYPE.HOFMARSCHALL));
		notDealtCards.push(new Card(CARD_TYPE.HOFMARSCHALL));
		notDealtCards.push(new Card(CARD_TYPE.HOFMARSCHALL));
		
		notDealtCards.push(new Card(CARD_TYPE.BARONIN));
		notDealtCards.push(new Card(CARD_TYPE.BARONIN));
		notDealtCards.push(new Card(CARD_TYPE.BARONIN));
		notDealtCards.push(new Card(CARD_TYPE.BARONIN));
		
		notDealtCards.push(new Card(CARD_TYPE.AEBTISSIN));
		notDealtCards.push(new Card(CARD_TYPE.AEBTISSIN));
		notDealtCards.push(new Card(CARD_TYPE.AEBTISSIN));
		notDealtCards.push(new Card(CARD_TYPE.AEBTISSIN));
		notDealtCards.push(new Card(CARD_TYPE.AEBTISSIN));
		
	}
	
	public void pushNotDealtCards(Card e) {notDealtCards.push(e);}
	public Card peekNotDealtCards() {return notDealtCards.peek();} // get Card on top of Stack
	public Card popNotDealtCards() {return notDealtCards.pop();} // remove Card on top of Stack
	
	public void addAllPlayedCards(Card e) {allPlayedCards.add(e);}
	public void removeFirstAllPlayedCards() {allPlayedCards.removeFirst();}
	public void removeLastAllPlayedCards() {allPlayedCards.removeLast();}
	
	public LinkedList<Card> getNotDealtCards(){return notDealtCards;}	
	public LinkedList<Card>[] getPlayerCards() {return playerCards;}
	public LinkedList<Card> getAllPlayedCards() {return allPlayedCards;}
	public Stack<Card> getCurrentTrick() {return currentTrick;}
	
}
