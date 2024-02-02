
public class TestPikachu 
{
	public static void main(String[] args)
	{
		Pikachu pikaMain = new Pikachu();
		Pikachu pikaTarget = new Pikachu();
		Bulbasaur newBulb = new Bulbasaur();
		
		System.out.println("Bulbasaur USE LEECH SEED");
		newBulb.leechSeed(pikaMain);
		System.out.println("Pika Main HP: "+pikaMain.getHp() + "Bulbasaur HP: "+newBulb.getHp());
		
		pikaMain.attackOne(newBulb);
		while(pikaTarget.getHp() > 0) {
		System.out.println("Pikachu USE QUICK ATTACK");
		pikaMain.attackOne(pikaTarget);
		System.out.println("Pika Target HP: "+pikaTarget.getHp());
		}
	}
}
