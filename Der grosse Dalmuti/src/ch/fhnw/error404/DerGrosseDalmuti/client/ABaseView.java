/**
 * 
 */
package ch.fhnw.error404.DerGrosseDalmuti.client;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JDialog;
import ch.fhnw.error404.DerGrosseDalmuti.shared.*;

/**
 * @author Jonas, Elias und Thomas
 *
 */
public abstract class ABaseView extends JFrame {
	private BorderLayout one;
	Action action = new Action();
	
	public ABaseView() throws HeadlessException {
		super();
	}

	public ABaseView(String title){
		super(title);
	}

}

