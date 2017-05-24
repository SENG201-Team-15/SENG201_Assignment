package dinosauria;

public class Toy6 extends DinoToys{
	
	public Toy6(){
		price = 40;
		boredomLoss = getboredomLoss(); // Always maximum boredom loss
		weightLoss = getWeightLoss();
		fatigueGain = getFatigueGain();
		name = "Old Tyre";
		description = "Obtained from a broken Jeep Rangler this tyre seems to be in bad shape with little enjoyment left"; 
	}
	
	private int getboredomLoss() {
		int boredomLost = RandomNumber.getRandomNumber(20);
		return boredomLost;
	}
	
	private int getWeightLoss ()
	{
		int weightLost = 10 + RandomNumber.getRandomNumber(5);
		return weightLost;
	}
	
	private int getFatigueGain()
	{
		int fatigueGained = 5 + RandomNumber.getRandomNumber(10);
		return fatigueGained;
	}
}
