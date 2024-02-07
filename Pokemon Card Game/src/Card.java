import java.util.ArrayList;

public class Card 
{
	private String name;
	private ArrayList<Energy> storage = new ArrayList<Energy>();
	
	public String getName()
	{
		return name;
	}
	
	public void receiveEnergy(Energy e)
	{
		storage.add(e);
	}
	
	public int getStorageSize()
	{
		return storage.size();
	}
}
