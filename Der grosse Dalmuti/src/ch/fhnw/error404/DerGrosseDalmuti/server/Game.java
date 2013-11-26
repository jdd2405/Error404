package ch.fhnw.error404.DerGrosseDalmuti.server;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

import ch.fhnw.error404.DerGrosseDalmuti.shared.*;


/**
* @author Jonas
*
*/

public class Game {
	
	
	protected LinkedList<Player> allPlayers; //TODO add all Players to this LinkedList
	public Stack<Card> currentTrick;	// currently on the table (de: "Karten in diesem Stich")
	public ArrayList<Card>[] swappableCards; // cards ready to swap
	public Deck deck;
	
	
	public Game(){
		// deck = new Deck(); // create new Deck once!
	}

	
	
	// Setter- and Getter-methods
	public LinkedList<Player> getAllPlayers() {	return allPlayers;}
	public void setAllPlayers(LinkedList<Player> allPlayers) {this.allPlayers = allPlayers;}
	public Stack<Card> getCurrentTrick() {return currentTrick;}
	public void setCurrentTrick(Stack<Card> currentTrick) {this.currentTrick = currentTrick;}
	public ArrayList<Card>[] getSwappableCards() {return swappableCards;}
	public void setSwappableCards(ArrayList<Card>[] swappableCards) {this.swappableCards = swappableCards;}

	
	
	
	
	// check if a trick (engl. "Stich") should be finished.
	public void maxPassedReached(){
		
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
		
		// check if maxPassed is reached
		if(passed == allPlayers.size()-1){
			// take cards from the table and put them in notDealtCards
			deck.notDealtCards.addAll(deck.currentTrick);
			deck.currentTrick.clear();
		}
	}
	
	public void isRoundFinished() {
		
		ListIterator<Player> listIterator = allPlayers.listIterator();
		int active = 0;
		
		while(listIterator.hasNext() && active < allPlayers.size()) {
			Player player = listIterator.next();
			if(player.isActive() == true){
				active++;			
			}
		}
		
		if(active == allPlayers.size()-1){
			// take cards from the table and put them in notDealtCards
			deck.notDealtCards.addAll(deck.currentTrick);
			deck.currentTrick.clear();
			
			listIterator = allPlayers.listIterator(); // renew listIterator to be sure
			
			// take all remaining cards from Players and put them in notDealtCards
			while(listIterator.hasNext()){
				Player player = listIterator.next();
				if(player.isActive() == true){
					deck.notDealtCards.removeAll(player.getCards());	
				}
			}
		}
	}
	
	
	
}
