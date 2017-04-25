
public class Toy5 extends DinoToys{

	public Toy5(){
		price = 70;
		boredomLoss = getboredomLoss(); // Always maximum boredom loss
		name = "Rubber Chicken";
		description = "Commonly known as dixie chick, this rubber chicken clucks when played with."; 
	}
	
	private int getboredomLoss() {
		int boredomLost = 10 + RandomNumber.getRandomNumber(20);
		return boredomLost;
	}
}
