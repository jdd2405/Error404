package ch.fhnw.error404.DerGrosseDalmuti.client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import ch.fhnw.error404.DerGrosseDalmuti.shared.*;

import javax.swing.*;

/**
 * @author Thomas and Elias
 * the following GUI is created on the base of Gridlayout
 * JLabels, JTextField or JButtons are created and Located in the Grid
 */

public class DeskView extends JFrame {
	
		JFrame mainFrame;
		
		private JPanel panelSouth;
		private GridBagConstraints gridSouth;
		private JTextField txtSpielerSouth;
		private JTextField txtRoleSouth;
		JButton btnPassen = new JButton();
		JButton btnAuswahlSpielen = new JButton();
		JTextField txtAmountCards;
		JTextField txtTypeCards;
		JButton[] btnSlot = new JButton[12];
		JLabel[] lblAmountOfCards = new JLabel[12];
		private JButton btnCloseGame;
		
		private JPanel panelWest;
		private GridBagConstraints gridWest;
		private JTextField txtSpielerWest;
		private JTextField txtRoleWest;
		private JTextField txtCardsInHandWest;
		
		private JPanel panelNorth;
		private GridBagConstraints gridNorth;
		private JTextField txtSpielerNorth;
		private JTextField txtRoleNorth;
		private JLabel lblNorth;
		private JTextField txtCardsInHandNorth;
		
		private JPanel panelEast;
		private GridBagConstraints gridEast;
		private JTextField txtSpielerEast;
		private JTextField txtRoleEast;
		private JTextField txtCardsInHandEast;
		
		private JPanel panelCenter;
		private GridBagConstraints gridCenter;
		private JLabel lblCardsCenter;
		private JTextField txtNumberOfCardsCenter;
		
		ImageIcon icon = new ImageIcon("Bilder/cardohne.png");
		ImageIcon[] myIcon = new ImageIcon[12];

