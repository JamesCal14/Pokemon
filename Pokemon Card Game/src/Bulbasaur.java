
public class Bulbasaur extends Pokemon
{
	public Bulbasaur()
	{
		setHp(70);
	}
	
	public void leechSeed(Pokemon target)
	{
		//deal 20 dmg, heal 20 dmg
		int currentHp = target.getHp();
		int resultingHp = currentHp - 20;
		
		//we're missing line of code to make sure the pokemon has missing life to heal
		int thisCurrentHp = this.getHp();
		this.setHp(thisCurrentHp + 20);
		
		target.setHp(resultingHp);
		
	}
}
