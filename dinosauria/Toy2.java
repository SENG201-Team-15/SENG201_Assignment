package dinosauria;

public class Toy2 extends DinoToys{

	public Toy2(){
		price = 130;
		boredomLoss = getboredomLoss(); // Always maximum boredom loss
		weightLoss = getWeightLoss();
		fatigueGain = getFatigueGain();
		name = "Giant Bone";
		description = "Giant slingshot included. Keeps active dinosaurs entertained for hours."; 
	}
	
	private int getboredomLoss() {
		int boredomLost = 70 + RandomNumber.getRandomNumber(20);
		return boredomLost;
	}
	
	private int getWeightLoss ()
	{
		int weightLost = 10 + RandomNumber.getRandomNumber(20);
		return weightLost;
	}
	
	private int getFatigueGain()
	{
		int fatigueGained = 10 + RandomNumber.getRandomNumber(20);
		return fatigueGained;
	}
}