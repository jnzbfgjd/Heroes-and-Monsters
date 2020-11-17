import java.util.Random;
import java.util.Scanner;

public class HeroAndMonsters {
	Team t;
	World w;
	Market m;
	Fight f;

	// the very beginning of the game
	public void startgame() {
		System.out.println("----------Welcome to the world of Monsters and Heroes!----------");
		System.out.println("Do you want to view the basic information of the game (Y/N):");
		while (true) {
			try {
				Scanner basicinfo = new Scanner(System.in);
				String basic = basicinfo.next();
				if (basic.equals("Y")) {
					System.out.println("---------------Basic Information---------------");
					System.out.print("W:move up\nA:move left\nS:move down\nD:move right\n\n");
					break;
				} else if (basic.equals("N")) {
					break;
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Invalid input please reenter!");
			}
		}
	}

	// the normal menu of the game
	public String menu() {
		String op;
		System.out.println("---------------Menu---------------");
		System.out.println("1.Move(W/A/S/D)");
		System.out.println("2.Show Map(M)");
		System.out.println("3.Open Bag(B)");
		System.out.println("4.Quit Game(Q)");
		System.out.println("5.Enter the Market(E)");
		while (true) {
			try {
				System.out.println("Please enter your operation:");
				Scanner operation = new Scanner(System.in);
				op = operation.next();
				if ((op.equals("W") == false) && (op.equals("A") == false) && (op.equals("S") == false)
						&& (op.equals("D") == false) && (op.equals("M") == false) && (op.equals("B") == false)
						&& (op.equals("Q") == false) && (op.equals("E") == false)) {
					throw new Exception();
				}
				break;
			} catch (Exception e) {
				System.out.println("invalid input!");
			}
		}
		return op;
	}

	// when heroes on the blank tile, judge if they meet monsters
	public boolean meetmonster() {
		boolean end = false;
		Random r = new Random();
		int meetmonster = r.nextInt(100);
		// probablity of meeting monsters
		int p = 30;
		if (meetmonster < p) {
			System.out.println("----------You meet monsters, get ready to fight!----------\n");
			t.showteam(t.number);
			f = new Fight();
			f.number = t.number;
			f.heroes = new Hero[f.number];

			for (int i = 0; i < f.number; i++) {
				f.heroes[i] = new Hero();
				f.heroes[i] = t.heroes[i];
			}
			f.highlevel();
			f.selectmonster();
			System.out.println("---------------11111111---------------");
			boolean winornot = f.startfight();
			if (winornot == true) {
				System.out.println("---------------Congratulate!---------------");
				System.out.println("------------------You Win!-----------------");
				for (int i = 0; i < f.number; i++) {
					if (f.heroes[i].alive == true) {
						f.heroes[i].experience += 2;
						f.heroes[i].money += 100 * f.maxlevel;
						f.heroes[i].hp += (int) (f.heroes[i].hp * 0.1);
						f.heroes[i].mana += (int) (f.heroes[i].mana * 0.1);
						f.heroes[i].levelup(f.heroes[i].type);
					} else {
						f.heroes[i].money += 100 * f.maxlevel;
						f.heroes[i].hp += f.heroes[i].level * 50;
					}
				}
				t.showteam(t.number);
				w.showmap();
			} else {
				System.out.println("---------------DEFEATED!---------------");
				end = true;
			}
		}
		return end;
	}

	// the menu when heroes are in the market
	public void marketmenu(int num) {
		t.showteam(t.number);
		System.out.println("\n---------------Market Menu---------------");
		boolean end = false;
		int num1, num2;
		while (end == false) {
			System.out.println("1.Buy Weapons");
			System.out.println("2.Buy Armors");
			System.out.println("3.Buy Potions");
			System.out.println("4.Buy Ice Spells");
			System.out.println("5.Buy Fire Spells");
			System.out.println("6.Buy Lightning Spells");
			System.out.println("7.Exit the Market");
			System.out.println("8.Sell Item");
			System.out.println("enter 1-8 to choose your movement:");
			while (true) {
				try {
					Scanner input = new Scanner(System.in);
					num1 = input.nextInt();
					if (num1 < 1 || num1 > 8) {
						throw new Exception();
					}
					break;
				} catch (Exception e) {
					System.out.println("Invalid input please reenter!");
				}
			}
			if (num1 == 7) {
				end = true;
				break;
			}
			System.out.println("Please enter the name of item:");
			Scanner input1 = new Scanner(System.in);
			String itemname = input1.next();
			if (num1 == 1) {
				num2 = m.buyweapon(itemname);
				if (num2 == -1) {
					System.out.println("Invalid item name!");
				} else if (t.heroes[num].money < m.weapons[num2].price) {
					System.out.println("Hero " + t.heroes[num].name + " don't have enough money!");
				} else if (t.heroes[num].hweapons[num2].name == null) {
					t.heroes[num].hweapons[num2].name = m.weapons[num2].name;
					t.heroes[num].hweapons[num2].price = m.weapons[num2].price;
					t.heroes[num].hweapons[num2].minlevel = m.weapons[num2].minlevel;
					t.heroes[num].hweapons[num2].damage = m.weapons[num2].damage;
					t.heroes[num].hweapons[num2].required_hands = m.weapons[num2].required_hands;
					t.heroes[num].hweapons[num2].wstate = false;
					t.heroes[num].money -= m.weapons[num2].price;
					System.out.println("Successful purchase!\n");
				} else {
					System.out.println("Already have one!");
				}
			} else if (num1 == 3) {
				num2 = m.buypotion(itemname);
				if (num2 == -1) {
					System.out.println("Invalid item name!");
				} else if (t.heroes[num].money < m.potions[num2].price) {
					System.out.println("Hero " + t.heroes[num].name + " don't have enough money!");
				} else if (t.heroes[num].hpotions[num2].name == null) {
					t.heroes[num].hpotions[num2].name = m.potions[num2].name;
					t.heroes[num].hpotions[num2].price = m.potions[num2].price;
					t.heroes[num].hpotions[num2].minlevel = m.potions[num2].minlevel;
					t.heroes[num].hpotions[num2].pincrease = m.potions[num2].pincrease;
					t.heroes[num].hpotions[num2].health = m.potions[num2].health;
					t.heroes[num].hpotions[num2].agility = m.potions[num2].agility;
					t.heroes[num].hpotions[num2].defense = m.potions[num2].defense;
					t.heroes[num].hpotions[num2].dexterity = m.potions[num2].dexterity;
					t.heroes[num].hpotions[num2].mana = m.potions[num2].mana;
					t.heroes[num].hpotions[num2].strength = m.potions[num2].strength;
					t.heroes[num].hpotions[num2].number = 1;
					t.heroes[num].money -= m.potions[num2].price;
					System.out.println("Successful purchase!\n");
				} else {
					t.heroes[num].hpotions[num2].number++;
					t.heroes[num].money -= m.potions[num2].price;
					System.out.println("Successful purchase!\n");
				}
			} else if (num1 == 2) {
				num2 = m.buyarmor(itemname);
				if (num2 == -1) {
					System.out.println("Invalid item name!");
				} else if (t.heroes[num].money < m.armors[num2].price) {
					System.out.println("Hero " + t.heroes[num].name + " don't have enough money!");
				} else if (t.heroes[num].harmors[num2].name == null) {
					t.heroes[num].harmors[num2].name = m.armors[num2].name;
					t.heroes[num].harmors[num2].price = m.armors[num2].price;
					t.heroes[num].harmors[num2].minlevel = m.armors[num2].minlevel;
					t.heroes[num].harmors[num2].rdamage = m.armors[num2].rdamage;
					t.heroes[num].harmors[num2].astate = false;
					t.heroes[num].money -= m.armors[num2].price;
					System.out.println("Successful purchase!\n");
				} else {
					System.out.println("Already have one!");
				}
			} else if (num1 == 4) {
				num2 = m.buyicespell(itemname);
				if (num2 == -1) {
					System.out.println("Invalid item name!");
				} else if (t.heroes[num].money < m.ice_spells[num2].price) {
					System.out.println("Hero " + t.heroes[num].name + " don't have enough money!");
				} else if (t.heroes[num].hice_spells[num2].name == null) {
					t.heroes[num].hice_spells[num2].name = m.ice_spells[num2].name;
					t.heroes[num].hice_spells[num2].price = m.ice_spells[num2].price;
					t.heroes[num].hice_spells[num2].minlevel = m.ice_spells[num2].minlevel;
					t.heroes[num].hice_spells[num2].damage = m.ice_spells[num2].damage;
					t.heroes[num].hice_spells[num2].mana = m.ice_spells[num2].mana;
					t.heroes[num].hice_spells[num2].number = 1;
					t.heroes[num].money -= m.ice_spells[num2].price;
					System.out.println("Successful purchase!\n");
				} else {
					t.heroes[num].hice_spells[num2].number++;
					t.heroes[num].money -= m.ice_spells[num2].price;
					System.out.println("Successful purchase!\n");
				}
			} else if (num1 == 5) {
				num2 = m.buyfirespell(itemname);
				if (num2 == -1) {
					System.out.println("Invalid item name!");
				} else if (t.heroes[num].money < m.fire_spells[num2].price) {
					System.out.println("Hero " + t.heroes[num].name + " don't have enough money!");
				} else if (t.heroes[num].hfire_spells[num2].name == null) {
					t.heroes[num].hfire_spells[num2].name = m.fire_spells[num2].name;
					t.heroes[num].hfire_spells[num2].price = m.fire_spells[num2].price;
					t.heroes[num].hfire_spells[num2].minlevel = m.fire_spells[num2].minlevel;
					t.heroes[num].hfire_spells[num2].damage = m.fire_spells[num2].damage;
					t.heroes[num].hfire_spells[num2].mana = m.fire_spells[num2].mana;
					t.heroes[num].hfire_spells[num2].number = 1;
					t.heroes[num].money -= m.fire_spells[num2].price;
					System.out.println("Successful purchase!\n");
				} else {
					t.heroes[num].hfire_spells[num2].number++;
					t.heroes[num].money -= m.fire_spells[num2].price;
					System.out.println("Successful purchase!\n");
				}
			} else if (num1 == 6) {
				num2 = m.buylightningspell(itemname);
				if (num2 == -1) {
					System.out.println("Invalid item name!");
				} else if (t.heroes[num].money < m.lightning_spells[num2].price) {
					System.out.println("Hero " + t.heroes[num].name + " don't have enough money!");
				} else if (t.heroes[num].hlight_spells[num2].name == null) {
					t.heroes[num].hlight_spells[num2].name = m.lightning_spells[num2].name;
					t.heroes[num].hlight_spells[num2].price = m.lightning_spells[num2].price;
					t.heroes[num].hlight_spells[num2].minlevel = m.lightning_spells[num2].minlevel;
					t.heroes[num].hlight_spells[num2].damage = m.lightning_spells[num2].damage;
					t.heroes[num].hlight_spells[num2].mana = m.lightning_spells[num2].mana;
					t.heroes[num].hlight_spells[num2].number = 1;
					t.heroes[num].money -= m.lightning_spells[num2].price;
					System.out.println("Successful purchase!\n");
				} else {
					t.heroes[num].hlight_spells[num2].number++;
					t.heroes[num].money -= m.lightning_spells[num2].price;
					System.out.println("Successful purchase!\n");
				}
			} else if (num1 == 8) {
				// judge if the item exist or not
				t.showteam(t.number);
				boolean a = false;
				for (int i = 0; i < m.weapon_amount; i++) {
					if (itemname.equals(t.heroes[num].hweapons[i].name)) {
						t.heroes[num].money += t.heroes[num].hweapons[i].price / 2;
						t.heroes[num].hweapons[i] = new Hero().new HWeapon();
						System.out.println("Successful transaction!\n");
						a = true;
					}
				}
				for (int i = 0; i < m.armor_amount; i++) {
					if (itemname.equals(t.heroes[num].harmors[i].name)) {
						t.heroes[num].money += t.heroes[num].harmors[i].price / 2;
						t.heroes[num].harmors[i] = new Hero().new HArmor();
						System.out.println("Successful transaction!\n");
						a = true;
					}
				}
				for (int i = 0; i < m.potion_amount; i++) {
					if (itemname.equals(t.heroes[num].hpotions[i].name)) {
						t.heroes[num].money += t.heroes[num].hpotions[i].price / 2;
						if (t.heroes[num].hpotions[i].number == 1) {
							t.heroes[num].hpotions[i] = new Hero().new HPotion();
						} else
							t.heroes[num].hpotions[i].number--;
						System.out.println("Successful transaction!\n");
						a = true;
					}
				}
				for (int i = 0; i < m.icespell_amount; i++) {
					if (itemname.equals(t.heroes[num].hice_spells[i].name)) {
						t.heroes[num].money += t.heroes[num].hice_spells[i].price / 2;
						if (t.heroes[num].hice_spells[i].number == 1) {
							t.heroes[num].hice_spells[i] = new Hero().new HIce_spell();
						} else
							t.heroes[num].hice_spells[i].number--;
						System.out.println("Successful transaction!\n");
						a = true;
					}
				}
				for (int i = 0; i < m.firespell_amount; i++) {
					if (itemname.equals(t.heroes[num].hfire_spells[i].name)) {
						t.heroes[num].money += t.heroes[num].hfire_spells[i].price / 2;
						if (t.heroes[num].hfire_spells[i].number == 1) {
							t.heroes[num].hfire_spells[i] = new Hero().new HFire_spell();
						} else
							t.heroes[num].hfire_spells[i].number--;
						System.out.println("Successful transaction!\n");
						a = true;
					}
				}
				for (int i = 0; i < m.lightspell_amount; i++) {
					if (itemname.equals(t.heroes[num].hlight_spells[i].name)) {
						t.heroes[num].money += t.heroes[num].hlight_spells[i].price / 2;
						if (t.heroes[num].hlight_spells[i].number == 1) {
							t.heroes[num].hlight_spells[i] = new Hero().new HLightning_spell();
						} else
							t.heroes[num].hlight_spells[i].number--;
						System.out.println("Successful transaction!\n");
						a = true;
					}
				}
				if (a == false) {
					System.out.println("Invalid item name!");
				}
			}
		}
	}

	// the main game of hero and monster
	public void maingame() {
		boolean end = false;
		String operation;
		startgame();
		t = new Team();
		t.selectheroes();
		w = new World();
		w.initmap();
		w.initplayer();
		w.showmap();
		m = new Market();
		while (end == false) {
			operation = menu();
			if (operation.equals("W")) {
				if ((w.judge(w.plocation.x, w.plocation.y - 1) == true)
						&& (w.map[w.plocation.y - 1][w.plocation.x] != 1)) {
					w.plocation.y--;
					w.showmap();
					if (w.map[w.plocation.y][w.plocation.x] == 3) {
						end = meetmonster();
					}
				} else {
					System.out.println("Invalid movement!");
				}
			} else if (operation.equals("A")) {
				if ((w.judge(w.plocation.x - 1, w.plocation.y) == true)
						&& (w.map[w.plocation.y][w.plocation.x - 1] != 1)) {
					w.plocation.x--;
					w.showmap();
					if (w.map[w.plocation.y][w.plocation.x] == 3) {
						end = meetmonster();
					}
				} else {
					System.out.println("Invalid movement!");
				}
			} else if (operation.equals("S")) {
				if ((w.judge(w.plocation.x, w.plocation.y + 1) == true)
						&& (w.map[w.plocation.y + 1][w.plocation.x] != 1)) {
					w.plocation.y++;
					w.showmap();
					if (w.map[w.plocation.y][w.plocation.x] == 3) {
						end = meetmonster();
					}
				} else {
					System.out.println("Invalid movement!");
				}
			} else if (operation.equals("D")) {
				if ((w.judge(w.plocation.x + 1, w.plocation.y) == true)
						&& (w.map[w.plocation.y][w.plocation.x + 1] != 1)) {
					w.plocation.x++;
					w.showmap();
					if (w.map[w.plocation.y][w.plocation.x] == 3) {
						end = meetmonster();
					}
				} else {
					System.out.println("Invalid movement!");
				}
			} else if (operation.equals("M")) {
				w.showmap();
			} else if (operation.equals("B")) {
				t.showteam(t.number);
				t.bagoperate(t.choosehero());
			} else if (operation.equals("Q")) {
				end = true;
			} else if (operation.equals("E")) {
				if (w.map[w.plocation.y][w.plocation.x] == 2) {
					int heronum = t.choosehero();
					m.showmarket(m);
					marketmenu(heronum);

				} else
					System.out.println("You are not in the Market !");
			}
		}
		System.out.println("---------------Game End---------------");
	}

	public static void main(String args[]) {
		HeroAndMonsters game = new HeroAndMonsters();
		game.maingame();
	}

}
