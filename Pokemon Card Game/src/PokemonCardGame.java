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
		playerOne.addToDeck(new Charmander());
		playerTwo.addToDeck(new Bulbasaur());
		playerOne.addToDeck(new Energy("Fire"));
	}
	
	public void setUpGame()
	{
		
	}
	//Make engine for program
	public void runGame()
	{
		playerOne.drawHand();
		System.out.println(playerOne.evaluateOpeningHand());
		//setUpGame();
		//while (player1/player2 has prize pile cards) then run game
	}
}
