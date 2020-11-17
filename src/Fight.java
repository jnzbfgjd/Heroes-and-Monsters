import java.util.Random;
import java.util.Scanner;

public class Fight {
	Hero[] heroes;
	Monster[] monsters;
	// the highest level of heroes
	int maxlevel;
	// number of heroes
	int number;

	// initialize the monsters to enter the fight according to the number of heroes
	public void selectmonster() {
		int count = 0;
		boolean end = false;
		monsters = new Monster[number];
		Dragons dmonster = new Dragons();
		Exoskeletons emonster = new Exoskeletons();
		Spirits smonster = new Spirits();
		dmonster.initdragons();
		emonster.initexos();
		smonster.initspirits();
		while (true) {
			for (int j = 0; j < dmonster.dragonamount; j++) {
				if (dmonster.dmonster[j].level == maxlevel) {
					Random random = new Random();
					int r = random.nextInt(2);
					if (r == 0) {
						monsters[count] = new Monster();
						monsters[count] = dmonster.dmonster[j];
						count++;
						if (count == number)
							end = true;
					}
				}
			}
			if (end == true)
				break;
			for (int j = 0; j < emonster.exoamount; j++) {
				if (emonster.emonster[j].level == maxlevel) {
					Random random = new Random();
					int r = random.nextInt(2);
					if (r == 0) {
						monsters[count] = new Monster();
						monsters[count] = emonster.emonster[j];
						count++;
						if (count == number)
							end = true;
					}
				}
			}
			if (end == true)
				break;
			for (int j = 0; j < smonster.spiritamount; j++) {
				if (smonster.smonster[j].level == maxlevel) {
					Random random = new Random();
					int r = random.nextInt(2);
					if (r == 0) {
						monsters[count] = new Monster();
						monsters[count] = smonster.smonster[j];
						count++;
						if (count == number)
							end = true;
					}
				}
			}
			if (end == true)
				break;
			System.out.println(end);
		}
	}

	public void showmonster() {
		System.out.println("--------------------------------Monster Information--------------------------------");
		System.out.println("Name                Level     HP      Damage    Defense   Dodge     ");
		for (int i = 0; i < number; i++) {
			System.out.printf("%-20s%-10s%-10s%-10s%-10s%-10s\n", monsters[i].name, monsters[i].level, monsters[i].hp,
					monsters[i].damage, monsters[i].defense, monsters[i].dodge_chance);
		}
	}

	public void showhero() {
		System.out.println("------------------------------------Heroes Information-----------------------------------");
		System.out.println(
				"\nName                     Level     HP        Mana      Strength  Agility   Dexterity Defense   ");
		for (int i = 0; i < number; i++) {
			System.out.printf("%-25s%-10s%-10s%-10s%-10s%-10s%-10s%-10s\n", heroes[i].name, heroes[i].level,
					heroes[i].hp, heroes[i].mana, heroes[i].strength, heroes[i].agility, heroes[i].dexterity,
					heroes[i].defense);
		}
	}

	// find the highest level in the heroes' team
	public void highlevel() {
		for (int i = 0; i < number; i++) {
			if (heroes[i].level >= maxlevel)
				maxlevel = heroes[i].level;
		}
	}

	// start the fight
	public boolean startfight() {
		boolean end = false;
		int round = 0;
		int count1 = 0, count2 = 0;

		while (end == false) {
			count1 = 0;
			count2 = 0;
			round++;
			System.out.println("-------------------------Round " + round + "-------------------------");
			showhero();
			showmonster();
			for (int i = 0; i < number; i++) {
				// System.out.println(heroes[i].alive);
				if (heroes[i].alive == true) {
					count1++;
					for (int j = 0; j < number; j++) {
						if (monsters[(j + i) % number].alive == true) {
							while (true) {
								boolean b = fightmenu(i, (j + i) % number);
								if (b == true)
									break;
							}
							break;
						}
					}
				}
			}
			for (int i = 0; i < number; i++) {
				// System.out.println(monsters[i].alive);
				if (monsters[i].alive == true) {
					count2++;
					for (int j = 0; j < number; j++) {
						if (heroes[(j + i) % number].alive == true) {
							monsterattack(i, (j + i) % number);
						}
					}
				}
			}
			// System.out.println("count1="+count1+"count2="+count2);
			if (count1 == 0 || count2 == 0) {
				end = true;
			}
		}
		if (count2 == 0) {
			return true;
		} else
			return false;
	}

	// monster attack the hero
	public void monsterattack(int mnum, int hnum) {
		System.out.println(monsters[mnum].name + " attack " + heroes[hnum].name);
		Random r = new Random();
		int r1 = r.nextInt(1000);
		if (r1 >= heroes[hnum].agility) {
			int damage;
			damage = (int) ((monsters[mnum].damage - heroes[hnum].defense) * 0.05);
			if (damage < 0)
				damage = 0;
			heroes[hnum].hp -= damage;
			System.out.println(monsters[mnum].name + " cause " + damage + " damage to " + heroes[hnum].name);
			if (heroes[hnum].hp <= 0) {
				heroes[hnum].alive = false;
				heroes[hnum].hp = 0;
			}
		} else
			System.out.println("Missed!");
	}

