import java.util.ArrayList;

/*
 * Pokemon Class extends card
 * 4 Pokemon - Charmander, Bulbasaur, Squirtle and Pikachu
 * The Pokemon class has a multitude of instance variables used by its child classes.
 * Methods consist of a constructor, getter and setter for HP. 
 * Getter methods for name, type, attackOneName, and attackTwoName.
 * Pokemon also has a ArrayList of type Energy called storage. This tracks if the Pokemon is able to use energy
 * to unleash a strong attack. To manage this there is the receiveEnergy() and useEnergy() methods.
 */
public class Pokemon extends Card
{
	private String name;
	private String type;
	private String attackOneName;
	private String attackTwoName;
	int attackOneCost;
	int attackTwoCost;
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
	
	public String getName()
	{
		return name;
	}
	
	public String getType()
	{
		return type;
	}
	
	public void receiveEnergy(Energy e)
	{
		storage.add(e);
	}
	
	public void useEnergy(int energy)
	{
		int size = storage.size() - energy;
		for(int i = storage.size()-1; i>=size;i--)
		{
			storage.remove(i);
		}
	}
	
	public int getStorageSize()
	{
		return storage.size();
	}
	
	
	public String getAttackOneName()
	{
		return attackOneName;
	}
	
	public String getAttackTwoName()
	{
		return attackTwoName;
	}
	
	public void attackOne(Pokemon target)
	{
	}
	
	public void attackTwo(Pokemon target)
	{
	}
}
