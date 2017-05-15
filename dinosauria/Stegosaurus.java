package dinosauria;

import javax.swing.ImageIcon;

public class Stegosaurus extends Pet
{
	private static int prestige = 2;
	private static char diet = 'H';
	private static ImageIcon image = new ImageIcon(GameGUI.class.getResource("/dinosauria/stegosaurusImage.png"));
	
	public Stegosaurus (String newName, String newFood, String newToy)
	{
		super(newName, newFood, newToy);
	}
	
	public char getDiet ()
	{
		return diet;
	}
	
	public String getSpecies ()
	{
		return "Stegosaurus";
	}
	
	public ImageIcon getImage ()
	{
		return image;
	}
	
	
	public static String getDescription ()
	{
		return "This armoured herbivore is known as the ‘covered lizard’ for " +
			   "the large dermal plates on its back. A high rate of sickness " +
			   "and fatigue is balanced by a low rate of food consumption " +
			   "and a reduced need to use the bathroom.";
	}
	
	public int getPrestige()
	{
		return prestige;
	}
	
	public void updateTraits() {
		boredom = limitTrait(boredom + 10 + RandomNumber.getRandomNumber(5));
		hunger = limitTrait(hunger + 5 + RandomNumber.getRandomNumber(10));
		fatigue = limitTrait(fatigue + 10 + RandomNumber.getRandomNumber(5));
		bladder = limitTrait(bladder + 5 + RandomNumber.getRandomNumber(10));
		weight = limitTrait(weight - 5 - RandomNumber.getRandomNumber(11));
	}
}
