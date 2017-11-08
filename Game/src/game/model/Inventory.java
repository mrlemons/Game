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
					if(inventorySlotsTaken < maxInventorySlots)
					{
						System.out.println("You equipped the " + getWeapon(itemID).getName() + " and " + hero.weaponEquip.getName() + " was added to your inventory.");
						inventorySlotsTaken += 1;
					}
					else
					{
						System.out.println("You dropped " + hero.weaponEquip.getName() + " and equiped " + getWeapon(itemID).getName() + "\n");
						location.addWeaponHere(hero.weaponEquip);
						inventorySlotsTaken -= 1;
					}
					
				}
				else
				{
					System.out.println("You equipped the " + getWeapon(itemID).getName());
					inventorySlotsTaken -= 1;
					
				}
				
				//Remove from inventory and equip
				hero.setWeaponEquip(getWeapon(itemID));
				weapons.remove(weapons.indexOf(getWeapon(itemID)));
			}
			if(getArmor(itemPosition[choice]) != null)
			{
				itemID = getArmor(itemPosition[choice]).getID();
				if(hero.armorEquip != null)
				{
					if(inventorySlotsTaken < maxInventorySlots)
					{
						System.out.println("You equipped the " + getArmor(itemID).getName() + " and " + hero.armorEquip.getName() + " was added to your inventory." );
						inventorySlotsTaken += 1;
					}
					else
					{
					System.out.println("You dropped " + hero.armorEquip.getName() + " and equiped " + getArmor(itemID).getName() + "\n");
					location.addArmorHere(hero.armorEquip);
					inventorySlotsTaken -= 1;
					}
				}
				else
				{
					System.out.println("You equipped the " + getArmor(itemID).getName());	
					inventorySlotsTaken -= 1;
				}
				
				//Remove from inventory and equip
				hero.setArmorEquip(getArmor(itemID));
				armors.remove(armors.indexOf(getArmor(itemID)));
			}
			//Remove from global inventory
			currentInventory.remove(currentInventory.indexOf(itemID));
		}
		catch (IndexOutOfBoundsException e)
		{
			System.out.println("Not a valid selection\n");
		}
		
		
	}
	
	public void compareEquipment(Hero hero, int choice)
	{
		Integer[] itemPosition = new Integer[currentInventory.size()];
		itemPosition = currentInventory.toArray(itemPosition);
		int itemID = 0;
		
		
		//Draws and displays our compare screen
		if(hero.getWeaponEquip() != null)
		{
			final Object[][] table = new String[6][];
			itemID = getWeapon(itemPosition[choice]).getID();
			table[0] = new String[] {"|", hero.getWeaponEquip().getName() + "(Equipped)", 		"|", getWeapon(itemID).getName() + "(Inventory)", 		"|"};
			table[1] = new String[] {"|", "Strength: " + hero.getWeaponEquip().getStrMod(), 	"|", "Strength: " + getWeapon(itemID).getStrMod(), 		"|"};
			table[2] = new String[] {"|", "Dex: " + hero.getWeaponEquip().getDexMod(), 			"|", "Dex: " + getWeapon(itemID).getDexMod(), 			"|"};
			table[3] = new String[] {"|", "Vitality: " + hero.getWeaponEquip().getVitMod(), 	"|", "Vitality: " + getWeapon(itemID).getVitMod(),		"|"};
			table[4] = new String[] {"|", "Intelligence: " + hero.getWeaponEquip().getIntMod(), "|", "Intelligence: " + getWeapon(itemID).getIntMod(),	"|"};
			table[5] = new String[] {"|", "Wisdom: " + hero.getWeaponEquip().getWisMod(),		"|", "Wisdom: " + getWeapon(itemID).getWisMod(), 		"|"};
			
			for (final Object[] row : table)
			{
				System.out.format("%-3s%-40s%-3s%-40s%-1s\n", row);
			}
		}
		else
		{
			System.out.println("Nothing equipped");
		}
	}
	
	public void showCurrentEquipment(Hero hero)
	{
		int weaponID = 0;
		int armorID = 0;
		
		if(hero.getWeaponEquip() == null)
		{
			System.out.println("Weapon: Nothing Equiped\n");
		}
		
		if(hero.getWeaponEquip() != null)
		{
			weaponID = hero.getWeaponEquip().getID();
			System.out.println("Currently Equiped Weapon: \n" 
					+ hero.getWeaponEquip().getName() + "\n"
					+ hero.getWeaponEquip().getDescription() + "\n"
					+ "Modifiers: \n"
					+ "Strength: " + hero.getWeaponEquip().getStrMod() + "\n"
					+ "Dex: " + hero.getWeaponEquip().getDexMod() + "\n"
					+ "Vitality: " + hero.getWeaponEquip().getVitMod() + "\n"
					+ "Intelligence: " + hero.getWeaponEquip().getIntMod() + "\n"
					+ "Wisdom: " + hero.getWeaponEquip().getWisMod()  + "\n");
		}
		
		if(hero.getArmorEquip() == null)
		{
			System.out.println("Armor: Nothing equipped.\n");
		}
		
		if(hero.getArmorEquip() != null)
		{
			armorID = hero.getArmorEquip().getID();
			System.out.println("Currently Equiped Armor: \n" 
					+ hero.getArmorEquip().getName() + "\n"
					+ hero.getArmorEquip().getDescription() + "\n"
					+ "Modifiers: \n"
					+ "Strength: " + hero.getArmorEquip().getStrMod() + "\n"
					+ "Dex: " + hero.getArmorEquip().getDexMod() + "\n"
					+ "Vitality: " + hero.getArmorEquip().getVitMod() + "\n"
					+ "Intelligence: " + hero.getArmorEquip().getIntMod() + "\n"
					+ "Wisdom: " + hero.getArmorEquip().getWisMod()  + "\n");
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

	public int getInventorySlotsTaken()
	{
		return inventorySlotsTaken;
	}

	public void setInventorySlotsTaken(int inventorySlotsTaken)
	{
		this.inventorySlotsTaken = inventorySlotsTaken;
	}

	public int getMaxInventorySlots()
	{
		return maxInventorySlots;
	}

	public void setMaxInventorySlots(int maxInventorySlots)
	{
		this.maxInventorySlots = maxInventorySlots;
	}
	
	
}
