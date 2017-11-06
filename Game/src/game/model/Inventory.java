package game.model;

import java.util.ArrayList;

public class Inventory
{
	private int inventorySlotsTaken;
	private int maxInventorySlots;
	
	
	
	ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	ArrayList<Armor> armors = new ArrayList<Armor>();
	ArrayList<Integer> currentInventory = new ArrayList<Integer>();
	
	World theWorld = World.getWorld();
	
	/**/

	
	public Inventory()
	{
		inventorySlotsTaken = 0;
		maxInventorySlots = 6;
	}
	
	//Adds item to our inventory
	public void addToInventory(int ID)
	{
		if(inventorySlotsTaken <= maxInventorySlots)
		{
			if(theWorld.getWeapon(ID) != null)
			{
				weapons.add(theWorld.getWeapon(ID));
				currentInventory.add(ID);
				System.out.println(getWeapon(ID).getName() + " was added.");
			}
			else if(theWorld.getArmor(ID) != null)
			{
				armors.add(theWorld.getArmor(ID));
				currentInventory.add(ID);
				System.out.println(getArmor(ID).getName());
			}
			inventorySlotsTaken += 1;
		}
		else
		{
			System.out.print("No more space");
		}
		
	}
	
	//Drop item back into the world
	public void removeFromInventory(int choice, Location location)
	{
		Integer[] itemPosition = new Integer[currentInventory.size()];
		itemPosition = currentInventory.toArray(itemPosition);
		int itemID = 0;
		
		try
		{
			if(getWeapon(itemPosition[choice]) != null)
			{
				itemID = getWeapon(itemPosition[choice]).getID();
				System.out.println("You dropped a " + getWeapon(itemID).getName());
				location.addWeaponHere(getWeapon(itemID));
				currentInventory.remove(currentInventory.indexOf(itemID));
				weapons.remove(weapons.indexOf(getWeapon(itemID)));
			}
			else if(getArmor(itemPosition[choice]) != null)
			{
				itemID = getArmor(itemPosition[choice]).getID();
				System.out.println("You picked dropped a " + getArmor(itemID).getID());
				location.addArmorHere(getArmor(itemPosition[itemID]));
				currentInventory.remove(currentInventory.indexOf(itemID));
				armors.remove(armors.indexOf(getArmor(itemID)));
			}
		}
		catch (IndexOutOfBoundsException e)
		{
			System.out.println("Not a valid selection\n");
		}
		
		
		
		
	}
	
	//Select item in inventory
	public void selectItem(int choice)
	{
		Integer[] itemPosition = new Integer[currentInventory.size()];
		itemPosition = currentInventory.toArray(itemPosition);
		int itemID = 0;
		
		try 
		{
			if(getWeapon(itemPosition[choice]) != null)
			{
				itemID = getWeapon(itemPosition[choice]).getID();
				System.out.println(getWeapon(itemID).getName() + "\n"
									+ getWeapon(itemID).getDescription() + "\n"
									+ "Modifiers: \n"
									+ "Strength: " + getWeapon(itemID).getStrMod() + "\n"
									+ "Dex: " + getWeapon(itemID).getDexMod() + "\n"
									+ "Vitality: " + getWeapon(itemID).getVitMod() + "\n"
									+ "Intelligence: " + getWeapon(itemID).getIntMod() + "\n"
									+ "Wisdom: " + getWeapon(itemID).getWisMod()  + "\n");
			}
			else if(getArmor(itemPosition[choice]) != null)
			{
				itemID = getArmor(itemPosition[choice]).getID();
				System.out.println(getArmor(itemID).getName() + "\n"
									+ getArmor(itemID).getDescription() + "\n"
									+ "Modifiers: \n"
									+ "Strength: " + getArmor(itemID).getStrMod() + "\n"
									+ "Dex: " + getArmor(itemID).getDexMod() + "\n"
									+ "Vitality: " + getArmor(itemID).getVitMod() + "\n"
									+ "Intelligence: " + getArmor(itemID).getIntMod() + "\n"
									+ "Wisdom: " + getArmor(itemID).getWisMod()  + "\n");
			}
		}
		catch (IndexOutOfBoundsException e)
		{
			System.out.println("Not a valid selection\n");
		}
	}
	
	public void equipItem(Hero hero, Location location, int choice)
	{
		Integer[] itemPosition = new Integer[currentInventory.size()];
		itemPosition = currentInventory.toArray(itemPosition);
		int itemID = 0;
		
		try 
		{
			if(getWeapon(itemPosition[choice]) != null)
			{
				itemID = getWeapon(itemPosition[choice]).getID();
				if(hero.weaponEquip != null)
				{
					System.out.println("You dropped " + hero.weaponEquip.getName() + " and equiped " + getWeapon(itemID).getName() + "\n");
					location.addWeaponHere(hero.weaponEquip);
					
				}
				else
				{
					System.out.println("You equipped the " + getWeapon(itemID).getName());
				}
				hero.setWeaponEquip(getWeapon(itemID));
				currentInventory.remove(currentInventory.indexOf(itemID));
				weapons.remove(weapons.indexOf(itemID));
			}
		}
		catch (IndexOutOfBoundsException e)
		{
			
		}
		
		
	}
	
	public void showCurrentEquipment(Hero hero)
	{
		int weaponID = 0;
		int armorID = 0;
		
		if(hero.getWeaponEquip() == null)
		{
			System.out.println("Nothing Equiped\n");
		}
		
		if(hero.getWeaponEquip() != null)
		{
			weaponID = hero.getWeaponEquip().getID();
			System.out.println("Currently Equiped Weapon: \n" 
					+ getWeapon(weaponID).getName() + "\n"
					+ getWeapon(weaponID).getDescription() + "\n"
					+ "Modifiers: \n"
					+ "Strength: " + getWeapon(weaponID).getStrMod() + "\n"
					+ "Dex: " + getWeapon(weaponID).getDexMod() + "\n"
					+ "Vitality: " + getWeapon(weaponID).getVitMod() + "\n"
					+ "Intelligence: " + getWeapon(weaponID).getIntMod() + "\n"
					+ "Wisdom: " + getWeapon(weaponID).getWisMod()  + "\n");
		}
		
	}
	
	//Print out all our items in our inventory
	public void showInventory()
	{
		int itemNumber = 0;
		
		if(currentInventory.isEmpty())
		{
			System.out.println("Nothing here...");
		}
		else
		{
			for(Integer item : currentInventory)
			{
				if(getWeapon(item) != null)
				{
					System.out.println("(" + itemNumber + ")" + getWeapon(item).getName());
					itemNumber += 1;
				}
				else if(getArmor(item) != null)
				{
					System.out.println("(" + itemNumber + ")" + getArmor(item).getName());
					itemNumber += 1;
				}
					
			}
		}
	}
	
	public Weapon getWeapon(int ID)
	{
		for(Weapon weapon : weapons)
		{
			if(weapon.getID() == ID)
			{
				return weapon;
			}
		}
		return null;
	}
	
	public Armor getArmor(int ID)
	{
		for(Armor armor: armors)
		{
			if(armor.getID() == ID)
			{
				return armor;
			}
		}
		return null;
	}
}
