package game.model;

import java.util.ArrayList;

public class Location
{
	private int ID;
	private String name;
	private String description;
	
	private Location locationToTheNorth;
	private Location locationToTheSouth;
	private Location locationToTheWest;
	private Location locationToTheEast;
	
	
	
	ArrayList<Weapon> weaponsHere = new ArrayList<Weapon>();
	ArrayList<Armor> armorsHere = new ArrayList<Armor>();
	ArrayList<Integer> itemsHere = new ArrayList<Integer>();
	
	
	public Location(int ID, String name, String description)
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

	public Location getLocationToTheNorth()
	{
		return locationToTheNorth;
	}

	public void setLocationToTheNorth(Location locationToTheNorth)
	{
		this.locationToTheNorth = locationToTheNorth;
	}

	public Location getLocationToTheSouth()
	{
		return locationToTheSouth;
	}

	public void setLocationToTheSouth(Location locationToTheSouth)
	{
		this.locationToTheSouth = locationToTheSouth;
	}

	public Location getLocationToTheWest()
	{
		return locationToTheWest;
	}

	public void setLocationToTheWest(Location locationToTheWest)
	{
		this.locationToTheWest = locationToTheWest;
	}

	public Location getLocationToTheEast()
	{
		return locationToTheEast;
	}

	public void setLocationToTheEast(Location locationToTheEast)
	{
		this.locationToTheEast = locationToTheEast;
	}
	
	public void addWeaponHere(Weapon weapon)
	{
		itemsHere.add(weapon.getID());
		weaponsHere.add(weapon);
		
	}
	
	public void addArmorHere(Armor armor)
	{
		itemsHere.add(armor.getID());
		armorsHere.add(armor);
	}
	
	public Weapon getWeaponsHere(int weaponID)
	{
		for(Weapon weapon : weaponsHere)
		{
			if(weapon.getID() == weaponID)
			{
				return weapon;
			}
		}
		return null;
	}
	
	public Armor getArmorsHere(int armorID)
	{
		for(Armor armor : armorsHere)
		{
			if(armor.getID() == armorID)
			{
				return armor;
			}
		}
		return null;
	}
	
	public void showAllItemsHere()
	{
		
		int itemNumber = 0;
		
		if(itemsHere.isEmpty())
		{
			System.out.println("Nothing here...");
		}
		else
		{
			for(Integer item : itemsHere)
			{
				System.out.println("(" + itemNumber + ")" + getWeaponsHere(item).getName());
				itemNumber += 1;	
			}
		}
	}
	

	
	public int pickUpItem(int choice)
	{
		Integer[] itemPosition = new Integer[itemsHere.size()];
		itemPosition = itemsHere.toArray(itemPosition);
		int itemID = 0;
		
		if(getWeaponsHere(itemPosition[choice]) != null)
		{
			System.out.println("You picked up a " + getWeaponsHere(itemPosition[choice]).getName() + "\n");
			itemID = getWeaponsHere(itemPosition[choice]).getID();
			itemsHere.remove(itemsHere.indexOf(itemID));
			weaponsHere.remove(weaponsHere.indexOf(getWeaponsHere(itemID)));
			
		}
		else if(getArmorsHere(itemPosition[choice]) != null)
		{
			
		}
		return itemID;
	}

	

	
	

}
