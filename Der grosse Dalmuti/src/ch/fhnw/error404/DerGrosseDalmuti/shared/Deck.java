package ch.fhnw.error404.DerGrosseDalmuti.shared;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Stack;

import ch.fhnw.error404.DerGrosseDalmuti.shared.Card;
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
		
		// Push cards to LinkedList "nodDealtCards"
		// The for-loop gets the amount of cards of every card type in this game
		// For example: there are only 2 cards of the card type "Erzbischof". This is checked by the getValue method.
		for(int i = 0; i<Card.DALMUTI.getValue(); i++){notDealtCards.push(Card.DALMUTI);}
		for(int i = 0; i<Card.ERZBISCHOF.getValue(); i++){notDealtCards.push(Card.ERZBISCHOF);}
		for(int i = 0; i<Card.HOFMARSCHALL.getValue(); i++){notDealtCards.push(Card.HOFMARSCHALL);}
		for(int i = 0; i<Card.BARONIN.getValue(); i++){notDealtCards.push(Card.BARONIN);}
		for(int i = 0; i<Card.AEBTISSIN.getValue(); i++){notDealtCards.push(Card.AEBTISSIN);}
		for(int i = 0; i<Card.RITTER.getValue(); i++){notDealtCards.push(Card.RITTER);}
		for(int i = 0; i<Card.NAEHERIN.getValue(); i++){notDealtCards.push(Card.NAEHERIN);}
		for(int i = 0; i<Card.STEINMETZ.getValue(); i++){notDealtCards.push(Card.STEINMETZ);}
		for(int i = 0; i<Card.KOECHIN.getValue(); i++){notDealtCards.push(Card.KOECHIN);}
		for(int i = 0; i<Card.SCHAFHIRTIN.getValue(); i++){notDealtCards.push(Card.SCHAFHIRTIN);}
		for(int i = 0; i<Card.BERGMANN.getValue(); i++){notDealtCards.push(Card.BERGMANN);}
		for(int i = 0; i<Card.TAGELOEHNER.getValue(); i++){notDealtCards.push(Card.TAGELOEHNER);}
		
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
