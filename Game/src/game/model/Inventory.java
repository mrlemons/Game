package game.model;

import java.util.ArrayList;

public class Inventory
{
	private int inventorySlotsTaken;
	private int maxInventorySlots;
	
	
	
	ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	ArrayList<Armor> armors = new ArrayList<Armor>();
	
	private int slotOne;
	
	public Inventory()
	{
		inventorySlotsTaken = 0;
		maxInventorySlots = 6;
	}
	
	public void addInventory(Weapon weapon, Armor armor)
	{
		int currentSlot = inventorySlotsTaken + 1;
		if(weapon != null && inventorySlotsTaken <= maxInventorySlots )
		{
			weapons.add(weapon);
			slotOne = weapon.getID()
			inventorySlotsTaken += 1;
		}
		else
		{
			System.out.println("No more space.");
		}
	}
	
	public void viewInventory() 
	{
		int numberChoice = 1;
		
		if(inventorySlotsTaken == 0)
		{
			System.out.println("Nothing here");
		}
		for(Weapon weapon: weapons)
		{
			System.out.println("(" + numberChoice + ")" + weapon.getName());
			numberChoice +=1;
		}
	}
	
}
