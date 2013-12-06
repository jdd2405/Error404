/**
 * 
 */
package ch.fhnw.error404.DerGrosseDalmuti.client;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import ch.fhnw.error404.DerGrosseDalmuti.client.Action;

/**
 * @author Elias und Thomas
 *
 */
public class LoginView extends JFrame {
	
	private JFrame loginView;
	private JPanel panel;
	private JButton login;
	private JLabel label;
	private JTextField username;
	
	public LoginView(){
		
		JFrame Frame = new JFrame();
		Frame.setTitle("Login");
		Frame.setSize(800, 600);
		Frame.setLocationRelativeTo(null);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginView = new JFrame();
		loginView.setTitle("Login");
		loginView.setSize(800, 600);
		loginView.setLocationRelativeTo(null);
		loginView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(200,300,200,300));
		panel.setLayout(new GridLayout(3,1));
		
		label = new JLabel();
		label.setText("Der Grosse Dalmuti");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial", Font.BOLD, 48));	
	
		login = new JButton("Login");
		
		loginView.getRootPane().setDefaultButton(login); // when enter key pressed -> login button is activatd
		
		username = new JTextField("Username", 10);
			
		panel.add(username);
		panel.add(login);
			
		loginView.add(panel);
		loginView.add(label, BorderLayout.NORTH);
		loginView.setVisible(true);
		
	}
	
	void reset() {
        // if needed
    }
    
    String getUserInput() {
        return username.getText();
    }
    
    void setUserInput(String string){
    	username.setText(string);
    }
    
    void addLoginListener(ActionListener listener) {
        login.addActionListener(listener);
    }
    
    
    void showError(String string) {
    	new LoginError();
    }
    
    void closeWindow(){
        loginView.dispose();
        loginView.setVisible(false);
    }
    
    void addClearOnClick(MouseListener listener){
    	username.addMouseListener(listener);
    }
}
