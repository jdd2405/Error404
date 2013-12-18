package ch.fhnw.error404.DerGrosseDalmuti.client;

import java.util.Collections;
import java.util.Date;
import java.util.ListIterator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

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
		deskView.addSwapCards(new SwapCards());
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
			for(int i = 0; i <4;i++){
				allPlayers[i].setLeftGame(true);
			}
			Client.sendToServer(allPlayers);
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
					if(deskView.lblNumberOfCardsCenter.getText()!=null && deskView.lblNumberOfCardsCenter.getText()!=""){
						if(Integer.parseInt(deskView.lblAmountOfCards[i].getText())>=Integer.parseInt(deskView.lblNumberOfCardsCenter.getText())){
							deskView.txtAmountCards.setText((deskView.lblNumberOfCardsCenter.getText()));
						}
						else{
							System.out.println("Beim Drücken der Karte ist ein Fehler aufgetreten: Ungültige Anzahl Karten.");
						}
					}
					else{
						if(!allPlayers[myPos].hasSwappedCards() && Integer.parseInt(deskView.lblAmountOfCards[i].getText())>allPlayers[myPos].getRole().getNOfSwappableCards()){
							deskView.txtAmountCards.setText(Integer.toString(allPlayers[myPos].getRole().getNOfSwappableCards()));
						} else {
							deskView.txtAmountCards.setText((deskView.lblAmountOfCards[i].getText()));
						}
					}
				}
			}
		}
	}
	
	class SwapCards implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// Aktion nur ausführen, wenn eine Karte ausgewählt ist.
			if(deskView.txtTypeCards.getText()!="" && deskView.txtAmountCards.getText()!=""){
			
				int nOfSwappableCards = allPlayers[myPos].getRole().getNOfSwappableCards();
				System.out.println("Anzahl Karten zum Tauschen: "+allPlayers[myPos].getRole().getNOfSwappableCards());
				
				Player playerToSwapCards = getPlayerToSwapCards(allPlayers[myPos]);
				System.out.println("Karten mit diesem Spieler tauschen: "+playerToSwapCards.getName());
				
				int nOfSwappedCards = 0; // Anzahl bereits getauschter KArten
				for (int i = 0; i<deck.getSwappedCards()[playerToSwapCards.getRole().ordinal()].length; i++){
					if(deck.getSwappedCards()[playerToSwapCards.getRole().ordinal()][i]!=null){
						nOfSwappedCards++;
					}
				}
				System.out.println("Anzahl bereits getauschter Karten: "+nOfSwappedCards);
	
				
				int nOfCards = Integer.parseInt(deskView.txtAmountCards.getText());
				if(nOfCards > nOfSwappedCards){
					nOfCards = nOfSwappableCards-nOfSwappedCards;
				}
				System.out.println("Anzahl Karten ausgewählt: "+deskView.txtAmountCards.getText());
				
				// check if card has to be the highest
				if (allPlayers[myPos].getRole().hasToBeHighest()) {
					System.out.println("Muss die höchte Karte sein. "+highestCard(allPlayers[myPos]).getLabel());
					
					// check if chosen card is highest
					if(deskView.txtTypeCards.getText().equals(highestCard(allPlayers[myPos]).getLabel())){
						
						// go through list
						ListIterator<Card> iterator = allPlayers[myPos].getCards().listIterator(); 
						while(iterator.hasNext() && nOfCards!=0){
							System.out.println("In schlaufe....");
							Card card = iterator.next();
							// card found?
							if(card.getCardType().getLabel().equals(deskView.txtTypeCards.getText())){
								System.out.println("Treffer ;-)");
								deck.swappedCards[playerToSwapCards.getRole().ordinal()][nOfSwappedCards]=card;
								iterator.remove();
								nOfCards--;	
								nOfSwappedCards++;
							}
							if(nOfSwappedCards==nOfSwappableCards){
								System.out.println("Anzahl erreicht.");
								allPlayers[myPos].setHasSwappedCards(true);
								setNextPlayerActive();
							}
						}
					} else {
						System.out.println("Bitte wählen Sie die höchste Karte!");
					}
					
				} else {
					System.out.println("Muss nicht die höchte Karte sein.");
					ListIterator<Card> iterator = allPlayers[myPos].getCards().listIterator(); 
					while(iterator.hasNext() && nOfCards!=0){
						System.out.println("In schlaufe....");
						Card card = iterator.next();
						if(card.getCardType().getLabel().equals(deskView.txtTypeCards.getText())){
							System.out.println("Treffer ;-)");
							deck.swappedCards[playerToSwapCards.getRole().ordinal()][nOfSwappedCards]=card;
							iterator.remove();
							nOfCards--;	
							nOfSwappedCards++;
						}
						if(nOfSwappedCards==nOfSwappableCards){
							System.out.println("Anzahl erreicht.");
							allPlayers[myPos].setHasSwappedCards(true);
							setNextPlayerActive();
						}
					}
				}
				
				if(countHasSwapped()==allPlayers.length){
					swapCards();
				}
	
				
				Client.sendToServer(allPlayers);
				Client.sendToServer(deck);
			}
			
			else {
				deskView.popUp("Ungültige Karte", "Bitte wählen Sie eine Karte aus.");
			}
				
		}
		
		
		public Player getPlayerToSwapCards(Player player){
			Player playerToSwapCards = null;
			int ordinal = 3-player.getRole().ordinal(); // ordinal of your player plus odrinal of player to swap cards with is always 3!
			
			for(int i = 0; i <allPlayers.length; i++){
				if(allPlayers[i].getRole().ordinal()==ordinal){
					playerToSwapCards = allPlayers[i];
				}
			}
			return playerToSwapCards;
		}
		
		
		// returns an Array of swappable Cards-Types for a specific Player
		public Card.CARD_TYPE highestCard(Player player) {

			// initialize List of Cards
			Card.CARD_TYPE highestCard = player.getCards().get(1).getCardType();

			ListIterator<Card> iterator = player.getCards().listIterator();
			while(iterator.hasNext()){
				Card card = iterator.next();
				if(card.getCardType().ordinal()<highestCard.ordinal()){
					highestCard=card.getCardType();
				}
			}
			return highestCard;

		}
		
		
		int countHasSwapped(){
			int nOfHasSwapped = 0;
			for(int i=0; i<allPlayers.length; i++){
				if(allPlayers[i].hasSwappedCards()){
					nOfHasSwapped++;
				}
			}
			return nOfHasSwapped;
		}
		
		
		void swapCards(){
			for (int i = 0; i < deck.swappedCards.length; i++){
				for(int j = 0; j < deck.swappedCards[i].length; j++){
					if(deck.swappedCards[i][j]!=null){
						System.out.println(deck.swappedCards[i][j].getCardType().getLabel());
					}
				}
			}
			
			for(int i = 0; i < allPlayers.length; i++){
				for(int j = 0; j < deck.swappedCards[allPlayers[i].getRole().ordinal()].length; j++){
					if(deck.swappedCards[allPlayers[i].getRole().ordinal()][j]!=null){
						allPlayers[i].addCard(deck.swappedCards[allPlayers[i].getRole().ordinal()][j]);
						System.out.println(deck.swappedCards[allPlayers[i].getRole().ordinal()][j].getCardType().getLabel()+" "+allPlayers[i].getName()+" gegeben.");
						deck.swappedCards[allPlayers[i].getRole().ordinal()][j]=null;
					}
				}
			}
			
		}
	}

	// spielzug passen Button Aktion
	class Passen implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (enableActions() == true) {
				int countActivePlayer =0;
				int countPassen = 0;
				for (int l = 0; l <4; l++){
					if (allPlayers[l].hasFinished() != true){
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
				Client.sendToServer(allPlayers);
				Client.sendToServer(deck);
			} else {
			}
		}

	}

	// Auswahl spielen Button Aktion
	class AuswahlSpielen implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (enableActions() == true) {
				// int nOfCards = Integer.parseInt(deskView.txtAmountCards.getText());
				int nOfCards = 0;
				
				if(deskView.lblNumberOfCardsCenter.getText()!=null && deskView.lblNumberOfCardsCenter.getText()!=""){
					if(Integer.parseInt(deskView.txtAmountCards.getText())>=Integer.parseInt(deskView.lblNumberOfCardsCenter.getText())){
						nOfCards = Integer.parseInt(deskView.lblNumberOfCardsCenter.getText());
					}
					else{
						System.out.println("Ungültige Anzahl Karten.");
					}
				}
				else{
					nOfCards = Integer.parseInt(deskView.txtAmountCards.getText());
				}
				
				
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
					System.out.println("anzahlRankVergaben: "+anzahlRankVergaben);
					// es sind noch mindestens 2 Spieler im Spiel
					if (anzahlRankVergaben <= 2) {
						allPlayers[myPos].setRank(anzahlRankVergaben);
						allPlayers[myPos].setFinished(true);
						System.out.println("Habe fertig!");
						setNextPlayerActive(); 
					}
					// beendet das ganze Spiel, da der 3. Spieler keine Karten
					// mehr hat
					else {
						allPlayers[myPos].setRank(anzahlRankVergaben);	
						Player player = getNextPlayerInOrder(allPlayers[myPos]);
						
						while(!allPlayers[myPos].hasFinished()){
							if(player.hasFinished()){
								player = getNextPlayerInOrder(player);
							}
							else {
								player.setRank(anzahlRankVergaben + 1);
								player.setFinished(true);
								allPlayers[myPos].setFinished(true);
								System.out.println("Habe fertig und das Spiel ist aus.");
							}
						}
							
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

			Client.sendToServer(allPlayers);
			Client.sendToServer(deck);
		}
	}

		/*
		 * GAME LOGIC - Methods for running the Game properly
		 */

		// create new player based on the login-variables
		// if there are 4 players deal cards
		protected void newPlayer(String name) {

			System.out.println("Anzahl Spieler: "+countPlayers());
			Player player = new Player(name, countPlayers() + 1, Role.values()[countPlayers()]);
			myId = player.getId();
			myPos = myId-1;
			System.out.println("ID meines Spielers: "+player.getId());
			allPlayers[myPos] = player; // cause IDs start from 1
			System.out.println("Name meines Spielers: "+allPlayers[myPos].getName());

			
			deskView.showInSouth(player);
			
			if (countPlayers() == 4) {
				shuffleCards();
				allPlayers[0].setActive(true);
			}
			
			System.out.println("Spielerliste an Server senden...");
			Client.sendToServer(allPlayers);
			
			
		}
		
		
		
		// counts number of Players in allPlayers-Array
		int countPlayers(){
			int nOfPlayers = 0;
			for(int i=0; i<allPlayers.length;i++){
				if(allPlayers[i]!=null){
					nOfPlayers++;
				}
			}
			return nOfPlayers;
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
			Client.sendToServer(deck);
			
		}

		// get next Player in Order -> relative to Role of given Player
		public Player getNextPlayerInOrder(Player player) {
			Player nextPlayerInOrder = null;
			int nextOrdinal = (player.getRole().ordinal()+1)%(Role.values().length);
			System.out.println("Ordinalzahl: "+nextOrdinal);
			
			for (int i = 0; i < allPlayers.length; i++) {
				if (allPlayers[i].getRole().equals(Role.values()[nextOrdinal])) { 
					nextPlayerInOrder = allPlayers[i];	
					break;
				}
			}

			return nextPlayerInOrder;
		}
		


		void setNextPlayerActive() {
			Player player = getNextPlayerInOrder(allPlayers[myPos]);
			while(allPlayers[myPos].isActive()==true){
				if(player.hasFinished()){
					player = getNextPlayerInOrder(player);
				}
				else{
					allPlayers[myPos].setActive(false);
					player.setActive(true);
				}
			}
				
			enableActions(); // to disable Buttons
		}

		// show all Players in proper position
		void showPlayers() {
			if(countPlayers()==4){
				deskView.showInSouth(allPlayers[myPos]);
				System.out.println("Im Westen: "+getNextPlayerInOrder(allPlayers[myPos]).getName());deskView.showInWest(getNextPlayerInOrder(allPlayers[myPos]));
				System.out.println("Im Norden: "+getNextPlayerInOrder(getNextPlayerInOrder(allPlayers[myPos])).getName());deskView.showInNorth(getNextPlayerInOrder(getNextPlayerInOrder(allPlayers[myPos])));
				System.out.println("Im Osten: "+getNextPlayerInOrder(getNextPlayerInOrder(getNextPlayerInOrder(allPlayers[myPos]))).getName());deskView.showInEast(getNextPlayerInOrder(getNextPlayerInOrder(getNextPlayerInOrder(allPlayers[myPos]))));
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
			else {
				deskView.showCurrentTrick();
			}
			
		}

		// show my Cards in South. Check if they are playable.
		void showMyCards() {
			if(countPlayers()==4){
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
		protected boolean enableActions() {
			
			deskView.showButtons(allPlayers[myPos].hasSwappedCards());
			
			boolean actionsEnabled = false;
			if (allPlayers[myPos].isActive() == true) {
				actionsEnabled = true;
				if(allPlayers[myPos].hasSwappedCards()!=true){
					deskView.btnSwapCards.setEnabled(true);
				}
				else{
					deskView.btnSwapCards.setEnabled(false);
					deskView.btnAuswahlSpielen.setEnabled(true);
					deskView.btnPassen.setEnabled(true);
				}
			} else {
				deskView.btnSwapCards.setEnabled(false);
				deskView.btnAuswahlSpielen.setEnabled(false);
				deskView.btnPassen.setEnabled(false);
			}
			
			System.out.println("Ich bin dran: "+actionsEnabled);
			return actionsEnabled;
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
			clearTable();
			for (int i = 0; i < allPlayers.length; i++) {
				// Lege alle noch nicht gespielte Karten auf den Stapel.
				if(!allPlayers[i].getCards().isEmpty()){
					ListIterator<Card> iterator = allPlayers[i].getCards().listIterator();
					while(iterator.hasNext()){
						deck.notDealtCards.add(iterator.next());
					}
				}
				allPlayers[i].setRole(Role.values()[allPlayers[i].getRank()-1]);
				System.out.println(allPlayers[i].getName()+" hat die Rolle "+allPlayers[i].getRole().getLabel()+" erhalten.");
				allPlayers[i].setFinished(false);
				allPlayers[i].setHasSwappedCards(false);
				allPlayers[i].setRank(0);
				if (allPlayers[i].getRole().equals(Role.GROSSERDALMUTI)) {
					allPlayers[i].setActive(true);
				}
			}
			shuffleCards();
		}
		
		
		//hat ein Spieler das Spiel verlassen?
	public void leftGame() {
		if (allPlayers[0].getLeftGame() == true) {
			deskView.popUpForExit("Spiel beendet.",
					"Spiel wurde von einem der Spieler verlassen.");
			deskView.closeWindow();

			try {
				Client.in.close();
				Client.out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

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
			enableActions(); System.out.println("Zeige meine Buttons.");
			leftGame();


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

