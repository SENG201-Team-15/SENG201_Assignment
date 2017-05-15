/**
 * Pet.java
 * 
 * DESCRIPTION
 * 
 * @author Robert Bruce
 * @version 0.4
 * @since 2017-04-13
 */


package dinosauria;

import java.io.Serializable;
import javax.swing.ImageIcon;

public abstract class Pet implements Serializable {
	// General information.
	private String name;
	private String favouriteFood;
	private String favouriteToy;
	
	// Variable statistics.
	protected int boredom;
	protected int hunger;
	protected int fatigue;
	protected int bladder;
	protected int weight;
	protected int actionPoints = 2;
	protected int daysSick;
	protected boolean sick = false;
	protected boolean angry = false;
	protected boolean alive = true;
	private boolean wasDead = false;
	
	/**
	 * Initialises an instance of the Pet class.
	 */
	public Pet(String newName, String newFood, String newToy)
	{
		name = newName;
		favouriteFood = newFood;
		favouriteToy = newToy;
		boredom = RandomNumber.getRandomNumber(21);
		hunger = RandomNumber.getRandomNumber(21);
		fatigue = RandomNumber.getRandomNumber(21);
		bladder = RandomNumber.getRandomNumber(21);
		weight = 40 + RandomNumber.getRandomNumber(21);
		
	}
	
	public String getMood()
	{
		if (!alive) {
			return "Dead";
		} else if (!sick && !angry) {
			return "Content";
		} else if (sick && !angry) {
			return "Sick";
		} else if (!sick && angry) {
			return "Angry";
		} else {
			return "Anrgy and sick";
		}
	}
	
	public int getBoredom ()
	{
		return boredom;
	}
	
	public int getHunger ()
	{
		return hunger;
	}
	
	public int getFatigue ()
	{
		return fatigue;
	}
	
	public int getBladder ()
	{
		return bladder;
	}
	
	public int getWeight ()
	{
		return weight;
	}
	
	
	public boolean getSick ()
	{
		return sick;
	}
	
	public boolean isAlive ()
	{
		return alive;
	}
	
	public String getName ()
	{
		return name;
	}
	
	public void setAlive(boolean newAlive)
	{
		alive = newAlive;
	}
	
	public String toString ()
	{
		return getName() + " (" + getSpecies() + ")";
	}
	
	public boolean wasDead()
	{
		return wasDead;
	}
	
	
	public int getActionPoints() {
		return actionPoints;
	}
	
	public void setActionPoints(int newActionPoints) {
		actionPoints = newActionPoints;
	}
	
	public boolean getAngry()
	{
		return angry;
	}
	
	protected static int limitTrait (int trait)
	{
		if (trait < 0) {
			trait = 0;
		} else if (trait > 100) {
			trait = 100;
		}
		
		return trait;
	}
	
	public void giveFood (DinoFood food)
	{
		if ((getDiet() == 'C' && food.meat == true) || (getDiet() == 'H' && food.meat == false) || getDiet() == 'O') {
			// The food is appropriate for the diet of the pet.
			hunger = limitTrait(hunger - food.hungerLoss);
			boredom = limitTrait(boredom - food.boredomLoss);
			bladder = limitTrait(bladder + food.toiletGain);
			weight = limitTrait(bladder + food.weightGain);
		} else {
			// The food is inappropriate for the diet of the pet.
			hunger = limitTrait(hunger + food.hungerLoss);
			boredom = limitTrait(boredom + food.boredomLoss);
			bladder = limitTrait(bladder + food.toiletGain);
			weight = limitTrait(bladder + food.weightGain);
		}
	}
	
	public void giveToy (DinoToys toy)
	{
		boredom = limitTrait(boredom - toy.boredomLoss);
		weight = limitTrait(weight - toy.weightLoss);
		fatigue = limitTrait(fatigue + toy.fatigueGain);
	}
	
	public void makeSleep ()
	{
		fatigue = limitTrait(fatigue - 50 - RandomNumber.getRandomNumber(50));
	}
	
	public void emptyBladder ()
	{
		bladder = limitTrait(fatigue - 50 - RandomNumber.getRandomNumber(50));
	}
	
	public void revive ()
	{
		if (!wasDead) {
			alive = true;
			wasDead = true;
			actionPoints = 2;
			angry = false;
			sick = false;
		}
	}
	
	public void kill ()
	{
		alive = false;
		actionPoints = 0;
		boredom = 0;
		hunger = 0;
		fatigue = 0;
		bladder = 0;
		weight = 50;
	}
	
	public abstract ImageIcon getImage();
	public abstract String getSpecies ();
	public abstract int getPrestige();
	public abstract void updateTraits();
	public abstract char getDiet();
	
	public void processEndOfDay()
	{
		if (boredom == 100 || fatigue == 100 || RandomNumber.getRandomNumber(10) < getPrestige()) {
			// Pet automatically becomes angry if boredom or fatigue reaches 100. There is a chance (based on prestige)
			// that the pet will become angry regardless of these traits.
			angry = true;
		} else if (angry && boredom < 100 && fatigue < 100 && RandomNumber.getRandomNumber(10) < 5 - getPrestige()) {
			// If the pet is angry, there is a chance it will get better if boredom and fatigue are not 100.
			angry = false;
		}
		
		if (hunger == 100 || bladder == 100 || weight == 0 || weight == 100 || RandomNumber.getRandomNumber(10) < getPrestige()) {
			// Pet automatically becomes sick if hunger, bladder, or weight reach extreme. The pet may become sick anyway.
			sick = true;
		} else if (sick && hunger < 100 && bladder < 100 && weight > 0 && weight < 100 && RandomNumber.getRandomNumber(10) < 5 - getPrestige()) {
			//  If hunger, bladder, and weight are not extreme and the pet is sick, there is a chance it may get better.
			sick = false;
			daysSick = 0;
		} else if (sick && daysSick < 5) {
			// If the pet is sick, increment the number of days it has been sick.
			daysSick += 1;
		} else if (sick) {
			// If the pet has been sick for more than five days, kill it.
			kill();
		}
		
		if (alive)
		{
			// If the pet is alive, adjust its traits.
			updateTraits();
		}
	}
	

	public int generateScore() {
		int score = ((100 - boredom) + (100 - hunger) + (100 - fatigue) + (100 - bladder)) * getPrestige();
		
		if (!sick) {
			score += 50;
		}
		
		if (!angry) {
			score += 50;
		}
		
		return score;
	}
}