	// the menu of hero when fight
	public boolean fightmenu(int num, int mnum) {
		System.out.println("1.Weapon operate");
		System.out.println("2.Armor operate");
		System.out.println("3.Potion operate");
		System.out.println("4.Cast ice spell");
		System.out.println("5.Cast fire spell");
		System.out.println("6.Cast lightning spell");
		System.out.println("7.Normal attack");
		System.out.println(heroes[num].name + " please select your movement:");
		int num1;
		// judge if the player operate or not
		boolean op = false;
		while (true) {
			try {
				Scanner input1 = new Scanner(System.in);
				num1 = input1.nextInt();
				if (num1 < 1 || num1 > 7)
					throw new Exception();
				break;
			} catch (Exception e) {
				System.out.println("Invalid input please reenter:");
			}
		}
		if (num1 != 7) {
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
									heroes[num].strength += heroes[num].hweapons[i].damage;
									op = true;
									heroes[num].hweapons[i].wstate = true;
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
									op = true;
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
									op = true;
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
									op = true;
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
								op = true;
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
			} else if (num1 == 4) {
				boolean b = false;
				for (int i = 0; i < heroes[num].hice_spells.length; i++) {
					if (itname.equals(heroes[num].hice_spells[i].name)) {
						b = true;
						if (heroes[num].level >= heroes[num].hice_spells[i].minlevel) {
							System.out.println("Do you want to use the spell (Y/N):");
							String s = YorN();
							if (s.equals("Y")) {
								if (heroes[num].mana >= heroes[num].hice_spells[i].mana) {
									System.out.println("Successful use!");
									op = true;
									heroes[num].mana -= heroes[num].hice_spells[i].mana;
									int damage;
									damage = (int) (heroes[num].hice_spells[i].damage
											* (1 + heroes[num].dexterity / 10000));
									monsters[mnum].hp -= damage;
									if (monsters[mnum].hp <= 0) {
										monsters[mnum].alive = false;
										monsters[mnum].hp = 0;
									}
									System.out.println(heroes[num].name + " cause " + damage + " damage to "
											+ monsters[mnum].name);
									monsters[mnum].damage -= heroes[num].hice_spells[i].reducedamage;
									if (heroes[num].hice_spells[i].number == 1) {
										heroes[num].hice_spells[i] = new Hero().new HIce_spell();
									} else
										heroes[num].hice_spells[i].number--;
								} else
									System.out.println("Not enough mana!");
							}
						} else
							System.out.println("Not enough level!");
					}
				}
				if (b == false) {
					System.out.println("Invalid input!");
				}
			} else if (num1 == 5) {
				boolean b = false;
				for (int i = 0; i < heroes[num].hfire_spells.length; i++) {
					if (itname.equals(heroes[num].hfire_spells[i].name)) {
						b = true;
						if (heroes[num].level >= heroes[num].hfire_spells[i].minlevel) {
							System.out.println("Do you want to use the spell (Y/N):");
							String s = YorN();
							if (s.equals("Y")) {
								if (heroes[num].mana >= heroes[num].hfire_spells[i].mana) {
									System.out.println("Successful use!");
									op = true;
									heroes[num].mana -= heroes[num].hfire_spells[i].mana;
									int damage;
									damage = (int) (heroes[num].hfire_spells[i].damage
											* (1 + heroes[num].dexterity / 10000));
									monsters[mnum].hp -= damage;
									if (monsters[mnum].hp <= 0) {
										monsters[mnum].alive = false;
										monsters[mnum].hp = 0;
									}
									System.out.println(heroes[num].name + " cause " + damage + " damage to "
											+ monsters[mnum].name);
									monsters[mnum].defense -= heroes[num].hfire_spells[i].reducedefense;
									if (heroes[num].hfire_spells[i].number == 1) {
										heroes[num].hfire_spells[i] = new Hero().new HFire_spell();
									} else
										heroes[num].hfire_spells[i].number--;
								} else
									System.out.println("Not enough mana!");
							}
						} else
							System.out.println("Not enough level!");
					}
				}
				if (b == false) {
					System.out.println("Invalid input!");
				}
			} else if (num1 == 6) {
				boolean b = false;
				for (int i = 0; i < heroes[num].hlight_spells.length; i++) {
					if (itname.equals(heroes[num].hlight_spells[i].name)) {
						b = true;
						if (heroes[num].level >= heroes[num].hlight_spells[i].minlevel) {
							System.out.println("Do you want to use the spell (Y/N):");
							String s = YorN();
							if (s.equals("Y")) {
								if (heroes[num].mana >= heroes[num].hlight_spells[i].mana) {
									System.out.println("Successful use!");
									op = true;
									heroes[num].mana -= heroes[num].hlight_spells[i].mana;
									int damage;
									damage = (int) (heroes[num].hlight_spells[i].damage
											* (1 + heroes[num].dexterity / 10000));
									monsters[mnum].hp -= damage;
									if (monsters[mnum].hp <= 0) {
										monsters[mnum].alive = false;
										monsters[mnum].hp = 0;
									}
									System.out.println(heroes[num].name + " cause " + damage + " damage to "
											+ monsters[mnum].name);
									monsters[mnum].dodge_chance -= heroes[num].hlight_spells[i].reducedodge;
									if (heroes[num].hlight_spells[i].number == 1) {
										heroes[num].hlight_spells[i] = new Hero().new HLightning_spell();
									} else
										heroes[num].hlight_spells[i].number--;
								} else
									System.out.println("Not enough mana!");
							}
						} else
							System.out.println("Not enough level!");
					}
				}
				if (b == false) {
					System.out.println("Invalid input!");
				}
			}
		} else if (num1 == 7) {
			op = true;
			Random rdodge = new Random();
			int rd = rdodge.nextInt(100);
			if (rd >= monsters[mnum].dodge_chance) {
				int damage;
				damage = (int) ((heroes[num].strength - monsters[mnum].defense) * 0.05);
				if (damage < 0)
					damage = 0;
				monsters[mnum].hp -= damage;
				System.out.println(heroes[num].name + " cause " + damage + " damage to " + monsters[mnum].name);
				if (monsters[mnum].hp <= 0) {
					monsters[mnum].alive = false;
					monsters[mnum].hp = 0;
				}
			} else
				System.out.println(heroes[num].name + " attack missed!");
		}
		return op;
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

}
