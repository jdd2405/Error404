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
	static Socket socket = null;
	static Thread inputThread;




	public static void main(String[] args) {
		Client client = new Client();
		LoginView loginView = new LoginView();
		DeskView deskView = new DeskView();
		action = new Action(loginView, deskView);
		client.clientSocket();
		

	}

	private void clientSocket() {

		

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

		inputThread = new Thread(new InputMessages());
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
		boolean whileSchlaufe = true;
		
		@SuppressWarnings("static-access")
		public void run() {
			try {
				while (whileSchlaufe == true) {
					object = in.readObject();
					//input ist Arrayliste mit den Playerobjekten

					if (object instanceof Player[]) {
						action.setAllPlayers((Player[]) object);
						if (action.allPlayers[0] != null && action.allPlayers[0].getLeftGame()==true) {
							whileSchlaufe = false;
							socket.close();
							try {
								inputThread.sleep(5000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							System.exit(0);
						}
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
