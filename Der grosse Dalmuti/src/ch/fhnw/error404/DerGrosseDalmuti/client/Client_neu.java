package ch.fhnw.error404.DerGrosseDalmuti.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

import ch.fhnw.error404.DerGrosseDalmuti.shared.*;

public class Client_neu {

	ObjectInputStream in;
	ObjectOutputStream out;
	private Player [] clientlist = new Player [4];



	public static void main(String[] args) {
		Client_neu client = new Client_neu();
		//LoginView loginView = new LoginView();
		//Action action = new Action(loginView);
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
			
			Outputmethod(Action.allPlayers);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		Thread inputThread = new Thread(new InputMessages());
		inputThread.start();

	}
	
	//OutputMethode zum Server
	public void Outputmethod(Object object){
		try {
			out.writeObject(object);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	


	

	public class InputMessages implements Runnable {
		public void run() {
			Object message;

			try {
				while (true) {
					message = in.readObject();
					//input ist Arrayliste mit den Playerobjekten
					if (message instanceof Player[]) {
						Action.allPlayers = (Player[]) message;;
							for (int i = 0; i < 4; i++) {
								System.out.println(Action.allPlayers[i]);
							}
					}
					//if (message instanceof Deck) {
						//Deck serverDeck = new Deck(message);
						

					//}
					else {
						System.out.println("keine Player bisher");
					}
					;
				}
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
		}

	}

}
