package dinosauria;

public class Toy5 extends DinoToys{

	public Toy5(){
		price = 70;
		boredomLoss = getboredomLoss(); // Always maximum boredom loss
		weightLoss = getWeightLoss();
		fatigueGain = getFatigueGain();
		name = "Rubber Chicken";
		description = "Commonly known as dixie chick, this rubber chicken clucks when played with."; 
	}
	
	private int getboredomLoss() {
		int boredomLost = 10 + RandomNumber.getRandomNumber(20);
		return boredomLost;
	}
	
	private int getWeightLoss ()
	{
		int weightLost = 5 + RandomNumber.getRandomNumber(10);
		return weightLost;
	}
	
	private int getFatigueGain()
	{
		int fatigueGained = 10 + RandomNumber.getRandomNumber(5);
		return fatigueGained;
	}
}
