
/*
 * Energy class extends Card and consists of Fire energy. Used to power up pokemon and unlock special attacks.
 * Includes getType(), getName(), and getInfo() methods.
 * 
 */
public class Energy extends Card
{
	private String type;
	
	public Energy()
	{
		type = "None";
	}
	
	public Energy(String t)
	{
		type = t;
	}
	
	public String getType()
	{
		return type;
	}
	
	public String getName()
	{
		return type+" Energy";
	}
	
	public void getInfo()
	{
		System.out.println("\n"+getName()+" - Basic Energy Card\nUsed to power up Pokemon attacks of Type "+type+"\n");
	}
}
