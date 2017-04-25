
public class Toy2 extends DinoToys{

	public Toy2(){
		price = 130;
		boredomLoss = getboredomLoss(); // Always maximum boredom loss
		name = "Giant Bone";
		description = "Giant slingshot included. Keeps active dinosaurs entertained for hours."; 
	}
	
	private int getboredomLoss() {
		int boredomLost = 70 + RandomNumber.getRandomNumber(20);
		return boredomLost;
	}
}