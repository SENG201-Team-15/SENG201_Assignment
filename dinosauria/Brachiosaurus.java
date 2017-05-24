package dinosauria;

import javax.swing.ImageIcon;

public class Brachiosaurus extends Pet
{
	private static int prestige = 3;
	private static char diet = 'H';
	private static ImageIcon image = new ImageIcon(GameGUI.class.getResource("/dinosauria/brachiosaurusImage.png"));
	
	public Brachiosaurus (String newName, String newFood, String newToy)
	{
		super(newName, newFood, newToy);
		
	}
	
	public char getDiet ()
	{
		return diet;
	}
	
	public String getSpecies ()
	{
		return "Brachiosaurus";
	}
	
	public ImageIcon getImage ()
	{
		return image;
	}
	
	
	public static String getDescription ()
	{
		return "Brachiosaurus is a sauropod, the largest form of animal life " +
			   "to ever walk the Earth. In recognition of this fact, a " +
			   "player with a living Brachiosaurus at the end of the game " +
			   "will receive a higher score. It is a herbivore which tires " +
			   "very quickly and gets sick very easily.";
	}
	
	public int getPrestige()
	{
		return prestige;
	}
	
	public void updateTraits() {
		boredom = limitTrait(boredom + 20 + RandomNumber.getRandomNumber(10));
		hunger = limitTrait(hunger + 10 + RandomNumber.getRandomNumber(20));
		fatigue = limitTrait(fatigue + 20 + RandomNumber.getRandomNumber(10));
		bladder = limitTrait(bladder + 10 + RandomNumber.getRandomNumber(20));
		weight = limitTrait(weight - 5 - RandomNumber.getRandomNumber(11));
	}
}
