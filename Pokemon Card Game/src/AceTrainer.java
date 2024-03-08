
/*
 * Ace Trainer is a trainer card that can be played if you have more prize pile cards then your opponent.
 * Both players' hands are shuffled into their decks. Then the player draws 6 cards and your opponent draws 3.
 * Calls the returnHand() method to reshuffle hand into deck. Then the draw() method is played to draw cards into hand.
 * Outputs an error if card doesn't meet play requirements.
 * Included is a getName() method and getInfo() method.
 */
public class AceTrainer extends Trainer
{
	public String name = "Ace Trainer";
	
	public void playable(Player player, Player player2)
	{
		if(player.getPrizePileSize() > player2.getPrizePileSize())
		{
			player.returnHand();
			player2.returnHand();
			for(int i = 0; i<6; i++)
			{
				player.draw();
			}
			
			for(int i = 0; i<3; i++)
			{
				player2.draw();
			}
		}
		else
		{
			System.out.println("Not Played (In order to play your prize pile must have more cards than your opponents)");
		}
	}
	
	public String getName()
	{
		return name;
	}
	
	public void getInfo()
	{
		System.out.println("\nAce Trainer - Trainer Card\nYou can play this card only if you have more prize cards than your opponent.\nEach player shuffles his or her hand into his or his deck. Then, draw 6 cards. Your opponent draws 3 cards.\n");
	}
}
