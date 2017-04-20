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

public abstract class Pet {
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
	private boolean sickness;
	private boolean alive;
	
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
	
	public String getName ()
	{
		return name;
	}
	
	public String toString ()
	{
		return getName() + " (" + getSpecies() + ")";
	}
	
	public abstract String getSpecies ();
	public abstract String getDescription ();
}