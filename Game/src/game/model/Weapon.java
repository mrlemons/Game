package game.model;

public class Weapon
{
	private int ID;
	private String name;
	private String description;
	private String itemType;
	private int modifier;
	
	public Weapon(int ID, String name, String description, int modifier)
	{
		this.ID = ID;
		this.name = name;
		this.description = description;
		this.modifier = modifier;
		
		itemType = "weapon";
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
	public int getModifier()
	{
		return modifier;
	}

	public String getItemType()
	{
		return itemType;
	} 
	
	
	
	
}
