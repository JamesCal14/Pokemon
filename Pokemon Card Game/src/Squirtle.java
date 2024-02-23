
public class Squirtle extends Pokemon implements Attackable
{
	public String name = "Squirtle";
	public String type = "Water";
	String attackOneName = "Tackle";
	String attackTwoName = "Rain Splash";
	public Squirtle()
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
		//deal 20 dmg
		int currentHp = target.getHp();
		int resultingHp = currentHp - 20;
		target.setHp(resultingHp);
	}
	
	public String getName()
	{
		return name;
	}
}