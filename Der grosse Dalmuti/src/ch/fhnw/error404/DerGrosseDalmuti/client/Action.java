package ch.fhnw.error404.DerGrosseDalmuti.client;

import java.util.Collections;
import java.util.Date;
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
	protected int myPos;
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

				deskView.mainFrame.setVisible(true);


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
			String[] kartname = new String[12];
			kartname[0] = "Dalmuti";
			kartname[1] = "Erzbischof";
			kartname[2] = "Hofmarschall";
			kartname[3] = "Baronin";
			kartname[4] = "Äbtissin";
			kartname[5] = "Ritter";
			kartname[6] = "Näherin";
			kartname[7] = "Steinmetz";
			kartname[8] = "Köchin";
			kartname[9] = "Schafhirtin";
			kartname[10] = "Bergmann";
			kartname[11] = "Tagelöhner";
			
			for(int i=0; i<12; i++){
				if (deskView.btnSlot[i].equals(e.getSource())){
					deskView.txtTypeCards.setText(kartname[i]);		
				}
			}
			
			for(int i=0; i<12; i++){
				if (e.getSource()!=null && deskView.btnSlot[i].equals(e.getSource())){
					deskView.txtAmountCards.setText((deskView.lblAmountOfCards[i].getText()));		
				}
			}
		}
	}

	// spielzug passen Button Aktion
	class Passen implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (actionsEnabled() == true) {
				int countActivePlayer =0;
				int countPassen = 0;
				for (int l = 0; l <4; l++){
					if (allPlayers[l].isFinished() != true){
						countActivePlayer++;
						if (allPlayers[l].passed == true) {
							countPassen++;
						}
					}
				}

				if (countActivePlayer-2 > countPassen) {
					allPlayers[myPos].setPassed(true);
					setNextPlayerActive();
				}

				else if (countActivePlayer-1 > countPassen) {
					clearTable(); System.out.println("Karten vom Tisch genommen.");
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
		public void actionPerformed(ActionEvent e) {

			if (actionsEnabled() == true) {
				int nOfCards = Integer.parseInt(deskView.txtAmountCards
						.getText());
				ListIterator<Card> listIterator = allPlayers[myPos].getCards()
						.listIterator();
				int i = 0;
				while (listIterator.hasNext() && i < nOfCards) {
					Card card = listIterator.next();
					if (card.getCardType().getLabel()
							.equals(deskView.txtTypeCards.getText())) {
						deck.currentTrick.push(card);
						System.out.println(card.getCardType().getLabel()
								+ " auf den Tisch gelegt");
						i++;
						listIterator.remove();
					}
				}
				System.out.println("Anzahl gelegter Karten: " + i);

				// löschen der Inhalte von anzahl gespielten karten und
				// Kartentyp
				deskView.txtAmountCards.setText("");
				deskView.txtTypeCards.setText("");

				// alle Spieler das "passen" zurücksetzen
				for (int j = 0; j < allPlayers.length; j++) {
					allPlayers[j].setPassed(false);
				}

				// hat Spieler keine Karten mehr, wird Rang zugewiesen
				if (allPlayers[myPos].getCards().isEmpty()) {
					int anzahlRankVergaben = 1;
					for (int k = 0; k < allPlayers.length; k++) {
						if (allPlayers[k].getRank() != 0) {
							anzahlRankVergaben++;
						}
					}
					// es sind noch mindestens 2 Spieler im Spiel
					if (anzahlRankVergaben <= 2) {
						allPlayers[myPos].setRank(anzahlRankVergaben);
						allPlayers[myPos].setFinished(true);
						setNextPlayerActive(); // <-- Does not happen here!!!
												// Check why.
					}
					// beendet das ganze Spiel, da der 3. Spieler keine Karten
					// mehr hat
					else {
						allPlayers[myPos].setRank(anzahlRankVergaben);
						getNextPlayerInOrder(allPlayers[myPos]).setRank(
								anzahlRankVergaben + 1);
						finishRound();
					}
				}
				// hat Spieler noch Karten, wird nächster Player aktiv
				// gesetzt
				// resp. aktueller deaktiv

				else {
					setNextPlayerActive();
				}
			}

			Client_neu.sendToServer(allPlayers);
			Client_neu.sendToServer(deck);
		}
	}

		/*
		 * GAME LOGIC - Methods for running the Game properly
		 */

		// create new player based on the login-variables
		// if there are 4 players deal cards
		protected void newPlayer(String name) {
			int NOfPlayers = 0;

			for (int i = 0; allPlayers[i]!=null; i++) {
				NOfPlayers++;

			}
			System.out.println("Anzahl Spieler: "+NOfPlayers);
			Player player = new Player(name, NOfPlayers + 1, Role.values()[NOfPlayers]);
			myId = player.getId();
			myPos = myId-1;
			System.out.println("ID meines Spielers: "+player.getId());
			allPlayers[myPos] = player; // cause IDs start from 1
			System.out.println("Name meines Spielers: "+allPlayers[myPos].getName());

			
			deskView.showInSouth(player);
			
			if (myId == 4) {
				shuffleCards();
				allPlayers[0].setActive(true);
			}
			
			System.out.println("Spielerliste an Server senden...");
			Client_neu.sendToServer(allPlayers);
			
			
		}

		// Karten mischen und auf Player verteilen
		void shuffleCards() {
			
			Collections.shuffle(deck.notDealtCards); // shuffle notDealtCards	
			ListIterator<Card> iterator = deck.notDealtCards.listIterator(); // creates Iterator to get trough the LinkedList
			
			int i = 0;
			int j = 0;
			
			while (iterator.hasNext()) {
				allPlayers[i].addCard(iterator.next());
				j++;
				System.out.println("Spieler "+allPlayers[i].getName()+" hat eine Karte erhalten. Ausgeteilt:" + j +" von 78"); // debug
				i = (i+1)%(allPlayers.length);  //alle Player durch -> von Vorne beginnen
			}
			
			deck.notDealtCards.clear();
			System.out.println("Deck an Server senden...");
			Client_neu.sendToServer(deck);
			
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
			allPlayers[myPos].setActive(false);

			// set next player active
			getNextPlayerInOrder(allPlayers[myPos]).setActive(true);
			actionsEnabled(); // to disable Buttons
		}

		// show all Players in proper position
		void showPlayers() {
			if(allPlayers[3]!=null){
				deskView.showInWest(getNextPlayerInOrder(allPlayers[myPos]));
				deskView.showInNorth(getNextPlayerInOrder(getNextPlayerInOrder(allPlayers[myPos])));
				deskView.showInEast(getNextPlayerInOrder(getNextPlayerInOrder(getNextPlayerInOrder(allPlayers[myPos]))));
			}
		}

		// show Cards in the center of deskView
		void showCurrentTrick() {
			if(!deck.currentTrick.isEmpty()){
				int nOfCards = 0;
				Card cardOnTop = deck.currentTrick.peek();
				ListIterator<Card> iterator = deck.currentTrick.listIterator();
				while(iterator.hasNext()){
					if(cardOnTop.getCardType().equals(iterator.next().getCardType())){
						nOfCards++;
					}
				}
				System.out.println("Auf dem Tisch: "+nOfCards);
				deskView.showCurrentTrick(cardOnTop.getCardType(), nOfCards);
			}
		}

		// show my Cards in South. Check if they are playable.
		void showMyCards() {
			if(allPlayers[3]!=null){
				int[][] myCards = new int[12][2];
				
				ListIterator<Card> iterator = allPlayers[myPos].getCards().listIterator();
				while (iterator.hasNext()) {
					myCards[iterator.next().getCardType().ordinal()][0]++;
				}
				
				if(deck.currentTrick.isEmpty()){
					System.out.println("currentTrick isEmpty? "+ deck.currentTrick.isEmpty());
					// when currentTrick is empty every card is playable
					ListIterator<Card> iterator2 = allPlayers[myPos].getCards().listIterator();
					while (iterator2.hasNext()) {
						myCards[iterator2.next().getCardType().ordinal()][1]=1; // set playable to 1
					}							
				}
				
				else {
					Card cardOnTop = deck.currentTrick.peek();
					int nOfCards = 0;
					ListIterator<Card> iterator3 = deck.currentTrick.listIterator();	
					// go through list
					while (iterator3.hasNext()) {
						// check if the cards are the same type
						if (cardOnTop.getCardType().equals(iterator3.next().getCardType())) {
							nOfCards++; //count number of equal cards. 
						}
					}
					// do you have enough cards to play?
					for(int i = 0; i<12; i++){
						if (nOfCards <= myCards[i][0]) {
							if(i<cardOnTop.getCardType().ordinal()){
								myCards[i][1] = 1;
							}
							else {
								myCards[i][1] = 0;
							}
						}
						else {
							myCards[i][1] = 0;
						}
					}
				}
				
				deskView.showMyCards(myCards);
				
			}
			

		}

		// check if it is the turn of my Player to enable Actions
		protected boolean actionsEnabled() {
			boolean actionsEnabled = false;
			if (allPlayers[myPos].isActive() == true) {
				actionsEnabled = true;
				deskView.btnAuswahlSpielen.setEnabled(true);
				deskView.btnPassen.setEnabled(true);
			} else {
				deskView.btnAuswahlSpielen.setEnabled(false);
				deskView.btnPassen.setEnabled(false);
			}
			System.out.println("Ich bin dran: "+actionsEnabled);
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
				System.out.println("Eine Karte vom Tisch weggenommen.");
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
			this.allPlayers = allPlayers; System.out.println("Spielerliste vom Server erhalten. "+ new Date());
			showPlayers(); System.out.println("Zeige alle Spieler.");
			showMyCards(); System.out.println("Zeige meine Karten.");
			actionsEnabled(); 
		}

		public Deck getDeck() {
			return deck;
		}

		public void setDeck(Deck deck) {
			this.deck = deck; System.out.println("Deck vom Server erhalten. "+ new Date());
			showCurrentTrick(); System.out.println("Zeige gelegte Karten.");
			showMyCards(); System.out.println("Zeige meine Karten.");
		}

	}

