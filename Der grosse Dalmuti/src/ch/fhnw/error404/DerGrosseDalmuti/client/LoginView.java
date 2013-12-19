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
	private JPanel panelLogin;
	private JButton btnLogin;
	private JLabel lblLogin;
	private JTextField txtUsername;
	
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
		
		panelLogin = new JPanel();
		panelLogin.setBorder(new EmptyBorder(200,300,200,300));
		panelLogin.setLayout(new GridLayout(3,1));
		
		lblLogin = new JLabel();
		lblLogin.setText("Der Grosse Dalmuti");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Arial", Font.BOLD, 48));	
	
		btnLogin = new JButton("Login");
		
		loginView.getRootPane().setDefaultButton(btnLogin); // when enter key pressed -> login button is activatd
		
		txtUsername = new JTextField("Username", 10);
			
		panelLogin.add(txtUsername);
		panelLogin.add(btnLogin);
			
		loginView.add(panelLogin);
		loginView.add(lblLogin, BorderLayout.NORTH);
		loginView.setVisible(true);
		
	}
    
    String getUserInput() {
        return txtUsername.getText();
    }
    
    void setUserInput(String string){
    	txtUsername.setText(string);
    }
    
    void addLoginListener(ActionListener listener) {
        btnLogin.addActionListener(listener);
    }
    
    void showError(String string) {
    	new LoginError();
    }
    
    void closeWindow(){
        loginView.dispose();
        loginView.setVisible(false);
    }
    
    void addClearOnClick(MouseListener listener){
    	txtUsername.addMouseListener(listener);
    }
}
