package dinosauria;

import java.io.Serializable;

public class DinoToys extends DinoItem implements Serializable {

public int durability;
public int weightLoss;
public int fatigueGain;

	public DinoToys(){
		durability = 8;
	}
	
	public void decreaseDurability(boolean petIsAngry)
	{
		if (petIsAngry) {
			durability -= (5 + RandomNumber.getRandomNumber(6));
		} else {
			durability -= (2 + RandomNumber.getRandomNumber(6));
		}
	}
	
	public static String getRandomToy ()
	{
		int random = RandomNumber.getRandomNumber(4);
		if (random == 0) {
			return "Jurassic Island Playset";
		} else if (random == 1) {
			return "Giant Bone";
		} else if (random == 2) {
			return "Ford Explorer";
		} else if (random == 3) {
			return "Dino Nip";
		} else if (random == 4) {
			return "Rubber Chicken";
		} else {
			return "Old Tyre";
		}
	}
}
