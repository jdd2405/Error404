package ch.fhnw.error404.DerGrosseDalmuti.client;

import java.awt.*;
import java.awt.event.ActionListener;

import ch.fhnw.error404.DerGrosseDalmuti.shared.*;

import javax.swing.*;

/**
 * @author Thomas and Elias
 * the following GUI is created on the base of GridBagLayout
 * JLabels, JTextField or JButtons are created and Located in the Grid
 */

@SuppressWarnings("serial")
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
		JLabel lblCardsWest;
		JLabel lblCardsInHandWest;
		JTextField txtRankWest;
		
		private JPanel panelNorth;
		private GridBagConstraints gridNorth;
		JTextField txtSpielerNorth;
		JTextField txtRoleNorth;
		JLabel lblCardsNorth;
		JLabel lblCardsInHandNorth;
		JTextField txtRankNorth;
		
		private JPanel panelEast;
		private GridBagConstraints gridEast;
		JTextField txtSpielerEast;
		JTextField txtRoleEast;
		JLabel lblCardsEast;
		JLabel lblCardsInHandEast;
		JTextField txtRankEast;
		
		private JPanel panelCenter;
		private GridBagConstraints gridCenter;
		JLabel lblCardsCenter;
		JLabel lblNumberOfCardsCenter;
		
		ImageIcon icon = new ImageIcon("Bilder/cards_s.png");
		ImageIcon[] myIcon = new ImageIcon[12];

	public DeskView() {
		mainFrame = new JFrame();
		/*Find a solution to get this image in the background and get a free beer from Thomas
		  try {
			mainFrame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("Bilder/test_bg.jpg")))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		mainFrame.pack();
		mainFrame.setTitle("Der Grosse Dalmuti");
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		mainFrame.setSize(w,h);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(false);
		
		//NORTH Panel
		panelNorth = new JPanel(new GridBagLayout());
		gridNorth = new GridBagConstraints();
		panelNorth.setPreferredSize(new Dimension(1600,200));
		
		lblCardsNorth = new JLabel(icon);
		lblCardsNorth.setLayout(new BorderLayout());
		lblCardsNorth.setPreferredSize(new Dimension(89,92));
		gridNorth.gridx = 0;
		gridNorth.gridy = 0;
		gridNorth.insets = new Insets(5,5,5,5);
		
		lblCardsInHandNorth = new JLabel();
		lblCardsInHandNorth.setFont(new Font("Arial", Font.ITALIC, 20));
		lblCardsInHandNorth.setBorder(null);
		lblCardsInHandNorth.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblCardsNorth.add(lblCardsInHandNorth);
		panelNorth.add(lblCardsNorth, gridNorth);
		
    	txtSpielerNorth = new JTextField();
    	txtSpielerNorth.setFont(new Font("Arial", Font.BOLD, 25));
    	txtSpielerNorth.setBorder(null);
    	txtSpielerNorth.setOpaque(false);
    	txtSpielerNorth.setEditable(false);
    	gridNorth.gridx = 0;
		gridNorth.gridy = 1;
		gridNorth.insets = new Insets(5,5,5,5);
		panelNorth.add(txtSpielerNorth, gridNorth);
		
		txtRoleNorth = new JTextField();
		txtRoleNorth.setFont(new Font("Arial", Font.ITALIC, 15));
		txtRoleNorth.setBorder(null);
		txtRoleNorth.setOpaque(false);
		txtRoleNorth.setEditable(false);
    	gridNorth.gridx = 1;
		gridNorth.gridy = 0;
		gridNorth.insets = new Insets(5,5,5,5);
		panelNorth.add(txtRoleNorth, gridNorth);
		
		txtRankNorth = new JTextField();	
		txtRankNorth.setBorder(null);
		txtRankNorth.setOpaque(false);
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
		
		lblCardsEast = new JLabel(icon);
		lblCardsEast.setLayout(new BorderLayout());
		lblCardsEast.setPreferredSize(new Dimension(89,92));
		gridEast.gridx = 0;
		gridEast.gridy = 0;
		gridEast.insets = new Insets(5,5,5,5);
		
		lblCardsInHandEast = new JLabel();
		lblCardsInHandEast.setFont(new Font("Arial", Font.ITALIC, 20));
		lblCardsInHandEast.setBorder(null);
		lblCardsInHandEast.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblCardsEast.add(lblCardsInHandEast);
		panelEast.add(lblCardsEast, gridEast);
		
		txtSpielerEast = new JTextField();
		txtSpielerEast.setFont(new Font("Arial", Font.BOLD, 25));
		txtSpielerEast.setBorder(null);
		txtSpielerEast.setOpaque(false);
		txtSpielerEast.setEditable(false);
		gridEast.gridx = 0;
		gridEast.gridy = 1;
		gridEast.insets = new Insets(5,5,5,5);
		panelEast.add(txtSpielerEast, gridEast);
		
		txtRoleEast = new JTextField();
		txtRoleEast.setFont(new Font("Arial", Font.ITALIC, 15));
		txtRoleEast.setBorder(null);
		txtRoleEast.setOpaque(false);
		txtRoleEast.setEditable(false);
		gridEast.gridx = 1;
		gridEast.gridy = 0;
		gridEast.insets = new Insets(5,5,5,5);
		panelEast.add(txtRoleEast, gridEast);
		
		txtRankEast = new JTextField();	
		txtRankEast.setBorder(null);
		txtRankEast.setOpaque(false);
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
				
		lblCardsWest = new JLabel(icon);
		lblCardsWest.setLayout(new BorderLayout());
		lblCardsWest.setPreferredSize(new Dimension(89,92));
		gridWest.gridx = 0;
		gridWest.gridy = 0;
		gridWest.insets = new Insets(5,5,5,5);
		
		lblCardsInHandWest = new JLabel();
		lblCardsInHandWest.setFont(new Font("Arial", Font.ITALIC, 20));
		lblCardsInHandWest.setBorder(null);
		lblCardsInHandWest.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblCardsWest.add(lblCardsInHandWest);
		panelWest.add(lblCardsWest, gridWest);
		
	   	txtSpielerWest = new JTextField();
	   	txtSpielerWest.setFont(new Font("Arial", Font.BOLD, 25));
		txtSpielerWest.setBorder(null);
		txtSpielerWest.setOpaque(false);
		txtSpielerWest.setEditable(false);
    	gridWest.gridx = 0;
		gridWest.gridy = 1;
		gridWest.insets = new Insets(5,5,5,5);
		panelWest.add(txtSpielerWest, gridWest);
		
		txtRoleWest = new JTextField();	
		txtRoleWest.setFont(new Font("Arial", Font.ITALIC, 15));
		txtRoleWest.setBorder(null);
		txtRoleWest.setOpaque(false);
		txtRoleWest.setEditable(false);
    	gridWest.gridx = 1;
		gridWest.gridy = 0;
		gridWest.insets = new Insets(5,5,5,5);
		panelWest.add(txtRoleWest, gridWest);
		
		txtRankWest = new JTextField();	
		txtRankWest.setBorder(null);
		txtRankWest.setOpaque(false);
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
		lblNumberOfCardsCenter.setHorizontalAlignment(SwingConstants.CENTER);
		lblCardsCenter.add(lblNumberOfCardsCenter);
		
		panelCenter.add(lblCardsCenter, gridCenter);
			
		mainFrame.getContentPane().add(panelCenter, BorderLayout.CENTER);
		
		//SOUTH Panel
		panelSouth = new JPanel(new GridBagLayout());
		gridSouth = new GridBagConstraints();
		panelSouth.setPreferredSize(new Dimension(1600,200));
		
		txtSpielerSouth = new JTextField();
		txtSpielerSouth.setFont(new Font("Arial", Font.BOLD, 25));
		txtSpielerSouth.setBorder(null);
		txtSpielerSouth.setOpaque(false);
		txtSpielerSouth.setEditable(false);
    	gridSouth.anchor = GridBagConstraints.LINE_START;
		gridSouth.gridx = 5;
		gridSouth.gridy = 0;
		gridSouth.insets = new Insets(5,5,5,5);
		panelSouth.add(txtSpielerSouth, gridSouth);
		
		txtRoleSouth = new JTextField();
		txtRoleSouth.setFont(new Font("Arial", Font.ITALIC, 15));
		txtRoleSouth.setBorder(null);
		txtRoleSouth.setOpaque(false);
		txtRoleSouth.setEditable(false);
		gridSouth.anchor = GridBagConstraints.LINE_START;
		gridSouth.gridx = 6;
		gridSouth.gridy = 0;
		gridSouth.insets = new Insets(5,5,5,5);
		panelSouth.add(txtRoleSouth, gridSouth);
		
		txtRankSouth = new JTextField();	
		txtRankSouth.setBorder(null);
		txtRankSouth.setOpaque(false);
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
    	    btnSlot[i].setIcon(myIcon[i]);
    		btnSlot[i].setPreferredSize(new Dimension(89,92));
    		btnSlot[i].setOpaque(false);
    		btnSlot[i].setBorderPainted(false);
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
    		lblAmountOfCards[i].setHorizontalAlignment(SwingConstants.CENTER);
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
		
		btnCloseGame = new JButton("Spiel beenden");
		btnCloseGame.setPreferredSize(new Dimension(170,30));	
		gridSouth.gridwidth = 2;
		gridSouth.gridx = 10;
		gridSouth.gridy = 2;
		gridSouth.insets = new Insets(5,5,5,5);
		btnCloseGame.setBackground(Color.RED);
		panelSouth.add(btnCloseGame, gridSouth);
						
		mainFrame.getContentPane().add(panelSouth, BorderLayout.SOUTH);
		
	}

    /**
     * South Methods
     */
    
	/**
	 * showButtons
	 * @param hasSwappedCards
	 * changes between play, pass and swap buttons
	 */
	
	void showButtons(boolean hasSwappedCards){
		
		btnPassen.setVisible(false); 
		btnAuswahlSpielen.setVisible(false); 
		btnSwapCards.setVisible(false);   
		btnPassen.repaint(); 
		btnAuswahlSpielen.repaint();
		btnSwapCards.repaint();
		panelSouth.remove(btnAuswahlSpielen);
		panelSouth.remove(btnPassen);
		panelSouth.remove(btnSwapCards);
		
		if (hasSwappedCards == true){
			
			btnAuswahlSpielen.setText("Auswahl spielen");
			btnAuswahlSpielen.setBackground(Color.GREEN);
			btnAuswahlSpielen.setPreferredSize(new Dimension(170,30));
			btnAuswahlSpielen.setEnabled(false);
			btnAuswahlSpielen.setVisible(true);
			gridSouth.gridwidth = 2;
			gridSouth.gridx = 4;
			gridSouth.gridy = 2;
			gridSouth.insets = new Insets(5,5,5,5);
			panelSouth.add(btnAuswahlSpielen, gridSouth);
			
			btnPassen.setText("Passen");
			btnPassen.setBackground(Color.GREEN);
			btnPassen.setPreferredSize(new Dimension(170,30));	
			btnPassen.setEnabled(false);
			btnPassen.setVisible(true);
			gridSouth.gridwidth = 2;
			gridSouth.gridx = 6;
			gridSouth.gridy = 2;
			gridSouth.insets = new Insets(5,5,5,5);
			panelSouth.add(btnPassen, gridSouth);
		
		} 
		else{
		
			btnSwapCards.setText("Karten tauschen");
			btnSwapCards.setBackground(Color.YELLOW);
			btnSwapCards.setPreferredSize(new Dimension(170,30));	
			btnSwapCards.setEnabled(false);
			btnSwapCards.setVisible(true);
			gridSouth.gridwidth = 2;
			gridSouth.gridx = 4;
			gridSouth.gridy = 2;
			gridSouth.insets = new Insets(5,5,5,5);
			panelSouth.add(btnSwapCards, gridSouth);
			
		}
	}
	
	/**
	 * showInSouth
	 * @param player
	 * shows and updates the south part of the GUI
	 */
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
    
    /**
     * showMyCards
     * @param cards
     * shows Cards and their Amount in GUI 
     */
    
    void showMyCards(int[][] cards){
    	
    	for(int i = 0; i < 12; i++){
    		btnSlot[i].setLayout(new BorderLayout());
    		btnSlot[i].add(lblAmountOfCards[i]);
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
    
	
    /**
	 * showInWest
	 * @param player
	 * shows and updates the west part of the GUI
	 */
    
	void showInWest(Player player){
		
    	txtSpielerWest.setText(player.getName());
		txtRoleWest.setText(player.getRole().getLabel());	
		lblCardsInHandWest.setText(Integer.toString(player.getCards().size()));
		txtRankWest.setText("Rang: "+player.getRank());
		
	}
	
	/**
	 * showInNorth
	 * @param player
	 * shows and updates the north of the GUI
	 */
	
    void showInNorth(Player player){
    	
    	txtSpielerNorth.setText(player.getName());
		txtRoleNorth.setText(player.getRole().getLabel());			
		lblCardsInHandNorth.setText(Integer.toString(player.getCards().size()));
		txtRankNorth.setText("Rang: "+player.getRank());	
		   	
    }
    
    /**
	 * showInEast
	 * @param player
	 * shows and updates the East part of the GUI
	 */
    
	void showInEast(Player player){
		
    	txtSpielerEast.setText(player.getName());
		txtRoleEast.setText(player.getRole().getLabel());			
		lblCardsInHandEast.setText(Integer.toString(player.getCards().size()));
		txtRankEast.setText("Rang: "+player.getRank());
		
	}
	
	/**
	 * showCurrentTrick
	 * @param cardtype
	 * @param numberOfCards
	 * Shows played cards in Center or clears the field
	 */
	
	void showCurrentTrick(Card.CARD_TYPE cardtype, int numberOfCards){
    	
    	lblCardsCenter.setIcon(new ImageIcon("Bilder/karte"+cardtype.getValue()+" (2).jpg"));		
		lblNumberOfCardsCenter.setText(Integer.toString(numberOfCards));
		
    }

	void showCurrentTrick(){
		
		lblCardsCenter.setIcon(new ImageIcon(""));		
		lblNumberOfCardsCenter.setText("");
		
	}
	
	/**
	 * addListenerMethods
	 * @param listener
	 * adds severals listeners to the deskview
	 */

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
    
    /**
     * popUp
     * @param titel
     * @param text
     * creates a popup if called
     */

	public void popUp(String titel, String text){
		
		JLabel lblSwap;
		JFrame Frame1;
	
		Frame1 = new JFrame();
		Frame1.setTitle(titel);
		Frame1.setSize(400,200);
		Frame1.setLocationRelativeTo(null);
		Frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		lblSwap = new JLabel(text);
		lblSwap.setVerticalAlignment(SwingConstants.CENTER);
		lblSwap.setHorizontalAlignment(SwingConstants.CENTER);
	
		Frame1.add(lblSwap);
		Frame1.setVisible(true);
	
	}
	
}

