package game.model;

import java.util.ArrayList;

public class World
{

	private static World theWorld = new World();
	
	ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	ArrayList<Armor> armors = new ArrayList<Armor>();
	
	//Weapon ID's
	public final int WEAPON_ID_RUSTY_SWORD = 1;
	public final int WEAPON_ID_OLD_BOW = 2;
	public final int WEAPON_ID_SPLINTERED_STAFF = 3;
	
	public World()
	{
		theWorld = this;
		
		//Populate our world
		
		populateWeapons();
	}
	
	public void populateWeapons()
	{
		//int ID, String name, String description, int modifier
		
		Weapon rustySword = new Weapon(WEAPON_ID_RUSTY_SWORD, "Rusty Sword", "An old sword that has gathered some rust", 1);
		
		//Add the weapons to our list
		weapons.add(rustySword);
	}
	
	
	
	
	
	
	
}
