package ch.fhnw.error404.DerGrosseDalmuti.server;

import ch.fhnw.error404.DerGrosseDalmuti.shared.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;


public class Server_old implements Runnable {
	private static Server_old server;
	private static Thread serverThread;


	public static void main(String[] args) {
		server = new Server_old();
		serverThread = new Thread(server, "Listener");
		serverThread.start();
	}


	private void sendObject(Serializable object){
		try {
			// Create a new socket, connect immediately to 127.0.0.1:50001
			Socket socket = new Socket("127.0.0.1", 50001);

			// Create reader and writer for the socket
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

		    oos.writeObject(object);
		    
		    // Clean up
		    oos.close();
		    socket.close();

		} 
		
		catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	

	@Override
	public void run() {

			try {
				
				// Create the server socket, to listen for incoming requests
				ServerSocket listener = new ServerSocket(50001, 10, null);
				
				while (true) {
					// Wait for and accept an incoming request
					Socket s = listener.accept();

				
					ObjectInputStream ois = new ObjectInputStream(listener.getObjectInputStream());
					Object o = (Object) ois.readObject();
					System.out.println(o.getClass());
					ois.close();
				
				}
			}
			
			catch (Exception e){
				System.out.println(e.toString());
				e.printStackTrace();
			}
	}
}
