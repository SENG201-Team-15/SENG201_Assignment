package dinosauria;

import javax.swing.ImageIcon;

public class Gigantoraptor extends Pet
{
	private static int prestige = 1;
	private static char diet = 'O';
	private static ImageIcon image = new ImageIcon(GameGUI.class.getResource("/dinosauria/gigantoraptorImage.png"));
	
	public Gigantoraptor (String newName, String newFood, String newToy)
	{
		super(newName, newFood, newToy);
	}
	
	public char getDiet ()
	{
		return diet;
	}
	
	public String getSpecies ()
	{
		return "Gigantoraptor";
	}
	
	public ImageIcon getImage ()
	{
		return image;
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
	
	public int getPrestige()
	{
		return prestige;
	}
	
	public void updateTraits() {
		boredom = limitTrait(boredom + 5 + RandomNumber.getRandomNumber(5));
		hunger = limitTrait(hunger + 5 + RandomNumber.getRandomNumber(10));
		fatigue = limitTrait(fatigue + 5 + RandomNumber.getRandomNumber(5));
		bladder = limitTrait(bladder + 5 + RandomNumber.getRandomNumber(10));
		weight = limitTrait(weight - 5 - RandomNumber.getRandomNumber(11));
	}
}
