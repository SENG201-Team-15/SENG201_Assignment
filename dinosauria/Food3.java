package dinosauria;

public class Food3 extends DinoFood{
	
	public Food3(){
		price = 30;
		hungerLoss = getHungerLoss();
		boredomLoss = getBoredomLoss(); // Always maximum boredom loss
		toiletGain = getToiletGain();
		weightGain = getWeightGain();
		name = "Plants";
		description = "Low nutrition high weight"; 
		meat = false; 
	}
	
	private int getHungerLoss(){
		int hungerLost = 40 + RandomNumber.getRandomNumber(20);
		return hungerLost;
	}
	
	private int getBoredomLoss() {
		int boredomLost = 5 + RandomNumber.getRandomNumber(20);
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
