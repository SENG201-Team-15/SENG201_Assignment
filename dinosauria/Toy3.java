package dinosauria;

public class Toy3 extends DinoToys{

	public Toy3(){
		price = 115;
		boredomLoss = getboredomLoss(); // Always maximum boredom loss
		weightLoss = getWeightLoss();
		fatigueGain = getFatigueGain();
		name = "Ford Explorer";
		description = "A rear beast nearing extinction due to being hunted for decades. All dinosaurs will be tranced into hunting them until caught."; 
	}
	
	private int getboredomLoss() {
		int boredomLost = 50 + RandomNumber.getRandomNumber(20);
		return boredomLost;
	}
	
	private int getWeightLoss ()
	{
		int weightLost = 5 + RandomNumber.getRandomNumber(5);
		return weightLost;
	}
	
	private int getFatigueGain()
	{
		int fatigueGained = 5 + RandomNumber.getRandomNumber(5);
		return fatigueGained;
	}
}
