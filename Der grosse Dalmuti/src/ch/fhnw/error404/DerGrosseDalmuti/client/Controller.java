/**
 * 
 */
package ch.fhnw.error404.DerGrosseDalmuti.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ch.fhnw.error404.DerGrosseDalmuti.shared.*;

import javax.swing.*;

/**
 * @author Jonas
 *
 */
public class Controller extends Client{
	
    
  //... The Controller needs to interact with both the Model and View.
    private Player player;
    private View  view;
    
    //========================================================== constructor
    /** Constructor */
    Controller(Player player, View view) {
        this.player = player;
        this.view  = view;
        
        //... Add listeners to the view.
        view.addShowListener(new MultiplyListener());
        view.addClearListener(new ClearListener());
    }
    
    
    ////////////////////////////////////////// inner class MultiplyListener
    /** When a mulitplication is requested.
     *  1. Get the user input number from the View.
     *  2. Call the model to mulitply by this number.
     *  3. Get the result from the Model.
     *  4. Tell the View to display the result.
     * If there was an error, tell the View to display it.
     */
    class MultiplyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            try {
                userInput = view.getUserInput();
                player = new Player(userInput, 1);
                view.showId(player.getId());
                
            } catch (NumberFormatException nfex) {
                view.showError("Bad input: '" + userInput + "'");
            }
        }
    }//end inner class MultiplyListener
    
    
    //////////////////////////////////////////// inner class ClearListener
    /**  1. Reset model.
     *   2. Reset View.
     */    
    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.reset();
        }
    }// end inner class ClearListener
}
