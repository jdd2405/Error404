
package ch.fhnw.error404.DerGrosseDalmuti.client;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;

import ch.fhnw.error404.DerGrosseDalmuti.shared.*;

public class View extends JFrame{

    
    //... Components
	private JTextField txtName = new JTextField(5);
	private JTextField txtId = new JTextField(5);
    private JButton    btnLogin = new JButton("Login");
    
    private Player player;
    
    //======================================================= constructor
    /** Constructor */
    View(Player player) {
        //... Set up the logic
    	this.player = player;
        
        //... Initialize components
        txtId.setText("noch nicht vergeben");
        
        //... Layout the components.      
        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(new JLabel("Input"));
        content.add(txtName);
        content.add(btnLogin);
        content.add(new JLabel("Ihre ID"));
        content.add(txtId);
        
        //... finalize layout
        this.setContentPane(content);
        this.pack();
        
        this.setTitle("Get ID of Player");
        // The window closing event should probably be passed to the 
        // Controller in a real program, but this is a short example.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    String getUserInput() {
        return txtName.getText();
    }
    
    void showId(int id) {
        txtId.setText(String.valueOf(id));
    }
    
    void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }
    
    void addShowListener(ActionListener addShowAL) {
        btnLogin.addActionListener(addShowAL);
    }
    
    void addClearListener(ActionListener addClearAL) {
        btnLogin.addActionListener(addClearAL);
    }
    
    void reset(){
    	txtId.setText(null);
    }
    
}
