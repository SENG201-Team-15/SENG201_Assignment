package dinosauria;

import java.io.Serializable;

public class DinoItem implements Serializable {
	public int price;
	public int boredomLoss; // happiness
	public String description; 
	public String name;
	
	public String getName ()
	{
		return name;
	}
	
	public String getDescription ()
	{
		return description;
	}
	
	public int getPrice()
	{
		return price;
	}
}
