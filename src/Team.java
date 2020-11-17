import java.util.Scanner;

public class Team {
	public int number;
	Hero[] heroes;

	// get the number of heroes
	public int getnumber() {
		int num;
		while (true) {
			try {
				System.out.println("please select the number of heroes (1/2/3):");
				Scanner inputnum = new Scanner(System.in);
				num = inputnum.nextInt();
				if (num < 1 || num > 3) {
					throw new Exception("incorrect playernumber");
				}
				break;
			} catch (Exception e) {
				System.out.println("out of bond please reenter");
			}
		}
		return num;
	}

	// show team information
	public void showteam(int num) {
		System.out.println(
				"\nName                     LEVEL     HP        Mana      Strength  Agility   Dexterity Defense   Money     Experience     ");
		for (int i = 0; i < num; i++) {
			System.out.printf("%-25s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-15s\n", heroes[i].name, heroes[i].hp,
					heroes[i].level, heroes[i].mana, heroes[i].strength, heroes[i].agility, heroes[i].dexterity,
					heroes[i].defense, heroes[i].money, heroes[i].experience);
			int[] count = new int[6];
			for (int k = 0; k < heroes[i].hweapons.length; k++) {
				if (heroes[i].hweapons[k].name != null)
					count[0]++;
			}
			for (int k = 0; k < heroes[i].harmors.length; k++) {
				if (heroes[i].harmors[k].name != null)
					count[1]++;
			}
			for (int k = 0; k < heroes[i].hpotions.length; k++) {
				if (heroes[i].hpotions[k].name != null)
					count[2]++;
			}
			for (int k = 0; k < heroes[i].hice_spells.length; k++) {
				if (heroes[i].hice_spells[k].name != null)
					count[3]++;
			}
			for (int k = 0; k < heroes[i].hfire_spells.length; k++) {
				if (heroes[i].hfire_spells[k].name != null)
					count[4]++;
			}
			for (int k = 0; k < heroes[i].hlight_spells.length; k++) {
				if (heroes[i].hlight_spells[k].name != null)
					count[5]++;
			}
			if (count[0] != 0) {
				System.out.println("--------------------Weapons--------------------");
				System.out.println("Name           Cost      level     damage    equip state    ");
				for (int j = 0; j < heroes[i].hweapons.length; j++) {
					if (heroes[i].hweapons[j].name != null) {
						System.out.printf("%-15s%-10s%-10s%-10s%-15s\n", heroes[i].hweapons[j].name,
								heroes[i].hweapons[j].price, heroes[i].hweapons[j].minlevel,
								heroes[i].hweapons[j].damage, heroes[i].hweapons[j].wstate);
					}
				}
			}
			if (count[1] != 0) {
				System.out.println("--------------------Armors--------------------");
				System.out.println("Name                Cost      level     damage reduction    equip state    ");
				for (int j = 0; j < heroes[i].harmors.length; j++) {
					if (heroes[i].harmors[j].name != null) {
						System.out.printf("%-20s%-10s%-10s%-20s%-15s\n", heroes[i].harmors[j].name,
								heroes[i].harmors[j].price, heroes[i].harmors[j].minlevel, heroes[i].harmors[j].rdamage,
								heroes[i].harmors[j].astate);
					}
				}
			}
			if (count[2] != 0) {
				System.out.println("--------------------Potions--------------------");
				System.out.println(
						"Name                Cost      level     attribute increase  attribute affected                             number    ");
				for (int j = 0; j < heroes[i].hpotions.length; j++) {
					if (heroes[i].hpotions[j].name != null) {
						System.out.printf("%-20s%-10s%-10s%-20s", heroes[i].hpotions[j].name,
								heroes[i].hpotions[j].price, heroes[i].hpotions[j].minlevel,
								heroes[i].hpotions[j].pincrease);
						if (heroes[i].hpotions[j].health == true)
							System.out.print("Health ");
						else
							System.out.print("       ");
						if (heroes[i].hpotions[j].mana == true)
							System.out.print("Mana ");
						else
							System.out.print("     ");
						if (heroes[i].hpotions[j].strength == true)
							System.out.print("Strength ");
						else
							System.out.print("         ");
						if (heroes[i].hpotions[j].dexterity == true)
							System.out.print("Dexterity ");
						else
							System.out.print("          ");
						if (heroes[i].hpotions[j].defense == true)
							System.out.print("Defense ");
						else
							System.out.print("        ");
						if (heroes[i].hpotions[j].agility == true)
							System.out.print("Agility ");
						else
							System.out.print("        ");
						System.out.println(heroes[i].hpotions[j].number);
					}
				}
			}
			if (count[3] != 0) {
				System.out.println("--------------------Ice spells--------------------");
				System.out.println("Name                Cost      level     damage    mana cost number    ");
				for (int j = 0; j < heroes[i].hice_spells.length; j++) {
					if (heroes[i].hice_spells[j].name != null) {
						System.out.printf("%-20s%-10s%-10s%-10s%-10s%-10s\n", heroes[i].hice_spells[j].name,
								heroes[i].hice_spells[j].price, heroes[i].hice_spells[j].minlevel,
								heroes[i].hice_spells[j].damage, heroes[i].hice_spells[j].mana,
								heroes[i].hice_spells[j].number);
					}
				}
			}
			if (count[4] != 0) {
				System.out.println("--------------------Fire spells--------------------");
				System.out.println("Name                Cost      level     damage    mana cost number    ");
				for (int j = 0; j < heroes[i].hfire_spells.length; j++) {
					if (heroes[i].hfire_spells[j].name != null) {
						System.out.printf("%-20s%-10s%-10s%-10s%-10s%-10s\n", heroes[i].hfire_spells[j].name,
								heroes[i].hfire_spells[j].price, heroes[i].hfire_spells[j].minlevel,
								heroes[i].hfire_spells[j].damage, heroes[i].hfire_spells[j].mana,
								heroes[i].hfire_spells[j].number);
					}
				}
			}
			if (count[5] != 0) {
				System.out.println("--------------------Lightning spells--------------------");
				System.out.println("Name                Cost      level     damage    mana cost number    ");
				for (int j = 0; j < heroes[i].hlight_spells.length; j++) {
					if (heroes[i].hlight_spells[j].name != null) {
						System.out.printf("%-20s%-10s%-10s%-10s%-10s%-10s\n", heroes[i].hlight_spells[j].name,
								heroes[i].hlight_spells[j].price, heroes[i].hlight_spells[j].minlevel,
								heroes[i].hlight_spells[j].damage, heroes[i].hlight_spells[j].mana,
								heroes[i].hlight_spells[j].number);
					}
				}
			}
		}
	}

