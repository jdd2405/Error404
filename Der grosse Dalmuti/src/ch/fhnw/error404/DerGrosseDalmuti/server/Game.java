package ch.fhnw.error404.DerGrosseDalmuti.server;

import java.util.LinkedList;
import java.util.ListIterator;

import ch.fhnw.error404.DerGrosseDalmuti.shared.*;


/**
* @author Jonas
*
*/

public class Game {

	Deck deck = new Deck(); // create new Deck once!
	private LinkedList<Player> allPlayers;
	private LinkedList<Object> updatedObject; // possibility to have more than one changed object

	public void addUpdatedObject(Object o){this.updatedObject.add(o);}
	public LinkedList<Object> getUpdatedObject(){return updatedObject;}


	// check if a trick (engl. "Stich") should be finished.
	public void clearTable(){
		ListIterator<Player> listIterator = allPlayers.listIterator();
		int passed = 0;
		
		// for every Player object which has passed add 1 to the counter
		// as long as the value of the counter is smaller than the amount of players
		while(listIterator.hasNext() && passed < allPlayers.size()) {
			Player player = listIterator.next();
			if(player.hasPassed() == true){
				passed++;
				player.setPassed(false);
				
			}
		}
		
		// check if the round
		if(passed == allPlayers.size()-1){
			// take cards from the table and put them in LinkedList allPlayedCards
			deck.allPlayedCards.push(deck.currentTrick.pop());
		}
	}

}
