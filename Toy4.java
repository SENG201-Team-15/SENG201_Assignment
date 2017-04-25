
public class Toy4 extends DinoToys{

	public Toy4(){
		price = 90;
		boredomLoss = getboredomLoss(); // Always maximum boredom loss
		name = "DinoNip";
		description = "A curious substance of unknown origins. Causes dinosaurs to chase imaginary floating foods"; 
	}
	
	private int getboredomLoss() {
		int boredomLost = 30 + RandomNumber.getRandomNumber(20);
		return boredomLost;
	}
}
