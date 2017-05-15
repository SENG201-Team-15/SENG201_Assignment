package dinosauria;

public class Food6 extends DinoFood{
	
	public Food6(){
		price = 50;
		hungerLoss = getHungerLoss();
		boredomLoss = getBoredomLoss(); // Always maximum boredom loss
		toiletGain = getToiletGain();
		weightGain = getWeightGain();
		name = "Roast Chicken";
		description = "High nutrition low weight"; 
		meat = true; 
	}
	
	private int getHungerLoss(){
		int hungerLost = 60 + RandomNumber.getRandomNumber(20);
		return hungerLost;
	}
	
	private int getBoredomLoss() {
		int boredomLost = 15 + RandomNumber.getRandomNumber(20);
		return boredomLost;
	}
	
	private int getToiletGain(){
		int toiletGained = 25 + RandomNumber.getRandomNumber(10);
		return toiletGained;
	}
	
	private int getWeightGain(){
		int WeightGained = 15 + RandomNumber.getRandomNumber(10); //need to have as a percentage of weight
		return WeightGained;
	}
}
