package dinosauria;

public class Food4 extends DinoFood{
	
	public Food4(){
		price = 25;
		hungerLoss = getHungerLoss();
		boredomLoss = getBoredomLoss(); // Always maximum boredom loss
		toiletGain = getToiletGain();
		weightGain = getWeightGain();
		name = "Grass";
		description = "High nutrition low weight"; 
		meat = false; 
	}
	
	private int getHungerLoss(){
		int hungerLost = 35 + RandomNumber.getRandomNumber(20);
		return hungerLost;
	}
	
	private int getBoredomLoss() {
		int boredomLost = 5 + RandomNumber.getRandomNumber(20);
		return boredomLost;
	}
	
	private int getToiletGain(){
		int toiletGained = 25 + RandomNumber.getRandomNumber(10); // average of 3% weight loss
		return toiletGained;
	}
	
	private int getWeightGain(){
		int WeightGained = 15 + RandomNumber.getRandomNumber(10); //need to have as a percentage of weight
		return WeightGained;
	}
}
