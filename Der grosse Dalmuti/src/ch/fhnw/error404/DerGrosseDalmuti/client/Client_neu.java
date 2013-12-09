package ch.fhnw.error404.DerGrosseDalmuti.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import ch.fhnw.error404.DerGrosseDalmuti.shared.*;

public class Client_neu {

	static ObjectInputStream in;
	static ObjectOutputStream out;
	static Action action;




	public static void main(String[] args) {
		Client_neu client = new Client_neu();
		LoginView loginView = new LoginView();
		DeskView deskView = new DeskView();
		action = new Action(loginView, deskView);
		client.clientSocket();
		

	}

	private void clientSocket() {

		Socket socket = null;

		try {

			// create socket
			socket = new Socket("127.0.0.1", 5000);
			System.out.println("Zum Server verbunden: " + socket.isConnected());
			// create outputStream for objects
			OutputStream os = socket.getOutputStream();
			out = new ObjectOutputStream(os);

			// create inputStream for objects
			InputStream is = socket.getInputStream();
			in = new ObjectInputStream(is);

		} catch (Exception e) {
			e.printStackTrace();
		}

		Thread inputThread = new Thread(new InputMessages());
		inputThread.start();

	}
	
	//OutputMethode zum Server
	public static void sendToServer(Object object){
		try {
			out.writeObject(object);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public class InputMessages implements Runnable {
		public void run() {
			Object object;

			try {
				while (true) {
					object = in.readObject();
					//input ist Arrayliste mit den Playerobjekten

					if (object instanceof Player[]) {
						action.setAllPlayers((Player[]) object);
						System.out.println("Folgende Spieler vom Server erhalten: ");
						for (int i = 0; i < 4; i++) {
							if(action.allPlayers[i]!=null){System.out.println(action.allPlayers[i].getName());}
						}
						
					}
					//input für die 3 Variablen im Deck
					if (object instanceof Deck) {
						action.setDeck((Deck) object);
						System.out.println("Deck vom Server erhalten.");
						
					}
					/*
					if (message instanceof ArrayList) {
						deck.notDealtCards = (ArrayList<Card>) message;
						System.out.println(deck.notDealtCards.size());
					}
					if (message instanceof Card[]) {
						deck.swappedCards = (Card[]) message;
						System.out.println(deck.notDealtCards.size());
					}
					
					else {
						System.out.println("keine Player bisher");
					}
					*/
					
				}
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
		}

	}

}
