
public class Food5 extends DinoFood{
	
	public Food5(){
		price = 55;
		hungerLoss = getHungerLoss();
		boredomLoss = getBoredomLoss(); // Always maximum boredom loss
		toiletGain = getToiletGain();
		weightGain = getWeightGain();
		name = "Steak with Cheese Sauce";
		description = "High nutrition high weight gain"; 
		meat = true; 
	}
	
	private int getHungerLoss(){
		int hungerLost = 70 + RandomNumber.getRandomNumber(20);
		return hungerLost;
	}
	
	private int getBoredomLoss() {
		int boredomLost = 15 + RandomNumber.getRandomNumber(20);
		return boredomLost;
	}
	
	private int getToiletGain(){ //low weight loss through toilet
		int toiletGained = 10 + RandomNumber.getRandomNumber(10); // average of 1.5% weight loss
		return toiletGained;
	}
	
	private int getWeightGain(){ // high weight gain
		int WeightGained = 50 + RandomNumber.getRandomNumber(20); // average of 6% weight gain
		return WeightGained;
	}
}
