package game.model;

public class Hero
{
	private String name;
	private int strength;
	private int dex;
	private int vitality;
	private int intelligence;
	private int wisdom;
	
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
	}
	public void setWeaponEquip(Weapon weapon)
	{
		weaponEquip = new Weapon(weapon.getID(), weapon.getName(), weapon.getDescription());
		weaponEquip.setStrMod(weapon.getStrMod());
		weaponEquip.setDexMod(weapon.getDexMod());
		weaponEquip.setVitMod(weapon.getVitMod());
		weaponEquip.setIntMod(weapon.getIntMod());
		weaponEquip.setWisMod(weapon.getWisMod());
		
		//Add weapon mods to our hero stats
		
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
