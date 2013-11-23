
package ch.fhnw.error404.DerGrosseDalmuti.client;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Stack;

import ch.fhnw.error404.DerGrosseDalmuti.shared.*;

/**
 * @author Jonas
 *
 */
public class Action {
	
	private int myId;

	
	/*
	 * These Collections need to be exchanged via client-server!!!
	 * -------------------------------------------------------------------------------------->
	 */
	protected ArrayList<Player> allPlayers; //TODO add all Players to this LinkedList
	public Stack<Card> currentTrick;	// currently on the table (de: "Karten in diesem Stich")
	public ArrayList<Card>[] swappableCards; // cards ready to swap
	/*
	 * <--------------------------------------------------------------------------------------
	 */
	
	
	// create new player based on the login-variables
	protected void newPlayer(String name){
		Player player = new Player(name, allPlayers.size()+1);
		allPlayers.add(player);
		myId = player.getId();
	}
	
	//Player Player1 = new Player("jonas", 1);
	
	
	// check if it is the turn of my Player to enable Actions
	protected boolean actionsEnabled(){
		boolean IsMyPlayerActive = false;
		ListIterator<Player> playerIterator = allPlayers.listIterator();
		while(playerIterator.hasNext()){
			if(playerIterator.next().getId() == myId && playerIterator.next().isActive()){
				IsMyPlayerActive = true;
			}
		}
		return IsMyPlayerActive;
	}
	
	// TODO create ActionListener!!!
	
	// returns a List of swappable Cards for a specific Player
		public ArrayList<Card> getSwappableCards(Player player){
			
			// initialize List of Cards
			ArrayList<Card> swappableCards = new ArrayList<Card>();
			
			
			
			if(player.getRole().hasToBeHighest() == true) {
				
				for(int i=0; i <=player.getRole().getNOfSwappableCards(); i++){
					
					// initialize listIterator
					ListIterator<Card> listIterator = player.getCards().listIterator();
					
					while(listIterator.hasNext()){
						
						// <========= DO YOUR WORK! CONTINUE HERE!
						
					}	
				}
				
			}
			
			// return List of swappable Cards
			return swappableCards;
		}
	
	
	
}
