package ch.fhnw.error404.DerGrosseDalmuti.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server_neu {
	
	//speichert die outputstreams der clients / Vector ist ein dynamisches Array
	private Vector <ObjectOutputStream> clientManager = new Vector <ObjectOutputStream>();
	
	public static void main(String [] args){
		Server_neu serverObject = new Server_neu();
		serverObject.startServer();
	}
	
	public void startServer(){
		try{
			ServerSocket server = new ServerSocket(5000);

			while (true){
				Socket client = server.accept();
				ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
				clientManager.add(output);
				Thread t = new Thread(new ChatThread (client));
				t.start();
				System.out.println("habe eine Verbindung");
			}
		}
		catch (IOException e){e.printStackTrace();}
	}
	
	public class ChatThread implements Runnable{
		private Socket client;
		private int clientPort;
		private ObjectInputStream input;
		Object message;
		
		public ChatThread(Socket client){
			this.client = client;
			clientPort = client.getPort();
			try {
				input = new ObjectInputStream(client.getInputStream());
			} catch (IOException e) {e.printStackTrace();}
		}
		
		public void run(){
			Object message;
			
			try{
				while(true){
				message = input.readObject();
				System.out.println(message);
				sendMessage(clientPort + ": " + message);}
			}
			catch (ClassNotFoundException | IOException e) {e.printStackTrace();}
				
				//in.close();
				//out.close();
		}

		private void sendMessage(Object message){
			synchronized (clientManager){
				for (ObjectOutputStream output : clientManager){
					try {
						output.writeObject(message);
						output.flush();
					} catch (IOException e) {e.printStackTrace();}	
				}
			}
		}
	}

}
