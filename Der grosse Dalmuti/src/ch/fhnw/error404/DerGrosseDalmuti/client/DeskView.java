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
	
		private JFrame mainFrame;
		
		private JPanel panelSouth;
		private GridBagConstraints gridSouth;
		private JTextField spielerSouth;
		private JTextField roleSouth;
		private JButton passen;
		private JButton auswahlSpielen;
		private JTextField AmountCards;
		private JButton[] slot = new JButton[12];
		private JLabel[] amountOfCards = new JLabel[12];
		private String a;
		
		private JPanel panelWest;
		private GridBagConstraints gridWest;
		private JTextField spielerWest;
		private JTextField roleWest;
		private JTextField cardsInHandWest;
		
		private JPanel panelNorth;
		private GridBagConstraints gridNorth;
		private JTextField spielerNorth;
		private JTextField roleNorth;
		private JLabel labelNorth;
		private JTextField cardsInHandNorth;
		
		private JPanel panelEast;
		private GridBagConstraints gridEast;
		private JTextField spielerEast;
		private JTextField roleEast;
		private JTextField cardsInHandEast;
		
		private JPanel panelCenter;
		private GridBagConstraints gridCenter;
		private JLabel cardsCenter;
		private JTextField numberOfCardsCenter;
		
		
		private JTextField username;
		private JButton closeGame;
		
		ImageIcon icon = new ImageIcon("Bilder/karte2.jpg");
		ImageIcon[] myIcon = new ImageIcon[12];

	public DeskView() {
		
		myIcon[0] = new ImageIcon("Bilder/karte1.jpg");
		myIcon[1] = new ImageIcon("Bilder/karte2.jpg");
		myIcon[2] = new ImageIcon("Bilder/karte3.jpg");
		myIcon[3] = new ImageIcon("Bilder/karte4.jpg");
		myIcon[4] = new ImageIcon("Bilder/karte5.jpg");
		myIcon[5] = new ImageIcon("Bilder/karte6.jpg");
		myIcon[6] = new ImageIcon("Bilder/karte7.jpg");
		myIcon[7] = new ImageIcon("Bilder/karte8.jpg");
		myIcon[8] = new ImageIcon("Bilder/karte9.jpg");
		myIcon[9] = new ImageIcon("Bilder/karte10.jpg");
		myIcon[10] = new ImageIcon("Bilder/karte11.jpg");
		myIcon[11] = new ImageIcon("Bilder/karte12.jpg");
		
		mainFrame = new JFrame();
		mainFrame.setTitle("Der Grosse Dalmuti");
		mainFrame.setSize(1600,900);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		
		//NORTH Panel
		panelNorth = new JPanel(new GridBagLayout());
		gridNorth = new GridBagConstraints();
		
		labelNorth = new JLabel(icon);
		labelNorth.setPreferredSize(new Dimension(89,92));
		gridNorth.gridx = 0;
		gridNorth.gridy = 0;
		gridNorth.insets = new Insets(5,5,5,5);
		panelNorth.add(labelNorth, gridNorth);
		
		panelNorth.setBackground(Color.BLUE);
		
		mainFrame.getContentPane().add(panelNorth, BorderLayout.NORTH);
		
		//EAST Panel
		panelEast = new JPanel(new GridBagLayout());
		gridEast = new GridBagConstraints();
		
		JLabel Label2 = new JLabel(icon);
		Label2.setPreferredSize(new Dimension(89,92));
		
		gridEast.gridx = 0;
		gridEast.gridy = 0;
		gridEast.insets = new Insets(5,5,5,5);
		panelEast.add(Label2, gridEast);
		
		panelEast.setBackground(Color.GREEN);
		
		mainFrame.getContentPane().add(panelEast, BorderLayout.EAST);
		
		
		//WEST Panel
		panelWest = new JPanel(new GridBagLayout());
		gridWest = new GridBagConstraints();
				
		JLabel Label3 = new JLabel(icon);
		Label3.setPreferredSize(new Dimension(89,92));
				
		gridWest.gridx = 0;
		gridWest.gridy = 0;
		gridWest.insets = new Insets(5,5,5,5);
		panelWest.add(Label3, gridWest);
		
		panelWest.setBackground(Color.RED);
				
		mainFrame.getContentPane().add(panelWest, BorderLayout.WEST);
		
		//CENTER Panel
		panelCenter = new JPanel(new GridBagLayout());
		gridCenter = new GridBagConstraints();
										
		panelCenter.setBackground(Color.YELLOW);
						
		mainFrame.getContentPane().add(panelCenter, BorderLayout.CENTER);
		
		//SOUTH Panel
		panelSouth = new JPanel(new GridBagLayout());
		gridSouth = new GridBagConstraints();
		
		for(int i = 0; i<12; i++){
    		slot[i] = new JButton();
    	    slot[i].setIcon(myIcon[i]);//here you set the icon for your button
    		slot[i].setPreferredSize(new Dimension(89,92));
    		slot[i].setContentAreaFilled(false);
    		gridSouth.gridx = i;
    		gridSouth.gridy = 1;
    		gridSouth.insets = new Insets(5,5,5,5);
    		panelSouth.add(slot[i], gridSouth);
    	}
		
		/*JButton gDalmi = new JButton(icon);
		gDalmi.setContentAreaFilled(false);
		gDalmi.setPreferredSize(new Dimension(89,92));
		gridSouth.gridx = 0;
		gridSouth.gridy = 1;
		gridSouth.insets = new Insets(5,5,5,5);
		panelSouth.add(gDalmi, gridSouth);*/
		
		setAmountCards(new JTextField(a));
		gridSouth.anchor = GridBagConstraints.LINE_START;
		gridSouth.gridx = 3;
		gridSouth.gridy = 2;
		gridSouth.insets = new Insets(5,5,5,5);
		panelSouth.add(getAmountCards(), gridSouth);
		
		JLabel Anzahl = new JLabel("Number of chosen cards:");
		gridSouth.gridwidth = 2;
		gridSouth.anchor = GridBagConstraints.LINE_END;
		gridSouth.gridx = 1;
		gridSouth.gridy = 2;
		gridSouth.insets = new Insets(5,5,5,5);
		panelSouth.add(Anzahl, gridSouth);
		
		
		auswahlSpielen= new JButton("Auswahl spielen");
		auswahlSpielen.setPreferredSize(new Dimension(170,30));
		gridSouth.gridwidth = 2;
		gridSouth.gridx = 4;
		gridSouth.gridy = 2;
		gridSouth.insets = new Insets(5,5,5,5);
		panelSouth.add(auswahlSpielen, gridSouth);
		
		passen = new JButton("Passen");
		passen.setPreferredSize(new Dimension(170,30));	
		gridSouth.gridwidth = 2;
		gridSouth.gridx = 6;
		gridSouth.gridy = 2;
		gridSouth.insets = new Insets(5,5,5,5);
		panelSouth.add(passen, gridSouth);
		
		closeGame = new JButton("Spiel beenden"); // closes game
		closeGame.setPreferredSize(new Dimension(170,30));	
		gridSouth.gridwidth = 2;
		gridSouth.gridx = 10;
		gridSouth.gridy = 2;
		gridSouth.insets = new Insets(5,5,5,5);
		panelSouth.add(closeGame, gridSouth);
		
		panelSouth.setBackground(Color.PINK);
						
		mainFrame.getContentPane().add(panelSouth, BorderLayout.SOUTH);
		
	}

    //South Methods
    
    void showInSouth(Player player){
    	spielerSouth = new JTextField(player.getName());
    	gridSouth.gridwidth = 2;
		gridSouth.gridx = 5;
		gridSouth.gridy = 0;
		gridSouth.insets = new Insets(5,5,5,5);
		panelSouth.add(spielerSouth, gridSouth);
		
		roleSouth = new JTextField((player.getRole()).getLabel());
		gridSouth.gridwidth = 2;
		gridSouth.gridx = 7;
		gridSouth.gridy = 0;
		gridSouth.insets = new Insets(5,5,5,5);
		panelSouth.add(spielerSouth, gridSouth);
    }
    
    void showMyCards(int[][] cards){
    	
    	for(int i = 0; i < 12; i++){
    		slot[i].setLayout(new BorderLayout());
    		slot[i].add(amountOfCards[i] = new JLabel(Integer.toString(cards[i][0])),BorderLayout.WEST);
    		amountOfCards[i].setFont(new Font("Arial", Font.BOLD, 35));
    		amountOfCards[i].setForeground(Color.red);
    		/*gridSouth.gridx = i;
    		gridSouth.gridy = 1;
    		gridSouth.insets = new Insets(5,5,5,5);
    		panelSouth.add(amountOfDisplayedCards, gridSouth);*/
    		
    		// for greying out cards for(int i = 0; i < 12; i++){
    		if(cards[i][1] == 0){
    			slot[i].setEnabled(false);
    		}
    	}
    	
    }
    
	
    //West Methods
	void showInWest(Player player){
		
    	spielerWest = new JTextField(player.getName());
    	gridWest.gridx = 0;
		gridWest.gridy = 1;
		gridWest.insets = new Insets(5,5,5,5);
		panelWest.add(spielerWest, gridWest);
		

		roleWest = new JTextField((player.getRole()).getLabel());	
    	gridWest.gridx = 1;
		gridWest.gridy = 0;
		gridWest.insets = new Insets(5,5,5,5);
		panelWest.add(roleWest, gridWest);
		
		cardsInHandWest = new JTextField((player.getCards()).size());
		gridWest.gridx = 0;
		gridWest.gridy = 0;
		gridWest.insets = new Insets(5,5,5,5);
		panelWest.add(cardsInHandWest, gridWest);
	
	}
	
	//North Methods
	
    void showInNorth(Player player){
    	
    	spielerNorth = new JTextField(player.getName());
    	gridNorth.gridx = 0;
		gridNorth.gridy = 1;
		gridNorth.insets = new Insets(5,5,5,5);
		panelNorth.add(spielerNorth, gridNorth);
		
		roleNorth = new JTextField((player.getRole()).getLabel());	
    	gridNorth.gridx = 1;
		gridNorth.gridy = 0;
		gridNorth.insets = new Insets(5,5,5,5);
		panelNorth.add(roleNorth, gridNorth);
		
		cardsInHandNorth = new JTextField((player.getCards()).size());
		gridNorth.gridx = 0;
		gridNorth.gridy = 0;
		gridNorth.insets = new Insets(5,5,5,5);
		panelNorth.add(cardsInHandNorth, gridNorth);
		   
    	
    }
    
    //East Methods
    
	void showInEast(Player player){
		
		spielerEast = new JTextField(player.getName());
		gridEast.gridx = 0;
		gridEast.gridy = 1;
		gridEast.insets = new Insets(5,5,5,5);
		panelEast.add(spielerEast, gridEast);
		
		roleEast = new JTextField((player.getRole()).getLabel());	
		gridEast.gridx = 1;
		gridEast.gridy = 0;
		gridEast.insets = new Insets(5,5,5,5);
		panelEast.add(roleEast, gridEast);
		
		cardsInHandEast = new JTextField((player.getCards()).size());
		gridEast.gridx = 0;
		gridEast.gridy = 0;
		gridEast.insets = new Insets(5,5,5,5);
		panelEast.add(cardsInHandEast, gridEast);
	}
	
	//Center Methods
	
    void showCurrentTrick(Card.CARD_TYPE cardtype, int numberOfCards){
    	
    	cardsCenter = new JLabel(cardtype.getLabel());
    	cardsCenter.setPreferredSize(new Dimension(89,92));		
		gridCenter.gridx = 0;
		gridCenter.gridy = 0;
		gridCenter.insets = new Insets(5,5,5,5);
		panelCenter.add(cardsCenter, gridCenter);
		
		numberOfCardsCenter = new JTextField(numberOfCards);
		gridCenter.gridx = 0;
		gridCenter.gridy = 1;
		gridCenter.insets = new Insets(5,5,5,5);
		panelCenter.add(cardsCenter, gridCenter);
		
		
    }
	
	//Other Methods
    
    void getTextOfLabel(){
    		//a = amountOfCards.getText();
    		System.out.println();
    		
    	}
    
    
    void addDisplayNumber(ActionListener listener){
    	for (int i=0;i<12;i++){
    		slot[i].addActionListener(listener);
    	}
    }
	
    void addCloseGame(ActionListener listener) {
        closeGame.addActionListener(listener);
    }
    void closeWindow(){
        mainFrame.dispose();
        mainFrame.setVisible(false);
    }
    
    void addPassen(ActionListener listener){
    	passen.addActionListener(listener);
    }
    
    void addAuswahlSpielen(ActionListener listener){
    	auswahlSpielen.addActionListener(listener);
    }
	public JTextField getAmountCards() {return AmountCards;}
	public void setAmountCards(JTextField amountCards) {AmountCards = amountCards;}
	

}

