
/*
 * Pikachu Class extends Pokemon and implements Attackable
 * Shares characteristics with its parent class Pokemon and implements Attackable in order to be able
 * to attack other Pokemon. Pikachu has two attacks, Quick Attack and Electro Ball. Quick Attack costs 0 energy to be
 * played and does 10 damage. Electro Ball costs 3 energy to be played and does 40 damage. 
 * The attack will fail if there is insufficient energy. Pikachu has multiple getter methods to return name, 
 * attackOneName, and attackTwoName. There is also the getInfo() method which will print all the cards characteristics
 * if you were unfamiliar with certain attacks and how much they cost.
 */
public class Pikachu extends Pokemon implements Attackable
{	
	public String name = "Pikachu";
	public String type = "Eletric";
	String attackOneName = "Quick Attack";
	String attackTwoName = "Electro Ball";
	int attackOneCost = 0;
	int attackTwoCost = 3;
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
	
	public void attackTwo(Pokemon target)
	{
		//deal 40 dmg
		int currentEnergy = this.getStorageSize();
		if(currentEnergy >= attackTwoCost)
		{
			int currentHp = target.getHp();
			int resultingHp = currentHp - 40;
			target.setHp(resultingHp);
			useEnergy(attackTwoCost);
			System.out.println("Attack Successful. "+attackTwoCost+" Energy used.");
		}
		else
		{
			//if failed loop again
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
