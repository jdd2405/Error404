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
	
		private JFrame deskView;
		
		private JPanel panelSouth;
		private GridBagConstraints gridSouth;
		private JTextField spielerSouth;
		private JTextField roleSouth;
		private JButton Button2;
		
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
		
		ImageIcon gDalmuti = new ImageIcon(ImageIcon.class.getResource("\\Error404\\Karten\\karte1.jpg"));


		
		/*void DisplayCard(int NOfCard, Card card, ActionListener listener){
			for (int i = 0; i < numberCards; i++){ // creates the button with all the cards
				cards[i] = new testclass(icon, i);
				cards[i].setContentAreaFilled(false);
				cards[i].setPreferredSize(new Dimension(89,92));
				cards[i].addActionListener(DisplayCards);
				GridSouth.gridx = i;
				GridSouth.gridy = 1;
				GridSouth.insets = new Insets(5,5,5,5);
				PanelSouth.add(cards[i], GridSouth);
			}
		}*/

		
	
	public DeskView() {
		
		ImageIcon icon = new ImageIcon("C:\\Users\\Glaimby\\Pictures\\card.png"); // for test reasons
		
		
		deskView = new JFrame();
		deskView.setTitle("Der Grosse Dalmuti");
		deskView.setSize(1600,900);
		deskView.setLocationRelativeTo(null);
		deskView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		
		deskView.getContentPane().add(panelNorth, BorderLayout.NORTH);
		deskView.setVisible(true);
		
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
		
		deskView.getContentPane().add(panelEast, BorderLayout.EAST);
		deskView.setVisible(true);
		
		
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
				
		deskView.getContentPane().add(panelWest, BorderLayout.WEST);
		deskView.setVisible(true);
		
		//CENTER Panel
		panelCenter = new JPanel(new GridBagLayout());
		gridCenter = new GridBagConstraints();
										
		panelCenter.setBackground(Color.YELLOW);
						
		deskView.getContentPane().add(panelCenter, BorderLayout.CENTER);
		deskView.setVisible(true);
		
		//SOUTH Panel
		panelSouth = new JPanel(new GridBagLayout());
		gridSouth = new GridBagConstraints();
		
		JButton gDalmi = new JButton(gDalmuti);
		gDalmi.setContentAreaFilled(false);
		gDalmi.setPreferredSize(new Dimension(89,92));
		gridSouth.gridx = 0;
		gridSouth.gridy = 1;
		gridSouth.insets = new Insets(5,5,5,5);
		panelSouth.add(gDalmi, gridSouth);
		
		JTextField AmountCards = new JTextField("A");
		gridSouth.anchor = GridBagConstraints.LINE_START;
		gridSouth.gridx = 3;
		gridSouth.gridy = 2;
		gridSouth.insets = new Insets(5,5,5,5);
		panelSouth.add(AmountCards, gridSouth);
		
		JLabel Anzahl = new JLabel("Number of chosen cards:");
		gridSouth.gridwidth = 2;
		gridSouth.anchor = GridBagConstraints.LINE_END;
		gridSouth.gridx = 1;
		gridSouth.gridy = 2;
		gridSouth.insets = new Insets(5,5,5,5);
		panelSouth.add(Anzahl, gridSouth);
		
		
		JButton Button1 = new JButton("Auswahl spielen");
		Button1.setPreferredSize(new Dimension(170,30));
		gridSouth.gridwidth = 2;
		gridSouth.gridx = 4;
		gridSouth.gridy = 2;
		gridSouth.insets = new Insets(5,5,5,5);
		panelSouth.add(Button1, gridSouth);
		
		Button2 = new JButton("Passen");
		Button2.setPreferredSize(new Dimension(170,30));	
		gridSouth.gridwidth = 2;
		gridSouth.gridx = 6;
		gridSouth.gridy = 2;
		gridSouth.insets = new Insets(5,5,5,5);
		panelSouth.add(Button2, gridSouth);
		
		closeGame = new JButton("Spiel beenden"); // closes game
		closeGame.setPreferredSize(new Dimension(170,30));	
		gridSouth.gridwidth = 2;
		gridSouth.gridx = 10;
		gridSouth.gridy = 2;
		gridSouth.insets = new Insets(5,5,5,5);
		panelSouth.add(closeGame, gridSouth);
		
		panelSouth.setBackground(Color.PINK);
						
		deskView.getContentPane().add(panelSouth, BorderLayout.SOUTH);
		deskView.setVisible(true);
		
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
    public JButton getButton2() {return Button2;}
	public void setButton2(JButton button2) {Button2 = button2;}
    
	
	
    //West Methods
	void showInWest(Player player){
		
    	spielerWest = new JTextField(player.getName());
    	gridWest.gridx = 0;
		gridWest.gridy = 1;
		gridWest.insets = new Insets(5,5,5,5);
		panelWest.add(spielerWest, gridWest);
		
		if(roleSouth.getText() == "grosser Dalmuti"){
			roleWest = new JTextField("kleiner Dalmuti");
		}
		else if(roleSouth.getText() == "kleiner Dalmuti"){
			roleWest = new JTextField("kleiner Diener");
		}
		else if(roleSouth.getText() == "kleiner Diener"){
			roleWest = new JTextField("grosser Diener");
		}
		else if(roleSouth.getText() == "grosser Diener"){
			roleWest = new JTextField("grosser Dalmuti");
		}
		else{
			roleWest = new JTextField("Bürger");
		}
			
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
		
    	if(roleSouth.getText() == "grosser Dalmuti"){
			roleNorth = new JTextField("kleiner Diener");
		}
		else if(roleSouth.getText() == "kleiner Dalmuti"){
			roleNorth = new JTextField("grosser Diener");
		}
		else if(roleSouth.getText() == "kleiner Diener"){
			roleNorth = new JTextField("grosser Dalmuti");
		}
		else if(roleSouth.getText() == "grosser Diener"){
			roleNorth = new JTextField("kleiner Dalmuti");
		}
		else{
			roleNorth = new JTextField("Bürger");
		}
    	
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
		
		if(roleSouth.getText() == "grosser Dalmuti"){
			roleEast = new JTextField("grosser Diener");
		}
		else if(roleSouth.getText() == "kleiner Dalmuti"){
			roleEast = new JTextField("grosser Dalmuti");
		}
		else if(roleSouth.getText() == "kleiner Diener"){
			roleEast = new JTextField("kleiner Dalmuti");
		}
		else if(roleSouth.getText() == "grosser Diener"){
			roleEast = new JTextField("kleiner Diener");
		}
		else{
			roleEast = new JTextField("Bürger");
		}
		
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
	
    void addCloseGame(ActionListener listener) {
        closeGame.addActionListener(listener);
    }
    void closeWindow(){
        deskView.dispose();
        deskView.setVisible(false);
    }
    

}

