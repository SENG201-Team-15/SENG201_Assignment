package dinosauria;

import javax.swing.ImageIcon;

public class Tyrannosaurus extends Pet 
{
	private static int prestige = 3;
	private static char diet = 'C';
	private static ImageIcon image = new ImageIcon(GameGUI.class.getResource("/dinosauria/tyrannosaurusImage.png"));
	
	public Tyrannosaurus (String newName, String newFood, String newToy)
	{
		super(newName, newFood, newToy);

	}
	
	public char getDiet ()
	{
		return diet;
	}
	
	public String getSpecies ()
	{
		return "Tyrannosaurus";
	}
	
	public ImageIcon getImage ()
	{
		return image;
	}
	
	
	public static String getDescription ()
	{
		return "The tyrant lizard of Laramidia is one of the most fearsome " +
			   "dinosaurs. It is a carnivore which consumes food at a very " +
			   "high rate and gets sick very easily. However, having a " +
			   "surviving Tyrannosaurus at the end of the game will result " +
			   "in a high score.";
	}
	
	public int getPrestige()
	{
		return prestige;
	}
	
	public void updateTraits() {
		boredom = limitTrait(boredom + 10 + RandomNumber.getRandomNumber(20));
		hunger = limitTrait(hunger + 20 + RandomNumber.getRandomNumber(10));
		fatigue = limitTrait(fatigue + 10 + RandomNumber.getRandomNumber(20));
		bladder = limitTrait(bladder + 20 + RandomNumber.getRandomNumber(10));
		weight = limitTrait(weight - 5 - RandomNumber.getRandomNumber(11));
	}
}
