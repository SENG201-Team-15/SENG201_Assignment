/**
 * Pet.java
 * 
 * DESCRIPTION
 * 
 * @author Robert Bruce
 * @version 0.3
 * @since 2017-04-13
 */


package dinosauria;

import java.io.Serializable;

import javax.swing.ImageIcon;

public abstract class Pet implements Serializable {
	// General information.
	private String name;
	private String favouriteFood;
	private String favouriteToy;
	
	
	// Variable statistics.
	private int boredom;
	private int hunger;
	private int fatigue;
	private int bladder;
	private int weight;
	private boolean sick = false;
	private boolean angry = false;
	private boolean alive = true;
	
	/**
	 * Initialises an instance of the Pet class.
	 */
	public Pet(String newName, String newFood, String newToy, int newWeight)
	{
		name = newName;
		favouriteFood = newFood;
		favouriteToy = newToy;
		weight = newWeight;
	}
	
	public String getMood()
	{
		if (!sick && !angry) {
			return "Content";
		} else if (sick && !angry) {
			return "Sick";
		} else if (!sick && angry) {
			return "Angry";
		} else {
			return "Anrgy and sick";
		}
	}
	
	public int getBoredom ()
	{
		return boredom;
	}
	
	public int getHunger ()
	{
		return hunger;
	}
	
	public int getFatigue ()
	{
		return fatigue;
	}
	
	public int getBladder ()
	{
		return bladder;
	}
	
	public int getWeight ()
	{
		return weight;
	}
	
	
	public boolean getSick ()
	{
		return sick;
	}
	
	public boolean getAlive ()
	{
		return alive;
	}
	
	public String getName ()
	{
		return name;
	}
	
	public String toString ()
	{
		return getName() + " (" + getSpecies() + ")";
	}
	
	public abstract ImageIcon getImage();
	public abstract String getSpecies ();
	public abstract int getSpeciesWeight();
	//public abstract String getDescription ();
}