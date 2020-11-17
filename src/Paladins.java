import java.io.*;

public class Paladins {
	Hero[] paladins;
	int paladin_amount = 0;
	String filepath = System.getProperty("user.dir") + "/data/Paladins.txt";

	public void initpaladins() {
		File file = new File(filepath);
		{
			if (file.isFile() && file.exists()) {
				try {
					FileInputStream fileInputStream = new FileInputStream(file);
					InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
					BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

					String text = null;
					bufferedReader.readLine();
					while ((text = bufferedReader.readLine()) != null) {
						if (text.equals("") == false) {
							paladin_amount++;
						}
					}
					paladins = new Hero[paladin_amount];

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
							paladins[count] = new Hero();
							paladins[count].initheroitem();
							paladins[count].name = strarray[0];
							paladins[count].mana = Integer.valueOf(strarray[1]);
							paladins[count].strength = Integer.valueOf(strarray[2]);
							paladins[count].agility = Integer.valueOf(strarray[3]);
							paladins[count].dexterity = Integer.valueOf(strarray[4]);
							paladins[count].money = Integer.valueOf(strarray[5]);
							paladins[count].experience = Integer.valueOf(strarray[6]);
							paladins[count].type = 3;
							paladins[count].hp = 100;
							paladins[count].level = 1;
							count++;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void showpaladins() {
		System.out.println("Paladins");
		System.out.println(
				"Name                     Mana      Strength  Agility   Dexterity Starting Money Starting Experience ");
		for (int i = 0; i < paladins.length; i++) {
			System.out.printf("%-25s%-10s%-10s%-10s%-10s%-15s%-20s\n", paladins[i].name, paladins[i].mana,
					paladins[i].strength, paladins[i].agility, paladins[i].dexterity, paladins[i].money,
					paladins[i].experience);
		}
		System.out.println();
	}
}
