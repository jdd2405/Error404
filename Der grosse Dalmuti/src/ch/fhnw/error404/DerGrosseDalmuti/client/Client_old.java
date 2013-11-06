// hallo test

package ch.fhnw.error404.DerGrosseDalmuti.client;

import ch.fhnw.error404.DerGrosseDalmuti.shared.*;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class Client_old implements Runnable {
	private static Client_old client;
	private static Thread clientThread;
	
	public static void main(String[] args) {
		
		client = new Client_old();
		clientThread = new Thread(client, "Listener");
		clientThread.start();
		
		Player Jonas = new Player("Jonas");
		client.sendObject(Jonas);
		
		
	}
	
	
	private void sendObject(Serializable object){
		try {
			// Create a new socket, connect immediately to 127.0.0.1:50001
			Socket socket = new Socket("127.0.0.1", 50001);

			// Create reader and writer for the socket
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

		    oos.writeObject(object);
		    
		    // Clean up
		    oos.close();
		    socket.close();

		} 
		
		catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
	
	

	@Override
	public void run() {

			try {
				
				// Create the server socket, to listen for incoming requests
				Socket listener = new Socket("127.0.0.1", 50001);
								
				FileInputStream fis = new FileInputStream("t.tmp");
				ObjectInputStream ois = new ObjectInputStream(fis);
		
				// read reply
				Object o = (Object) ois.readObject();
				System.out.println(o.toString());
				ois.close();
				
			}
			
			catch (Exception e){
				System.out.println(e.toString());
			}
	}
}
			


/* REMEMBER THIS:
 * 
 * package trySocket;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Client2 extends JFrame {
	private JTextArea txtMessages;
	private JTextField txtNewMessage;
	private JButton btnSend;

	public static void main(String[] args) {
		
		Client2 c =new Client2();
		
		//Send an initial text to say that you want to be connected.
		String initialText = "I want to be connected!";
		c.sendMessage(initialText);
		
	}
	
	public Client2() {
		super("Simple client");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		txtMessages = new JTextArea();
		txtMessages.setEnabled(false);
		txtMessages.setPreferredSize(new java.awt.Dimension(600, 300));
		this.add(txtMessages, BorderLayout.CENTER);

		Box bottomBox = Box.createHorizontalBox();
		this.add(bottomBox, BorderLayout.SOUTH);

		txtNewMessage = new JTextField();
		txtNewMessage.setPreferredSize(new java.awt.Dimension(200, 30));
		bottomBox.add(txtNewMessage, BorderLayout.CENTER);

		bottomBox.add(Box.createHorizontalGlue());

		btnSend = new JButton("Send");
		bottomBox.add(btnSend, BorderLayout.SOUTH);
		btnSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});

		pack();
		setVisible(true);
	}
	
	

	private void sendMessage() {
		try {
			// Create a new socket, connect immediately to 127.0.0.1:50001
			Socket s = new Socket("127.0.0.1", 50001);

			// Create reader and writer for the socket
			BufferedReader r = new BufferedReader(new InputStreamReader(s.getInputStream()));
			OutputStreamWriter w = new OutputStreamWriter(s.getOutputStream());

			// Send the message from the text box
			w.write(txtNewMessage.getText() + "\n");
			w.flush();

			// Read and display the reply
			String msgIn = r.readLine();
			txtMessages.setText(txtMessages.getText() + "\n" + msgIn);

			// Clean up
			r.close();
			w.close();
			s.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	private void sendMessage(String Text) {
		try {
			// Create a new socket, connect immediately to 127.0.0.1:50001
			Socket s = new Socket("127.0.0.1", 50001);

			// Create reader and writer for the socket
			BufferedReader r = new BufferedReader(new InputStreamReader(s.getInputStream()));
			OutputStreamWriter w = new OutputStreamWriter(s.getOutputStream());

			// Send the message from the variable "Text"
			w.write(Text + "\n");
			w.flush();

			// Read and display the reply
			String msgIn = r.readLine();
			txtMessages.setText(txtMessages.getText() + "\n" + msgIn);

			// Clean up
			r.close();
			w.close();
			s.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}



package trySocket;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Server2 extends JFrame implements Runnable {
	private static Server2 server;
	private static Thread serverThread;

	private JTextArea txtMessages;

	public static void main(String[] args) {
		server = new Server2();
		serverThread = new Thread(server, "Listener");
		serverThread.start();
	}

	public Server2() {
		super("Simple server");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		txtMessages = new JTextArea();
		txtMessages.setEnabled(false);
		txtMessages.setPreferredSize(new java.awt.Dimension(600, 300));
		this.add(txtMessages, BorderLayout.CENTER);

		pack();
		setVisible(true);
	}

	@Override
	public void run() {
		try {
			// Create the server socket, to listen for incoming requests
			int port = Integer.parseInt("50001");
			ServerSocket listener = new ServerSocket(port, 10, null);

			while (true) {
				// Wait for and accept an incoming request
				Socket s = listener.accept();

				// Create reader and writer for the socket
				BufferedReader r = new BufferedReader(new InputStreamReader(s.getInputStream()));
				OutputStreamWriter w = new OutputStreamWriter(s.getOutputStream());

				
				// read the incoming message; append it to the text area
				String msgIn = r.readLine().trim();
				System.out.println(msgIn);
				txtMessages.setText(txtMessages.getText() + "\n" + msgIn);

				if (msgIn.equals("I want to be connected!")){
						w.write("Hello. I'm your Server. How can I help you?");
					
				}
				
				else {
					// write our confirmation
					w.write("Hello. I'm your Server. I Received this message from you: '" + msgIn + "'\n");
				}
				

				w.flush();

				// Clean up
				r.close();
				w.close();
				s.close();
				
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}



 */
