package game.controller;

import java.util.Scanner;

import game.model.Hero;
import game.model.Inventory;
import game.model.Location;
import game.model.World;

public class GameController
{
	public enum MENU
	{
		VIEWSTATS(1),
		LOOKAROUND(2),
		MOVE(3),
		REST(4),
		EAT(5),
		INVENTORY(6),
			VIEWITEM(1),
			EQUIP(2),
			USEITEM(3),
			GOBACK(4);
		
		private int menuNumber;
		
		private MENU(int number)
		{
			this.menuNumber = number;
		}
		
		public int getMenuNumber()
		{
			return menuNumber;
		}
	}
	
	Scanner input = new Scanner(System.in);
	
	private String heroName;
	private int userChoice;
	private boolean gameOn;
	private int gameStarted;
	
	private int startingStrength;
	private int startingDex;
	private int startingVitality;
	private int startingIntelligence;
	private int startingWisdom;
	
	Hero hero;
	World theWorld = World.getWorld();
	Inventory inventory;
	MENU menu;
	
	private Location currentLocation;
	
	public GameController(MENU menu)
	{
		this.menu = menu;
	}
	
	public GameController()
	{
		startingStrength = 10;
		startingDex = 10;
		startingVitality = 10;
		startingIntelligence = 10;
		startingWisdom = 10;
		
		hero = new Hero("Link", startingStrength, startingDex, startingVitality,
						startingIntelligence, startingWisdom);
		
		inventory = new Inventory();
		
		beginGame();
	}
	
	public void beginGame()
	{
		boolean menuScreenOn = true;
		
		while(menuScreenOn == true)
		{
			//Begin the game
			System.out.println("You awake in a dark dungeon deep below the earth. Dear "
					+ "adventurer, what is your name?");
			
			heroName = input.nextLine();
			hero.setName(heroName);
			
			System.out.println(heroName + " please choose from the following:\n"
								+ "(1)New Game\n"
								+ "(2)Quit");
			userChoice = input.nextInt();
			
			if(userChoice == 1)
			{
				currentLocation = theWorld.getLocation(theWorld.LOCATION_ID_ROOM_START);
				gameOn = true;
				menuScreenOn = false;
			}
		}
		
		//The main game
		while (gameOn = true)
		{
			setMenuState();
		}
	}
	
	public void setMenuState()
	{
		System.out.println("\n"
				+ "Make a choice:\n"
				+ "(1)View Stats\n"
				+ "(2)Look Around\n"
				+ "(3)Move\n"
				+ "(4)Rest\n"
				+ "(5)Eat\n"
				+ "(6)View Inventory\n");
		userChoice = input.nextInt();
		
		//Control the menu state
		if(userChoice == MENU.VIEWSTATS.getMenuNumber())
		{
			viewStats();
		}
		if(userChoice == MENU.LOOKAROUND.getMenuNumber())
		{
			lookAround();
		}
		if(userChoice == MENU.MOVE.getMenuNumber())
		{
			move();
		}
		if(userChoice == MENU.INVENTORY.getMenuNumber())
		{
			//manageInventory();
		}
		else
		{
			System.out.println("Not a valid choice\n");
		}
	}
	
	public void viewStats() 
	{
		System.out.println("Name: " + hero.getName());
		System.out.println("Strength: " + hero.getStrength());
		System.out.println("Dex: " + hero.getDex());
		System.out.println("Vitality: " + hero.getVitality());
		System.out.println("Intelligence: " + hero.getIntelligence());
		System.out.println("Wisdom: " + hero.getWisdom());
	}
	
