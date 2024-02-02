
public class Pikachu extends Pokemon implements Attackable
{	
	String attackOneName = "Quick Attack";
	String attackTwoName = "Electro Ball";
	public Pikachu()
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
		//deal 60 dmg
	}
}
