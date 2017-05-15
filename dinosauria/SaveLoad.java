/**
 * Version 0.2
 */

package dinosauria;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SaveLoad {
	/**
	 * 0 = Good
	 * 1 = Exists
	 * 2 = Failure
	 * 
	 * @param file
	 * @param players
	 * @param playerNumber
	 * @param dayNumber
	 * @param currentDay
	 * @param actionPoints
	 * @return
	 */
	public static int saveGame (String file, ArrayList<Player> players, 
								int playerNumber, int dayNumber, int currentDay, int actionPoints)
	{
		try {
			File testFile = new File(file + ".dino");
			String path = testFile.getCanonicalPath(); // Raises IOException if the filename is illegal.
			
			// Test whether the file already exists.
			if (testFile.isFile()) { 
				return 1;
			} 
			
			// Write to file.
			else {
				FileOutputStream save = new FileOutputStream(file + ".dino");
				ObjectOutputStream out = new ObjectOutputStream(save);
				out.writeObject(players);
				out.writeInt(playerNumber);
				out.writeInt(dayNumber);
				out.writeInt(currentDay);
				out.writeInt(actionPoints);
				out.close();
				save.close();
				return 0;
			} 
			
		} catch(IOException e) {
			return 2;
		}
		
	}
	
	
	public static boolean loadGame (String file)
	{
		try {
			FileInputStream save = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(save);
			
			ArrayList<Player> players = (ArrayList<Player>) in.readObject();
			int playerNumber = in.readInt();
			int dayNumber = in.readInt();
			int currentDay = in.readInt();
			int actionPoints = in.readInt();
			in.close();
			save.close();
			return GameGUI.setGameState(players, playerNumber, dayNumber, currentDay, actionPoints);
		} catch(IOException e) {
			return false;
		} catch(ClassNotFoundException c) {
	         return false;
	    }
	}
	
	public static boolean saveHighScores (ArrayList<Player> newHighScores)
	{
		try {
			FileOutputStream save = new FileOutputStream("highscores.save");
			ObjectOutputStream out = new ObjectOutputStream(save);
			out.writeObject(newHighScores);
			return true;
		} catch(IOException e) {
			return false;
		}
	}
	
	public static ArrayList<Player> loadHighScores ()
	{
		try {
			FileInputStream save = new FileInputStream("highscores.save");
			ObjectInputStream in = new ObjectInputStream(save);
			ArrayList<Player> players = (ArrayList<Player>) in.readObject();
			in.close();
			save.close();
			return players;
			
		} catch(IOException e) {
			return null;
			
		} catch(ClassNotFoundException c) {
	         return null;
	    }
	}
		
}
