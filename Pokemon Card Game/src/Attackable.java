
public interface Attackable 
{
	/*interface Attackable with two abstract methods, attackOne() and attackTwo()
	 * Each pokemon should implement the interface such as Pikachu
	 * public class Pikachu extends Pokemon implements Attackable
	 * Update the methods to attack 1 and 2, make global variables String attackOneName
	 * and attackTwoName
	 * Main purpose is to let you add userinterface to simply attack by choosing attack1
	 * or attack2
	 */
	String attackOneName = "";
	String attackTwoName = "";
	void attackOne(Pokemon target);
	void attackTwo(Pokemon target);
}
