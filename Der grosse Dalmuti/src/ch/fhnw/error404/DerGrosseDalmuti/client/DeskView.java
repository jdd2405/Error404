package ch.fhnw.error404.DerGrosseDalmuti.client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * @author Thomas and Elias
 * the following GUI is created on the base of Gridlayout
 * JLabels, JTextField or JButtons are created and Located in the Grid
 */

public class DeskView extends LoginView {
	
	public DeskView() {
		
		ImageIcon icon = new ImageIcon("C:\\Users\\Glaimby\\Pictures\\card.png"); // for test reasons
		
		deskView = new JFrame();
		deskView.setTitle("Der Grosse Dalmuti");
		deskView.setSize(1600,900);
		deskView.setLocationRelativeTo(null);
		deskView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//NORTH Panel
		JPanel Panel = new JPanel(new GridBagLayout());
		GridBagConstraints Grid = new GridBagConstraints();
		
		JLabel Label1 = new JLabel(icon);
		Label1.setPreferredSize(new Dimension(89,92));
		Grid.gridx = 0;
		Grid.gridy = 0;
		Grid.insets = new Insets(5,5,5,5);
		Panel.add(Label1, Grid);
		
		JTextField Spieler2 = new JTextField("Player 1");
		Grid.gridx = 0;
		Grid.gridy = 1;
		Grid.insets = new Insets(5,5,5,5);
		Panel.add(Spieler2, Grid);
		
		Panel.setBackground(Color.BLUE);
		
		deskView.getContentPane().add(Panel, BorderLayout.NORTH);
		deskView.setVisible(true);
		
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
		
		deskView.getContentPane().add(PanelEast, BorderLayout.EAST);
		deskView.setVisible(true);
		
		
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
				
		deskView.getContentPane().add(PanelWest, BorderLayout.WEST);
		deskView.setVisible(true);
		
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
						
		deskView.getContentPane().add(PanelCenter, BorderLayout.CENTER);
		deskView.setVisible(true);
		
		//SOUTH Panel
		JPanel PanelSouth = new JPanel(new GridBagLayout());
		GridBagConstraints GridSouth = new GridBagConstraints();
		
		
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
		
		newPlayer("basmeg");
		
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
		Button3.addActionListener(CloseGame);
		Button3.setPreferredSize(new Dimension(170,30));	
		GridSouth.gridwidth = 2;
		GridSouth.gridx = 10;
		GridSouth.gridy = 2;
		GridSouth.insets = new Insets(5,5,5,5);
		PanelSouth.add(Button3, GridSouth);
		
		
		PanelSouth.setBackground(Color.PINK);
						
		deskView.getContentPane().add(PanelSouth, BorderLayout.SOUTH);
		deskView.setVisible(true);
		
		
	}
	
	
	
}

