package ch.fhnw.error404.DerGrosseDalmuti.client;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JTextField;

import ch.fhnw.error404.DerGrosseDalmuti.shared.*;

/* TO DO's
 * - Thread for checking for updates.
 * - Check Model Type with typeOf() (od so...)
 * - Update (replace) Model Object
 */


public class Client {
	
	Object object;
	
	public static void main(String[] args) {

		int[][] test = new int[12] [2];		
		test[0][1]= 1;
		test[0][0]= 5;
		test[1][0]= 3;
		test[1][1]= 1;
		test[2][1]= 1;
		test[2][0]= 5;
		test[3][0]= 3;
		test[3][1]= 1;
		test[4][1]= 1;
		test[4][0]= 5;
		test[5][0]= 3;
		test[5][1]= 1;
		test[6][1]= 1;
		test[6][0]= 5;
		test[7][0]= 3;
		test[7][1]= 1;
		test[8][1]= 1;
		test[8][0]= 5;
		test[9][0]= 3;
		test[9][1]= 1;
		test[10][1]= 1;
		test[10][0]= 5;
		test[11][0]= 5;
		test[11][1]= 1;
		
		LoginView loginView = new LoginView();
		DeskView deskView = new DeskView();
		deskView.showMyCards(test);
		new Action(loginView, deskView);
		
		
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
			oos.writeObject(object);
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
