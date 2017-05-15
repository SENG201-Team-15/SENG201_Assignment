package dinosauria;

public class Toy1 extends DinoToys{

	public Toy1(){
		price = 150;
		boredomLoss = 100; // Always maximum boredom loss
		weightLoss = getWeightLoss();
		fatigueGain = getFatigueGain();
		name = "Jurassic Island Playset";
		description = "A mini playset incuding plastic dinosaurs and various environments. The most wanted dinosaur toy currently avalible"; 
	}

	private int getWeightLoss ()
	{
		int weightLost = 10 + RandomNumber.getRandomNumber(10);
		return weightLost;
	}
	
	private int getFatigueGain()
	{
		int fatigueGained = 10 + RandomNumber.getRandomNumber(10);
		return fatigueGained;
	}
}
