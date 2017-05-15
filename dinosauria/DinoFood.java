package dinosauria;

public class DinoFood extends DinoItem {

	
	public int hungerLoss; // nutrition
	public int toiletGain; 
	public int weightGain;
	public boolean meat;
	
	public static String getRandomFood ()
	{
		int random = RandomNumber.getRandomNumber(6);
		if (random == 0) {
			return "Caesar Salad";
		} else if (random == 1) {
			return "Roasted Vegetables";
		} else if (random == 2) {
			return "Plants";
		} else if (random == 3) {
			return "Grass";
		} else if (random == 4) {
			return "Steak with Cheese Sauce";
		} else if (random == 5) {
			return "Roast Chicken";
		} else if (random == 6) {
			return "Bacon Bits";
		} else {
			return "Meat Scraps";
		}
	}
	
}
// toilet and weight gain are linearly balanced when divided by 100 it gives the percentage of weight lost/gained, multiply by weight to get number
// half toilet loss /200 is weight loss e.g 50 loss = 50/200