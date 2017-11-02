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
	
	/*Integer[] inventory = new Integer[currentInventory.size()];
	  inventory = currentInventory.toArray(inventory);*/
	
	private int[] slot = new int[5];
	
	public Inventory()
	{
		inventorySlotsTaken = 0;
		maxInventorySlots = 6;
		currentSlot = 0;
	}
	
	public void addToInventory(int ID)
	{
		if(theWorld.getWeapon(ID) != null)
		{
			weapons.add(theWorld.getWeapon(ID));
			currentInventory.add(ID);
		}
		else if(theWorld.getArmor(ID) != null)
		{
			armors.add(theWorld.getArmor(ID));
			currentInventory.add(ID);
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
