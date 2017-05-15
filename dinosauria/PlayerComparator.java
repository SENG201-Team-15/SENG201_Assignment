package dinosauria;

import java.util.Comparator;

public class PlayerComparator implements Comparator<Player>
{
	@Override
	public int compare(Player player1, Player player2) {
		if (player1.getScore() > player2.getScore()) {
			return -1;
		} else if (player1.getScore() < player2.getScore()) {
			return 1;
		} else {
			return 0;
		}
	}
}
