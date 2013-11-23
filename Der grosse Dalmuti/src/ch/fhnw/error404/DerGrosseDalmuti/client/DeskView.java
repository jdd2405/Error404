package ch.fhnw.error404.DerGrosseDalmuti.client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ch.fhnw.error404.DerGrosseDalmuti.client.Action;
import ch.fhnw.error404.DerGrosseDalmuti.shared.Player;
/**
 * @author Thomas and Elias
 * the following GUI is created on the base of Gridlayout
 * JLabels, JTextField or JButtons are created and Located in the Grid
 */

public class DeskView extends LoginView {
	
	private static final int numberCards = 12;
	
	private JFrame Frame1;
	private JButton playCards;
	private JButton pass;
	private JButton quit;
	private JTextField numberOfCards;
	private JButton card[];
	private JDialog errorMsg;
	private static int countCardsToPlay;
	
	// objects used to count on GUI (testing phase)
	JLabel AmountCards = new JLabel(countCardsToPlay+" "); 
	JButton[] cards = new JButton[numberCards];
	int[] counter = new int[numberCards];
	
	
	public DeskView() {
		
		ImageIcon icon = new ImageIcon("C:\\Users\\Glaimby\\Pictures\\card.png"); // for test reasons
		
		Frame1 = new JFrame();
		Frame1.setTitle("Der Grosse Dalmuti");
		Frame1.setSize(1600,900);
		Frame1.setLocationRelativeTo(null);
		Frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//NORTH Panel
		JPanel Panel = new JPanel(new GridBagLayout());
		GridBagConstraints Grid = new GridBagConstraints();
		
		JLabel Label1 = new JLabel(icon);
		Label1.setPreferredSize(new Dimension(89,92));
		Grid.gridx = 0;
		Grid.gridy = 0;
		Grid.insets = new Insets(5,5,5,5);
		Panel.add(Label1, Grid);
		
		JTextField Spieler2 = new JTextField("Spieler 2");
		Grid.gridx = 0;
		Grid.gridy = 1;
		Grid.insets = new Insets(5,5,5,5);
		Panel.add(Spieler2, Grid);
		
		Panel.setBackground(Color.BLUE);
		
		Frame1.getContentPane().add(Panel, BorderLayout.NORTH);
		Frame1.setVisible(true);
		
		//EAST Panel
		JPanel PanelEast = new JPanel(new GridBagLayout());
		GridBagConstraints GridEast = new GridBagConstraints();
		
		JLabel Label2 = new JLabel(icon);
		Label2.setPreferredSize(new Dimension(89,92));
		
		GridEast.gridx = 0;
		GridEast.gridy = 0;
		GridEast.insets = new Insets(5,5,5,5);
		PanelEast.add(Label2, GridEast);
		
		JTextField Spieler1 = new JTextField("Spieler 1");
		GridEast.gridx = 0;
		GridEast.gridy = 1;
		GridEast.insets = new Insets(5,5,5,5);
		PanelEast.add(Spieler1, GridEast);
		
		PanelEast.setBackground(Color.GREEN);
		
		Frame1.getContentPane().add(PanelEast, BorderLayout.EAST);
		Frame1.setVisible(true);
		
		
		//WEST Panel
		JPanel PanelWest = new JPanel(new GridBagLayout());
		GridBagConstraints GridWest = new GridBagConstraints();
				
		JLabel Label3 = new JLabel(icon);
		Label3.setPreferredSize(new Dimension(89,92));
				
		GridWest.gridx = 0;
		GridWest.gridy = 0;
		GridWest.insets = new Insets(5,5,5,5);
		PanelWest.add(Label3, GridWest);
				
		JTextField Spieler3 = new JTextField("Spieler 3");
		GridWest.gridx = 0;
		GridWest.gridy = 1;
		GridWest.insets = new Insets(5,5,5,5);
		PanelWest.add(Spieler3, GridWest);
				
		PanelWest.setBackground(Color.RED);
				
		Frame1.getContentPane().add(PanelWest, BorderLayout.WEST);
		Frame1.setVisible(true);
		
		//CENTER Panel
		JPanel PanelCenter = new JPanel(new GridBagLayout());
		GridBagConstraints GridCenter = new GridBagConstraints();
						
		JLabel Label4 = new JLabel(icon);
		Label4.setPreferredSize(new Dimension(89,92));
						
		GridCenter.gridx = 0;
		GridCenter.gridy = 0;
		GridCenter.insets = new Insets(5,5,5,5);
		PanelCenter.add(Label4, GridCenter);
						
		PanelCenter.setBackground(Color.YELLOW);
						
		Frame1.getContentPane().add(PanelCenter, BorderLayout.CENTER);
		Frame1.setVisible(true);
		
		//SOUTH Panel
		JPanel PanelSouth = new JPanel(new GridBagLayout());
		GridBagConstraints GridSouth = new GridBagConstraints();
		
		
		for (int i = 0; i < numberCards; i++){ // creates the button with all the cards
			cards[i] = new JButton(icon);
			cards[i].setContentAreaFilled(false);
			cards[i].setPreferredSize(new Dimension(89,92));
			cards[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					calculate();
				}
			});
			GridSouth.gridx = i;
			GridSouth.gridy = 1;
			GridSouth.insets = new Insets(5,5,5,5);
			PanelSouth.add(cards[i], GridSouth);
		}
		
		GridSouth.anchor = GridBagConstraints.LINE_START;
		GridSouth.gridx = 3;
		GridSouth.gridy = 2;
		GridSouth.insets = new Insets(5,5,5,5);
		PanelSouth.add(AmountCards, GridSouth);
		
		JLabel Anzahl = new JLabel("Number of chosen cards:");
		GridSouth.gridwidth = 2;
		GridSouth.anchor = GridBagConstraints.LINE_END;
		GridSouth.gridx = 1;
		GridSouth.gridy = 2;
		GridSouth.insets = new Insets(5,5,5,5);
		PanelSouth.add(Anzahl, GridSouth);
		
		JTextField Spieler4 = new JTextField((allPlayers.get(0)).getName()); //funktioniert nur wenn ArrayList public static oder der Server sie wieder zurückschickt?
		GridSouth.gridwidth = 2;
		GridSouth.gridx = 5;
		GridSouth.gridy = 0;
		GridSouth.insets = new Insets(5,5,5,5);
		PanelSouth.add(Spieler4, GridSouth);
		
		JButton Button1 = new JButton("Auswahl spielen");
		Button1.setPreferredSize(new Dimension(170,30));
		GridSouth.gridwidth = 2;
		GridSouth.gridx = 4;
		GridSouth.gridy = 2;
		GridSouth.insets = new Insets(5,5,5,5);
		PanelSouth.add(Button1, GridSouth);
		
		JButton Button2 = new JButton("Passen");
		Button2.setPreferredSize(new Dimension(170,30));	
		GridSouth.gridwidth = 2;
		GridSouth.gridx = 6;
		GridSouth.gridy = 2;
		GridSouth.insets = new Insets(5,5,5,5);
		PanelSouth.add(Button2, GridSouth);
		
		JButton Button3 = new JButton("Spiel beenden"); // closes game
		Button3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Frame1.dispose();		
			}
		});
		Button3.setPreferredSize(new Dimension(170,30));	
		GridSouth.gridwidth = 2;
		GridSouth.gridx = 10;
		GridSouth.gridy = 2;
		GridSouth.insets = new Insets(5,5,5,5);
		PanelSouth.add(Button3, GridSouth);
		
		
		PanelSouth.setBackground(Color.PINK);
						
		Frame1.getContentPane().add(PanelSouth, BorderLayout.SOUTH);
		Frame1.setVisible(true);
		
		
	}
	
	public void calculate(){ // calculates the cards selected and sums them up (testing phase)
		   countCardsToPlay++;
		   this.AmountCards.setText(" " + countCardsToPlay + " ");
		} 
	
	
}