	// select heroes
	public void selectheroes() {
		number = getnumber();
		heroes = new Hero[number];
		Warriors w = new Warriors();
		Sorcerers s = new Sorcerers();
		Paladins p = new Paladins();
		w.initwarriors();
		s.initsorcerers();
		p.initpaladins();
		System.out.println("---------------Select Your heroes---------------");
		w.showwarriors();
		s.showsorcerers();
		p.showpaladins();
		for (int i = 0; i < number; i++) {
			int end = 1;
			while (end == 1) {
				try {
					System.out.print("Please enter the name of hero " + (i + 1) + " :");
					Scanner inputname = new Scanner(System.in);
					String name = inputname.next();
					for (int j = 0; j < w.warrior_amount; j++) {
						if (w.warriors[j].name.equals(name)) {
							heroes[i] = new Hero();
							heroes[i] = w.warriors[j];
							end = 0;
						}
					}
					if (end != 0) {
						for (int j = 0; j < s.sorcerer_amount; j++) {
							if (s.sorcerers[j].name.equals(name)) {
								heroes[i] = new Hero();
								heroes[i] = s.sorcerers[j];
								end = 0;
							}
						}
					}
					if (end != 0) {
						for (int j = 0; j < p.paladin_amount; j++) {
							if (p.paladins[j].name.equals(name)) {
								heroes[i] = new Hero();
								heroes[i] = p.paladins[j];
								end = 0;
							}
						}
					}
					if (end == 1) {
						throw new Exception();
					}
				} catch (Exception e) {
					System.out.println("Invalid name of hero, please reenter!");
				}

			}
		}
		showteam(number);
	}

