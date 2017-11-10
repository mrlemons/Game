package game.controller;

import java.util.Scanner;

import game.model.Hero;
import game.model.Location;
import game.model.World;

public class GameController
{
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
	
	private Location currentLocation;
	
	public GameController()
	{
		startingStrength = 10;
		startingDex = 10;
		startingVitality = 10;
		startingIntelligence = 10;
		startingWisdom = 10;
		
		hero = new Hero("Link", startingStrength, startingDex, startingVitality,
						startingIntelligence, startingWisdom);
		
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
			System.out.println("\n"
					+ "Make a choice:\n"
					+ "(1)View Stats\n"
					+ "(2)Look Around\n"
					+ "(3)Move\n"
					+ "(4)Rest\n"
					+ "(5)Eat\n"
					+ "(6)View Inventory\n");
			userChoice = input.nextInt();
			
			switch(userChoice)
			{
				case 1:
					viewStats();
					break;
				case 2:
					System.out.println(currentLocation.getName() + " \n" + currentLocation.getDescription());
					break;
				case 3:
					move();
					break;
			}
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
				System.out.println("(" + i + ")" + "Go North");
				i++;
			}
			if(locationToTheSouth == true)
			{
				System.out.println("(" + i + ")" + "Go South");
				i++;
			}
			if(locationToTheEast == true)
			{
				System.out.println("(" + i + ")" + "Go East");
				i++;
			}
			if(locationToTheWest == true)
			{
				System.out.println("(" + i + ")" + "Go West");
				i++;
			}
			i = 5;
			
		}
		
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
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
