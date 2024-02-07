import java.util.ArrayList;
import java.util.Random;

/* 
 * SOFTWARE ENGINEERING PORTION
 * PokemonCardGame class - has 2 players, player 1 and player 2
 * Create player object with arraylists deck, hand, prize pile, discard pile
 * 
 * Need to create game engine
 * In pokemoncardgame class write method called runGame with a while loop
 * "while either player has prize pile cards remaining continue"
 * playerOneturn()
 * playerTwoturn()
 * outside of loop have a setUpGame method
 * 
 * Player turn - draw 1 card - play pokemon - play energy - play trainer - attack - end
 * 
 * Constructing deck with 20 pokemon, energy and trainer
 * 
 * CREATE print methods to track progress
 */
public class PokemonCardGame 
{
	//A deck of cards
	private Player playerOne;
	private Player playerTwo;
	
	public PokemonCardGame()
	{
		playerOne = new Player();
		playerTwo = new Player();
	}
	
	public void setUpGame()
	{
		//reshuffle hand if no pokemon
		playerOne.drawHand();
		playerTwo.drawHand();
		if (playerOne.evaluateOpeningHand() == false)
		{
			playerOne.reshuffleHand();
			//playerTwo.drawCard();
		}
		if (playerTwo.evaluateOpeningHand() == false)
		{
			playerTwo.reshuffleHand();
			//playerOne.drawCard();
		}
		playerOne.drawPrizePile();
		playerTwo.drawPrizePile();
	}
	//Make engine for program
	public void runGame()
	{
		setUpGame();
		System.out.println("Deck: "+playerOne.printDeck());
		System.out.println("Deck Size: "+playerOne.getDeckSize());
		System.out.println("Hand: "+playerOne.printHand());
		System.out.println("Prize Pile: "+playerOne.printPrizePile());
		System.out.println("Bench: "+playerOne.printBench());
		System.out.println("Active: "+playerOne.printActive());
		tcAbility(playerOne);
		//while (player1/player2 has prize pile cards) then run game
		//while (playerOne.prizePileSize() > 0 || playerTwo.prizePileSize() > 0)
		{
			//playerOneTurn()
			//playerTwoTurn()
		}
	}
}
