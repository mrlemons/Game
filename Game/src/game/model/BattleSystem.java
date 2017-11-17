package game.model;

import java.util.Random;

public class BattleSystem
{
	boolean playerTurn;
	boolean monsterTurn;
	
	Random RNG = new Random();
	
	public void doBattle(Hero hero, Monster monster) 
	{
		//See who goes first
		if(whoGoesFirst(hero, monster) == true)
		{
			
		}
		//Deal damage
		//Get results 
	}
	public Boolean whoGoesFirst(Hero hero, Monster monster)
	{
		boolean isPlayerFirst = false;

		double speedModifier;
		int heroSpeed;
		int monsterSpeed;
		double result;
		
		//Get hero speed
		heroSpeed = hero.getDex();
		speedModifier = RNG.nextInt(6) + 1;
		result = speedModifier / 10;
		heroSpeed = (int) (heroSpeed + speedModifier);
		
		//Get monster speed
		monsterSpeed = monster.getSpeed();
		speedModifier = RNG.nextInt(6) + 1;
		result = speedModifier / 10;
		monsterSpeed = (int)(monsterSpeed + speedModifier);
		
		if(heroSpeed > monsterSpeed)
		{
			isPlayerFirst = true;
		}
		else
		{
			isPlayerFirst = false;
		}
		
		return isPlayerFirst;
	}
}
