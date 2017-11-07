package game.model;

public class Armor
{
	private int ID;
	private String name;
	private String description;
	private int strMod;
	private int dexMod;
	private int vitMod;
	private int intMod;
	private int wisMod;
	
	public Armor(int ID, String name, String description)
	{
		this.ID = ID;
		this.name = name;
		this.description = description;
	}

	public int getID()
	{
		return ID;
	}

	public void setID(int iD)
	{
		ID = iD;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public int getModifier()
	{
		return strMod;
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
