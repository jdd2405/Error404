/**
 * 
 */
package ch.fhnw.error404.DerGrosseDalmuti.shared;

import java.util.List;

/**
 * @author Jonas
 *
 */
public class Player {
	
	private String name;
	private Role role;
	private int rank;
	private List<Card> cards;
	
	Player(){	
	}
	
	Player(String name) {
		this.name = name;
		this.role = new Role(1);
		
	}

	
}
