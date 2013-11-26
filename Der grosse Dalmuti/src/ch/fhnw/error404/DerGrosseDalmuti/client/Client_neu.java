package ch.fhnw.error404.DerGrosseDalmuti.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

import ch.fhnw.error404.DerGrosseDalmuti.shared.*;


public class Client_neu implements Serializable{

	ObjectInputStream in;
	Integer [] clientlist= {2,4,6,8};
		
	public static void main(String[] args) {
		
		Client_neu client = new Client_neu();
		
		
		client.clientSocket();
		
		//new LoginView();
		

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
			//clientlist.add(test);
			out.writeObject(clientlist);
			out.flush();

			// create inputStream for objects
			InputStream is = socket.getInputStream();
			in = new ObjectInputStream(is);
		}
		catch (Exception e) {
			e.printStackTrace();}
		
		Thread inputThread = new Thread (new InputMessages());
		inputThread.start();

	}
	
	public class InputMessages implements Runnable {
		public void run(){
			Integer [] message;

				try {
					while(true){
						message = (Integer[]) in.readObject();
						clientlist = message;
						for(int i = 0; i<4; i++){
							System.out.println(message[i]);
							System.out.println(clientlist [i]);
						}
					}
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();}
		}
		
	}

}
