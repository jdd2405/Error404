package ch.fhnw.error404.DerGrosseDalmuti.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ch.fhnw.error404.DerGrosseDalmuti.shared.*;

/**
 * @author Jonas, Elias und Thomas
 *
 */
public class Action{
	
	static protected int myId;
	public static Player[] allPlayers = new Player[4];
	public static Deck deck;
	LoginView loginView;
	DeskView  deskView;

	/*
	 * KONSTRUCTOR for Action Class
	 */

	public Action(LoginView loginView, DeskView deskView) {
		this.loginView = loginView;
		this.deskView = deskView;

		//... Add listeners to the view.
		loginView.addLoginListener(new LoginListener());
		loginView.addClearOnClick(new ClearOnClick());
		
		//deskView.addDisplayAmountOfCardsToPlay(new DisplayAmountOfCardsToPlay());
		deskView.addCloseGame(new CloseGame());
		deskView.addPassen(new Passen());
		deskView.addAuswahlSpielen(new AuswahlSpielen());
		
	}
	
	/*
	 * INNER CLASSES for Action- and MouseListeners
	 */
	
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



	// ActionListeners of GUI!!!
	// ActionListener for the Login Button
	class LoginListener implements ActionListener{
		public void actionPerformed(ActionEvent e){	
			if ((loginView.getUserInput()).matches("[a-zA-Z0-9]*") == true){ // checks if username is valid
				newPlayer(loginView.getUserInput()); // creates new player object in action class using the typed name at the login
				loginView.closeWindow();
				System.out.println(allPlayers[0].getName()); // for test reasons
				deskView.setVisible(true);
			}
			else{
				new LoginError();
			}
		}
	}
	
	// Clear Loginfield on click
	class ClearOnClick implements MouseListener{
		
		public void mouseClicked(MouseEvent e){
			loginView.setUserInput(""); // Sets the Username on click to empty if the username is "Username"
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
		}		
		@Override
		public void mousePressed(MouseEvent e) {
		}	
		@Override
		public void mouseReleased(MouseEvent e) {
		}
	}	
	
