package dinosauria;

public class Troodon extends Pet
{
	private static int speciesWeight = 1400;
	private static int prestiege = 1;
	
	public Troodon (String newName, String newFood, String newToy)
	{
		super(newName, newFood, newToy, speciesWeight);
	}
	
	public String getSpecies ()
	{
		return "Troodon";
	}
	
	public String getDescription ()
	{
		return "The troodon, like the velociraptor and the gigantoraptor, is " +
			   "a therapod. Compared to some other dinosaurs, this omnivore " +
			   "is a safe option as it requires less food and rarely gets " +
			   "sick. It also rarely needs to use the bathroom. However, " +
			   "owning one will result in a lower score for the player.";
	}
}
