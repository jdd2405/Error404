package ch.fhnw.error404.DerGrosseDalmuti.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import ch.fhnw.error404.DerGrosseDalmuti.shared.Player;

public class Client_test {
	static Socket socket;
	static ObjectInputStream ois;
	static ObjectOutputStream oos;
	static Object objFromServer;
	
	
	public static void main (String[] args) throws Exception{
		socket = new Socket ("127.0.0.1", 5000);
		System.out.println("Connection successful.");
		ois = new ObjectInputStream(socket.getInputStream());
		oos = new ObjectOutputStream(socket.getOutputStream());
		Input in = new Input(ois);
		Thread thread = new Thread(in);
		thread.start();
		
	}

}
class Input implements Runnable{
	
	ObjectInputStream ois;
	
	public Input(ObjectInputStream ois){
		this.ois = ois;
	}


	public void run() {
		while(true){
			try {
				Player player1 = (Player) ois.readObject();
				System.out.println(player1.getName());
			} 
			catch (ClassNotFoundException e) {e.printStackTrace();}
			catch (IOException e) {e.printStackTrace();}
		}
		
	}
	
}
