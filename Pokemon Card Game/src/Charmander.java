
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
	
	//@Override
	public void attackOne(Pokemon unfortunatePokemon)
	{
		//deal 10 dmg
		int currentHp = unfortunatePokemon.getHp();
		int resultingHp = currentHp - 10;
		unfortunatePokemon.setHp(resultingHp);
	}
	
	@Override
	public void attackTwo(Pokemon unfortunatePokemon)
	{
		//deal 30 dmg and discard fire energy
		int energy = this.getStorageSize();
		if(energy >= 2)
		{
			int currentHp = unfortunatePokemon.getHp();
			int resultingHp = currentHp - 30;
			unfortunatePokemon.setHp(resultingHp);
			setStorageSize(2);
			System.out.println("Attack Successful.");
			System.out.println("2 Energy used.");
		}
		else
		{
			System.out.println("Attack Failed.");
			System.out.println("Lack of energy");
		}
	}
	
	public String getName()
	{
		return name;
	}
}
