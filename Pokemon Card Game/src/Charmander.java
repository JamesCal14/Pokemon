
/*
 * Charmander Class extends Pokemon and implements Attackable
 * Shares characteristics with its parent class Pokemon and implements Attackable in order to be able
 * to attack other Pokemon. Charmander has two attacks, Scratch and Ember. Scratch costs 0 energy to be
 * played and does 10 damage. Ember costs 2 energy to be played and does 30 damage. The attack will fail
 * if there is insufficient energy. Charmander has multiple getter methods to return name, attackOneName,
 * and attackTwoName. There is also the getInfo() method which will print all the cards characteristics
 * if you were unfamiliar with certain attacks and how much they cost.
 */
public class Charmander extends Pokemon implements Attackable
{
	public String name = "Charmander";
	public String type = "Fire";
	String attackOneName = "Scratch";
	String attackTwoName = "Ember";
	int attackOneCost = 0;
	int attackTwoCost = 2;
	
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
		int currentEnergy = this.getStorageSize();
		if(currentEnergy >= attackTwoCost)
		{
			int currentHp = unfortunatePokemon.getHp();
			int resultingHp = currentHp - 30;
			unfortunatePokemon.setHp(resultingHp);
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