	// choose hero to enter the market
	public int choosehero() {
		System.out.println("Select the hero to operate (name of hero):");
		int end = 0;
		int num = 0;
		while (end == 0) {
			try {
				Scanner input = new Scanner(System.in);
				String markethero = input.next();
				for (int i = 0; i < number; i++) {
					if (heroes[i].name.equals(markethero)) {
						end = 1;
						num = i;
					}
				}
				if (end == 0) {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Invalid input please reenter:");
			}
		}
		return num;
	}

	// the menu when you operate the bag
	public void bagoperate(int num) {
		System.out.println("1.Weapon operate");
		System.out.println("2.Armor operate");
		System.out.println("3.Potion operate");
		System.out.println("4.Exit bag");
		System.out.println("Please choose your operate:");
		int num1;
		while (true) {
			try {
				Scanner input1 = new Scanner(System.in);
				num1 = input1.nextInt();
				if (num1 < 1 || num1 > 4)
					throw new Exception();
				break;
			} catch (Exception e) {
				System.out.println("Invalid input please reenter:");
			}
		}
		if (num1 == 4) {
			System.out.println("Exit the bag");
		} else {
			System.out.println("Please enter the name of item:");
			Scanner input2 = new Scanner(System.in);
			String itname = input2.next();
			if (num1 == 1) {
				boolean b = false;
				for (int i = 0; i < heroes[num].hweapons.length; i++) {
					if (itname.equals(heroes[num].hweapons[i].name)) {
						b = true;
						if (heroes[num].level >= heroes[num].hweapons[i].minlevel) {
							if (heroes[num].hweapons[i].wstate == false) {
								System.out.println("The weapon is not equiped now, do you want to equip (Y/N):");
								String s = YorN();
								if (s.equals("Y")) {
									System.out.println("Successful used!");
									heroes[num].hweapons[i].wstate = true;
									heroes[num].strength += heroes[num].hweapons[i].damage;
									for (int j = 0; j < heroes[num].hweapons.length; j++) {
										if (j != i)
											heroes[num].hweapons[j].wstate = false;
									}
								}
							} else if (heroes[num].hweapons[i].wstate == true) {
								System.out.println("The weapon is equiped now, do you want to remove (Y/N):");
								String s = YorN();
								if (s.equals("Y")) {
									System.out.println("Successful removed!");
									heroes[num].strength -= heroes[num].hweapons[i].damage;
									heroes[num].hweapons[i].wstate = false;
								}
							}
						} else
							System.out.println("Not enough level!");
					}
				}
				if (b == false) {
					System.out.println("Invalid input!");
				}
			} else if (num1 == 2) {
				boolean b = false;
				for (int i = 0; i < heroes[num].harmors.length; i++) {
					if (itname.equals(heroes[num].harmors[i].name)) {
						b = true;
						if (heroes[num].level >= heroes[num].harmors[i].minlevel) {
							if (heroes[num].harmors[i].astate == false) {
								System.out.println("The armor is not equiped now, do you want to equip (Y/N):");
								String s = YorN();
								if (s.equals("Y")) {
									System.out.println("Successful equiped!");
									heroes[num].defense += heroes[num].harmors[i].rdamage;
									heroes[num].harmors[i].astate = true;
									for (int j = 0; j < heroes[num].harmors.length; j++) {
										if (j != i)
											heroes[num].harmors[j].astate = false;
									}
								}
							} else if (heroes[num].harmors[i].astate == true) {
								System.out.println("The armor is equiped now, do you want to remove (Y/N):");
								String s = YorN();
								if (s.equals("Y")) {
									heroes[num].defense -= heroes[num].harmors[i].rdamage;
									System.out.println("Successful removed!");
									heroes[num].harmors[i].astate = false;
								}
							}
						} else
							System.out.println("Not enough level!");
					}
				}
				if (b == false) {
					System.out.println("Invalid input!");
				}
			} else if (num1 == 3) {
				boolean b = false;
				for (int i = 0; i < heroes[num].hpotions.length; i++) {
					if (itname.equals(heroes[num].hpotions[i].name)) {
						b = true;
						if (heroes[num].level >= heroes[num].hpotions[i].minlevel) {
							System.out.println("Do you want to use the potion (Y/N):");
							String s = YorN();
							if (s.equals("Y")) {
								System.out.println("Successful use!");
								if (heroes[num].hpotions[i].health) {
									heroes[num].hp += heroes[num].hpotions[i].pincrease;
								}
								if (heroes[num].hpotions[i].mana) {
									heroes[num].mana += heroes[num].hpotions[i].pincrease;
								}
								if (heroes[num].hpotions[i].strength) {
									heroes[num].strength += heroes[num].hpotions[i].pincrease;
								}
								if (heroes[num].hpotions[i].agility) {
									heroes[num].agility += heroes[num].hpotions[i].pincrease;
								}
								if (heroes[num].hpotions[i].defense) {
									heroes[num].defense += heroes[num].hpotions[i].pincrease;
								}
								if (heroes[num].hpotions[i].dexterity) {
									heroes[num].dexterity += heroes[num].hpotions[i].pincrease;
								}
								if (heroes[num].hpotions[i].number == 1) {
									heroes[num].hpotions[i] = new Hero().new HPotion();
								} else
									heroes[num].hpotions[i].number--;
							}

						} else
							System.out.println("Not enough level!");
					}
				}
				if (b == false) {
					System.out.println("Invalid input!");
				}
			}
		}
	}

	public String YorN() {
		String s;
		while (true) {
			try {
				Scanner input = new Scanner(System.in);
				s = input.next();
				if ((s.equals("Y") == false) && (s.equals("N") == false)) {
					throw new Exception();
				}
				break;
			} catch (Exception e) {
				System.out.println("Invalid input please reenter!");
			}
		}
		return s;
	}

	/*
	 * public static void main(String args[]) { Team t = new Team();
	 * t.selectheroes(); }
	 */

}
