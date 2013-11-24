
package ch.fhnw.error404.DerGrosseDalmuti.client;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Stack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ch.fhnw.error404.DerGrosseDalmuti.shared.*;

/**
 * @author Jonas
 *
 */
public class Action extends Client {
	
	private int myId;
	private LoginView loginView;
	private DeskView  deskView;
	
	protected ArrayList<Player> allPlayers = new ArrayList<Player>(); //TODO add all Players to this created LinkedList
	public Stack<Card> currentTrick;	// currently on the table (de: "Karten in diesem Stich")
	public ArrayList<Card>[] swappableCards; // cards ready to swap

	public Action(LoginView loginView, DeskView deskView) {
		this.loginView = loginView;
		this.deskView = deskView;

		//... Add listeners to the view.
		loginView.addListener(new Listener());
	}


	// inner class Listener
	class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String userInput = "";
			try {
				userInput = loginView.getUserInput();
				newPlayer(userInput);

			} catch (NumberFormatException nfex) {
				loginView.showError("Bad input: '" + userInput + "'");
			}
		}
	} // end inner class MultiplyListener






	// create new player based on the login-variables
	protected void newPlayer(String name){
		Player player = new Player(name, allPlayers.size()+1);
		allPlayers.add(player);
		myId = player.getId();
	}

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
