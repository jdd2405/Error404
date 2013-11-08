package ch.fhnw.error404.DerGrosseDalmuti.server;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import ch.fhnw.error404.DerGrosseDalmuti.shared.*;

/* TO DO's
 * - Thread for checking for updates.
 * - Check Model Type with typeOf() (od so...)
 * - Update (replace) Model Object
 */

public class Server implements Runnable{
	
	boolean hasAnyModelChanged = false;
	Object objFromClient = new Object();
	Object objFromServer = new Object();
	
	public static void main(String[] args){
		Server server = new Server();
		
		Thread serverThread = new Thread(server, "Listener");
		serverThread.start();
		
		//Deck deck = new Deck();
		//System.out.println(deck.peekNotDealtCards().getCardType()); // CHECK OUT WHY THIS DOESN'T WORK!
	      
	}

	@Override
	public void run() {
		ServerSocket server = null;
		try {
	    	  
	    	  // create ServerSocket-listener with port 404
			server = new ServerSocket(5000, 10, null);
			System.out.println("Server started");
	    	  
	    	  while(true){
	    		  
	    		  	// Wait for and accept an incoming request
	    		  	Socket socket = server.accept();

	  				// create inputStream for objects
	  				InputStream is = socket.getInputStream();
	  				ObjectInputStream ois = new ObjectInputStream( is );
	  				
	  				// create outputStream for objects
	  				OutputStream os = socket.getOutputStream();
	  				ObjectOutputStream oos = new ObjectOutputStream( os );
	  			
	  				// read object from inputStream
	  				objFromClient = ois.readObject();
	  				
	  				// check type of Object
	  				if (objFromClient instanceof Player){
	  					// Do something with Player Object
	  					Player player = (Player)objFromClient;
	  					player.setRank(2); 
	  					objFromServer = player;
	  				}
	  				if (objFromClient instanceof Deck){
	  					// Do something with Player Object for example:
	  					// Deck deck = (Deck)objFromClient; 				
	  				}
	  				
	  				
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
