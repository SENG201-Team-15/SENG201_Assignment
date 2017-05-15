package dinosauria;

public class Toy4 extends DinoToys{

	public Toy4(){
		price = 90;
		boredomLoss = getboredomLoss(); // Always maximum boredom loss
		weightLoss = getWeightLoss();
		fatigueGain = getFatigueGain();
		name = "Dino Nip";
		description = "A curious substance of unknown origins. Causes dinosaurs to chase imaginary floating foods"; 
	}
	
	private int getboredomLoss() {
		int boredomLost = 30 + RandomNumber.getRandomNumber(20);
		return boredomLost;
	}
	
	private int getWeightLoss ()
	{
		int weightLost = 5 + RandomNumber.getRandomNumber(10);
		return weightLost;
	}
	
	private int getFatigueGain()
	{
		int fatigueGained = 5 + RandomNumber.getRandomNumber(10);
		return fatigueGained;
	}
}
