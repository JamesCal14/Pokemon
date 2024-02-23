
public class Bulbasaur extends Pokemon implements Attackable
{
	public String name = "Bulbasaur";
	public String type = "Grass";
	String attackOneName = "Tackle";
	String attackTwoName = "Leech Seed";
	public Bulbasaur()
	{
		setHp(70);
	}
	
	public void attackOne(Pokemon target)
	{
		//deal 10 dmg
		int currentHp = target.getHp();
		int resultingHp = currentHp - 10;
		target.setHp(resultingHp);
	}
	
	public void attackTwo(Pokemon target)
	{
		//deal 20 dmg, heal 20 dmg
		int currentHp = target.getHp();
		int resultingHp = currentHp - 20;
		
		//we're missing line of code to make sure the pokemon has missing life to heal
		int thisCurrentHp = this.getHp();
		this.setHp(thisCurrentHp + 20);
		
		target.setHp(resultingHp);
		
	}
	
	public String getName()
	{
		return name;
	}
}
