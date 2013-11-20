package ch.fhnw.error404.DerGrosseDalmuti.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/* TO DO's
 * - Thread for checking for updates.
 * - Check Model Type with typeOf() (od so...)
 * - Update (replace) Model Object
 */

public class Client_neu {
	Integer test = new Integer(568);
	ObjectInputStream in;

	public static void main(String[] args) {
		Client_neu client = new Client_neu();
		client.clientSocket();

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

			// write object to outputStream
			out.writeObject(test);
			out.flush();

			// create inputStream for objects
			InputStream is = socket.getInputStream();
			in = new ObjectInputStream(is);
		}
		catch (Exception e) {
			e.printStackTrace();}
		
		Thread inputThread = new Thread (new InputMessages());
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
	
	public class InputMessages implements Runnable {
		public void run(){
			Object message = null;

				try {
					while((message = in.readObject()) != null){
					System.out.println(message);}
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();}
		}
		
	}

}

