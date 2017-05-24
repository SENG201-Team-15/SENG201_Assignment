/**
 * RandomNumber.java
 * 
 * @author Robert Bruce
 * @version 0.1
 * @since 2017-04-10
 * 
 * This class creates a static random number generator which can be used to
 * generate random numbers without creating a @java.util.Random object.
 */

package dinosauria;
import java.util.Random;

public final class RandomNumber {
	
	private static Random generator = new Random();
	
	
	/**
	 * Prevents this class from being instantiated.
	 */
	private RandomNumber() {}
	
	
	/**
	 * Replicates the functionality of @java.util.Random's non-static nextInt
	 * method. It returns an integer between 0 and the parameter bound.
	 * 
	 * @param bound int representing the upper boundary of the number generated.
	 * @return int between 0 (inclusive) and bound (exclusive).
	 */
	public static int getRandomNumber(int bound)
	{
		return generator.nextInt(bound);
	}
}
