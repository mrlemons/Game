package game.model;

import java.util.ArrayList;

public class Inventory
{
	private int inventorySlotsTaken;
	private int maxInventorySlots;
	private int currentSlot;
	
	
	
	ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	ArrayList<Armor> armors = new ArrayList<Armor>();
	
	World theWorld = World.getWorld();
	

	
	private int[] slot = new int[5];
	
	public Inventory()
	{
		inventorySlotsTaken = 0;
		maxInventorySlots = 6;
		currentSlot = 0;
	}
	
	//Add to our inventory
	public void addInventory(int ID)
	{
		int currentSlot = inventorySlotsTaken;
		if(theWorld.getWeapon(ID) != null && inventorySlotsTaken >= maxInventorySlots )
		{
			weapons.add(theWorld.getWeapon(ID));
			slot[currentSlot] = theWorld.getWeapon(ID).getID();
			inventorySlotsTaken += 1;
		}
		else if(theWorld.getArmor(ID) != null && inventorySlotsTaken >= maxInventorySlots)
		{
			armors.add(theWorld.getArmor(ID));
			slot[currentSlot] = theWorld.getArmor(ID).getID();
			inventorySlotsTaken += 1;
		}
		if(inventorySlotsTaken >= maxInventorySlots)
		{
			System.out.println("No more space.");
		}
	}
	
	//View our inventory
	public void viewInventory() 
	{
		
		
		for(int numberChoice = 0; numberChoice < 5; numberChoice++)
		{
			if(getWeapon(slot[numberChoice]) != null)
			{
				System.out.println("(" + numberChoice + ")" + getWeapon(slot[numberChoice]).getName());
				numberChoice += 1;
			}
			if(getArmor(slot[numberChoice]) != null)
			{
				System.out.println("(" + numberChoice + ")" + getArmor(slot[numberChoice]).getName());
			}
		}
		
		
		if(inventorySlotsTaken == 0)
		{
			System.out.println("Nothing here");
		}
	}
	
	//Select an item
	public void selectItem(int choice)
	{
		
		if(getWeapon(slot[choice]) != null)
		{
			System.out.println("\n"
								+ "Name: " + getWeapon(slot[choice]).getName() + "\n"
								+ "Description: " + getWeapon(slot[choice]).getDescription() + "\n");
		}
		else if(getArmor(slot[choice]) != null)
		{
			System.out.println("\n"
					+ "Name: " + getArmor(slot[choice]).getName() + "\n"
					+ "Description: " + getArmor(slot[choice]).getDescription() + "\n");
		}
	}
	
	public void removeItem(int choice)
	{
		
		
		if(getWeapon(slot[choice]) != null)
		{
			weapons.remove(getWeapon(slot[choice]));
			slot[choice] = 0;
			inventorySlotsTaken -= 1;
			
		}
		else if(getArmor(slot[choice]) != null)
		{
			armors.remove(getArmor(slot[choice]));
			slot[choice] = 0;
			inventorySlotsTaken -= 1;
			
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
