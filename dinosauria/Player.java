package dinosauria;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {
	private String name;
	private int balance;
	private int	score;
	private ArrayList<Pet> pets;
	private ArrayList<DinoItem> inventory;
	
	
	/**
	 * Initialises a new Player object.
	 * 
	 * @param newName The name of the new player.
	 */
	public Player (String newName)
	{
		name = newName;
		balance = 1000;
		score = 0;
		pets = new ArrayList<Pet>();
		inventory = new ArrayList();
	}

	
	/**
	 * Returns the name of the player.
	 * 
	 * @return String corresponding to player's name.
	 */
	public String getName ()
	{
		return name;
	}
	
	
	/**
	 * Returns the ArrayList containing the pets owned by the player.
	 * 
	 * @return ArrayList pets.
	 */
	public ArrayList<Pet> getPets()
	{
		return pets;
	}
	
	
	/**
	 * Associates a new pet with the player.
	 * 
	 * @param newPet A pet object.
	 */
	public void addPet(Pet newPet)
	{
		pets.add(newPet);
	}
	
	
	/**
	 * Returns the number of pets the player has as an integer.
	 * 
	 * @return int equal to the size of ArrayList 'pets'.
	 */
	public int getPetNumber()
	{
		return pets.size();
	}
	
	public int getBalance()
	{
		return balance;
	}
	
	public void setBalance(int newBalance)
	{
		balance = newBalance;
	}
	
	public ArrayList<DinoItem> getInventory ()
	{
		return inventory;
	}
	
	
	/**
	 * Compares the current Player object to a second Player object and returns
	 * true if their names are identical. Returns false otherwise.
	 * 
	 * @param other Another Player object.
	 * @return	boolean which is true if the name of the two Player objects is
	 * identical, false otherwise.
	 */
	public boolean equals(Player other)
	{
		if (name.equals(other.name)) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getScore() {
		return score;
	}

	public void processEndOfDay() {
		for (int pet= 0; pet < pets.size(); pet ++) {
			Pet selectedPet = pets.get(pet);
			
			if (selectedPet.isAlive()) {
				score += selectedPet.generateScore();
				selectedPet.processEndOfDay();
				
			}
		}
	}
	
}
