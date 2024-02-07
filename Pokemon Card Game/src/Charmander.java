
public class Charmander extends Pokemon implements Attackable
{
	public String name = "Charmander";
	public String type = "Fire";
	String attackOneName = "Scratch";
	String attackTwoName = "Ember";
	public Charmander()
	{
		setHp(70);
	}
	
	public void attackOne(Pokemon unfortunatePokemon)
	{
		//deal 10 dmg
		int currentHp = unfortunatePokemon.getHp();
		int resultingHp = currentHp - 10;
		unfortunatePokemon.setHp(resultingHp);
	}
	
	public void attackTwo(Pokemon unfortunatePokemon)
	{
		//deal 30 dmg and discard fire energy
	}
	
	public String getName()
	{
		return name;
	}
}
