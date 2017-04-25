package dinosauria;

import javax.swing.ImageIcon;

public class Brachiosaurus extends Pet
{
	private static int speciesWeight = 35000;
	private static int prestiege = 3;
	private static ImageIcon image = new ImageIcon(GameGUI.class.getResource("/dinosauria/brachiosaurusImage.png"));
	
	public Brachiosaurus (String newName, String newFood, String newToy)
	{
		super(newName, newFood, newToy, speciesWeight);
		
	}
	
	public String getSpecies ()
	{
		return "Brachiosaurus";
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
		return "Brachiosaurus is a sauropod, the largest form of animal life " +
			   "to ever walk the Earth. In recognition of this fact, a " +
			   "player with a living Brachiosaurus at the end of the game " +
			   "will receive a higher score. It is a herbivore which tires " +
			   "very quickly and gets sick very easily.";
	}
}
