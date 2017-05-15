package dinosauria;

public class Food1 extends DinoFood{
	
	public Food1(){
		price = 50;
		hungerLoss = getHungerLoss();
		boredomLoss = getBoredomLoss(); // Always maximum boredom loss
		toiletGain = getToiletGain();
		weightGain = getWeightGain();
		name = "Caesar Salad";
		description = "Made by the reincarnated king himself. Caesar's life goal is to rule the kitchen with the most nutritious dinosaur sized salad in the world"; // *dictator
		meat = false; 
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
