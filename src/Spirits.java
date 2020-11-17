import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Spirits extends Monster {
	// the amount of Spirits
	public int spiritamount = 0;
	Monster[] smonster;

	private String filepath = System.getProperty("user.dir") + "/data/Spirits.txt";

	public void initspirits() {
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
						spiritamount++;
					}
				}
				smonster = new Monster[spiritamount];

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
						smonster[count] = new Monster();
						smonster[count].name = strarray[0];
						smonster[count].level = Integer.valueOf(strarray[1]);
						smonster[count].hp = smonster[count].level * 100;
						smonster[count].damage = Integer.valueOf(strarray[2]);
						smonster[count].defense = Integer.valueOf(strarray[3]);
						smonster[count].dodge_chance = Integer.valueOf(strarray[4]);
						count++;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
