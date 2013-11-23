package ch.fhnw.error404.DerGrosseDalmuti.client;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class testclass extends JButton {
	
	private int number;

	public testclass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public testclass(Action a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	public testclass(Icon icon, int number) {
		super(icon);
		this.number = number;
		// TODO Auto-generated constructor stub
	}

	public testclass(String text, Icon icon) {
		super(text, icon);
		// TODO Auto-generated constructor stub
	}

	public testclass(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public int getNumber(){
		return number;
		}
	
	
	

}
