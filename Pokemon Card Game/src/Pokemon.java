import java.util.ArrayList;

/*
 * Pokemon Class extends card
 * 4 Pokemon - Charmander, Bulbasaur, Squirtle and Pikachu
 */
public class Pokemon extends Card
{
	private String name;
	private String type;
	public String attackOneName;
	public String attackTwoName;
	private int hp;
	private ArrayList<Energy> storage = new ArrayList<Energy>();
	
	public Pokemon()
	{
		hp = 70;
	}
	
	public int getHp()
	{
		return hp;
	}
	
	public void setHp(int userInputHp)
	{
		hp = userInputHp;
	}
	
	public void attackOne(Pokemon target)
	{
	}
	
	public void attackTwo(Pokemon target)
	{
	}
	
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
	
	public void setStorageSize(int energy)
	{
		int size = storage.size() - energy;
		for(int i = storage.size()-1; i>=size;i--)
		{
			storage.remove(i);
		}
	}
}
