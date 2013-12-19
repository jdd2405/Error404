package ch.fhnw.error404.DerGrosseDalmuti.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.*;

import ch.fhnw.error404.DerGrosseDalmuti.shared.*;

public class Client {

	static ObjectInputStream in;
	static ObjectOutputStream out;
	static Action action;




	public static void main(String[] args) {
		Client client = new Client();
		LoginView loginView = new LoginView();
		DeskView deskView = new DeskView();
		action = new Action(loginView, deskView);
		client.clientSocket();
		

	}

	private void clientSocket() {

		Socket socket = null;

		try {

			// create socket
			socket = new Socket("127.0.0.1", 4000);
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
			out.flush();
			System.out.println("Objekt an Server gesendet. "+ new Date());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public class InputMessages implements Runnable {
		Object object;
		
		public void run() {
			try {
				while (true) {
					object = in.readObject();
					//input ist Arrayliste mit den Playerobjekten

					if (object instanceof Player[]) {
						action.setAllPlayers((Player[]) object);
					}
					//input für die 3 Variablen im Deck
					else if (object instanceof Deck) {
						action.setDeck((Deck) object);
						System.out.println("Deck vom Server erhalten. "+ new Date());
						
					}					
				}
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
