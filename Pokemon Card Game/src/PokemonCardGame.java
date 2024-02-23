import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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
 * 
 * use interfaces
 * 
 * TO DO LIST
 * -Once pokemon is at 0 hp require another pokemon be put in and continue game
 * -Play multiple cards in a turn
 * -Add checkifwinner() method
 * -Add one more trainer card
 * -Screenshots and documentation
 * 
 */
public class PokemonCardGame 
{
	//A deck of cards
	private Player playerOne;
	private Player playerTwo;
	Scanner in = new Scanner(System.in);
	
	public PokemonCardGame()
	{
		playerOne = new Player();
		playerTwo = new Player();
	}
	
	public void playerOneTurn()
	{
		System.out.println("\nPlayer One\n");
		System.out.println("Hand: "+playerOne.printHand());
		System.out.println("Bench: "+playerOne.printBench());
		System.out.println("Active: "+playerOne.printActive());
		System.out.println("Deck Size: "+playerOne.getDeckSize());
		System.out.println("\nPlayer One Turn\n");
		playerOne.draw();
		playerOne.play();
		//playerOne.attack(playerTwo);
		//end
	}
	
	public void playerTwoTurn()
	{
		System.out.println("\nPlayer Two\n");
		System.out.println("Hand: "+playerTwo.printHand());
		System.out.println("Bench: "+playerTwo.printBench());
		System.out.println("Active: "+playerTwo.printActive());
		System.out.println("Deck Size: "+playerTwo.getDeckSize());
		System.out.println("\nPlayer Two Turn\n");
		playerTwo.draw();
		playerTwo.play();
		//playerTwo.attack(playerOne);
		//end
	}
	
	public void preTurn()
	{
		System.out.println("\nPlayer One Start\n");
		playerOne.play();
		System.out.println("\nPlayer Two Start\n");
		playerTwo.play();
	}
	
	public void setUpGame()
	{
		//reshuffle hand if no pokemon
		playerOne.drawHand();
		playerTwo.drawHand();
		while (playerOne.evaluateOpeningHand() == false)
		{
			playerOne.reshuffleHand();
			playerTwo.draw();
		}
		while (playerTwo.evaluateOpeningHand() == false)
		{
			playerTwo.reshuffleHand();
			playerOne.draw();
		}
		playerOne.drawPrizePile();
		playerTwo.drawPrizePile();
		System.out.println("\nPlayer One");
		System.out.println("Hand: "+playerOne.printHand());
		System.out.println("Prize Pile Size: "+playerOne.prizePileSize());
		System.out.println("Deck Size: "+playerOne.getDeckSize());
		System.out.println("Bench: "+playerOne.printBench());
		System.out.println("Active: "+playerOne.printActive());
		System.out.println("\nPlayer Two");
		System.out.println("Hand: "+playerTwo.printHand());
		System.out.println("Prize Pile Size: "+playerTwo.prizePileSize());
		System.out.println("Deck Size: "+playerTwo.getDeckSize());
		System.out.println("Bench: "+playerTwo.printBench());
		System.out.println("Active: "+playerTwo.printActive());
	}
	//Make engine for program
	public void runGame()
	{
		printInstructions();
		setUpGame();
		preTurn();
		while (playerOne.prizePileSize() > 0 || playerTwo.prizePileSize() > 0)
		{
			playerOneTurn();
			playerTwoTurn();
		}
	}
	
	public void printInstructions()
	{
		System.out.println("Print Instructions? (1 for Yes, 2 for No)");
		String userInput = in.next();
		if(userInput.equals("1"))
		{
		System.out.println("Pokemon Card Game Simulation Instructions\nTo start you are given a deck of cards consisting of the three types, Pokemon, Energy, and Trainer.\n7 of these cards are put into your hand to be played on the field.\nPokemon are played on the Active and Bench positions with the Active Pokemon being the primary attacker.\nEnergy is attached to Pokemon with the same type in order to unleash powerful special moves.\nTrainer cards perform abilities that alter gameplay, such as drawing cards or changing hands.\nThe objective of the game is to attack the opponents Active pokemon and defeat them.\nTaking down the Pokemon will send it to the Discard Pile and remove a card from the opponent's Prize Pile.\nThe first player to run out of cards in their Prize Pile loses.\nIn general, when playing cards, you can press 1 to Play or 2 to Not Play, except in scenarios when there is more than 2 options.");
		}
	}
}
