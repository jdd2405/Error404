package ch.fhnw.error404.DerGrosseDalmuti.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

import ch.fhnw.error404.DerGrosseDalmuti.client.Action;

import java.util.ArrayList;

import ch.fhnw.error404.DerGrosseDalmuti.shared.*;

/* TO DO's
 * - Thread for checking for updates.
 * - Check Model Type with typeOf() (od so...)
 * - Update (replace) Model Object
 */

public class Client_neu implements Runnable {
	
	ArrayList <Player> clientlist = new ArrayList <Player>(4);
	Player playertest = new Player("thesi", 5);
	

	
	ObjectInputStream in;

	public static void main(String[] args) {
		
	
		//Client_neu client = new Client_neu();
		//client.clientSocket();
		
		
		new LoginView();
		
		
		

		// LoginView lw = new LoginView();

	}

	private void clientSocket() {

		Socket socket = null;

		try {

			// create socket
			socket = new Socket("127.0.0.1", 5000);
			System.out.println("Zum Server verbunden: " + socket.isConnected());
			// create outputStream for objects
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(os);
			clientlist.add(0, playertest);

			// write object to outputStream
			out.writeObject(clientlist);
			out.flush();

			// create inputStream for objects
			InputStream is = socket.getInputStream();
			in = new ObjectInputStream(is);
		}
		catch (Exception e) {
			e.printStackTrace();}
		
		Thread inputThread = new Thread ();
		inputThread.start();

		// read object from inputStream
		// Object objFromServer = in.readObject();
		// String ausgabe = objFromServer.toString();

		// check type of Object
		// if (objFromServer instanceof Integer){
		// Do something with Player Object
		// int player = (int)objFromServer;
		// System.out.println("test: " + player);
		// }

	}
	
		public void run(){
			Object message;

				try {
					while((message =  in.readObject()) != null){
						for(int i =0; i<4;i++){
						clientlist.add(i, (Player) message);
						}
					}
					Iterator<Player>iter =clientlist.iterator();
					while(iter.hasNext()){
						System.out.println(iter.next().getName());}

					//System.out.println(clientlist);}
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();}
		}

}

