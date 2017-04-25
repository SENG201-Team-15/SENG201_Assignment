
public class Food8 extends DinoFood{
	
	public Food8(){
		price = 30;
		hungerLoss = getHungerLoss();
		boredomLoss = getBoredomLoss(); // Always maximum boredom loss
		toiletGain = getToiletGain();
		weightGain = getWeightGain();
		name = "Meat Scraps";
		description = "Low nutriton, low weight"; 
		meat = true; 
	}
	
	private int getHungerLoss(){
		int hungerLost = 30 + RandomNumber.getRandomNumber(20);
		return hungerLost;
	}
	
	private int getBoredomLoss() {
		int boredomLost = 5 + RandomNumber.getRandomNumber(20);
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
