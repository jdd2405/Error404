package ch.fhnw.error404.DerGrosseDalmuti.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
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
	public ArrayList<Card> notDealtCards; // not dealt cards (de: "nicht ausgeteilte Karten")
	public ArrayList<Card>[] swappedCards; // cards ready to swap
	
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
		for(int i = 0; i<Card.DALMUTI.getValue(); i++){notDealtCards.add(Card.DALMUTI);}
		for(int i = 0; i<Card.ERZBISCHOF.getValue(); i++){notDealtCards.add(Card.ERZBISCHOF);}
		for(int i = 0; i<Card.HOFMARSCHALL.getValue(); i++){notDealtCards.add(Card.HOFMARSCHALL);}
		for(int i = 0; i<Card.BARONIN.getValue(); i++){notDealtCards.add(Card.BARONIN);}
		for(int i = 0; i<Card.AEBTISSIN.getValue(); i++){notDealtCards.add(Card.AEBTISSIN);}
		for(int i = 0; i<Card.RITTER.getValue(); i++){notDealtCards.add(Card.RITTER);}
		for(int i = 0; i<Card.NAEHERIN.getValue(); i++){notDealtCards.add(Card.NAEHERIN);}
		for(int i = 0; i<Card.STEINMETZ.getValue(); i++){notDealtCards.add(Card.STEINMETZ);}
		for(int i = 0; i<Card.KOECHIN.getValue(); i++){notDealtCards.add(Card.KOECHIN);}
		for(int i = 0; i<Card.SCHAFHIRTIN.getValue(); i++){notDealtCards.add(Card.SCHAFHIRTIN);}
		for(int i = 0; i<Card.BERGMANN.getValue(); i++){notDealtCards.add(Card.BERGMANN);}
		for(int i = 0; i<Card.TAGELOEHNER.getValue(); i++){notDealtCards.add(Card.TAGELOEHNER);}
		
	}
	
	public void dealCards(ArrayList<Player> allPlayers){
		// shuffle notDealtCards
		Collections.shuffle(notDealtCards);
		// create Iterator to get trough the LinkedList
		ListIterator<Card> iterator = notDealtCards.listIterator();
		while (iterator.hasNext()){
			// TODO: give Cards to Players
			for(int p=0; p<=allPlayers.size(); p++){
				Player player = allPlayers.get(p);
				for(int c=0; c<=notDealtCards.size(); c++){
					player.addCard(notDealtCards.remove(c));
				}
			}
		}
	}
	
	protected void addSwappedCards(Player player){
		player.getCards().addAll(swappedCards[player.getRole().getCode()-1]);
	}
	

}