	public DeskView() {

		for(int i=0; i<12; i++){
			myIcon[i]= new ImageIcon("Bilder/karte"+(i+1)+".jpg");
		}
		
		mainFrame = new JFrame();
		mainFrame.setTitle("Der Grosse Dalmuti");
		mainFrame.setSize(1600,900);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(false);
		
		//NORTH Panel
		panelNorth = new JPanel(new GridBagLayout());
		gridNorth = new GridBagConstraints();
		panelNorth.setPreferredSize(new Dimension(1600,200));
		
		lblNorth = new JLabel(icon);
		lblNorth.setPreferredSize(new Dimension(89,92));
		gridNorth.gridx = 0;
		gridNorth.gridy = 0;
		gridNorth.insets = new Insets(5,5,5,5);
		panelNorth.add(lblNorth, gridNorth);
		
		mainFrame.getContentPane().add(panelNorth, BorderLayout.NORTH);
		
		//EAST Panel
		panelEast = new JPanel(new GridBagLayout());
		gridEast = new GridBagConstraints();
		panelEast.setPreferredSize(new Dimension(300,900));
		
		JLabel Label2 = new JLabel(icon);
		Label2.setPreferredSize(new Dimension(89,92));
		
		gridEast.gridx = 0;
		gridEast.gridy = 0;
		gridEast.insets = new Insets(5,5,5,5);
		panelEast.add(Label2, gridEast);
		
		mainFrame.getContentPane().add(panelEast, BorderLayout.EAST);
		
		//WEST Panel
		panelWest = new JPanel(new GridBagLayout());
		gridWest = new GridBagConstraints();
		panelWest.setPreferredSize(new Dimension(300,900));
				
		JLabel Label3 = new JLabel(icon);
		Label3.setPreferredSize(new Dimension(89,92));
				
		gridWest.gridx = 0;
		gridWest.gridy = 0;
		gridWest.insets = new Insets(5,5,5,5);
		panelWest.add(Label3, gridWest);
	
		mainFrame.getContentPane().add(panelWest, BorderLayout.WEST);
		
		//CENTER Panel
		panelCenter = new JPanel(new GridBagLayout());
		panelCenter.setMaximumSize(new Dimension(200,200));
		gridCenter = new GridBagConstraints();
		panelCenter.setBackground(Color.YELLOW);
		panelCenter.setBorder(BorderFactory.createLineBorder(Color.BLACK,10));
			
		mainFrame.getContentPane().add(panelCenter, BorderLayout.CENTER);
		
		//SOUTH Panel
		panelSouth = new JPanel(new GridBagLayout());
		gridSouth = new GridBagConstraints();
		panelSouth.setPreferredSize(new Dimension(1600,200));
		
		
		for(int i = 0; i<12; i++){
    		btnSlot[i] = new JButton();
    	    btnSlot[i].setIcon(myIcon[i]);//here you set the icon for your button
    		btnSlot[i].setPreferredSize(new Dimension(89,92));
    		btnSlot[i].setContentAreaFilled(false);
    		gridSouth.gridx = i;
    		gridSouth.gridy = 1;
    		gridSouth.insets = new Insets(5,5,5,5);
    		panelSouth.add(btnSlot[i], gridSouth);
    	}
		
		txtTypeCards = new JTextField(20);
		gridSouth.anchor = GridBagConstraints.LINE_START;
		gridSouth.gridwidth = 2;
		gridSouth.gridx = 0;
		gridSouth.gridy = 2;
		gridSouth.insets = new Insets(5,5,5,5);
		panelSouth.add(txtTypeCards, gridSouth);
		
		txtAmountCards = new JTextField(3);
		gridSouth.gridwidth = 1;
		gridSouth.anchor = GridBagConstraints.LINE_END;
		gridSouth.gridx = 2;
		gridSouth.gridy = 2;
		gridSouth.insets = new Insets(5,5,5,5);
		panelSouth.add(txtAmountCards, gridSouth);
		
		
		btnAuswahlSpielen.setText("Auswahl spielen");
		btnAuswahlSpielen.setPreferredSize(new Dimension(170,30));
		btnAuswahlSpielen.setEnabled(false);
		gridSouth.gridwidth = 2;
		gridSouth.gridx = 5;
		gridSouth.gridy = 2;
		gridSouth.insets = new Insets(5,5,5,5);
		panelSouth.add(btnAuswahlSpielen, gridSouth);
		
		btnPassen.setText("Passen");
		btnPassen.setPreferredSize(new Dimension(170,30));	
		btnPassen.setEnabled(false);
		gridSouth.gridwidth = 2;
		gridSouth.gridx = 7;
		gridSouth.gridy = 2;
		gridSouth.insets = new Insets(5,5,5,5);
		panelSouth.add(btnPassen, gridSouth);
		
		btnCloseGame = new JButton("Spiel beenden"); // closes game
		btnCloseGame.setPreferredSize(new Dimension(170,30));	
		gridSouth.gridwidth = 2;
		gridSouth.gridx = 10;
		gridSouth.gridy = 2;
		gridSouth.insets = new Insets(5,5,5,5);
		panelSouth.add(btnCloseGame, gridSouth);
						
		mainFrame.getContentPane().add(panelSouth, BorderLayout.SOUTH);
		
	}

    //South Methods
    
    void showInSouth(Player player){
    	txtSpielerSouth = new JTextField(player.getName());
    	gridSouth.gridwidth = 2;
		gridSouth.gridx = 0;
		gridSouth.gridy = 0;
		gridSouth.insets = new Insets(5,5,5,5);
		panelSouth.add(txtSpielerSouth, gridSouth);
		
		txtRoleSouth = new JTextField((player.getRole()).getLabel());
		gridSouth.gridwidth = 2;
		gridSouth.gridx = 5;
		gridSouth.gridy = 0;
		gridSouth.insets = new Insets(5,5,5,5);
		panelSouth.add(txtSpielerSouth, gridSouth);
    }
    
