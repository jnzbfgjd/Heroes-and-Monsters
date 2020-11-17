import java.io.*;

public class Dragons extends Monster {
	// the amount of dragons
	public int dragonamount = 0;
	Monster[] dmonster;

	private String filepath = System.getProperty("user.dir") + "/data/Dragons.txt";

	// initialize the dragon from txt file
	public void initdragons() {
		File file = new File(filepath);
		if (file.isFile() && file.exists()) {
			try {
				FileInputStream fileInputStream = new FileInputStream(file);
				InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

				String text = null;
				bufferedReader.readLine();
				while ((text = bufferedReader.readLine()) != null) {
					if (text.equals("") == false) {
						dragonamount++;
					}
				}
				dmonster = new Monster[dragonamount];

				FileInputStream fileInputStream1 = new FileInputStream(file);
				InputStreamReader inputStreamReader1 = new InputStreamReader(fileInputStream1);
				BufferedReader bufferedReader1 = new BufferedReader(inputStreamReader1);

				String text1 = null;
				// skip the first line
				bufferedReader1.readLine();
				int count = 0;

				while ((text1 = bufferedReader1.readLine()) != null) {
					if (text1.equals("") == false) {
						// Multiple spaces
						String[] strarray = text1.split("\\s+");
						dmonster[count] = new Monster();
						dmonster[count].name = strarray[0];
						dmonster[count].level = Integer.valueOf(strarray[1]);
						dmonster[count].hp = dmonster[count].level * 100;
						dmonster[count].damage = Integer.valueOf(strarray[2]);
						dmonster[count].defense = Integer.valueOf(strarray[3]);
						dmonster[count].dodge_chance = Integer.valueOf(strarray[4]);
						count++;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
