/**
 * 
 */
package ch.fhnw.error404.DerGrosseDalmuti.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import ch.fhnw.error404.DerGrosseDalmuti.shared.*;

import javax.swing.*;

/**
 * @author Jonas
 *
 */

public class TestAction extends Client{
	
    private int myId;
    Player player;
  //... The Controller needs to interact with both the Model and View.
    private TestDeskView deskView;
    

    // Constructor with 
    TestAction(TestLoginView loginView) {
        this.loginView  = loginView;

        
        //... Add listeners to the view.
        loginView.addLoginListener(new LoginListener());
        loginView.addClearLoginListener(new ClearLoginListener());
    }  

    
    // inner class
    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            try {
                userInput = loginView.getUserInput();
                player = new Player(userInput, 4);
                myId = player.getId();
                Client.allPlayers.add(player);
                loginView.setVisible(false);
                deskView = new TestDeskView();
                deskView.setVisible(true);
                deskView.addBtnCardListener(new BtnCardListener());
                
            } catch (NumberFormatException nfex) {
            	loginView.showError("Bad input: '" + userInput + "'");
            }
        }
    }
    
    
    // inner class ClearListener
    /**  1. Reset model.
     *   2. Reset View.
     */    
    class ClearLoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	loginView.reset();
        }
    }
    
    
 // inner class
    class BtnCardListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            try {
               // userInput = loginView.getUserInput();
               
                
            } catch (NumberFormatException nfex) {
            	loginView.showError("Bad input: '" + userInput + "'");
            }
        }
    }
}
