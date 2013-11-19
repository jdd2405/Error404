
package ch.fhnw.error404.DerGrosseDalmuti.client;

import java.util.LinkedList;
import java.util.ListIterator;

import ch.fhnw.error404.DerGrosseDalmuti.shared.*;

/**
 * @author Jonas
 *
 */
public class Action {
	
	private int myId;
	
	protected LinkedList<Player> allPlayers; //TODO add all Players to this LinkedList
	
	protected LinkedList<Object> updatedObject; // possibility to have more than one changed object
	
	
	public void addUpdatedObject(Object o){this.updatedObject.add(o);}
	public LinkedList<Object> getUpdatedObject(){return updatedObject;}
	
	// create new player based on the login-variables
	protected void newPlayer(String name){
		Player player = new Player(name, allPlayers.getLast().getId()+1);
		myId = player.getId();
	}
	
	// check if it is the turn of my Player to enable Actions
	protected boolean actionsEnabled(){
		boolean myPlayerIsActive = false;
		ListIterator<Player> playerIterator = allPlayers.listIterator();
		while(playerIterator.hasNext()){
			if(playerIterator.next().getId() == myId && playerIterator.next().isActive()){
				myPlayerIsActive = true;
			}
		}
		return myPlayerIsActive;
	}
	
	// 
	protected LinkedList<Card> swapCards(){
		
		LinkedList<Card> swapCards = null;
		Player thisPlayer = null;
		int NOfSwappingCards = 0; // Number of (NOf) swapped cards
		boolean hasToBeHightest;
		Card hightestCard;
		ListIterator<Player> playerIterator = allPlayers.listIterator();
		
		while(playerIterator.hasNext()){
			Player player = playerIterator.next();
			
			if(player.getId() == myId){
				thisPlayer = playerIterator.next();
				switch(player.getRole()){
				case BUERGER:
					NOfSwappingCards = 0;
				case GROSSERDALMUTI:
					NOfSwappingCards = 2;
					hasToBeHightest = false;
				case GROSSERDIENER:
					NOfSwappingCards = 2;
					hasToBeHightest = true;
				case KLEINERDALMUTI:
					NOfSwappingCards = 1;
					hasToBeHightest = false;
				case KLEINERDIENER:
					NOfSwappingCards = 1;
					hasToBeHightest = true;
				}
			}
		}
		
		
		// TODO: ActionListener for choosing swapping cards
		// Wait for Action and then do:
		if(NOfSwappingCards != 0){
			swapCards.add(thisPlayer.getCards().remove());
			NOfSwappingCards--;
		}
		
		return swapCards;
	}
	
	
	
}
