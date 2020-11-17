import java.util.*;

public class World {
	public int length = 8;
	public int width = 8;
	public int[][] map = new int[length][width];
	public position plocation;

	// the player's location
	public class position {
		public int x;
		public int y;
	}

	// initialize the map
	public void initmap() {
		Random R = new Random();
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < width; j++) {
				int randomnum = R.nextInt(10);
				if (randomnum <= 1) {
					// non-accessible cells
					map[i][j] = 1;
				} else if (randomnum <= 4) {
					// markets cells
					map[i][j] = 2;
				} else {
					// common cells
					map[i][j] = 3;
				}
			}
		}
	}

	// initialize the player
	public void initplayer() {
		Random R1 = new Random();
		Random R2 = new Random();
		int r1, r2;
		do {
			r1 = R1.nextInt(length);
			r2 = R2.nextInt(width);
		} while (map[r2][r1] == 1);
		plocation = new position();
		plocation.x = r1;
		plocation.y = r2;
	}

	// judge the movement
	public boolean judge(int a, int b) {
		if (a >= 0 && a <= (width - 1) && b >= 0 && b <= (length - 1)) {
			return true;
		} else
			return false;
	}

	public void showmap() {
		for (int i = 0; i < 2 * length + 1; i++) {
			if (i % 2 == 0)
				System.out.print("+");
			else
				System.out.print("|");
			for (int j = 0; j < 2 * width; j++) {
				if ((i + 1) % 2 == 1) {
					if (j % 2 == 0)
						System.out.print(" - -");
					else
						System.out.print(" +");
				} else {
					if (j % 2 == 0) {
						if (plocation.y == i / 2 && plocation.x == j / 2) {
							System.out.print("  P  ");
						} else if (map[i / 2][j / 2] == 1) {
							System.out.print("  X  ");
						} else if (map[i / 2][j / 2] == 2) {
							System.out.print("  M  ");
						} else if (map[i / 2][j / 2] == 3) {
							System.out.print("     ");
						}
					} else
						System.out.print("|");
				}
			}
			System.out.print("\n");
		}
		System.out.print("\nX:Non-accessible    M:Market       P:Player location\n");
	}
}
