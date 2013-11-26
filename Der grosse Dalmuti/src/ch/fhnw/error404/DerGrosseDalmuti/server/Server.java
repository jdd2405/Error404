package ch.fhnw.error404.DerGrosseDalmuti.server;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import ch.fhnw.error404.DerGrosseDalmuti.client.Action;
import ch.fhnw.error404.DerGrosseDalmuti.shared.*;

/* TO DO's
 * - Thread for checking for updates.
 * - Check Model Type with typeOf() (od so...)
 * - Update (replace) Model Object
 */

public class Server implements Runnable{
	
	Object objFromClient = new Object();
	Object objFromServer = new Object();
	
	Game game;
	
	
	
	public static void main(String[] args){
		Server server = new Server();
		
		Thread serverThread = new Thread(server, "Listener");
		serverThread.start();
	}
	
	
	// Constructor
	public Server() {
		game = new Game();
	}
	
	
	@Override
	public void run() {
		ServerSocket socketServer = null;
		try {
	    	  
	    	  // create ServerSocket-listener with port 404
			socketServer = new ServerSocket(5000, 10, null);
			System.out.println("Server started");
	    	  
	    	  while(true){
	    		  
	    		  	// Wait for and accept an incoming request
	    		  	Socket socket = socketServer.accept();
	    		  	

	  				// create inputStream for objects
	  				InputStream is = socket.getInputStream();
	  				ObjectInputStream ois = new ObjectInputStream( is );
	  			
	  				// read object from inputStream
	  				objFromClient = ois.readObject();
	  				
	  				// check type of Object
	  				if (objFromClient instanceof Player){
	  					// Do something with Player Object
						Player player = (Player)objFromClient;
	  					player.setRank(2);  // only for testing reasons
	  					objFromServer = player;
	  				}
	  				if (objFromClient instanceof Deck){
	  					// Do something with Player Object for example:
	  					// Deck deck = (Deck)objFromClient; 				
	  				}
	  				
	  				
	  				// create outputStream for objects
	  				OutputStream os = socket.getOutputStream();
	  				ObjectOutputStream oos = new ObjectOutputStream( os );
	  				
	  				// write object to outputStream	  				
	  				oos.writeObject( objFromServer );
	  				oos.flush();
	  				
	  				
	  				// clean up
	  				ois.close();
	  				oos.close();
	  			

	    	 }
	    	
	         


	      } 
		catch (Exception e) {
	         e.printStackTrace();
		}
		
		
	}

}