	public void move()
	{
		boolean locationToTheNorth = false;
		boolean locationToTheSouth = false;
		boolean locationToTheEast = false;
		boolean locationToTheWest = false;
		
		boolean makeChoice = false;
		
		//Determine if there is any paths that can be taken
		if(currentLocation.getLocationToTheNorth() != null)
		{
			System.out.println("You may travel north");
			locationToTheNorth = true;
		}
		if(currentLocation.getLocationToTheSouth() != null)
		{
			System.out.println("You may travel south");
			locationToTheSouth = true;
		}
		if(currentLocation.getLocationToTheEast() != null)
		{
			System.out.println("You may travel east");
			locationToTheEast = true;
		}
		if(currentLocation.getLocationToTheWest() != null)
		{
			System.out.println("You may travel west");
			locationToTheWest = true;
		}
		
		System.out.println("\n");
		
		for(int i=1; i < 4; i++)
		{
			if(locationToTheNorth == true)
			{
				System.out.println("(" + i + ")" + "Go North" + " (" + currentLocation.getLocationToTheNorth().getName() + ")");
				i++;
			}
			if(locationToTheSouth == true)
			{
				System.out.println("(" + i + ")" + "Go South" + " (" + currentLocation.getLocationToTheSouth().getName() + ")");
				i++;
			}
			if(locationToTheEast == true)
			{
				System.out.println("(" + i + ")" + "Go East" + " (" + currentLocation.getLocationToTheEast().getName() + ")");
				i++;
			}
			if(locationToTheWest == true)
			{
				System.out.println("(" + i + ")" + "Go West" + " (" + currentLocation.getLocationToTheWest().getName() + ")");
				i++;
			}
			i = 5;
			
		}
		
		System.out.println("(5)Stay here");
		userChoice = input.nextInt();
		makeChoice = true;
		
		while(makeChoice == true)
		{
			switch(userChoice)
			{
				case 1:
					if(locationToTheNorth == true)
					{
						currentLocation = currentLocation.getLocationToTheNorth();
					}
					else if(locationToTheSouth == true)
					{
						currentLocation = currentLocation.getLocationToTheSouth();
					}
					else if(locationToTheEast == true)
					{
						currentLocation = currentLocation.getLocationToTheEast();
					}
					else if(locationToTheWest == true)
					{
						currentLocation = currentLocation.getLocationToTheWest();
					}
					makeChoice = false;
					break;
				case 2:
					if(locationToTheSouth == true)
					{
						currentLocation = currentLocation.getLocationToTheSouth();
					}
					else if(locationToTheEast == true)
					{
						currentLocation = currentLocation.getLocationToTheEast();
					}
					else if(locationToTheWest == true)
					{
						currentLocation = currentLocation.getLocationToTheWest();
					}
					makeChoice = false;
					break;
				case 3:
					if(locationToTheEast == true)
					{
						currentLocation = currentLocation.getLocationToTheEast();
					}
					else if(locationToTheWest == true)
					{
						currentLocation = currentLocation.getLocationToTheWest();
					}
					makeChoice = false;
					break;
				case 4:
					if(locationToTheWest == true)
					{
						currentLocation = currentLocation.getLocationToTheWest();
					}
					makeChoice = false;
					break;
				default:
					System.out.println("Please make a valid choice");
					makeChoice = true;
					break;	
			}
		}
		System.out.println("You traveled to: " + currentLocation.getName());
	}
	
	public void lookAround()
	{
		System.out.println(currentLocation.getName() + "\n" + currentLocation.getDescription() + "\n");
		
		//Determine if there is any paths that can be taken
		if(currentLocation.getLocationToTheNorth() != null)
		{
			System.out.println("There is another room north of here");
		}
		if(currentLocation.getLocationToTheSouth() != null)
		{
			System.out.println("There is another room south of here");
		}
		if(currentLocation.getLocationToTheEast() != null)
		{
			System.out.println("There is another room east of here");
		}
		if(currentLocation.getLocationToTheWest() != null)
		{
			System.out.println("There is another room west of here");
		}
	}
	
	public void manageInventory()
	{
		boolean makeChoice = true;
		inventory.addInventory(theWorld.getWeapon(theWorld.WEAPON_ID_RUSTY_SWORD), null);
		inventory.addInventory(null, theWorld.getArmor(theWorld.ARMOR_ID_IRON_ARMOR));
		inventory.addInventory(theWorld.getWeapon(theWorld.WEAPON_ID_OLD_BOW), null);
		
		//We stopped here
	}
	
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
