/*
 * Add trainer card Professor's research
 * Rebuild deck using equal parts PR, Energy and Charmander
 */
public class Trainer extends Card
{
	private String name;
	
	public Trainer()
	{
		name = "Professor's Research";
	}
	
	public void tcAbility(Player player)
	{
		player.discardHand();
		player.drawHand();
	}
	
	public String getName()
	{
		return name;
	}
}
