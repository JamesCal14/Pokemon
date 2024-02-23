/*
 * Trainer class extends card
 * 3 Trainer cards - Professor's Research, Nest Ball, N
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

	public void playable(Player player) 
	{
	}
}
