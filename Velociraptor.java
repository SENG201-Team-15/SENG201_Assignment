package dinosauria;

public class Velociraptor extends Pet
{
	private static int speciesWeight = 15;
	private static int prestiege = 2;
	
	public Velociraptor (String newName, String newFood, String newToy)
	{
		super(newName, newFood, newToy, speciesWeight);
	}
	
	public String getSpecies ()
	{
		return "Velociraptor";
	}
	
	public String getDescription ()
	{
		return "This six-foot turkey is a carnivore known as the ‘swift " +
			   "seizer’. It consumes food at a high rate and has an equal " +
			   "chance of becoming sick. Compared to some other dinosaurs, " +
			   "the velociraptor requires less sleep and needs to go to the " +
			   "bathroom less often.";
	}
}
