
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
	protected LinkedList<Player> allPlayers;
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
		ListIterator<Player> iterator = allPlayers.listIterator();
		while(iterator.hasNext()){
			if(iterator.next().getId() == myId && iterator.next().isActive()){
				myPlayerIsActive = true;
			}
		}
		return myPlayerIsActive;
	}
	
	
	
}
