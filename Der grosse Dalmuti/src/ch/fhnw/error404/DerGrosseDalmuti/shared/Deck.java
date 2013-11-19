<<<<<<< HEAD
package ch.fhnw.error404.DerGrosseDalmuti.shared;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.ListIterator;
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
	
	// has to be public to access from every class. 
	// Does not make sense to create public push-, add-, remove-, and do on methods.
	private static final long serialVersionUID = -4903713809034981834L;
	public Stack<Card> currentTrick;	// currently on the table (de: "Karten in diesem Stich")
	public LinkedList<Card> allPlayedCards; // all played cards of this round
	public LinkedList<Card>[] playerCards; // current hands of players. Position +1 of Array is the value of the card type
	public LinkedList<Card> notDealtCards; // not dealt cards (de: "nicht ausgeteilte Karten")
	
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
	
	public void shuffleCards(){
		// create Iterator to get trough the LinkedList
		ListIterator<Card> iterator = allPlayedCards.listIterator();
		while (iterator.hasNext()){
			// TODO: randomize this!
			notDealtCards.addFirst(allPlayedCards.removeLast());
			notDealtCards.addLast(allPlayedCards.removeFirst());
		}
	}
	
}
=======
package ch.fhnw.error404.DerGrosseDalmuti.shared;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.ListIterator;
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
	
	// has to be public to access from every class. 
	// Does not make sense to create public push-, add-, remove-, and do on methods.
	private static final long serialVersionUID = -4903713809034981834L;
	public Stack<Card> currentTrick;	// currently on the table (de: "Karten in diesem Stich")
	public LinkedList<Card> allPlayedCards; // all played cards of this round
	public LinkedList<Card>[] playerCards; // current hands of players. Position +1 of Array is the value of the card type
	public LinkedList<Card> notDealtCards; // not dealt cards (de: "nicht ausgeteilte Karten")
	public LinkedList<Card>[] swappedCards; // cards ready to swap
	
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
	
	public Deck(){
		
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
	
	public void shuffleCards(){
		// create Iterator to get trough the LinkedList
		ListIterator<Card> iterator = allPlayedCards.listIterator();
		while (iterator.hasNext()){
			// TODO: randomize this!
			notDealtCards.addFirst(allPlayedCards.removeLast());
			notDealtCards.addLast(allPlayedCards.removeFirst());
		}
	}
	
}
>>>>>>> branch 'master' of https://github.com/jdd2405/Error404.git
