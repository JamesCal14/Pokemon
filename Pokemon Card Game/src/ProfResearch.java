
/*
 * Professor's Research is a trainer card that discards your current hand and draws 7 random cards from the players deck.
 * Utilizes the discardHand() method and drawHand() method.
 * Included is a getName() method and getInfo() method.
 */
public class ProfResearch extends Trainer
{
	public String name = "Professor's Research";
	@Override
	public void playable(Player player, Player p2)
	{
		player.discardHand();
		player.drawHand();
	}
	
	public String getName()
	{
		return name;
	}
	
	public void getInfo()
	{
		System.out.println("\nProfessor's Research - Trainer Card\nDiscard your hand and draw 7 cards.\n");
	}
}
