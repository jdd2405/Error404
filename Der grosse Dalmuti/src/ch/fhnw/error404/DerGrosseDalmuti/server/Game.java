/**
 * 
 */
package ch.fhnw.error404.DerGrosseDalmuti.server;

import java.util.LinkedList;

/**
 * @author Jonas
 *
 */
public class Game {
	
	boolean modelHasChanged = false; // set to "true" when a model has changed. Set to "false" when it has been sent to all clients.
	public LinkedList<Object> changedObject; // possibility to have more than one changed object
	
	public void setModelHasChanged(boolean b){this.modelHasChanged = b;}
	public boolean getModelHasChanged() {return modelHasChanged;}
	
	public void addChangedObject(Object o){this.changedObject.add(o);}
	public LinkedList<Object> getChangedObject(){return changedObject;}
	
	
}
