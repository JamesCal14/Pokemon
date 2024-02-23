import java.util.ArrayList;

public class ProfResearch extends Trainer
{
	public String name = "Professor's Research";
	@Override
	public void playable(Player player)
	{
		player.discardHand();
		player.drawHand();
	}
	
	public String getName()
	{
		return name;
	}
}
