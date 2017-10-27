package game.model;

import java.util.ArrayList;

public class Inventory
{
	private int inventorySlotsTaken;
	private int maxInventorySlots;
	
	ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	ArrayList<Armor> armors = new ArrayList<Armor>();
	
	public Inventory()
	{
		inventorySlotsTaken = 0;
		maxInventorySlots = 6;
	}
	
	public void addInventory(Weapon weapon, Armor armor)
	{
		if(weapon != null && inventorySlotsTaken <= maxInventorySlots )
		{
			weapons.add(weapon);
			inventorySlotsTaken += 1;
		}
		else
		{
			System.out.println("No more space.");
		}
	}
	
	public void viewInventory() 
	{
		for(Weapon weapon: weapons)
		{
			System.out.println(weapon.getName());
		}
	}
	
	
}
