package server;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Server extends JFrame implements Runnable {
	private static Server server;
	private static Thread serverThread;

	private JTextArea txtMessages;

	public static void main(String[] args) {
		server = new Server();
		serverThread = new Thread(server, "Listener");
		serverThread.start();
	}

	public Server() {
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

