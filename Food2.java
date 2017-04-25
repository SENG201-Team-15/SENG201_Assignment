
public class Food2 extends DinoFood{

	public Food2(){
		price = 40;
		hungerLoss = getHungerLoss();
		boredomLoss = getBoredomLoss(); // Always maximum boredom loss
		toiletGain = getToiletGain();
		weightGain = getWeightGain();
		name = "Roasted Vegetables";
		description = "High nutrition low weight"; 
		meat = false; 
	}
	
	private int getHungerLoss(){
		int hungerLost = 55 + RandomNumber.getRandomNumber(20);
		return hungerLost;
	}
	
	private int getBoredomLoss() {
		int boredomLost = 15 + RandomNumber.getRandomNumber(20);
		return boredomLost;
	}
	
	private int getToiletGain(){
		int toiletGained = 25 + RandomNumber.getRandomNumber(10); //average of 3% weight loss
		return toiletGained;
	}
	
	private int getWeightGain(){
		int WeightGained = 15 + RandomNumber.getRandomNumber(10); //average of 2% weight gain
		return WeightGained;
	}
}
