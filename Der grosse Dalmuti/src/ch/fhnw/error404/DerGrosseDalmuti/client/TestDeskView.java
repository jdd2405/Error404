package ch.fhnw.error404.DerGrosseDalmuti.client;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import ch.fhnw.error404.DerGrosseDalmuti.shared.*;

public class TestDeskView extends JFrame{

  
    //... Components
	private JPanel mainPanel;
	
	private JPanel panelNorth = new JPanel();
	private JPanel panelWest = new JPanel();
	private JPanel panelEast = new JPanel();
	
	private JLabel lblPlayer = new JLabel();
	//private Image playerCards = new Image();
	
	
	private JPanel panelSouth = new JPanel();
	private JPanel cardPanel = new JPanel();
	private JButton btnCard = new JButton();
	private JTextField txtNOfCards = new JTextField(2);
	private JButton btnPlayCards = new JButton("Auswahl spielen");
	private JButton btnPass = new JButton("Passen");
	private JButton btnExit = new JButton("Spiel verlassen");
    
    
    //======================================================= constructor
    /** Constructor */
    TestDeskView() {

        
        //... Layout the components.
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(panelNorth, BorderLayout.NORTH);
        mainPanel.add(panelEast, BorderLayout.EAST);
        mainPanel.add(panelSouth, BorderLayout.SOUTH);
        mainPanel.add(panelWest, BorderLayout.WEST);
        
        // Panel North
        panelNorth.setLayout(new GridLayout(1,1));
        panelNorth.add(lblPlayer);
        
        
        // Panel South
        panelSouth.setLayout(new BorderLayout());
        panelSouth.add(txtNOfCards, BorderLayout.SOUTH);
        panelSouth.add(btnPlayCards, BorderLayout.SOUTH);
        panelSouth.add(btnPass, BorderLayout.SOUTH);
        panelSouth.add(btnExit, BorderLayout.SOUTH);
        
        // Panel South - Panel Card
        panelSouth.add(cardPanel, BorderLayout.CENTER);
        cardPanel.setLayout(new FlowLayout());
        cardPanel.add(btnCard);
        
        
        //... finalize layout
        this.getContentPane().add(mainPanel);
        
        this.setTitle("Der grosse Dalmuti");
        // The window closing event should probably be passed to the 
        // Controller in a real program, but this is a short example.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    String getTxtNOfCardsInput() {
        return txtNOfCards.getText();
    }
    
    void showTxtNOfCards(int id) {
    	txtNOfCards.setText(String.valueOf(id));
    }
    
    void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }
    
    void addBtnCardListener(ActionListener addCardBtnListener) {
        btnCard.addActionListener(addCardBtnListener);
    }
    

    
}
