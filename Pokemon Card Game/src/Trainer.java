/*
 * Trainer class extends card
 * 3 Trainer cards - Professor's Research, Nest Ball, Ace Trainer
 * The Trainer Class has the instance variable name which has two constructors and a getter method.
 * The main functionality of Trainer is it implements TrainerAction which has the playable method.
 * The playable requires two objects of type Player, one for the card user and another for the opponent.
 * All trainer cards have the playable method and output a different effect respectively.
 */
public class Trainer extends Card implements TrainerAction
{
	private String name;
	
	public Trainer()
	{
		name = "None";
	}
	
	public Trainer(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}

	public void playable(Player player, Player p2) 
	{	
	}
}
