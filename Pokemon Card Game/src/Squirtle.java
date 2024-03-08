
/*
 * Squirtle Class extends Pokemon and implements Attackable
 * Shares characteristics with its parent class Pokemon and implements Attackable in order to be able
 * to attack other Pokemon. Squirtle has two attacks, Tackle and Rain Splash. Tackle costs 0 energy to be
 * played and does 10 damage. Rain Splash costs 2 energy to be played and does 30 damage. 
 * The attack will fail if there is insufficient energy. Squirtle has multiple getter methods to return name, 
 * attackOneName, and attackTwoName. There is also the getInfo() method which will print all the cards characteristics
 * if you were unfamiliar with certain attacks and how much they cost.
 */
public class Squirtle extends Pokemon implements Attackable
{
	public String name = "Squirtle";
	public String type = "Water";
	String attackOneName = "Tackle";
	String attackTwoName = "Rain Splash";
	int attackOneCost = 0;
	int attackTwoCost = 2;
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
		//deal 30 dmg
		int currentEnergy = this.getStorageSize();
		if(currentEnergy >= attackTwoCost)
		{
			int currentHp = target.getHp();
			int resultingHp = currentHp - 30;
			target.setHp(resultingHp);
			useEnergy(attackTwoCost);
			System.out.println("Attack Successful. "+attackTwoCost+" Energy used.");
		}
		else
		{
			System.out.println("Attack Failed. Lack of Energy. "+attackTwoName+" Energy Cost: "+attackTwoCost+" Current Energy: "+this.getStorageSize());
		}
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getAttackOneName()
	{
		return attackOneName;
	}
	
	public String getAttackTwoName()
	{
		return attackTwoName;
	}
	
	public void getInfo()
	{
		System.out.println("\n"+name+" - Pokemon Card\n"+name+" is a "+type+" Type Pokemon\nHP: "+getHp()+"\nAttacks: "+attackOneName+","+attackTwoName+"\n"+attackOneName+" Energy Cost: "+attackOneCost+"\n"+attackTwoName+" Energy Cost: "+attackTwoCost+" "+type+" Energy\n");
	}
}