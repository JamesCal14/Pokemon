import java.util.ArrayList;

public class Pokemon extends Card
{
	private int hp;
	private ArrayList<Energy> storage;
	
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
}
