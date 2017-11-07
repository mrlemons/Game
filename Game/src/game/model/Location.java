package game.model;

public class Location
{
	private int ID;
	private String name;
	private String description;
	
	private Location locationToTheNorth;
	private Location locationToTheSouth;
	private Location locationToTheWest;
	private Location locationToTheEast;
	
<<<<<<< HEAD
=======
	
	
>>>>>>> Lesson-2
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

	public Location getLocationToTheNorth()
	{
		return locationToTheNorth;
	}

	public void setLocationToTheNorth(Location locationToTheNorth)
	{
		this.locationToTheNorth = locationToTheNorth;
	}

	public Location getLocationToTheSouth()
	{
		return locationToTheSouth;
	}

	public void setLocationToTheSouth(Location locationToTheSouth)
	{
		this.locationToTheSouth = locationToTheSouth;
	}

	public Location getLocationToTheWest()
	{
		return locationToTheWest;
	}

	public void setLocationToTheWest(Location locationToTheWest)
	{
		this.locationToTheWest = locationToTheWest;
	}

	public Location getLocationToTheEast()
	{
		return locationToTheEast;
	}

	public void setLocationToTheEast(Location locationToTheEast)
	{
		this.locationToTheEast = locationToTheEast;
	}
<<<<<<< HEAD
=======
	
>>>>>>> Lesson-2
	
	

}
