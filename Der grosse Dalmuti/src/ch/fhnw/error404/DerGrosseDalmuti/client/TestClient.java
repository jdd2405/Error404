package ch.fhnw.error404.DerGrosseDalmuti.client;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

import ch.fhnw.error404.DerGrosseDalmuti.shared.*;

/* TO DO's
 * - Thread for checking for updates.
 * - Check Model Type with typeOf() (od so...)
 * - Update (replace) Model Object
 */


public class Client {

	public static ArrayList<Player> allPlayers;;
	public static Deck deck;;



	// Have a look at http://www.leepoint.net/notes-java/GUI/structure/40mvc.html
	//... Create model, view, and controller.  They are
	//    created once here and passed to the parts that
	//    need them so there is only one copy of each.
	public static void main(String[] args) {

		Client client = new Client();
		client.clientSocket();
		
		System.out.println(Card.CARD_TYPE.AEBTISSIN.getValue());

		TestLoginView      loginView       = new TestLoginView();
		TestDeskView deskView = new TestDeskView();
		TestAction actionController = new TestAction(deskView);

		loginView.setVisible(true);
	}

	
	public Client(){
		
		// For testing purpose
		allPlayers = new ArrayList<Player>();
		allPlayers.add(new Player("Thomas", 1));
		allPlayers.add(new Player("Theresa", 2));
		allPlayers.add(new Player("Elias", 3));
		
		//deck = new Deck();
	}


	

	private void clientSocket() {

		String host = "127.0.0.1";
		int port = 5000;


		Socket socket = null;

		try {

			// create socket
			socket = new Socket(host, port);
			System.out.println("Zum Server verbunden: " + socket.isConnected());

			// create outputStream for objects
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);

			// write object to outputStream
			oos.writeObject(allPlayers);
			oos.flush();

			// create inputStream for objects
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);

			// read object from inputStream
			Object objFromServer = ois.readObject();

			// check type of Object
			if (objFromServer instanceof Player){
				// Do something with ArrayList Object
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
