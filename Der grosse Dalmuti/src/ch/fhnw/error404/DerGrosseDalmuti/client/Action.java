
package ch.fhnw.error404.DerGrosseDalmuti.client;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Stack;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import ch.fhnw.error404.DerGrosseDalmuti.shared.*;

/**
 * @author Jonas, Elias und Thomas
 *
 */
public class Action extends Client {
	
	private int myId;
	private LoginView loginView;
	private DeskView  deskView;
	
	protected ArrayList<Player> allPlayers = new ArrayList<Player>(); //TODO add all Players to this created LinkedList
	public Stack<Card> currentTrick;	// currently on the table (de: "Karten in diesem Stich")
	public ArrayList<Card>[] swappableCards; // cards ready to swap

	public Action(DeskView deskView) {
		this.deskView = deskView;
		//deskView.addDisplayAmountOfCardsToPlay(new DisplayAmountOfCardsToPlay());
		deskView.addCloseGame(new CloseGame());
	}
	
	public Action(LoginView loginView) {
		this.loginView = loginView;

		//... Add listeners to the view.
		loginView.addLoginListener(new LoginListener());
		loginView.addClearOnClick(new ClearOnClick());

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

	// ActionListeners of GUI!!!
	// ActionListener for the Login Button

	class LoginListener implements ActionListener{
		public void actionPerformed(ActionEvent e){	
			if ((loginView.getUserInput()).matches("[a-zA-Z0-9]*") == true){ // checks if username is valid
				newPlayer(loginView.getUserInput()); // creates new player object in action class using the typed name at the login
				loginView.closeWindow();

	ActionListener LoginListener = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if ((Username.getText()).matches("[a-zA-Z0-9]*") == true){ // checks if username is valid
				newPlayer(Username.getText()); // creates new player object in action class using the typed name at the login
				dispose();
				System.out.println((allPlayers.get(0)).getName()); // for test reasons
				DeskView deskView = new DeskView();
				new Action(deskView);
				new DeskView(); // opens the deskview GUI
				loginview.setVisible(false); // closes the Loginview
			}
			else{
				new LoginError();
			}
		}
	};
	
	// Clear Loginfield on click
	MouseListener ClearOnClick = new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
			Username.setText(""); // Sets the Username on click to empty if the username is "Username"
		}
	};	
	
	// Counts cards of the player on click
	ActionListener DisplayCards = new ActionListener(){
		public void actionPerformed(ActionEvent e){

		}
	};
	
	// Close Game

	class CloseGame extends LoginListener implements ActionListener{
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
