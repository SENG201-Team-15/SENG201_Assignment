
public class Toy3 extends DinoToys{

	public Toy3(){
		price = 115;
		boredomLoss = getboredomLoss(); // Always maximum boredom loss
		name = "Ford Explorer";
		description = "A rear beast nearing extinction due to being hunted for decades. All dinosaurs will be tranced into hunting them until caught."; 
	}
	
	private int getboredomLoss() {
		int boredomLost = 50 + RandomNumber.getRandomNumber(20);
		return boredomLost;
	}
}