	// Counts cards of the player on click
	class DisplayAmountOfCardsToPlay implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
	}
	
	// Close Game
	class CloseGame implements ActionListener{
		public void actionPerformed(ActionEvent e){
			deskView.closeWindow();		
		}
	}
	//spielzug passen Button Aktion
	class Passen implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int countPassen=0;
			for(int i = 0; i<4; i++){
				if(allPlayers[i].passed == true){
					countPassen++;}
			}
			if(countPassen <= 1){allPlayers[myId].setPassed(true);}
			else if (countPassen ==2){
				allPlayers[myId].setPassed(true);
				clearTable();
				for(int i = 0; i<4; i++){
					allPlayers[i].passed = false;}
			}
		}
	}
	
	// Auswahl spielen Button Aktion
	class AuswahlSpielen implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			
		}
	}
	
	
	/*
	 * GAME LOGIC - Methods for running the Game properly
	 */
	
	// create new player based on the login-variables
	// if there are 4 players deal cards
	protected void newPlayer(String name){
		int NOfPlayers = 0;
		for (int i = 0; i < allPlayers.length; i++){
			if(allPlayers[i]!=null){
				NOfPlayers++;
			}
		}
		Player player = new Player(name, NOfPlayers+1);
		myId = player.getId();
		allPlayers[myId-1] = player; // cause IDs start from 1
		
		if(myId==4){
			// shuffle notDealtCards
			Collections.shuffle(deck.notDealtCards);
			// create Iterator to get trough the LinkedList
			ListIterator<Card> iterator = deck.notDealtCards.listIterator();
			while (iterator.hasNext()){
				for(int i=0; i<=allPlayers.length; i++){
					for(int j=0; j<=deck.notDealtCards.size(); j++){
						allPlayers[i].addCard(deck.notDealtCards.remove(j));
					}
				}
			}
		}
		
		
		
		Client_neu.sendToServer(allPlayers);
	}
	
	
	// show all Players in proper position
	void showPlayers(){
		switch (allPlayers[myId].getRole().getCode()){
		case(1): // e.g. Grosser Dalmuti
			for(int i = 0; i<allPlayers.length; i++){
				if(allPlayers[i].getRole().getCode()==2){
					deskView.showInWest(allPlayers[i]);
				}
				else if(allPlayers[i].getRole().getCode()==4){
					deskView.showInNorth(allPlayers[i]);
				}
				else if(allPlayers[i].getRole().getCode()==5){
					deskView.showInEast(allPlayers[i]);
				}
					
			}
		case(2): // e.g. Kleiner Dalmuti
			for(int i = 0; i<allPlayers.length; i++){
				if(allPlayers[i].getRole().getCode()==4){
					deskView.showInWest(allPlayers[i]);
				}
				else if(allPlayers[i].getRole().getCode()==5){
					deskView.showInNorth(allPlayers[i]);
				}
				else if(allPlayers[i].getRole().getCode()==1){
					deskView.showInEast(allPlayers[i]);
				}
					
			}
		case(4): // e.g. Kleiner Diener
			for(int i = 0; i<allPlayers.length; i++){
				if(allPlayers[i].getRole().getCode()==1){
					deskView.showInWest(allPlayers[i]);
				}
				else if(allPlayers[i].getRole().getCode()==2){
					deskView.showInNorth(allPlayers[i]);
				}
				else if(allPlayers[i].getRole().getCode()==3){
					deskView.showInEast(allPlayers[i]);
				}
					
			}
		case(5): // e.g. grosser Diener
			for(int i = 0; i<allPlayers.length; i++){
				if(allPlayers[i].getRole().getCode()==3){
					deskView.showInWest(allPlayers[i]);
				}
				else if(allPlayers[i].getRole().getCode()==4){
					deskView.showInNorth(allPlayers[i]);
				}
				else if(allPlayers[i].getRole().getCode()==1){
					deskView.showInEast(allPlayers[i]);
				}
					
			}
		default: 
			switch(myId){
			case(1):
				deskView.showInWest(allPlayers[myId+1]);
				deskView.showInNorth(allPlayers[myId+2]);
				deskView.showInEast(allPlayers[myId+3]);
			
			case(2):
				deskView.showInWest(allPlayers[myId+1]);
				deskView.showInNorth(allPlayers[myId+2]);
				deskView.showInEast(allPlayers[myId-1]);
			
			case(3):
				deskView.showInWest(allPlayers[myId+1]);
				deskView.showInNorth(allPlayers[myId-2]);
				deskView.showInEast(allPlayers[myId-1]);
			
			case(4):
				deskView.showInWest(allPlayers[myId-3]);
				deskView.showInNorth(allPlayers[myId-2]);
				deskView.showInEast(allPlayers[myId-1]);
			}
				
		}
	}
	
	

	// check if it is the turn of my Player to enable Actions
	protected boolean actionsEnabled(){
		boolean actionsEnabled = false;
		if(allPlayers[myId].isActive() == true){
				actionsEnabled = true;
			}
		return actionsEnabled;
	}
	
	
	
	
	
	// returns an Array of swappable Cards-Types for a specific Player
	public Card.CARD_TYPE[] getSwappableCards(Player player){

		// initialize List of Cards
		Card.CARD_TYPE[] swappableCards = new Card.CARD_TYPE[2];

		if(player.getRole().hasToBeHighest() == true) {

			for(int i=0; i <=player.getRole().getNOfSwappableCards(); i++){

				// initialize listIterator
				ListIterator<Card> listIterator = player.getCards().listIterator();

				while(listIterator.hasNext()){
					if(swappableCards[1].getValue() > listIterator.next().getCardType().getValue()){
						if(swappableCards[2].getValue() > listIterator.next().getCardType().getValue()){
							swappableCards[2]=listIterator.next().getCardType();
						}
						else {
							swappableCards[1]=listIterator.next().getCardType();
						}
					}
					

				}
				// if two equal card types in array set one to null
				// -> if there is only one card type you have at least to of them.
				if(swappableCards[1].equals(swappableCards[2])){
					swappableCards[2] = null;
				}
			}

		}

		// return List of swappable Cards
		return swappableCards;
	}	
	
	
	// clear table nachdem 3 Player gepasst haben
	protected void clearTable(){
		while(!deck.currentTrick.isEmpty()){ // not empty
			deck.notDealtCards.add(deck.currentTrick.pop());
		}
	}

	
}

