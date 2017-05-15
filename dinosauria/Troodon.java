package dinosauria;

import javax.swing.ImageIcon;

public class Troodon extends Pet
{
	private static int prestige = 1;
	private static char diet = 'O';
	private static ImageIcon image = new ImageIcon(GameGUI.class.getResource("/dinosauria/troodonImage.png"));
	
	public Troodon (String newName, String newFood, String newToy)
	{
		super(newName, newFood, newToy);
	}
	
	public char getDiet ()
	{
		return diet;
	}
	
	public String getSpecies ()
	{
		return "Troodon";
	}
	
	public ImageIcon getImage ()
	{
		return image;
	}
	
	
	public static String getDescription ()
	{
		return "The troodon, like the velociraptor and the gigantoraptor, is " +
			   "a therapod. Compared to some other dinosaurs, this omnivore " +
			   "is a safe option as it requires less food and rarely gets " +
			   "sick. It also rarely needs to use the bathroom. However, " +
			   "owning one will result in a lower score for the player.";
	}
	
	public int getPrestige()
	{
		return prestige;
	}
	
	public void updateTraits() {
		boredom = limitTrait(boredom + 5 + RandomNumber.getRandomNumber(10));
		hunger = limitTrait(hunger + 5 + RandomNumber.getRandomNumber(5));
		fatigue = limitTrait(fatigue + 5 + RandomNumber.getRandomNumber(10));
		bladder = limitTrait(bladder + 5 + RandomNumber.getRandomNumber(5));
		weight = limitTrait(weight - 5 - RandomNumber.getRandomNumber(11));
	}
}
