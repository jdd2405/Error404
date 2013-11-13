package ch.fhnw.error404.DerGrosseDalmuti.client;

import java.awt.BorderLayout;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class LoginError {
	
	private JFrame Frame1;
	
	public LoginError(){
	
	Frame1 = new JFrame();
	Frame1.setTitle("LoginError");
	Frame1.setSize(400,200);
	Frame1.setLocationRelativeTo(null);
	//Frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	JLabel Label = new JLabel("Benutzername ungültig. Keine Sonderzeichen erlaubt!");
	Label.setVerticalAlignment(SwingConstants.CENTER);
	Label.setHorizontalAlignment(SwingConstants.CENTER);
	
	Frame1.add(Label);
	Frame1.setVisible(true);
	
	}
}
