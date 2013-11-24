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
	
	private JPanel Panel;
	private JButton Login;
	private JLabel Label;
	private JTextField Username;
	
	public LoginView(){
		
		JFrame Frame = new JFrame();
		Frame.setTitle("Login");
		Frame.setSize(800, 600);
		Frame.setLocationRelativeTo(null);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginview = new JFrame();
		loginview.setTitle("Login");
		loginview.setSize(800, 600);
		loginview.setLocationRelativeTo(null);
		loginview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Panel = new JPanel();
		Panel.setBorder(new EmptyBorder(200,300,200,300));
		Panel.setLayout(new GridLayout(3,1));
		
		Label = new JLabel();
		Label.setText("Der Grosse Dalmuti");
		Label.setHorizontalAlignment(SwingConstants.CENTER);
		Label.setFont(new Font("Arial", Font.BOLD, 48));	
	
		Login = new JButton("Login");
		Login.addActionListener(LoginListener);
		
		loginview.getRootPane().setDefaultButton(Login); // when enter key pressed -> login button is activatd
		
		Username = new JTextField("Username", 10);
		Username.addMouseListener(ClearOnClick);
			
		Panel.add(Username);
		Panel.add(Login);
			
		loginview.add(Panel);
		loginview.add(Label, BorderLayout.NORTH);
		loginview.setVisible(true);
		
	}
	
	void reset() {
        // if needed
    }
    
    String getUserInput() {
        return Username.getText();
    }
    
    void setTotal(String newTotal) {
    	Username.setText(newTotal);
    }
    
    
    void addListener(ActionListener listener) {
        Login.addActionListener(listener);
    }
    
    void addClearListener(ActionListener cal) {
        // for good reasons
    }
    
    void showError(String string) {
    	new LoginError();
    }
}
