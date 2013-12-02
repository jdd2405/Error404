package ch.fhnw.error404.DerGrosseDalmuti.client;

import java.util.ArrayList;
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
	public Player[] allPlayers = new Player[4];
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
	
	
	/*
	 * GAME LOGIC 
	 */
	
	// create new player based on the login-variables
	protected void newPlayer(String name){
		Player player = new Player(name, getAllPlayers().length+1);
		myId = player.getId();
		allPlayers[myId] = player;
		
	}

	// check if it is the turn of my Player to enable Actions
	protected boolean actionsEnabled(){
		boolean actionsEnabled = false;
		if(allPlayers[myId].isActive() == true){
				actionsEnabled = true;
			}
		return actionsEnabled;
	}

	private void enableActionListeners() {
		// TODO Auto-generated method stub
		
	}
	
	
	
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
	

	//bitte nicht löschen, ist für die Verbindung zum Client
	public Player[] getAllPlayers() {
		return allPlayers;
	}
	
	public void setAllPlayers(Player[] allPlayers) {
		this.allPlayers = allPlayers;
	}
	
}

