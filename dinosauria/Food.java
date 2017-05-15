/**
 * Food.java
 * 
 * DESCRIPTION
 * 
 * @author Robert Bruce
 * @version 0.1
 * @since 2017-04-11
 */

package dinosauria;

public class Food {
	private String name;
	private char type;
	private int nutrition;
	private int tastiness;
	
	/**
	 * Creates an instance of a Food object.
	 * 
	 * @param foodName The name of the food.
	 */
	public Food (String foodName)
	{
		name = foodName;
		
		if (name.equals("Chicken")) {
			type = 'C';
			nutrition = 30;
			tastiness = 30;
			
		} else if (name.equals("Goat")) {
			type = 'C';
			nutrition = 50;
			tastiness = 20;
			
		} else if (name.equals("Didelphodon")) {
			type = 'C';
			nutrition = 20;
			tastiness = 50;
			
		} else if (name.equals("Grass")) {
			type = 'H';
			nutrition = 30;
			tastiness = 30;
			
		} else if (name.equals("Cabbage")) {
			type = 'H';
			nutrition = 50;
			tastiness = 20;
			
		} else if (name.equals("Tree Fern")) {
			type = 'H';
			nutrition = 20;
			tastiness = 50;
		}
	}
	
	
	/**
	 * Returns the food type as a character object. This is either 'C' for
	 * carnivore or 'H' for herbivore.
	 * 
	 * @return char representing food type.
	 */
	public char getType ()
	{
		return type;
	}
	
	
	/**
	 * Returns the nutrition value of the food as an integer.
	 * 
	 * @return int representing nutrition.
	 */
	public int getNutrition ()
	{
		return nutrition;
	}
	
	
	/**
	 * Returns the tastiness value of the food as an integer.
	 * 
	 * @return int representing tastiness.
	 */
	public int getTastiness ()
	{
		return tastiness;
	}
}