import java.util.ArrayList;

public class Pokemon extends Card
{
	private String name;
	private String type;
	private int hp;
	
	public Pokemon()
	{
		hp = 70;
	}
	
	public int getHp()
	{
		return hp;
	}
	
	public void setHp(int userInputHp)
	{
		hp = userInputHp;
	}
	
	public String getName()
	{
		return name;
	}
}
