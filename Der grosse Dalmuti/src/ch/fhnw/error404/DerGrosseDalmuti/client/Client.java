package ch.fhnw.error404.DerGrosseDalmuti.client;



import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;


import ch.fhnw.error404.DerGrosseDalmuti.shared.*;

public class Client {
	public static void main(String[] args){
		Client client = new Client();
		client.clientSocket();
	}
	
	private void clientSocket(){
		
		String host = "127.0.0.1";
		int port = 5000;
		Player jonas = new Player("Jonas");
		Object object = jonas;
		
		Socket socket = null;
		
		try {
			
			// create socket
			socket = new Socket( host, port );
			
			// create outputStream for objects
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream( os );
			
			// write object to outputStream
			oos.writeObject( object );
			oos.flush();
			
			// create inputStream for objects
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream( is );
			
			// read object from inputStream
			Object object2 = ois.readObject();
			
			// do something with object
			Player anyPlayer = (Player)object2;
			System.out.println(anyPlayer.getRank());
			
			// clean up
			oos.close();
			ois.close();
			
		}

		catch ( Exception e ) {
		      e.printStackTrace();
		}
	}
}