    void showMyCards(int[][] cards){
    	
    	for(int i = 0; i < 12; i++){
    		btnSlot[i].setLayout(new BorderLayout());
    		btnSlot[i].add(lblAmountOfCards[i] = new JLabel(Integer.toString(cards[i][0])),BorderLayout.WEST);
    		lblAmountOfCards[i].setFont(new Font("Arial", Font.BOLD, 35));
    		lblAmountOfCards[i].setForeground(Color.red);
    		
    		// for greying out cards for(int i = 0; i < 12; i++){
    		if(cards[i][1] == 0){
    			btnSlot[i].setEnabled(false);
    		}
    	}
    	
    }
    
	
    //West Methods
	void showInWest(Player player){
		
    	txtSpielerWest = new JTextField(player.getName());
    	gridWest.gridx = 0;
		gridWest.gridy = 1;
		gridWest.insets = new Insets(5,5,5,5);
		panelWest.add(txtSpielerWest, gridWest);
		
		txtRoleWest = new JTextField((player.getRole()).getLabel());	
    	gridWest.gridx = 1;
		gridWest.gridy = 0;
		gridWest.insets = new Insets(5,5,5,5);
		panelWest.add(txtRoleWest, gridWest);
		
		txtCardsInHandWest = new JTextField((player.getCards()).size());
		gridWest.gridx = 0;
		gridWest.gridy = 0;
		gridWest.insets = new Insets(5,5,5,5);
		panelWest.add(txtCardsInHandWest, gridWest);
	
	}
	
	//North Methods
	
    void showInNorth(Player player){
    	
    	txtSpielerNorth = new JTextField(player.getName());
    	gridNorth.gridx = 0;
		gridNorth.gridy = 1;
		gridNorth.insets = new Insets(5,5,5,5);
		panelNorth.add(txtSpielerNorth, gridNorth);
		
		txtRoleNorth = new JTextField((player.getRole()).getLabel());	
    	gridNorth.gridx = 1;
		gridNorth.gridy = 0;
		gridNorth.insets = new Insets(5,5,5,5);
		panelNorth.add(txtRoleNorth, gridNorth);
		
		txtCardsInHandNorth = new JTextField((player.getCards()).size());
		gridNorth.gridx = 0;
		gridNorth.gridy = 0;
		gridNorth.insets = new Insets(5,5,5,5);
		panelNorth.add(txtCardsInHandNorth, gridNorth);
		   
    	
    }
    
    //East Methods
    
	void showInEast(Player player){
		
		txtSpielerEast = new JTextField(player.getName());
		gridEast.gridx = 0;
		gridEast.gridy = 1;
		gridEast.insets = new Insets(5,5,5,5);
		panelEast.add(txtSpielerEast, gridEast);
		
		txtRoleEast = new JTextField((player.getRole()).getLabel());	
		gridEast.gridx = 1;
		gridEast.gridy = 0;
		gridEast.insets = new Insets(5,5,5,5);
		panelEast.add(txtRoleEast, gridEast);
		
		txtCardsInHandEast = new JTextField((player.getCards()).size());
		gridEast.gridx = 0;
		gridEast.gridy = 0;
		gridEast.insets = new Insets(5,5,5,5);
		panelEast.add(txtCardsInHandEast, gridEast);
	}
	
	//Center Methods
	
    void showCurrentTrick(Card.CARD_TYPE cardtype, int numberOfCards){
    	
    	lblCardsCenter = new JLabel(cardtype.getLabel());
    	lblCardsCenter.setPreferredSize(new Dimension(89,92));		
		gridCenter.gridx = 0;
		gridCenter.gridy = 0;
		gridCenter.insets = new Insets(5,5,5,5);
		panelCenter.add(lblCardsCenter, gridCenter);
		
		txtNumberOfCardsCenter = new JTextField(numberOfCards);
		gridCenter.gridx = 0;
		gridCenter.gridy = 1;
		gridCenter.insets = new Insets(5,5,5,5);
		panelCenter.add(lblCardsCenter, gridCenter);
		
		
    }
	
	//Other Methods
    
    void getTextOfLabel(){
    		// a = amountOfCards.getText();
    		
    	}
    
    
    void addDisplayNumber(ActionListener listener){
    	for (int i=0;i<12;i++){
    		btnSlot[i].addActionListener(listener);
    	}
    }
	
    void addCloseGame(ActionListener listener) {
        btnCloseGame.addActionListener(listener);
    }
    void closeWindow(){
        mainFrame.dispose();
        mainFrame.setVisible(false);
    }
    
    void addPassen(ActionListener listener){
    	btnPassen.addActionListener(listener);
    }
    
    void addAuswahlSpielen(ActionListener listener){
    	btnAuswahlSpielen.addActionListener(listener);
    }	
}

