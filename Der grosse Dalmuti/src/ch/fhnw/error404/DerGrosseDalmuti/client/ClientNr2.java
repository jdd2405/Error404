package ch.fhnw.error404.DerGrosseDalmuti.client;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import ch.fhnw.error404.DerGrosseDalmuti.shared.*;

public class ClientNr2 {
	public static void main(String[] args) {
		ClientNr2 client2 = new ClientNr2();
		client2.clientSocket();
	}

	private void clientSocket() {

		String host = "127.0.0.1";
		int port = 5000;
		Player thesi = new Player("Thomas"); // There is a diference.

		Socket socket = null;

		try {

			// create socket
			socket = new Socket(host, port);
			System.out.println("Connectet to server: " + socket.isConnected());

			// create outputStream for objects
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);

			// write object to outputStream
			oos.writeObject(thesi);
			oos.flush();

			// create inputStream for objects
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);

			// read object from inputStream
			Object object2 = ois.readObject();

			// do something with object
			Player anotherPlayer = (Player) object2;
			System.out.println("Rank of "+ anotherPlayer.getName()+ ": " +anotherPlayer.getRank());

			// clean up
			oos.close();
			ois.close();
			
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
