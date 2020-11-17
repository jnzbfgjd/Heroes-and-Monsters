import java.io.*;

public class Sorcerers {
	Hero[] sorcerers;
	int sorcerer_amount = 0;
	String filepath = System.getProperty("user.dir") + "/data/Sorcerers.txt";

	public void initsorcerers() {
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
							sorcerer_amount++;
						}
					}
					sorcerers = new Hero[sorcerer_amount];

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
							sorcerers[count] = new Hero();
							sorcerers[count].initheroitem();
							sorcerers[count].name = strarray[0];
							sorcerers[count].mana = Integer.valueOf(strarray[1]);
							sorcerers[count].strength = Integer.valueOf(strarray[2]);
							sorcerers[count].agility = Integer.valueOf(strarray[3]);
							sorcerers[count].dexterity = Integer.valueOf(strarray[4]);
							sorcerers[count].money = Integer.valueOf(strarray[5]);
							sorcerers[count].experience = Integer.valueOf(strarray[6]);
							sorcerers[count].type = 2;
							sorcerers[count].hp = 100;
							sorcerers[count].level = 1;
							count++;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void showsorcerers() {
		System.out.println("Sorcerers");
		System.out.println(
				"Name                     Mana      Strength  Agility   Dexterity Starting Money Starting Experience ");
		for (int i = 0; i < sorcerers.length; i++) {
			System.out.printf("%-25s%-10s%-10s%-10s%-10s%-15s%-20s\n", sorcerers[i].name, sorcerers[i].mana,
					sorcerers[i].strength, sorcerers[i].agility, sorcerers[i].dexterity, sorcerers[i].money,
					sorcerers[i].experience);
		}
		System.out.println();
	}
}
