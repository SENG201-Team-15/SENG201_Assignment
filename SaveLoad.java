package dinosauria;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SaveLoad {
	public static boolean saveGame (String file, ArrayList<Player> players, 
			int playerNumber, int dayNumber, int currentDay, int actionPoints)
	{
		
		try {
			// Check if save already exists.
			if (new File(file + ".dino").isFile()) {
				return false;
			} else {
				FileOutputStream save = new FileOutputStream(file + ".dino");
				ObjectOutputStream out = new ObjectOutputStream(save);
				out.writeObject(players);
				out.writeInt(playerNumber);
				out.writeInt(dayNumber);
				out.writeInt(currentDay);
				out.writeInt(actionPoints);
				out.close();
				save.close();
				System.out.print("SAVED");
				return true;
				
			}
		} catch(IOException e) {
			return false;
		}
		
	}
	
	
	public static boolean loadGame (String file)
	{
		try {
			FileInputStream save = new FileInputStream(file + ".dino");
			ObjectInputStream in = new ObjectInputStream(save);
			
			ArrayList<Player> players = (ArrayList<Player>) in.readObject();
			int playerNumber = in.readInt();
			int dayNumber = in.readInt();
			int currentDay = in.readInt();
			int actionPoints = in.readInt();
			in.close();
			save.close();
			System.out.print("LOADED");
			return GameGUI.setGameState(players, playerNumber, dayNumber, currentDay, actionPoints);
		} catch(IOException e) {
			return false;
		} catch(ClassNotFoundException c) {
	         return false;
	    }
	}
}
