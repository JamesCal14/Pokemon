
public class Pokemon extends Card
{
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
}
