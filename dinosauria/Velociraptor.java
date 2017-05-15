package dinosauria;

import javax.swing.ImageIcon;

public class Velociraptor extends Pet
{

	private static int prestige = 2;
	private static char diet = 'C';
	private static ImageIcon image = new ImageIcon(GameGUI.class.getResource("/dinosauria/velociraptorImage.png"));;
	
	public Velociraptor (String newName, String newFood, String newToy)
	{
		super(newName, newFood, newToy);
	}
	
	public String getSpecies ()
	{
		return "Velociraptor";
	}
	
	public char getDiet ()
	{
		return diet;
	}

	
	public ImageIcon getImage ()
	{
		return image;
	}
	
	public static String getDescription ()
	{
		return "This six-foot turkey is a carnivore known as the ‘swift " +
			   "seizer’. It consumes food at a high rate and has an equal " +
			   "chance of becoming sick. Compared to some other dinosaurs, " +
			   "the velociraptor requires less sleep and needs to go to the " +
			   "bathroom less often.";
	}
	
	public int getPrestige()
	{
		return prestige;
	}
	
	public void updateTraits() {
		boredom = limitTrait(boredom + 5 + RandomNumber.getRandomNumber(10));
		hunger = limitTrait(hunger + 10 + RandomNumber.getRandomNumber(5));
		fatigue = limitTrait(fatigue + 5 + RandomNumber.getRandomNumber(10));
		bladder = limitTrait(bladder + 10 + RandomNumber.getRandomNumber(5));
		weight = limitTrait(weight - 5 - RandomNumber.getRandomNumber(11));
	}
}
