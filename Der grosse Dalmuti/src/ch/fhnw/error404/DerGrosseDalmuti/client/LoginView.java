/**
 * 
 */
package ch.fhnw.error404.DerGrosseDalmuti.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JDialog;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import ch.fhnw.error404.DerGrosseDalmuti.shared.Player;

/**
 * @author Elias und Thomas
 *
 */
public class LoginView extends ABaseView {
	
	private JFrame Frame;
	private JPanel Panel;
	private JButton Login;
	private JLabel Label;
	private JTextField Username;
	
	public LoginView(){
		
		Frame = new JFrame();
		Frame.setTitle("Login");
		Frame.setSize(800, 600);
		Frame.setLocationRelativeTo(null);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Panel = new JPanel();
		//Panel.setBackground(Color.BLACK);
		Panel.setBorder(new EmptyBorder(200,300,200,300));
		Panel.setLayout(new GridLayout(3,1));
		
		Label = new JLabel();
		Label.setText("Der Grosse Dalmuti");
		Label.setHorizontalAlignment(SwingConstants.CENTER);
		Label.setFont(new Font("Arial", Font.BOLD, 48));	
	
		Login = new JButton("Login");
		Login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				Player.Player1.setName(Username.getText());
				
				if ((Username.getText()).matches("[a-zA-Z0-9]*") == true){
					dispose();
					new DeskView();
					Frame.setVisible(false);
				}
				else{
					new LoginError();
				}
			}
		});
		Frame.getRootPane().setDefaultButton(Login);
		
		
		Username = new JTextField("Username", 10);
		Username.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				Username.setText("");
			}
		});
		Username.addKeyListener(new KeyAdapter(){
			public void KeyTyped(KeyEvent e){
				Username.setText("");
			}
		});
		
			
		Panel.add(Username);
		Panel.add(Login);
			
		Frame.add(Panel);
		Frame.add(Label, BorderLayout.NORTH);
		Frame.setVisible(true);
		
	}
}
