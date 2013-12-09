package ch.fhnw.error404.DerGrosseDalmuti.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

import ch.fhnw.error404.DerGrosseDalmuti.shared.*;

public class Server_neu{

	// speichert die outputstreams der clients / Vector ist ein dynamisches
	// Array
	private Vector<ObjectOutputStream> clientManager = new Vector<ObjectOutputStream>();
	static Deck deck = new Deck();
	static Player[] allPlayers;

	public static void main(String[] args) {
		Server_neu serverObject = new Server_neu();
		serverObject.startServer();
		
	}

	public void startServer() {
		try {
			ServerSocket server = new ServerSocket(5000);
			System.out.println("Server ist gestartet");
			
			Iterator<Card> iterator = deck.notDealtCards.iterator();
			System.out.println("Folgende Karten wurden notDealtCards hinzugefügt:");
			while(iterator.hasNext()){
				System.out.println(iterator.next().getCardType().getLabel());
			}
			
			while (true) {
				Socket client = server.accept();
				ObjectOutputStream output = new ObjectOutputStream(
						client.getOutputStream());
				clientManager.add(output);
				output.writeObject(allPlayers);
				output.writeObject(deck);
				
				output.flush();
				Thread t = new Thread(new ChatThread(client));
				t.start();
				System.out.println("habe eine Verbindung");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public class ChatThread implements Runnable {
		private Socket client;
		private int clientPort;
		private ObjectInputStream input;
		Object object;

		public ChatThread(Socket client) {
			this.client = client;
			clientPort = client.getPort();
			try {
				input = new ObjectInputStream(client.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void run() {

			try {
				object = input.readObject();
				System.out.println(object.toString());
				//if (object.isEmpty() != true) {
					//for (int i = 0; i < 4; i++) {
						//System.out.println(object.get(i));
					//}
					
					if (object instanceof Player[]) {
						allPlayers = (Player[]) object;
						System.out.println("allPlayers-Array erhalten von Client");
					}
					if (object instanceof Deck) {
						deck = (Deck) object;
						System.out.println("Deck von Client erhalten");
					}
					
					sendToAllClients(object);
					
				//}
					
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}

			// in.close();
			// out.close();
		}

		private void sendToAllClients(Object message2) {
			synchronized (clientManager) {
				for (ObjectOutputStream output : clientManager) {
					try {
						output.writeObject(message2);
						output.flush();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
