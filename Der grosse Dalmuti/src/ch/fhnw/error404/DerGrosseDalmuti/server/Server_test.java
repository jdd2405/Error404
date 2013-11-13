package ch.fhnw.error404.DerGrosseDalmuti.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import ch.fhnw.error404.DerGrosseDalmuti.shared.Player;

public class Server_test {
	static ServerSocket serverSocket;
	static Socket socket;
	static ObjectOutputStream oos;
	static ObjectInputStream ois;
	static Users[] user = new Users[4];

	static Player player1 = new Player("Theresa");

	public static void main(String[] args) throws Exception {
		serverSocket = new ServerSocket(5000);
		System.out.println("Server started...");
		while (true) {
			socket = serverSocket.accept();
			for (int i = 0; i < 4; i++) {

				System.out.println("Connection from: "+ socket.getInetAddress());
				oos = new ObjectOutputStream(socket.getOutputStream());
				ois = new ObjectInputStream(socket.getInputStream());
				if (user[i] == null) {
					user[i] = new Users(oos, ois, user);
					Thread thread = new Thread(user[i]);
					thread.start();
					break;
				}

			}
		}

	}
}

class Users implements Runnable {

	ObjectOutputStream oos;
	ObjectInputStream ois;
	Users[] user = new Users[4];

	public Users(ObjectOutputStream oos, ObjectInputStream ois, Users[] user) {
		this.oos = oos;
		this.ois = ois;
		this.user = user;
	}

	public void run() {
		while (true) {
		try {
			Player serverobject = (Player) ois.readObject();
			for(int i = 0; i<4; i++){
				if(user[i] != null){
					user[i].oos.writeObject(serverobject);
					oos.flush();
				}
			}
		} 
		catch (ClassNotFoundException e) {e.printStackTrace();} 
		catch (IOException e) {e.printStackTrace();}

		}

	}

}
