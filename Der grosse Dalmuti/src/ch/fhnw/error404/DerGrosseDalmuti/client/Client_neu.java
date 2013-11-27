package ch.fhnw.error404.DerGrosseDalmuti.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;





import ch.fhnw.error404.DerGrosseDalmuti.shared.*;


public class Client_neu implements Serializable{

	ObjectInputStream in;
	ObjectOutputStream out;
	private ArrayList <Player> clientlist = new ArrayList <Player>(4);
	
	
	
    public void SetArray( ArrayList <Player> clientlist ){  // Setter
        this.clientlist = clientlist;
        //änderungen an server schicken
        try {
			out.writeObject(clientlist);
		} catch (IOException e) {e.printStackTrace();}
    }
    
	public ArrayList <Player> GetArray(){  // Getter
	        return clientlist;
	}

		
	public static void main(String[] args) {
		Client_neu client = new Client_neu();
		//new LoginView();
		client.clientSocket();
		
		

	}

	private void clientSocket() {

		Socket socket = null;

		try {

			// create socket
			socket = new Socket("127.0.0.1", 5000);
			System.out.println("Zum Server verbunden: " + socket.isConnected());
			// create outputStream for objects
			OutputStream os = socket.getOutputStream();
			out = new ObjectOutputStream(os);

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
			ArrayList<Player> message;

				try {
					while(true){
						message = (ArrayList<Player>) in.readObject();
						clientlist = message;
						if(message.isEmpty() != true){
						for(int i = 0; i<4; i++){
							System.out.println(message.get(i));
							//System.out.println(clientlist [i]);
						}
						}
						else {System.out.println("keine Player bisher");};
					}
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();}
		}
		
	}

}
