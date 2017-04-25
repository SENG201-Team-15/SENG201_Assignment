package dinosauria;

import javax.swing.ImageIcon;

public class Gigantoraptor extends Pet
{
	private static int speciesWeight = 1400;
	private static int prestiege = 1;
	private static ImageIcon image = new ImageIcon(GameGUI.class.getResource("/dinosauria/gigantoraptorImage.png"));
	
	public Gigantoraptor (String newName, String newFood, String newToy)
	{
		super(newName, newFood, newToy, speciesWeight);
	}
	
	public String getSpecies ()
	{
		return "Gigantoraptor";
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
		return "The Gigantoraptor is the larger distant cousin of the " +
			   "velociraptor. It is an omnivore which gets tires at a slower " +
			   "rate than other dinosaurs and rarely needs to go to the " + 
			   "toilet. The gigantoraptor will also rarely get sick. Owning " +
			   "this comparatively ‘safe’ dinosaur will result in a lower "
			   + "score.";
	}
}
