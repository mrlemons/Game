package game.model;

import java.util.ArrayList;

public class World
{
	private static World theWorld = new World();
	
	ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	ArrayList<Armor> armors = new ArrayList<Armor>();
	ArrayList<Location> locations = new ArrayList<Location>();
	
	
	
	//Weapon ID's 1 - 200
	public final int WEAPON_ID_RUSTY_SWORD = 1;
	public final int WEAPON_ID_OLD_BOW = 2;
	public final int WEAPON_ID_SPLINTERED_STAFF = 3;
	
	//Armor ID's 201 - 400
	public final int ARMOR_ID_IRON_ARMOR = 201;
	
	//Item ID's 401 - 600
	
	//Location ID's 601 - 800
	public final int LOCATION_ID_ROOM_START = 601;
	public final int LOCATION_ID_SOUTH_ROOM_FLOOR_ONE = 602;
	public final int LOCATION_ID_WEST_ROOM_FLOOR_ONE = 603;
	
	public World() 
	{
		theWorld = this;
		
		//Populate our world
		populateWeapons();
		populateArmors();
		populateLocations();
	}
	
	public static World getWorld()
	{
		return theWorld;
	}
	
	public void populateWeapons() 
	{
		//int ID, String name, String description
		
		Weapon rustySword = new Weapon(WEAPON_ID_RUSTY_SWORD,"Rusty Sword", "An old sword that has gathered some rust.");
		Weapon oldBow = new Weapon(WEAPON_ID_OLD_BOW, "Old Bow", "An old bow that has seen better days.");
		Weapon splinteredStaff = new Weapon(WEAPON_ID_SPLINTERED_STAFF, "Splintered Staff", "A staff with many splinters.");
		
		//Set our weapon stat modifiers 
		rustySword.setStrMod(1);
		
		oldBow.setDexMod(1);
		
		splinteredStaff.setIntMod(1);
		
		//Add the weapons to our weapon list
		weapons.add(rustySword);
		weapons.add(oldBow);
		weapons.add(splinteredStaff);
	}
	
	public void populateArmors()
	{
		//int ID, String name, String description, int modifier
		
		Armor ironArmor = new Armor(ARMOR_ID_IRON_ARMOR, "Iron Armor", "A set of iron armor once worn by a forgotten knight");
		
		//Set our armor stat modifiers
		ironArmor.setVitMod(1);
		
		//Add the armor to our armor list
		armors.add(ironArmor);
		
	}
	
	public void populateLocations()
	{
		//int ID, String name, String description
		Location roomStart = new Location(LOCATION_ID_ROOM_START, "Damp Dungeon", "A very dark dungeon. Damp and cold. You figure you must be "
											+ "very deep under the earth.");
		Location southRoomFloorOne = new Location(LOCATION_ID_SOUTH_ROOM_FLOOR_ONE, "South Room", "This room is dark however, you see a pile of bones and what you think maybe be something made of iron in the corner.");
		
		Location westRoomFloorOne = new Location(LOCATION_ID_WEST_ROOM_FLOOR_ONE, "West Room", "This room is lit with a single torch. In the middle of the floor you make out what looks like an old bow and a quiver of arrows");
		
		//Set all reachable locations
		roomStart.setLocationToTheNorth(null);
		roomStart.setLocationToTheSouth(southRoomFloorOne);
		roomStart.setLocationToTheWest(null);
		roomStart.setLocationToTheEast(null);
		
		southRoomFloorOne.setLocationToTheNorth(roomStart);
		southRoomFloorOne.setLocationToTheSouth(null);
		southRoomFloorOne.setLocationToTheWest(westRoomFloorOne);
		southRoomFloorOne.setLocationToTheEast(null);
		
		westRoomFloorOne.setLocationToTheNorth(null);
		westRoomFloorOne.setLocationToTheSouth(null);
		westRoomFloorOne.setLocationToTheWest(null);
		westRoomFloorOne.setLocationToTheEast(southRoomFloorOne);
		
		//Add any weapons to location
	
		roomStart.addWeaponHere(getWeapon(WEAPON_ID_RUSTY_SWORD));
		roomStart.addWeaponHere(getWeapon(WEAPON_ID_OLD_BOW));
		
		
		
		//Add location to list
		locations.add(roomStart);
		locations.add(southRoomFloorOne);
		locations.add(westRoomFloorOne);
		
		
	}
	
	//Search for weapons
	public Weapon getWeapon(int weaponID)
	{
		for(Weapon weapon: weapons)
		{
			if(weapon.getID() == weaponID)
			{
				return weapon;
			}
		}
		return null;
		
	}
	
	//Search for armor
	public Armor getArmor(int armorID)
	{
		for(Armor armor: armors)
		{
			if(armor.getID() == armorID)
			{
				return armor;
			}
		}
		return null;
	}
	
	//Search for locations
	public Location getLocation(int locationID)
	{
		for(Location location: locations)
		{
			if(location.getID() == locationID)
			{
				return location;
			}
		}
		return null;
	}
	
}
