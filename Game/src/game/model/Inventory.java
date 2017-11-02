package game.model;

import java.util.ArrayList;

public class Inventory
{
	private int inventorySlotsTaken;
	private int maxInventorySlots;
	private int currentSlot;
	
	
	
	ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	ArrayList<Armor> armors = new ArrayList<Armor>();
	ArrayList<Integer> currentInventory = new ArrayList<Integer>();
	
	World theWorld = World.getWorld();
	
	/**/
	
	private int[] slot = new int[5];
	
	public Inventory()
	{
		inventorySlotsTaken = 0;
		maxInventorySlots = 6;
		currentSlot = 0;
	}
	
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
	
	public void removeFromInventory(int choice, Location location)
	{
		Integer[] itemPosition = new Integer[currentInventory.size()];
		itemPosition = currentInventory.toArray(itemPosition);
		int itemID = 0;
		
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
