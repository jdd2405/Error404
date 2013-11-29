package ch.fhnw.error404.DerGrosseDalmuti.client;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Stack;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import ch.fhnw.error404.DerGrosseDalmuti.shared.*;

/**
 * @author Jonas, Elias und Thomas
 *
 */
public class Action extends Client implements ActionListener {
	
	static protected int myId;
	public static Player[] allPlayers = new Player[4];
	private LoginView loginView;
	private DeskView  deskView;


	public Action(DeskView deskView) {
		this.deskView = deskView;
		
		//deskView.addDisplayAmountOfCardsToPlay(new DisplayAmountOfCardsToPlay());
		deskView.addCloseGame(new CloseGame());
	}
	
	public Action(LoginView loginView) {
		this.loginView = loginView;

		//... Add listeners to the view.
		loginView.addLoginListener(new LoginListener());
		//loginView.addClearOnClick(new ClearOnClick());
		loginView.username.addMouseListener(new ClearOnClick());
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
		Player player = new Player(name, getAllPlayers().length+1);
		myId = player.getId();
		getAllPlayers()[player.getId()] = player;
		
	}

	// check if it is the turn of my Player to enable Actions
	protected boolean actionsEnabled(){
		if(allPlayers[myId]).isActive() == true){
				
			}
		}
		return IsMyPlayerActive;
	}

	// ActionListeners of GUI!!!
	// ActionListener for the Login Button
	class LoginListener implements ActionListener{
		public void actionPerformed(ActionEvent e){	
			if ((loginView.getUserInput()).matches("[a-zA-Z0-9]*") == true){ // checks if username is valid
				newPlayer(loginView.getUserInput()); // creates new player object in action class using the typed name at the login
				loginView.closeWindow();
				System.out.println((allPlayers.get(0)).getName()); // for test reasons
				deskView = new DeskView();
				new Action(deskView);
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
			
	@Override
	public void actionPerformed(ActionEvent e) {	
	}
	

}

