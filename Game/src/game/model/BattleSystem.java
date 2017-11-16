package game.model;

import java.util.Random;

public class BattleSystem
{
	boolean playerTurn;
	boolean monsterTurn;
	
	public void doBattle(Hero hero, Monster monster) 
	{
		//See who goes first
		//Deal damage
		//Get results 
	}
	public Boolean whoGoesFirst(Hero hero, Monster monster)
	{
		boolean isPlayerFirst = false;
		
		Random RNG = new Random();
		
		int speedModifier;
		int heroSpeed;
		int monsterSpeed;
		
		heroSpeed = RNG.nextInt(3) + 1;
		heroSpeed = 10 / heroSpeed;
		
		heroSpeed = heroSpeed 
		
		
		
		return isPlayerFirst;
	}
}
