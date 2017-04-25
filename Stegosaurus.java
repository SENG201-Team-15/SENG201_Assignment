package dinosauria;

import javax.swing.ImageIcon;

public class Stegosaurus extends Pet
{
	private static int speciesWeight = 2400;
	private static int prestiege = 2;
	private static ImageIcon image = new ImageIcon(GameGUI.class.getResource("/dinosauria/stegosaurusImage.png"));
	
	public Stegosaurus (String newName, String newFood, String newToy)
	{
		super(newName, newFood, newToy, speciesWeight);
	}
	
	public String getSpecies ()
	{
		return "Stegosaurus";
	}
	
	public ImageIcon getImage ()
	{
		return image;
	}
	
	public int getSpeciesWeight()
	{
		return speciesWeight;
	}
	
	public static String getDescription ()
	{
		return "This armoured herbivore is known as the ‘covered lizard’ for " +
			   "the large dermal plates on its back. A high rate of sickness " +
			   "and fatigue is balanced by a low rate of food consumption " +
			   "and a reduced need to use the bathroom.";
	}
}
