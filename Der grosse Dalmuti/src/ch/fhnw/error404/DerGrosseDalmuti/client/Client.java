package ch.fhnw.error404.DerGrosseDalmuti.client;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import ch.fhnw.error404.DerGrosseDalmuti.shared.*;

/* TO DO's
 * - Thread for checking for updates.
 * - Check Model Type with typeOf() (od so...)
 * - Update (replace) Model Object
 */


public class Client {
	
	
	public static void main(String[] args) {
		Client client = new Client();
		client.clientSocket();
		
		LoginView lw = new LoginView();

	}

	
	private void clientSocket() {

		String host = "127.0.0.1";
		int port = 5000;
		Object object = new Player("Jonas");
		

		Socket socket = null;

		try {

			// create socket
			socket = new Socket(host, port);
			System.out.println("Zum Server verbunden: " + socket.isConnected());

			// create outputStream for objects
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);

			// write object to outputStream
			oos.writeObject(object);
			oos.flush();

			// create inputStream for objects
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);

			// read object from inputStream
			Object objFromServer = ois.readObject();

			// check type of Object
				if (objFromServer instanceof Player){
					// Do something with Player Object
					Player player = (Player)objFromServer;
					System.out.println(player.getName() +" has rank: "+ player.getRank());
				}
				if (objFromServer instanceof Deck){
					// Do something with Player Object
					// Deck deck = (Deck)objFromServer; 				
				}

			// clean up
			oos.close();
			ois.close();
		}

		catch (Exception e) {
			e.printStackTrace();

		}

	}
}
