package dinosauria;

import javax.swing.ImageIcon;

public class Tyrannosaurus extends Pet 
{
	private static int speciesWeight = 8400;
	private static int prestiege = 3;
	private static ImageIcon image = new ImageIcon(GameGUI.class.getResource("/dinosauria/tyrannosaurusImage.png"));
	
	private int boredomRate;
	private int hungerRate;
	private int fatigueRate;
	private int bladderRate;
	private int sicknessRate;
	private int weightRate;
	
	
	public Tyrannosaurus (String newName, String newFood, String newToy)
	{
		super(newName, newFood, newToy, speciesWeight);

	}
	
	public String getSpecies ()
	{
		return "Tyrannosaurus";
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
		return "The tyrant lizard of Laramidia is one of the most fearsome " +
			   "dinosaurs. It is a carnivore which consumes food at a very " +
			   "high rate and gets sick very easily. However, having a " +
			   "surviving Tyrannosaurus at the end of the game will result " +
			   "in a high score.";
	}
}
