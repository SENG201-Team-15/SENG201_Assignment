package dinosauria;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput
{	
	private static Scanner scanner = new Scanner(System.in);

	
	/**
	 * Returns a string corresponding to user input.
	 * 
	 * @return String passed to the program by the user.
	 */
	public static String getString ()
	{
		String string = scanner.nextLine();
		scanner = new Scanner(System.in);
		return string;
	}
	
	
	/**
	 * Returns an integer between 1 (inclusive) and bound (exclusive)
	 * corresponding to a user's input if their input falls within that range.
	 * Returns -1 otherwise to indicate an invalid input.
	 * 
	 * @param bound Limit of user input.
	 * @return int between 1 and bound, or -1 if the input is invalid.
	 */
	public static int getInt (int bound)
	{	
		try
		{
			int value = scanner.nextInt();
			if (value < 1 || value > bound - 1) {
				return -1;
			} else {
				return value;
			}
		}
		
		catch(InputMismatchException exception)
		{
			return -1;
		}
		
		finally
		{
			scanner = new Scanner(System.in);
		}
	}
}
