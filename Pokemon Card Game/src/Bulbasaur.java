
/*
 * Bulbasaur Class extends Pokemon and implements Attackable
 * Shares characteristics with its parent class Pokemon and implements Attackable in order to be able
 * to attack other Pokemon. Bulbasaur has two attacks, Tackle and Leech Seed. Tackle costs 0 energy to be
 * played and does 10 damage. Leech Seed costs 2 energy to be played and does 20 damage and also
 * heals for 20 damage. The attack will fail if there is insufficient energy. 
 * Bulbasaur has multiple getter methods to return name, attackOneName,
 * and attackTwoName. There is also the getInfo() method which will print all the cards characteristics
 * if you were unfamiliar with certain attacks and how much they cost.
 */
public class Bulbasaur extends Pokemon implements Attackable
{
	public String name = "Bulbasaur";
	public String type = "Grass";
	String attackOneName = "Tackle";
	String attackTwoName = "Leech Seed";
	int attackOneCost = 0;
	int attackTwoCost = 2;
	
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
		
		int currentEnergy = this.getStorageSize();
		if(currentEnergy >= attackTwoCost)
		{
			//deal 20 dmg, heal 20 dmg
			int currentHp = target.getHp();
			int resultingHp = currentHp - 20;
			
			int thisCurrentHp = this.getHp();
			this.setHp(thisCurrentHp + 20);
			
			target.setHp(resultingHp);
			
			useEnergy(attackTwoCost);
			System.out.println("Attack Successful. "+attackTwoCost+" Energy used. Current HP: "+this.getHp());
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
