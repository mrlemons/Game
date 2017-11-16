package game.model;

public class Monster
{
	private int ID;
	private String name;
	private String description;
	private int attack;
	private int defense;
	private int health;
	private String attackType;
	private int speed;
	
	public Monster(int ID, String name, String description, int attack, int defense, int health, 
					String attackType, int speed)
	{
		this.ID = ID;
		this.name = name;
		this.description = description;
		this.attack = attack;
		this.defense = defense;
		this.health = health;
		this.attackType = attackType;
		this.speed = speed;
	}
	
	public int getID()
	{
		return ID;
	}
	public void setID(int iD)
	{
		ID = iD;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public int getAttack()
	{
		return attack;
	}
	public void setAttack(int attack)
	{
		this.attack = attack;
	}
	public int getDefense()
	{
		return defense;
	}
	public void setDefense(int defense)
	{
		this.defense = defense;
	}

	public int getHealth()
	{
		return health;
	}

	public void setHealth(int health)
	{
		this.health = health;
	}

	public int getSpeed()
	{
		return speed;
	}

	public void setSpeed(int speed)
	{
		this.speed = speed;
	}

	public String getAttackType()
	{
		return attackType;
	}
	
	

}
