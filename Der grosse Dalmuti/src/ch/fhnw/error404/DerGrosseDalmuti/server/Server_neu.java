package ch.fhnw.error404.DerGrosseDalmuti.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

import ch.fhnw.error404.DerGrosseDalmuti.shared.*;

public class Server_neu implements Serializable{
	
	//speichert die outputstreams der clients / Vector ist ein dynamisches Array
	private Vector <ObjectOutputStream> clientManager = new Vector <ObjectOutputStream>();
	ArrayList <Player> serverlist= new ArrayList <Player>(4);
	
	public static void main(String [] args){
		Server_neu serverObject = new Server_neu();
		serverObject.startServer();
	}
	
	public void startServer(){
		try{
			ServerSocket server = new ServerSocket(5000);
			System.out.println("Server ist gestartet");

			while (true){
				Socket client = server.accept();
				ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
				clientManager.add(output);
				output.writeObject(serverlist);
				output.flush();
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
			ArrayList <Player> message;
			
			try{
				message = (ArrayList<Player>) input.readObject();
				serverlist = message;
				for(int i =0; i <4; i++){
				System.out.println(message.get(i));
				//System.out.println(serverlist[i]);
				}
				sendMessage(message);
			}
			catch (ClassNotFoundException | IOException e) {e.printStackTrace();}
				
				//in.close();
				//out.close();
		}

		private void sendMessage(ArrayList<Player> message2){
			synchronized (clientManager){
				for (ObjectOutputStream output : clientManager){
					try {
						output.writeObject(message2);
						output.flush();
					} catch (IOException e) {e.printStackTrace();}	
				}
			}
		}
	}

}
