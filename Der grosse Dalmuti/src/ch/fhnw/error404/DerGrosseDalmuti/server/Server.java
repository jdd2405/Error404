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
	
	boolean endconnection = false;
	
	public static void main(String[] args){
		Server server = new Server();
		
		Thread serverThread = new Thread(server, "Listener");
		serverThread.start();
	      
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
	  			
	  				// read object from inputStream
	  				Object object = ois.readObject();
	  				
	  				// Do something with object				 
	  				Player player = (Player)object;
	  				System.out.println(object.getClass().toString() +": "+ player.getName());
	  				player.setRank(2);
	  				
	    		  	// create outputStream for objects
	  				OutputStream os = socket.getOutputStream();
	  				ObjectOutputStream oos = new ObjectOutputStream( os );
	  			
	  				// write object to outputStream
	  				oos.writeObject( player );
	  				oos.flush();
	  				
	  				// clean up
	  				ois.close();
	  				oos.close();
	  			

	    	 }
	    	
	         


	      } 
		catch (Exception e) {
	         e.printStackTrace();;
		}
		
		
	}

}
