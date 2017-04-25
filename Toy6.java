
public class Toy6 extends DinoToys{
	
	public Toy6(){
		price = 40;
		boredomLoss = getboredomLoss(); // Always maximum boredom loss
		name = "Old Tyre";
		description = "Obtained from a broken Jeep Rangler this tyre seems to be in bad shape with little enjoyment left"; 
	}
	
	private int getboredomLoss() {
		int boredomLost = RandomNumber.getRandomNumber(20);
		return boredomLost;
	}
}
