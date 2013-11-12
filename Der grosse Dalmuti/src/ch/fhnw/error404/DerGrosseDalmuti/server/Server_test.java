package ch.fhnw.error404.DerGrosseDalmuti.server;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server_test {
	LinkedList <Player> player;
	
	public class ClientHandler implements Runnable{
		BufferedReader reader;
		Socket sock;
		
		public ClientHandler (Socket clientSocket){
			try{
				sock = clientSocket;
				InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
				reader= new BufferedReader (isReader);
			}
			catch (Exception ex) {ex.printStackTrace();}
		}
		public void run(){
			String nachricht;
			try{
				while((nachricht = reader.readLine()) != null){
					System.out.println("gelesen: " + nachricht);
					esAllenWeitersagen(nachricht);
				}
			}
			catch (Exception ex) {ex.printStackTrace();}
		}
	}
	public static void main(String[] args) {
		Server_test server = new Server_test();
		server.los();
		
	}
	
	public void los(){

		
		try{
			ServerSocket serverSock = new ServerSocket (5000,10,null);
			
			while(true){
				Socket clientSocket = serverSock.accept();
				OutputStream os = clientSocket.getOutputStream();
  				oos = new ObjectOutputStream( os );
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
				clientAusgabeStröme.add(writer);
				Thread t = new Thread (new ClientHandler(clientSocket));
				t.start();
				System.out.println("habe eine Verbindung");
			}
		}
		catch (Exception ex) {ex.printStackTrace();}
	}
	
	public void esAllenWeitersagen(String nachricht){
		Iterator it = clientAusgabeStröme.iterator();
		while(it.hasNext()){
			try{
				PrintWriter writer = (PrintWriter) it.next();
				writer.println(nachricht);
				writer.flush();
			}
			catch (Exception ex) {ex.printStackTrace();}
		}
	}
}
