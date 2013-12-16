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
		JTextField txtSpielerSouth;
		JTextField txtRoleSouth;
		JButton btnSwapCards = new JButton();
		JButton btnPassen = new JButton();
		JButton btnAuswahlSpielen = new JButton();
		JTextField txtAmountCards;
		JTextField txtTypeCards;
		JButton[] btnSlot = new JButton[12];
		JLabel[] lblAmountOfCards = new JLabel[12];
		JButton btnCloseGame;
		JTextField txtRankSouth;
		
		private JPanel panelWest;
		private GridBagConstraints gridWest;
		JTextField txtSpielerWest;
		JTextField txtRoleWest;
		JTextField txtCardsInHandWest;
		JTextField txtRankWest;
		
		private JPanel panelNorth;
		private GridBagConstraints gridNorth;
		JTextField txtSpielerNorth;
		JTextField txtRoleNorth;
		JLabel lblNorth;
		JTextField txtCardsInHandNorth;
		JTextField txtRankNorth;
		
		private JPanel panelEast;
		private GridBagConstraints gridEast;
		JTextField txtSpielerEast;
		JTextField txtRoleEast;
		JTextField txtCardsInHandEast;
		JTextField txtRankEast;
		
		private JPanel panelCenter;
		private GridBagConstraints gridCenter;
		JLabel lblCardsCenter;
		JLabel lblNumberOfCardsCenter;
		
		ImageIcon icon = new ImageIcon("Bilder/cardohne.png");
		ImageIcon[] myIcon = new ImageIcon[12];

	public DeskView() {
		
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
		
    	txtSpielerNorth = new JTextField();
    	txtSpielerNorth.setEditable(false);
    	gridNorth.gridx = 0;
		gridNorth.gridy = 1;
		gridNorth.insets = new Insets(5,5,5,5);
		panelNorth.add(txtSpielerNorth, gridNorth);
		
		txtRoleNorth = new JTextField();	
		txtRoleNorth.setEditable(false);
    	gridNorth.gridx = 1;
		gridNorth.gridy = 0;
		gridNorth.insets = new Insets(5,5,5,5);
		panelNorth.add(txtRoleNorth, gridNorth);
		
		txtCardsInHandNorth = new JTextField();
		txtCardsInHandNorth.setEditable(false);
		gridNorth.gridx = 0;
		gridNorth.gridy = 0;
		gridNorth.insets = new Insets(5,5,5,5);
		panelNorth.add(txtCardsInHandNorth, gridNorth);
		
		txtRankNorth = new JTextField();	
		txtRankNorth.setEditable(false);
    	gridNorth.gridx = 1;
		gridNorth.gridy = 1;
		gridNorth.insets = new Insets(5,5,5,5);
		panelNorth.add(txtRankNorth, gridNorth);
		
		mainFrame.getContentPane().add(panelNorth, BorderLayout.NORTH);
		
		//EAST Panel
		panelEast = new JPanel(new GridBagLayout());
		gridEast = new GridBagConstraints();
		panelEast.setPreferredSize(new Dimension(500,900));
		
		JLabel Label2 = new JLabel(icon);
		Label2.setPreferredSize(new Dimension(89,92));
		
		gridEast.gridx = 0;
		gridEast.gridy = 0;
		gridEast.insets = new Insets(5,5,5,5);
		panelEast.add(Label2, gridEast);
		
		txtSpielerEast = new JTextField();
		txtSpielerEast.setEditable(false);
		gridEast.gridx = 0;
		gridEast.gridy = 1;
		gridEast.insets = new Insets(5,5,5,5);
		panelEast.add(txtSpielerEast, gridEast);
		
		txtRoleEast = new JTextField();
		txtRoleEast.setEditable(false);
		gridEast.gridx = 1;
		gridEast.gridy = 0;
		gridEast.insets = new Insets(5,5,5,5);
		panelEast.add(txtRoleEast, gridEast);
		
		txtCardsInHandEast = new JTextField();
		txtCardsInHandEast.setEditable(false);
		gridEast.gridx = 0;
		gridEast.gridy = 0;
		gridEast.insets = new Insets(5,5,5,5);
		panelEast.add(txtCardsInHandEast, gridEast);
		
		txtRankEast = new JTextField();	
		txtRankEast.setEditable(false);
    	gridEast.gridx = 1;
		gridEast.gridy = 1;
		gridEast.insets = new Insets(5,5,5,5);
		panelEast.add(txtRankEast, gridEast);
		
		mainFrame.getContentPane().add(panelEast, BorderLayout.EAST);
		
		//WEST Panel
		panelWest = new JPanel(new GridBagLayout());
		gridWest = new GridBagConstraints();
		panelWest.setPreferredSize(new Dimension(500,900));
				
		JLabel Label3 = new JLabel(icon);
		Label3.setPreferredSize(new Dimension(89,92));		
		gridWest.gridx = 0;
		gridWest.gridy = 0;
		gridWest.insets = new Insets(5,5,5,5);
		panelWest.add(Label3, gridWest);
		
	   	txtSpielerWest = new JTextField();
    	txtSpielerWest.setEditable(false);
    	gridWest.gridx = 0;
		gridWest.gridy = 1;
		gridWest.insets = new Insets(5,5,5,5);
		panelWest.add(txtSpielerWest, gridWest);
		
		txtRoleWest = new JTextField();	
		txtRoleWest.setEditable(false);
    	gridWest.gridx = 1;
		gridWest.gridy = 0;
		gridWest.insets = new Insets(5,5,5,5);
		panelWest.add(txtRoleWest, gridWest);
		
		txtCardsInHandWest = new JTextField();
		txtCardsInHandWest.setEditable(false);
		gridWest.gridx = 0;
		gridWest.gridy = 0;
		gridWest.insets = new Insets(5,5,5,5);
		panelWest.add(txtCardsInHandWest, gridWest);
		
		txtRankWest = new JTextField();	
		txtRankWest.setEditable(false);
    	gridWest.gridx = 1;
		gridWest.gridy = 1;
		gridWest.insets = new Insets(5,5,5,5);
		panelWest.add(txtRankWest, gridWest);
	
		mainFrame.getContentPane().add(panelWest, BorderLayout.WEST);
		
		//CENTER Panel
		panelCenter = new JPanel(new GridBagLayout());
		panelCenter.setMaximumSize(new Dimension(200,200));
		gridCenter = new GridBagConstraints();
		panelCenter.setBorder(BorderFactory.createLineBorder(Color.GRAY,3));
		
    	lblCardsCenter = new JLabel();
    	lblCardsCenter.setPreferredSize(new Dimension(161,250));
    	lblCardsCenter.setLayout(new BorderLayout());
		gridCenter.gridx = 0;
		gridCenter.gridy = 0;
		gridCenter.insets = new Insets(5,5,5,5);
		
		lblNumberOfCardsCenter = new JLabel();
		lblNumberOfCardsCenter.setFont(new Font("Arial", Font.BOLD, 35));
		lblNumberOfCardsCenter.setForeground(Color.red);
		lblCardsCenter.add(lblNumberOfCardsCenter, BorderLayout.WEST);
		
		panelCenter.add(lblCardsCenter, gridCenter);
			
		mainFrame.getContentPane().add(panelCenter, BorderLayout.CENTER);
		
		//SOUTH Panel
		panelSouth = new JPanel(new GridBagLayout());
		gridSouth = new GridBagConstraints();
		panelSouth.setPreferredSize(new Dimension(1600,200));
		
		txtSpielerSouth = new JTextField();
    	txtSpielerSouth.setEditable(false);
    	gridSouth.anchor = GridBagConstraints.LINE_START;
		gridSouth.gridx = 5;
		gridSouth.gridy = 0;
		gridSouth.insets = new Insets(5,5,5,5);
		panelSouth.add(txtSpielerSouth, gridSouth);
		
		txtRoleSouth = new JTextField();
		txtRoleSouth.setEditable(false);
		gridSouth.anchor = GridBagConstraints.LINE_START;
		gridSouth.gridx = 6;
		gridSouth.gridy = 0;
		gridSouth.insets = new Insets(5,5,5,5);
		panelSouth.add(txtRoleSouth, gridSouth);
		
		txtRankSouth = new JTextField();	
		txtRankSouth.setEditable(false);
    	gridSouth.gridx = 7;
		gridSouth.gridy = 0;
		gridSouth.insets = new Insets(5,5,5,5);
		panelSouth.add(txtRankSouth, gridSouth);
		
		for(int i=0; i<12; i++){
			myIcon[i]= new ImageIcon("Bilder/karte"+(i+1)+".jpg");
		}
		
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
		
		for(int i = 0; i < 12; i++){
			lblAmountOfCards[i] = new JLabel();
			lblAmountOfCards[i].setFont(new Font("Arial", Font.BOLD, 35));
    		lblAmountOfCards[i].setForeground(Color.red);
		}
		
		txtTypeCards = new JTextField(12);
		txtTypeCards.setEditable(false);
		gridSouth.anchor = GridBagConstraints.LINE_START;
		gridSouth.gridwidth = 2;
		gridSouth.gridx = 0;
		gridSouth.gridy = 2;
		gridSouth.insets = new Insets(5,5,5,5);
		panelSouth.add(txtTypeCards, gridSouth);
		
		txtAmountCards = new JTextField(3);
		gridSouth.gridwidth = 1;
		gridSouth.anchor = GridBagConstraints.LINE_START;
		gridSouth.gridx = 2;
		gridSouth.gridy = 2;
		gridSouth.insets = new Insets(5,5,5,5);
		panelSouth.add(txtAmountCards, gridSouth);
		
		btnAuswahlSpielen.setText("Auswahl spielen");
		btnAuswahlSpielen.setBackground(Color.GREEN);
		btnAuswahlSpielen.setPreferredSize(new Dimension(170,30));
		btnAuswahlSpielen.setEnabled(false);
		gridSouth.gridwidth = 2;
		gridSouth.gridx = 4;
		gridSouth.gridy = 2;
		gridSouth.insets = new Insets(5,5,5,5);
		panelSouth.add(btnAuswahlSpielen, gridSouth);
		
		btnSwapCards.setText("swap cards");
		btnSwapCards.setBackground(Color.GREEN);
		btnSwapCards.setPreferredSize(new Dimension(170,30));	
		btnSwapCards.setEnabled(false);
		gridSouth.gridwidth = 1;
		gridSouth.gridx = 8;
		gridSouth.gridy = 2;
		gridSouth.insets = new Insets(5,5,5,5);
		panelSouth.add(btnSwapCards, gridSouth);
		
		btnPassen.setText("Passen");
		btnPassen.setBackground(Color.GREEN);
		btnPassen.setPreferredSize(new Dimension(170,30));	
		btnPassen.setEnabled(false);
		gridSouth.gridwidth = 2;
		gridSouth.gridx = 6;
		gridSouth.gridy = 2;
		gridSouth.insets = new Insets(5,5,5,5);
		panelSouth.add(btnPassen, gridSouth);
		
		btnCloseGame = new JButton("Spiel beenden"); // closes game
		btnCloseGame.setPreferredSize(new Dimension(170,30));	
		gridSouth.gridwidth = 2;
		gridSouth.gridx = 10;
		gridSouth.gridy = 2;
		gridSouth.insets = new Insets(5,5,5,5);
		btnCloseGame.setBackground(Color.RED);
		panelSouth.add(btnCloseGame, gridSouth);
						
		mainFrame.getContentPane().add(panelSouth, BorderLayout.SOUTH);
		
	}

    //South Methods
    
    void showInSouth(Player player){
    	
    	txtSpielerSouth.setText(player.getName());
		txtRoleSouth.setText(player.getRole().getLabel());	
		txtRankSouth.setText("Rang: "+player.getRank());
		
		if(player.getRank()==1){
			txtRankSouth.setText("YOU HAVE WON");			
		}
		if(player.getRank()==2){
			txtRankSouth.setText("YOU HAVE PLACED 2nd");
		}
		if(player.getRank()==3){
			txtRankSouth.setText("YOU HAVE PLACED 3rd");
		}
		if(player.getRank()==4){
			txtRankSouth.setText("YOU HAVE LOST");
		}
    	
    }
    
    void showMyCards(int[][] cards){
    	
    	for(int i = 0; i < 12; i++){
    		btnSlot[i].setLayout(new BorderLayout());
    		btnSlot[i].add(lblAmountOfCards[i],BorderLayout.WEST);
    		lblAmountOfCards[i].setText(Integer.toString(cards[i][0]));
    		
    		// for greying out cards
    		if(cards[i][1] == 0){
    			btnSlot[i].setEnabled(false);
    		}
    		else{
    			btnSlot[i].setEnabled(true);
    		}
    	}
    	
    }
    
	
    //West Methods
	void showInWest(Player player){
		
    	txtSpielerWest.setText(player.getName());
		txtRoleWest.setText(player.getRole().getLabel());	
		txtCardsInHandWest.setText(Integer.toString(player.getCards().size()));
		txtRankWest.setText("Rang: "+player.getRank());
		
	}
	
	//North Methods
	
    void showInNorth(Player player){
    	
    	txtSpielerNorth.setText(player.getName());
		txtRoleNorth.setText(player.getRole().getLabel());			
		txtCardsInHandNorth.setText(Integer.toString(player.getCards().size()));
		txtRankNorth.setText("Rang: "+player.getRank());	
		   	
    }
    
    //East Methods
    
	void showInEast(Player player){
		
    	txtSpielerEast.setText(player.getName());
		txtRoleEast.setText(player.getRole().getLabel());			
		txtCardsInHandEast.setText(Integer.toString(player.getCards().size()));
		txtRankEast.setText("Rang: "+player.getRank());
		
	}
	
	//Center Methods
	
	void showCurrentTrick(Card.CARD_TYPE cardtype, int numberOfCards){
    	
    	lblCardsCenter.setIcon(new ImageIcon("Bilder/karte"+cardtype.getValue()+" (2).jpg"));		
		lblNumberOfCardsCenter.setText(Integer.toString(numberOfCards));
		
    }

	void showCurrentTrick(){
		
		lblCardsCenter.setIcon(new ImageIcon(""));		
		lblNumberOfCardsCenter.setText("");
		
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
    
    void addSwapCards(ActionListener listener){
    	btnSwapCards.addActionListener(listener);
    }	
    
    void addPassen(ActionListener listener){
    	btnPassen.addActionListener(listener);
    }
    
    void addAuswahlSpielen(ActionListener listener){
    	btnAuswahlSpielen.addActionListener(listener);
    }	


	
	public void popUp(String titel, String text){
		
		JLabel lblSwap;
		
		JFrame Frame1;
	
	Frame1 = new JFrame();
	Frame1.setTitle(titel);
	Frame1.setSize(400,200);
	Frame1.setLocationRelativeTo(null);
	//Frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	lblSwap = new JLabel("The cards : " + text + "are not valid to swap!");
	lblSwap.setVerticalAlignment(SwingConstants.CENTER);
	lblSwap.setHorizontalAlignment(SwingConstants.CENTER);
	
	Frame1.add(lblSwap);
	Frame1.setVisible(true);
	
	}
}

