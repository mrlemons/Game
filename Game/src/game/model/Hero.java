package game.model;

public class Hero
{
	private String name;
	private int strength;
	private int dex;
	private int vitality;
	private int intelligence;
	private int wisdom;
	private int strWeapMod;
	private int dexWeapMod;
	private int vitWeapMod;
	private int intWeapMod;
	private int wisWeapMod;
	private int strArmMod;
	private int dexArmMod;
	private int vitArmMod;
	private int intArmMod;
	private int wisArmMod;
	private int baseStr;
	private int baseDex;
	private int baseVit;
	private int baseInt;
	private int baseWis;
	
	private int hunger;
	private int starvingLimit;
	private int hungryLimit;
	private int fineLimit;
	private int maxHunger;
	
	Weapon weaponEquip;
	Armor armorEquip;
	
	
	public Hero(String name, int strength, int dex, int vitality, 
					int intelligence, int wisdom)
	{
		this.name = name;
		this.strength = strength;
		this.dex = dex;
		this.vitality = vitality;
		this.intelligence = intelligence;
		this.wisdom = wisdom;
		
		baseStr = strength;
		baseDex = dex;
		baseVit = vitality;
		baseInt = intelligence;
		baseWis = wisdom;
		
		maxHunger = 100;
		starvingLimit = 25;
		hungryLimit = 50;
		fineLimit = 75;
		hunger = maxHunger;
	}
	public void getHunger()
	{
		/*Four tiers of hunger.
		 * 0-25: Starving
		 * 26-50 Hungry
		 * 51-75: Fine
		 * 76-100: Full
		 */
		if(hunger >= starvingLimit)
		{
			System.out.print("You are starving.\n");
		}
		else if(hunger >= hungryLimit)
		{
			System.out.println("You are hungry.\n");
		}
		else if(hunger >= fineLimit)
		{
			System.out.println("You are fine.\n");
		}
		else if(hunger >= maxHunger)
		{
			System.out.println("You are full.\n");
		}
			
	}
	public void setHunger(boolean adding, int amount)
	{
		if(adding == true)
		{
			hunger += amount;
			if(hunger >= maxHunger)
			{
				hunger = maxHunger;
			}
		}
		else
		{
			hunger -= amount;
			if(hunger >= 0)
			{
				hunger = 0;
			}
		}
	}
	public void setWeaponEquip(Weapon weapon)
	{
		weaponEquip = new Weapon(weapon.getID(), weapon.getName(), weapon.getDescription());
		weaponEquip.setStrMod(weapon.getStrMod());
		weaponEquip.setDexMod(weapon.getDexMod());
		weaponEquip.setVitMod(weapon.getVitMod());
		weaponEquip.setIntMod(weapon.getIntMod());
		weaponEquip.setWisMod(weapon.getWisMod());
		
		setStats();
	}
	public void removeWeapon()
	{
		weaponEquip = null;
		setStats();
	}
	
	public void removeArmor()
	{
		armorEquip = null;
		setStats();
	}
	public void setStats()
	{
		if(weaponEquip == null)
		{
			strWeapMod = 0;
			dexWeapMod = 0;
			vitWeapMod = 0;
			intWeapMod = 0;
			wisWeapMod = 0;
		}
		if(armorEquip == null)
		{
			strArmMod = 0;
			dexArmMod = 0;
			vitArmMod = 0;
			intArmMod = 0;
			wisArmMod = 0;
		}
		if(weaponEquip != null)
		{
			strWeapMod = weaponEquip.getStrMod();
			dexWeapMod = weaponEquip.getDexMod();
			vitWeapMod = weaponEquip.getVitMod();
			intWeapMod = weaponEquip.getIntMod();
			wisWeapMod = weaponEquip.getWisMod();
		}
		if(armorEquip != null)
		{
			strArmMod = armorEquip.getStrMod();
			dexArmMod = armorEquip.getDexMod();
			vitArmMod = armorEquip.getVitMod();
			intArmMod = armorEquip.getIntMod();
			wisArmMod = armorEquip.getWisMod();
		}
		
		//Set our stats
		strength = baseStr + strWeapMod + strArmMod; 
		dex = baseDex + dexWeapMod + dexArmMod;
		vitality = baseVit + vitWeapMod + vitArmMod;
		intelligence = baseInt + intWeapMod + intArmMod;
		wisdom = baseWis + wisWeapMod + wisArmMod;
			
	}

	
	public void setArmorEquip(Armor armor)
	{
		armorEquip = new Armor(armor.getID(), armor.getName(), armor.getDescription());
		armorEquip.setStrMod(armor.getStrMod());
		armorEquip.setDexMod(armor.getDexMod());
		armorEquip.setVitMod(armor.getVitMod());
		armorEquip.setIntMod(armor.getIntMod());
		armorEquip.setWisMod(armor.getWisMod());
		
		setStats();
	}

	public Armor getArmorEquip()
	{
		return armorEquip;
	}
	public Weapon getWeaponEquip()
	{
		return weaponEquip;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getStrength()
	{
		return strength;
	}

	public void setStrength(int strength)
	{
		this.strength = strength;
	}

	public int getDex()
	{
		return dex;
	}

	public void setDex(int dex)
	{
		this.dex = dex;
	}

	public int getVitality()
	{
		return vitality;
	}

	public void setVitality(int vitality)
	{
		this.vitality = vitality;
	}

	public int getIntelligence()
	{
		return intelligence;
	}

	public void setIntelligence(int intelligence)
	{
		this.intelligence = intelligence;
	}

	public int getWisdom()
	{
		return wisdom;
	}

	public void setWisdom(int wisdom)
	{
		this.wisdom = wisdom;
	}
	
	

	
}
