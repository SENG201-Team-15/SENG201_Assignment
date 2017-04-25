
public class DinoFood {

public int price;
public int hungerLoss; // nutrition
public int boredomLoss; // happiness
public int toiletGain; 
public int weightGain;
public String description; 
public String name;
public boolean meat;
}
// toilet and weight gain are linearly balanced when divided by 100 it gives the percentage of weight lost/gained, multiply by weight to get number
// half toilet loss /200 is weight loss e.g 50 loss = 50/200