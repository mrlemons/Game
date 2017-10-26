package game.model;

public class Location
{
	private int ID;
	private String name;
	private String description;
	
	public Location(int ID, String name, String description)
	{
		this.ID = ID;
		this.name = name;
		this.description = description;
		
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
	
	

}
