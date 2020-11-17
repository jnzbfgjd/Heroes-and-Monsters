import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Exoskeletons extends Monster {
	// the amount of Exoskeletons
	public int exoamount = 0;
	Monster[] emonster;

	private String filepath = System.getProperty("user.dir") + "/data/Exoskeletons.txt";

	// initialize the exoskeletons from txt file
	public void initexos() {
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
						exoamount++;
					}
				}
				emonster = new Monster[exoamount];

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
						emonster[count] = new Monster();
						emonster[count].name = strarray[0];
						emonster[count].level = Integer.valueOf(strarray[1]);
						emonster[count].hp = emonster[count].level * 100;
						emonster[count].damage = Integer.valueOf(strarray[2]);
						emonster[count].defense = Integer.valueOf(strarray[3]);
						emonster[count].dodge_chance = Integer.valueOf(strarray[4]);
						count++;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
