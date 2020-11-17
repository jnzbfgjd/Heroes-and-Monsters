import java.io.*;

public class Warriors {

	Hero[] warriors;
	int warrior_amount = 0;
	String filepath = System.getProperty("user.dir") + "/data/Warriors.txt";

	public void initwarriors() {
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
							warrior_amount++;
						}
					}
					warriors = new Hero[warrior_amount];

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
							warriors[count] = new Hero();
							warriors[count].initheroitem();
							warriors[count].name = strarray[0];
							warriors[count].mana = Integer.valueOf(strarray[1]);
							warriors[count].strength = Integer.valueOf(strarray[2]);
							warriors[count].agility = Integer.valueOf(strarray[3]);
							warriors[count].dexterity = Integer.valueOf(strarray[4]);
							warriors[count].money = Integer.valueOf(strarray[5]);
							warriors[count].experience = Integer.valueOf(strarray[6]);
							warriors[count].type = 1;
							warriors[count].hp = 100;
							warriors[count].level = 1;
							count++;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void showwarriors() {
		System.out.println("Warriors");
		System.out.println(
				"Name                     Mana      Strength  Agility   Dexterity Starting Money Starting Experience ");
		for (int i = 0; i < warriors.length; i++) {
			System.out.printf("%-25s%-10s%-10s%-10s%-10s%-15s%-20s\n", warriors[i].name, warriors[i].mana,
					warriors[i].strength, warriors[i].agility, warriors[i].dexterity, warriors[i].money,
					warriors[i].experience);
		}
		System.out.println();
	}
}
