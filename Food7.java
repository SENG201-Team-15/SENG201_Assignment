
public class Food7 extends DinoFood{
	
	public Food7(){
		price = 35;
		hungerLoss = getHungerLoss();
		boredomLoss = getBoredomLoss(); // Always maximum boredom loss
		toiletGain = getToiletGain();
		weightGain = getWeightGain();
		name = "Bacon Bits";
		description = "Low nutrition high weight"; 
		meat = true; 
	}
	
	private int getHungerLoss(){
		int hungerLost = 40 + RandomNumber.getRandomNumber(20);
		return hungerLost;
	}
	
	private int getBoredomLoss() {
		int boredomLost = 10 + RandomNumber.getRandomNumber(20);
		return boredomLost;
	}
	
	private int getToiletGain(){ //low weight loss through toilet
		int toiletGained = 10 + RandomNumber.getRandomNumber(10);
		return toiletGained;
	}
	
	private int getWeightGain(){ // high weight gain
		int WeightGained = 50 + RandomNumber.getRandomNumber(20);
		return WeightGained;
	}
}
