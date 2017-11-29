package game.model;

import java.util.ArrayList;

public class Inventory
{
	private int inventorySlotsTaken;
	private int maxInventorySlots;
	private int currentSlot;
	
	ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	ArrayList<Armor> armors = new ArrayList<Armor>();
	
	private int[] slot = new int[5];
	
	public Inventory()
	{
		inventorySlotsTaken = 0;
		maxInventorySlots = 6;
		currentSlot = 0;
	}
	
	public void addInventory(Weapon weapon, Armor armor)
	{
		int currentSlot = inventorySlotsTaken;
		if(weapon != null && inventorySlotsTaken <= maxInventorySlots)
		{
			weapons.add(weapon);
			slot[currentSlot] = weapon.getID();
			inventorySlotsTaken += 1;
		}
		else if(armor != null && inventorySlotsTaken <= maxInventorySlots)
		{
			armors.add(armor);
			slot[currentSlot] = armor.getID();
			inventorySlotsTaken += 1;
		}
		else
		{
			System.out.println("No more space.\n");
		}
	}
	
	public void viewInventory()
	{
		int numberChoice = 1;
		
		if(inventorySlotsTaken == 0)
		{
			System.out.println("Nothing here");
		}
		for(Weapon weapon : weapons)
		{
			System.out.println("(" + numberChoice + ")" + weapon.getName());
			numberChoice += 1;
		}
		for(Armor armor : armors)
		{
			System.out.println("(" + numberChoice + ")" + armor.getName());
			numberChoice += 1;
		}
	}
	
	public void selectItem(int choice)
	{
		choice = choice - 1;
		
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
		for(Armor armor : armors)
		{
			if(armor.getID() == ID)
			{
				return armor;
			}
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
