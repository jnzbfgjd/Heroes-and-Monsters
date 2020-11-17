
public class Hero {
	// name of hero
	public String name;
	// level of hero
	public int level;
	// HP of hero
	public int hp;
	// live or not
	public boolean alive = true;
	// mana of hero
	public int mana;
	// strength of hero
	public int strength;
	// agility of hero
	public int agility;
	// dexterity of hero
	public int dexterity;

	public int defense = 0;
	// money of hero
	public int money;
	// experience of hero
	public int experience;
	// type of hero 1 for warriors 2 for sorcerers 3 for paladins
	public int type;

	public HWeapon[] hweapons;

	public HArmor[] harmors;

	public HPotion[] hpotions;

	public HIce_spell[] hice_spells;

	public HFire_spell[] hfire_spells;

	public HLightning_spell[] hlight_spells;

	public class HWeapon extends Weapon {
		// state of weapon, false for not equiped, true for equiped
		public boolean wstate;
	}

	public class HArmor extends Armor {
		// state of armor, false for not equiped, ture for equiped
		public boolean astate;
	}

	public class HPotion extends Potion {
		public int number;
	}

	public class HIce_spell extends Ice_spell {
		public int number;
	}

	public class HFire_spell extends Fire_spell {
		public int number;
	}

	public class HLightning_spell extends Lightning_spell {
		public int number;
	}

	public void isalive(int hp) {
		if (hp <= 0) {
			alive = false;
		}
	}

	public void levelup(int type) {
		if (experience >= level * 10) {
			System.out.println(name + " level up!");
			level++;
			hp = level * 100;
			for (int i = 0; i < hweapons.length; i++) {
				if (hweapons[i].wstate = true) {
					strength -= hweapons[i].damage;
				}
			}
			mana = (int) (mana * 1.1);
			if (type == 1) {
				strength = (int) (strength * 1.1);
				agility = (int) (agility * 1.1);
				dexterity = (int) (dexterity * 1.05);
			} else if (type == 2) {
				strength = (int) (strength * 1.05);
				agility = (int) (agility * 1.1);
				dexterity = (int) (dexterity * 1.1);
			} else {
				strength = (int) (strength * 1.1);
				agility = (int) (agility * 1.05);
				dexterity = (int) (dexterity * 1.1);
			}
			for (int i = 0; i < hweapons.length; i++) {
				if (hweapons[i].wstate = true) {
					strength += hweapons[i].damage;
				}
			}
		}
	}

	public void initheroitem() {
		Market m = new Market();
		m.initarmor();
		m.initweapon();
		m.initpotion();
		m.initfirespell();
		m.initicespell();
		m.initlightspell();
		hweapons = new HWeapon[m.weapon_amount];
		for (int i = 0; i < m.weapon_amount; i++) {
			hweapons[i] = new HWeapon();
		}
		harmors = new HArmor[m.armor_amount];
		for (int i = 0; i < m.armor_amount; i++) {
			harmors[i] = new HArmor();
		}
		hpotions = new HPotion[m.potion_amount];
		for (int i = 0; i < m.potion_amount; i++) {
			hpotions[i] = new HPotion();
		}
		hice_spells = new HIce_spell[m.icespell_amount];
		for (int i = 0; i < m.icespell_amount; i++) {
			hice_spells[i] = new HIce_spell();
		}
		hfire_spells = new HFire_spell[m.firespell_amount];
		for (int i = 0; i < m.firespell_amount; i++) {
			hfire_spells[i] = new HFire_spell();
		}
		hlight_spells = new HLightning_spell[m.lightspell_amount];
		for (int i = 0; i < m.lightspell_amount; i++) {
			hlight_spells[i] = new HLightning_spell();
		}
	}
}