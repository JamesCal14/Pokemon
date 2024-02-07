
public class Energy extends Card
{
	//add fire energy (or appropriate type for pokemon)
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
}
