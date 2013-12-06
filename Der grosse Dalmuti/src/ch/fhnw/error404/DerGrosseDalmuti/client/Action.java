package ch.fhnw.error404.DerGrosseDalmuti.client;

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
public class Action {

	protected int myId;
	Player[] allPlayers = new Player[4];
	Deck deck;
	LoginView loginView;
	DeskView deskView;

	/*
	 * KONSTRUCTOR for Action Class
	 */

	public Action(LoginView loginView, DeskView deskView) {
		this.loginView = loginView;
		this.deskView = deskView;

		// ... Add listeners to the view.
		loginView.addLoginListener(new LoginListener());
		loginView.addClearOnClick(new ClearOnClick());

		// deskView.addDisplayAmountOfCardsToPlay(new
		// DisplayAmountOfCardsToPlay());
		deskView.addCloseGame(new CloseGame());
		deskView.addPassen(new Passen());
		deskView.addAuswahlSpielen(new AuswahlSpielen());
		// deskView.addButtonKlick(new ButtonKlick());
		deskView.addDisplayNumber(new DisplayNumber());

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
	class LoginListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if ((loginView.getUserInput()).matches("[a-zA-Z0-9]*") == true) { // checks
																				// if
																				// username
																				// is
																				// valid
				newPlayer(loginView.getUserInput()); // creates new player
														// object in action
														// class using the typed
														// name at the login
				loginView.closeWindow();
				System.out.println(allPlayers[0].getName()); // for test reasons
				deskView.setVisible(true);
			} else {
				new LoginError();
			}
		}
	}

	// Clear Loginfield on click
	class ClearOnClick implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			loginView.setUserInput(""); // Sets the Username on click to empty
										// if the username is "Username"
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
	class DisplayAmountOfCardsToPlay implements ActionListener {
		public void actionPerformed(ActionEvent e) {

		}
	}

	// Close Game
	class CloseGame implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			deskView.closeWindow();
		}
	}

	class DisplayNumber implements ActionListener {
		String b;

		public void actionPerformed(ActionEvent e) {
			/*
			for(int i = 0; i < deskView.slot.length; i++){
				if(deskView.slot[i].equals(e.getSource())){
					deskView.typeCards.setText(Card.CARD_TYPE.values().length+i);
				}
			}
			*/
			if (deskView.slot[0].equals(e.getSource())){
				deskView.typeCards.setText("Dalmuti");		
				}
				else if (deskView.slot[1].equals(e.getSource())){
				deskView.typeCards.setText("Erzbischof");
				}
				else if (deskView.slot[2].equals(e.getSource())){
				deskView.typeCards.setText("Hofmarschall");
				}
				else if (deskView.slot[3].equals(e.getSource())){
				deskView.typeCards.setText("Baronin");
				}
				else if (deskView.slot[4].equals(e.getSource())){
				deskView.typeCards.setText("Äbtissin");
				}
				else if (deskView.slot[5].equals(e.getSource())){
				deskView.typeCards.setText("Ritter");
				}
				else if (deskView.slot[6].equals(e.getSource())){
				deskView.typeCards.setText("Näherin");
				}
				else if (deskView.slot[7].equals(e.getSource())){
				deskView.typeCards.setText("Steinmetz");
				}
				else if (deskView.slot[8].equals(e.getSource())){
				deskView.typeCards.setText("Köchin");
				}
				else if (deskView.slot[9].equals(e.getSource())){
				deskView.typeCards.setText("Schafhirtin");
				}
				else if (deskView.slot[10].equals(e.getSource())){
				deskView.typeCards.setText("Bergmann");
				}
				else if (deskView.slot[11].equals(e.getSource())){
				deskView.typeCards.setText("Tagelöhner");
				}
			
			if (deskView.slot[0].equals(e.getSource())){
				deskView.amountCards.setText((deskView.amountOfCards[0].getText()));		
				}
				else if (deskView.slot[1].equals(e.getSource())){
				deskView.amountCards.setText((deskView.amountOfCards[1].getText()));
				}
				else if (deskView.slot[2].equals(e.getSource())){
				deskView.amountCards.setText((deskView.amountOfCards[2].getText()));
				}
				else if (deskView.slot[3].equals(e.getSource())){
				deskView.amountCards.setText((deskView.amountOfCards[3].getText()));
				}
				else if (deskView.slot[4].equals(e.getSource())){
				deskView.amountCards.setText((deskView.amountOfCards[4].getText()));
				}
				else if (deskView.slot[5].equals(e.getSource())){
				deskView.amountCards.setText((deskView.amountOfCards[5].getText()));
				}
				else if (deskView.slot[6].equals(e.getSource())){
				deskView.amountCards.setText((deskView.amountOfCards[6].getText()));
				}
				else if (deskView.slot[7].equals(e.getSource())){
				deskView.amountCards.setText((deskView.amountOfCards[7].getText()));
				}
				else if (deskView.slot[8].equals(e.getSource())){
				deskView.amountCards.setText((deskView.amountOfCards[8].getText()));
				}
				else if (deskView.slot[9].equals(e.getSource())){
				deskView.amountCards.setText((deskView.amountOfCards[9].getText()));
				}
				else if (deskView.slot[10].equals(e.getSource())){
				deskView.amountCards.setText((deskView.amountOfCards[10].getText()));
				}
				else if (deskView.slot[11].equals(e.getSource())){
				deskView.amountCards.setText((deskView.amountOfCards[11].getText()));
				}			
		}
	}

	// spielzug passen Button Aktion
	class Passen implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (actionsEnabled() == true) {
				int countPassen = 0;
				for (int i = 0; i < 4; i++) {
					if (allPlayers[i].passed == true) {
						countPassen++;
					}
				}

				if (countPassen <= 1) {
					allPlayers[myId].setPassed(true);
					setNextPlayerActive();
				}

				else if (countPassen == 2) {
					clearTable();
					for (int i = 0; i < 4; i++) {
						allPlayers[i].passed = false;
					}
					setNextPlayerActive();
				}
				Client_neu.sendToServer(allPlayers);
				Client_neu.sendToServer(deck);
			} else {
			}
		}

	}

	// Auswahl spielen Button Aktion
	class AuswahlSpielen implements ActionListener {
		public void actionPerformed(ActionEvent e){

			if (actionsEnabled() == true){
			int anzahlKarten = get."Textfeld + parse.to int";
			ListIterator<Card> listIterator = allPlayers[myId].getCards().listIterator();
			while(listIterator.hasNext()){
				Card cardtype = listIterator.next();
				if(cardtype.getCardType().equals("vom AnzeigeKartentyp get Kartentyp")){
					for(int i =0; i<anzahlKarten;i++){
						//add it to currentTrick
						deck.currentTrick.push(cardtype);
						//remove it from the playercards arraylist
						listIterator.remove();
					}
				}

			//löschen der Inhalte von anzahl gespielten karten und Kartentyp
			
			
			
			//alle Spieler das "passen" zurücksetzen
			for(int i = 0; i<allPlayers.length;i++){
				allPlayers[i].setPassed(false);
			}

			
			//hat Spieler keine Karten mehr, wird Rang zugewiesen
			if(allPlayers[myId].getCards().isEmpty()){
				int anzahlRankVergaben = 1;
				for(int i = 0; i<allPlayers.length;i++){
					if(allPlayers[i].getRank() != 0){
						anzahlRankVergaben++;
					}
				}
				//es sind noch mindestens 2 Spieler im Spiel
				if (anzahlRankVergaben<=2){
					allPlayers[myId].setRank(anzahlRankVergaben);
					allPlayers[myId].setFinished(true);
					allPlayers[myId].setActive(false);
					getNextPlayerInOrder(allPlayers[myId]).setActive(true);
				}
				//beendet das ganze Spiel, da der 3. Spieler keine Karten mehr hat
				else{
					allPlayers[myId].setRank(anzahlRankVergaben);
					getNextPlayerInOrder(allPlayers[myId]).setRank(anzahlRankVergaben+1);
					finishRound();
				}
				
			}
			//hat Spieler noch Karten, wird nächster Player aktiv gesetzt resp. aktueller deaktiv
			else{
				allPlayers[myId].setActive(false);
				getNextPlayerInOrder(allPlayers[myId]).setActive(true);
			}
			Client_neu.sendToServer(deck);
			Client_neu.sendToServer(allPlayers);
			}
		}
			else{}
		}
	}


		/*
		 * GAME LOGIC - Methods for running the Game properly
		 */

		// create new player based on the login-variables
		// if there are 4 players deal cards
		protected void newPlayer(String name) {
			int NOfPlayers = 0;
			for (int i = 0; i < allPlayers.length; i++) {
				if (allPlayers[i] != null) {
					NOfPlayers++;
				}
			}
			Player player = new Player(name, NOfPlayers + 1,
					Role.values()[NOfPlayers]);
			myId = player.getId();
			allPlayers[myId - 1] = player; // cause IDs start from 1

			if (myId == 4) {
				shuffleCards();
				Client_neu.sendToServer(deck);
			}

			Client_neu.sendToServer(allPlayers);

		}

		// Karten mischen und auf Player verteilen
		void shuffleCards() {
			// shuffle notDealtCards
			Collections.shuffle(deck.notDealtCards);
			// create Iterator to get trough the LinkedList
			ListIterator<Card> iterator = deck.notDealtCards.listIterator();
			while (iterator.hasNext()) {
				for (int i = 0; i <= allPlayers.length; i++) {
					for (int j = 0; j <= deck.notDealtCards.size(); j++) {
						allPlayers[i].addCard(deck.notDealtCards.remove(j));
					}
				}
			}
		}

		// get next Player in Order -> relative to Role of given Player
		public Player getNextPlayerInOrder(Player player) {
			Player nextPlayerInOrder = null;
			int nextOrdinal = player.getRole().ordinal() + 1;
			
			for (int i = 0; i < allPlayers.length; i++) {
				if (nextOrdinal > Role.values().length - 1) {
					nextOrdinal = 0;
				}
				// get the Player which has the next Role in Order as the given
				// Player.
				// more specific: check ordinal-value of the Role and add 1.
				// Check list of all Players which player has the next Role in
				// Order.
				if (allPlayers[i].getRole().equals(Role.values()[nextOrdinal])) { 
					if(allPlayers[i].isFinished()==false){
						nextPlayerInOrder = allPlayers[i];
					} else{
						nextOrdinal++;
					}
				}
			}

			return nextPlayerInOrder;
		}

		void setNextPlayerActive() {
			allPlayers[myId].setActive(false);

			// set next player active
			getNextPlayerInOrder(allPlayers[myId]).setActive(true);
			actionsEnabled(); // to disable Buttons
		}

		// show all Players in proper position
		void showPlayers() {
			deskView.showInWest(getNextPlayerInOrder(allPlayers[myId]));
			deskView.showInNorth(getNextPlayerInOrder(getNextPlayerInOrder(allPlayers[myId])));
			deskView.showInEast(getNextPlayerInOrder(getNextPlayerInOrder(getNextPlayerInOrder(allPlayers[myId]))));
		}

		// show Cards in the center of deskView
		void showCurrentTrick() {
			ListIterator<Card> iterator = deck.currentTrick.listIterator();
			int NOfCards = 1; // count number of equal cards. default 1 because
								// you always card with the "same" type.
			// go through list
			while ((iterator.hasNext())
					&& (iterator.next().equals(iterator.previous()) || iterator
							.previous() == null)) {
				NOfCards++; //
			}
			deskView.showCurrentTrick(deck.currentTrick.peek().getCardType(),
					NOfCards);
		}

		// show my Cards in South. Check if they are playable.
		void showMyCards() {
			int[][] myCards = new int[12][2];
			ListIterator<Card> iterator = allPlayers[myId].getCards()
					.listIterator();
			while (iterator.hasNext()) {
				myCards[iterator.next().getCardType().getValue()][1]++;
			}

			iterator = deck.currentTrick.listIterator();
			int i = 1; // count number of equal cards. default 1 because you
						// always card with the "same" type.
			// go through list
			while (iterator.hasNext()) {
				// check if the cards are the same type
				if (iterator.next().equals(iterator.previous())) {
					i++; //
					// do you have enough cards to play?
					if (i == myCards[iterator.next().getCardType().getValue()][1]) {
						myCards[iterator.next().getCardType().getValue()][2] = 1;
					}

				} else {
					i = 1;
				} // set back to 0 if the cards are no longer the same type
			}

			deskView.showMyCards(myCards);

		}

		// check if it is the turn of my Player to enable Actions
		protected boolean actionsEnabled() {
			boolean actionsEnabled = false;
			if (allPlayers[myId].isActive() == true) {
				actionsEnabled = true;
				deskView.auswahlSpielen.setEnabled(true);
				deskView.passen.setEnabled(true);
			} else {
				deskView.auswahlSpielen.setEnabled(false);
				deskView.passen.setEnabled(false);
			}
			return actionsEnabled;
		}

		// returns an Array of swappable Cards-Types for a specific Player
		public Card.CARD_TYPE[] getSwappableCards(Player player) {

			// initialize List of Cards
			Card.CARD_TYPE[] swappableCards = new Card.CARD_TYPE[2];

			if (player.getRole().hasToBeHighest() == true) {

				for (int i = 0; i <= player.getRole().getNOfSwappableCards(); i++) {

					// initialize listIterator
					ListIterator<Card> listIterator = player.getCards()
							.listIterator();

					while (listIterator.hasNext()) {
						if (swappableCards[1].getValue() > listIterator.next()
								.getCardType().getValue()) {
							if (swappableCards[2].getValue() > listIterator
									.next().getCardType().getValue()) {
								swappableCards[2] = listIterator.next()
										.getCardType();
							} else {
								swappableCards[1] = listIterator.next()
										.getCardType();
							}
						}

					}
					// if two equal card types in array set one to null
					// -> if there is only one card type you have at least to of
					// them.
					if (swappableCards[1].equals(swappableCards[2])) {
						swappableCards[2] = null;
					}
				}

			}

			// return List of swappable Cards
			return swappableCards;
		}

		// clear table nachdem 3 Player gepasst haben
		protected void clearTable() {
			while (!deck.currentTrick.isEmpty()) { // not empty
				deck.notDealtCards.add(deck.currentTrick.pop());
			}
		}

		// Runde ist fertig, alle Rank's wurden verteilt
		private void finishRound() {
			for (int i = 0; i < allPlayers.length; i++) {
				allPlayers[i].setRole(allPlayers[i].getRank());
				allPlayers[i].setFinished(false);
				if (allPlayers[i].getRole().equals(Role.GROSSERDALMUTI)) {
					allPlayers[i].setActive(true);
				}
			}
			shuffleCards();
		}

		public int getMyId() {
			return myId;
		}

		public void setMyId(int myId) {
			this.myId = myId;
		}

		public Player[] getAllPlayers() {
			return allPlayers;
		}

		public void setAllPlayers(Player[] allPlayers) {
			this.allPlayers = allPlayers;
			showPlayers();
			showMyCards();
		}

		public Deck getDeck() {
			return deck;
		}

		public void setDeck(Deck deck) {
			this.deck = deck;
			if(!(deck.currentTrick==null)){
				showCurrentTrick();
			}
		}

	}

