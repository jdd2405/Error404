package client;

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
public class Client extends JFrame {
	private JTextArea txtMessages;
	private JTextField txtNewMessage;
	private JButton btnSend;

	public static void main(String[] args) {
		
		Client c =new Client();
		
		//Send an initial text to say that you want to be connected.
		String initialText = "I want to be connected!";
		c.sendMessage(initialText);
		
	}
	
	public Client() {
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

