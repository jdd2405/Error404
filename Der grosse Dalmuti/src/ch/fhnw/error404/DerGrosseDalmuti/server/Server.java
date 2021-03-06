package ch.fhnw.error404.DerGrosseDalmuti.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

import ch.fhnw.error404.DerGrosseDalmuti.shared.*;

public class Server{

	// speichert die outputstreams der clients / Vector ist ein dynamisches
	// Array
	private Vector <ObjectOutputStream> clientManager = new Vector <ObjectOutputStream>();
	static Deck deck = new Deck();
	static Player[] allPlayers;

	public static void main(String[] args) {
		Server serverObject = new Server();
		serverObject.startServer();
		
	}

	public void startServer() {
		try {
			@SuppressWarnings("resource")
			ServerSocket server = new ServerSocket(4000);
			System.out.println("Server ist gestartet");
			
			Iterator<Card> iterator = deck.notDealtCards.iterator();
			System.out.println("Folgende Karten wurden notDealtCards hinzugefügt:");
			while(iterator.hasNext()){
				System.out.println(iterator.next().getCardType().getLabel());
			}
			int anzahlAktivePlayer =0;
			while (anzahlAktivePlayer <4) {
				Socket client = server.accept();
				ObjectOutputStream output = new ObjectOutputStream(
						client.getOutputStream());
				clientManager.add(output);
				anzahlAktivePlayer++;
				
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
		@SuppressWarnings("unused")
		private Socket client;
		@SuppressWarnings("unused")
		private int clientPort;
		private ObjectInputStream input;
		Object object;
		int anzahlIfAufruf=0;
		boolean whileSchlaufe = true;

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
				while (whileSchlaufe == true) {
					object = input.readObject();
					System.out.println(object.toString());

					if (object instanceof Player[]) {
						allPlayers = (Player[]) object;
						System.out.println("Spielerliste vom Client erhalten. "+ new Date());
						

							if (allPlayers[0].getLeftGame()==true) {
								anzahlIfAufruf++;
								if (anzahlIfAufruf == 1) {
									System.out.println("client ist aus dem Spiel");
									sendToAllClients(object);
									Iterator<ObjectOutputStream> iterator = clientManager.iterator();
									while (iterator.hasNext()) {
										iterator.next().close();
										whileSchlaufe = false;
										System.exit(0);
									}

								}
							}

						if(anzahlIfAufruf ==0) {
								sendToAllClients(object);
						}
					
					
					} else if (object instanceof Deck) {
						deck = (Deck) object;
						System.out.println("Deck von Client erhalten. "
								+ new Date());
						sendToAllClients(object);
					}

				}
				
					
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			catch (IOException e){
				e.printStackTrace();
			}
		}

		private void sendToAllClients(Object message2) {
			synchronized (clientManager) {
				for (ObjectOutputStream output : clientManager) {
					try {
						output.writeObject(message2);
						output.flush();
						System.out.println("Objekt an Clients gesendet. "+ new Date());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
