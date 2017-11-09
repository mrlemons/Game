package game.model;

public class Hero
{
	private String name;
	private int strength;
	private int dex;
	private int vitality;
	private int intelligence;
	private int wisdom;
	private int strMod;
	private int dexMod;
	private int vitMod;
	private int intMod;
	private int wisMod;
	
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
		strMod += weaponEquip.getStrMod();
		dexMod += weaponEquip.getDexMod();
		vitMod += weaponEquip.getVitMod();
		intMod += weaponEquip.getVitMod();
		wisMod += weaponEquip.getWisMod();
		
		strength += strMod;
		dex += dexMod;
		vitality += vitMod;
		intelligence += intMod;
		wisdom += wisMod;
		
		
		
	}
	public void removeWeapon()
	{
		weaponEquip = null;
		
		strMod -= weaponEquip.getStrMod();
		dexMod -= weaponEquip.getDexMod();
		vitMod -= weaponEquip.getVitMod();
		intMod -= weaponEquip.getVitMod();
		wisMod -= weaponEquip.getWisMod();
		
		strength -= strMod;
		dex -= dexMod;
		vitality -= vitMod;
		intelligence -= intMod;
		wisdom -= wisMod;
	}
	
	public void removeArmor()
	{
		armorEquip = null;
		strMod -= armorEquip.getStrMod();
		dexMod -= armorEquip.getDexMod();
		vitMod -= armorEquip.getVitMod();
		intMod -= armorEquip.getVitMod();
		wisMod -= armorEquip.getWisMod();
		
		strength -= strMod;
		dex -= dexMod;
		vitality -= vitMod;
		intelligence -= intMod;
		wisdom -= wisMod;
	}
	
	public void setArmorEquip(Armor armor)
	{
		armorEquip = new Armor(armor.getID(), armor.getName(), armor.getDescription());
		armorEquip.setStrMod(armor.getStrMod());
		armorEquip.setDexMod(armor.getDexMod());
		armorEquip.setVitMod(armor.getVitMod());
		armorEquip.setIntMod(armor.getIntMod());
		armorEquip.setWisMod(armor.getWisMod());
		
		//Add armor mods to our hero stats
		strMod += armorEquip.getStrMod();
		dexMod += armorEquip.getDexMod();
		vitMod += armorEquip.getVitMod();
		intMod += armorEquip.getVitMod();
		wisMod += armorEquip.getWisMod();
		
		strength += strMod;
		dex += dexMod;
		vitality += vitMod;
		intelligence += intMod;
		wisdom += wisMod;
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
	public int getStrMod()
	{
		return strMod;
	}
	public void setStrMod(int strMod)
	{
		this.strMod = strMod;
	}
	public int getDexMod()
	{
		return dexMod;
	}
	public void setDexMod(int dexMod)
	{
		this.dexMod = dexMod;
	}
	public int getVitMod()
	{
		return vitMod;
	}
	public void setVitMod(int vitMod)
	{
		this.vitMod = vitMod;
	}
	public int getIntMod()
	{
		return intMod;
	}
	public void setIntMod(int intMod)
	{
		this.intMod = intMod;
	}
	public int getWisMod()
	{
		return wisMod;
	}
	public void setWisMod(int wisMod)
	{
		this.wisMod = wisMod;
	}
	
	
	

	
}
