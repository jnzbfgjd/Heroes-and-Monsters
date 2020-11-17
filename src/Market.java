import java.io.*;
import java.util.Scanner;

public class Market {

	int weapon_amount;

	int armor_amount;

	int potion_amount;

	int icespell_amount;

	int firespell_amount;

	int lightspell_amount;

	public Weapon[] weapons;

	public Armor[] armors;

	public Potion[] potions;

	public Ice_spell[] ice_spells;

	public Fire_spell[] fire_spells;

	public Lightning_spell[] lightning_spells;

	// initialize the weapon
	public void initweapon() {
		weapon_amount = 0;
		String filepath = System.getProperty("user.dir") + "/data/Weaponry.txt";

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
						weapon_amount++;
					}
				}
				weapons = new Weapon[weapon_amount];

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
						weapons[count] = new Weapon();
						weapons[count].name = strarray[0];
						weapons[count].price = Integer.valueOf(strarray[1]);
						weapons[count].minlevel = Integer.valueOf(strarray[2]);
						weapons[count].damage = Integer.valueOf(strarray[3]);
						weapons[count].required_hands = Integer.valueOf(strarray[4]);
						count++;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// initialize the armor
	public void initarmor() {
		armor_amount = 0;
		String filepath = System.getProperty("user.dir") + "/data/Armory.txt";

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
						armor_amount++;
					}
				}
				armors = new Armor[armor_amount];

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
						armors[count] = new Armor();
						armors[count].name = strarray[0];
						armors[count].price = Integer.valueOf(strarray[1]);
						armors[count].minlevel = Integer.valueOf(strarray[2]);
						armors[count].rdamage = Integer.valueOf(strarray[3]);
						count++;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// initialize the potion
	public void initpotion() {
		potion_amount = 0;
		String filepath = System.getProperty("user.dir") + "/data/Potions.txt";

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
						potion_amount++;
					}
				}
				potions = new Potion[potion_amount];

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
						potions[count] = new Potion();
						potions[count].name = strarray[0];
						potions[count].price = Integer.valueOf(strarray[1]);
						potions[count].minlevel = Integer.valueOf(strarray[2]);
						potions[count].pincrease = Integer.valueOf(strarray[3]);
						String[] strarray1 = strarray[4].split("/");
						for (String str : strarray1) {
							if (str.equals("Health")) {
								potions[count].health = true;
							}
							if (str.equals("Mana")) {
								potions[count].mana = true;
							}
							if (str.equals("Strength")) {
								potions[count].strength = true;
							}
							if (str.equals("Dexterity")) {
								potions[count].dexterity = true;
							}
							if (str.equals("Defense")) {
								potions[count].defense = true;
							}
							if (str.equals("Agility")) {
								potions[count].agility = true;
							}
						}
						count++;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// initialize the ice spells
	public void initicespell() {
		icespell_amount = 0;
		String filepath = System.getProperty("user.dir") + "/data/IceSpells.txt";

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
						icespell_amount++;
					}
				}
				ice_spells = new Ice_spell[icespell_amount];

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
						ice_spells[count] = new Ice_spell();
						ice_spells[count].name = strarray[0];
						ice_spells[count].price = Integer.valueOf(strarray[1]);
						ice_spells[count].minlevel = Integer.valueOf(strarray[2]);
						ice_spells[count].damage = Integer.valueOf(strarray[3]);
						ice_spells[count].mana = Integer.valueOf(strarray[4]);
						count++;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// initialize the fire spells
	public void initfirespell() {
		firespell_amount = 0;
		String filepath = System.getProperty("user.dir") + "/data/FireSpells.txt";

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
						firespell_amount++;
					}
				}
				fire_spells = new Fire_spell[firespell_amount];

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
						fire_spells[count] = new Fire_spell();
						fire_spells[count].name = strarray[0];
						fire_spells[count].price = Integer.valueOf(strarray[1]);
						fire_spells[count].minlevel = Integer.valueOf(strarray[2]);
						fire_spells[count].damage = Integer.valueOf(strarray[3]);
						fire_spells[count].mana = Integer.valueOf(strarray[4]);
						count++;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// initialize the fire spells
	public void initlightspell() {
		lightspell_amount = 0;
		String filepath = System.getProperty("user.dir") + "/data/LightningSpells.txt";

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
						lightspell_amount++;
					}
				}
				lightning_spells = new Lightning_spell[lightspell_amount];

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
						lightning_spells[count] = new Lightning_spell();
						lightning_spells[count].name = strarray[0];
						lightning_spells[count].price = Integer.valueOf(strarray[1]);
						lightning_spells[count].minlevel = Integer.valueOf(strarray[2]);
						lightning_spells[count].damage = Integer.valueOf(strarray[3]);
						lightning_spells[count].mana = Integer.valueOf(strarray[4]);
						count++;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void showmarket(Market m) {
		m.initarmor();
		m.initweapon();
		m.initpotion();
		m.initfirespell();
		m.initicespell();
		m.initlightspell();
		System.out.println("---------------Welcome To The Market---------------");
		// weapon market
		System.out.println("Weapons");
		System.out.println("Name           Cost      level     damage    ");
		for (int i = 0; i < m.weapons.length; i++) {
			System.out.printf("%-15s%-10s%-10s%-10s\n", m.weapons[i].name, m.weapons[i].price, m.weapons[i].minlevel,
					m.weapons[i].damage);
		}
		// armor market
		System.out.println("\nArmors");
		System.out.println("Name                Cost      level     damage reduction    ");
		for (int i = 0; i < m.armors.length; i++) {
			System.out.printf("%-20s%-10s%-10s%-20s\n", m.armors[i].name, m.armors[i].price, m.armors[i].minlevel,
					m.armors[i].rdamage);
		}
		// potion market
		System.out.println("\nPotions");
		System.out.println("Name                Cost      level     attribute increase  attribute affected  ");
		for (int i = 0; i < m.potions.length; i++) {
			System.out.printf("%-20s%-10s%-10s%-20s", m.potions[i].name, m.potions[i].price, m.potions[i].minlevel,
					m.potions[i].pincrease);
			if (m.potions[i].health == true)
				System.out.print("Health ");
			if (m.potions[i].mana == true)
				System.out.print("Mana ");
			if (m.potions[i].strength == true)
				System.out.print("Strength ");
			if (m.potions[i].dexterity == true)
				System.out.print("Dexterity ");
			if (m.potions[i].defense == true)
				System.out.print("Defense ");
			if (m.potions[i].agility == true)
				System.out.print("Agility ");
			System.out.println();
		}
		// ice spell market
		System.out.println("\nIce spells");
		System.out.println("Name                Cost      level     damage    mana cost ");
		for (int i = 0; i < m.ice_spells.length; i++) {
			System.out.printf("%-20s%-10s%-10s%-10s%-10s\n", m.ice_spells[i].name, m.ice_spells[i].price,
					m.ice_spells[i].minlevel, m.ice_spells[i].damage, m.ice_spells[i].mana);
		}
		// fire spell market
		System.out.println("\nFire spells");
		System.out.println("Name                Cost      level     damage    mana cost ");
		for (int i = 0; i < m.fire_spells.length; i++) {
			System.out.printf("%-20s%-10s%-10s%-10s%-10s\n", m.fire_spells[i].name, m.fire_spells[i].price,
					m.fire_spells[i].minlevel, m.fire_spells[i].damage, m.fire_spells[i].mana);
		}
		// lightning spell market
		System.out.println("\nLightning spells");
		System.out.println("Name                Cost      level     damage    mana cost ");
		for (int i = 0; i < m.lightning_spells.length; i++) {
			System.out.printf("%-20s%-10s%-10s%-10s%-10s\n", m.lightning_spells[i].name, m.lightning_spells[i].price,
					m.lightning_spells[i].minlevel, m.lightning_spells[i].damage, m.lightning_spells[i].mana);
		}

	}

	public int buyweapon(String itemname) {
		int num = -1;
		for (int i = 0; i < weapon_amount; i++) {
			if (weapons[i].name.equals(itemname)) {
				num = i;
			}
		}
		return num;
	}

	public int buyarmor(String itemname) {
		int num = -1;
		for (int i = 0; i < armor_amount; i++) {
			if (armors[i].name.equals(itemname)) {
				num = i;
			}
		}
		return num;
	}

	public int buypotion(String itemname) {
		int num = -1;
		for (int i = 0; i < potion_amount; i++) {
			if (potions[i].name.equals(itemname)) {
				num = i;
			}
		}
		return num;
	}

	public int buyicespell(String itemname) {
		int num = -1;
		for (int i = 0; i < icespell_amount; i++) {
			if (ice_spells[i].name.equals(itemname)) {
				num = i;
			}
		}
		return num;
	}

	public int buyfirespell(String itemname) {
		int num = -1;
		for (int i = 0; i < firespell_amount; i++) {
			if (fire_spells[i].name.equals(itemname)) {
				num = i;
			}
		}
		return num;
	}

	public int buylightningspell(String itemname) {
		int num = -1;
		for (int i = 0; i < lightspell_amount; i++) {
			if (lightning_spells[i].name.equals(itemname)) {
				num = i;
			}
		}
		return num;
	}
}
