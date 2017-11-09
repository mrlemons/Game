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
		else if(armorEquip == null)
		{
			strArmMod = 0;
			dexArmMod = 0;
			vitArmMod = 0;
			intArmMod = 0;
			wisArmMod = 0;
		}
		else if(weaponEquip != null)
		{
			strWeapMod = weaponEquip.getStrMod();
			dexWeapMod = weaponEquip.getDexMod();
			vitWeapMod = weaponEquip.getVitMod();
			intWeapMod = weaponEquip.getVitMod();
			wisWeapMod = weaponEquip.getWisMod();
		}
		else if(armorEquip != null)
		{
			strArmMod = weaponEquip.getStrMod();
			dexArmMod = weaponEquip.getDexMod();
			vitArmMod = weaponEquip.getVitMod();
			intArmMod = weaponEquip.getVitMod();
			wisArmMod = weaponEquip.getWisMod();
		}
		
		strength = strength + strWeapMod + strArmMod; 
		dex = dex + dexWeapMod + dexArmMod;
		vitality = vitality + vitWeapMod + vitArmMod;
		intelligence = intelligence + intWeapMod + intArmMod;
		wisdom = wisdom + wisWeapMod + wisArmMod;
			
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
