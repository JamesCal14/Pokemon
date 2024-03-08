import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

 /* 
 * PokemonCardGame Class is the main game engine. Creates two Player type objects and a Scanner for
 * userInput. PokemonCardGame class has playerTurn methods for each player which prints the cards
 * for a visual as well as calls play and attack. The preTurn() method is used so players can play
 * cards before attacking so activePile is not empty. The setUpGame() draws the cards from the deck
 * for each player and sets up their hand, prizePile, etc. The runGame() is the main game engine
 * and continuously runs playerTurn until a players' prizePile is depleted. It then calls the
 * checkIfWinner() to output a winner and stop the program.
 * Additional Methods
 * printInstructions() outputs instructions for the game on how to play.
 * runNumber() will calculate the probability of having a pokemon if your starting hand.
 * brickCalculator() will calculate the probability that your deck is "bricked" and the hypothetical trainer card
 * of Rare Candy is in your prize pile.
 */
public class PokemonCardGame 
{
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
		playerOne.draw();
		System.out.println("\nPlayer One\n");
		System.out.println("Hand: "+playerOne.printHand());
		System.out.println("Bench: "+playerOne.printBench());
		System.out.println("Active: "+playerOne.printActive());
		System.out.println("Deck Size: "+playerOne.getDeckSize());
		System.out.println("\nPlayer One Turn\n");
		playerOne.play(playerTwo);
		playerOne.attack(playerTwo);
	}
	
	public void playerTwoTurn()
	{
		playerTwo.draw();
		System.out.println("\nPlayer Two\n");
		System.out.println("Hand: "+playerTwo.printHand());
		System.out.println("Bench: "+playerTwo.printBench());
		System.out.println("Active: "+playerTwo.printActive());
		System.out.println("Deck Size: "+playerTwo.getDeckSize());
		System.out.println("\nPlayer Two Turn\n");
		playerTwo.play(playerOne);
		playerTwo.attack(playerOne);
	}
	
	public void preTurn()
	{
		//Preturn so no attacking until ActivePile is filled
		System.out.println("\nPlayer One Start\n");
		System.out.println("Hand: "+playerOne.printHand());
		playerOne.play(playerTwo);
		System.out.println("\nPlayer Two Start\n");
		System.out.println("Hand: "+playerTwo.printHand());
		playerTwo.play(playerOne);
	}
	
	public void setUpGame()
	{
		//Reshuffle hand if no pokemon
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
		System.out.println("Prize Pile Size: "+playerOne.getPrizePileSize());
		System.out.println("Deck Size: "+playerOne.getDeckSize());
		System.out.println("Bench: "+playerOne.printBench());
		System.out.println("Active: "+playerOne.printActive());
		System.out.println("\nPlayer Two");
		System.out.println("Hand: "+playerTwo.printHand());
		System.out.println("Prize Pile Size: "+playerTwo.getPrizePileSize());
		System.out.println("Deck Size: "+playerTwo.getDeckSize());
		System.out.println("Bench: "+playerTwo.printBench());
		System.out.println("Active: "+playerTwo.printActive());
	}
	
	public void checkIfWinner()
	{
		if(playerOne.getPrizePileSize()==0)
		{
			System.out.println("Player Two Wins!");
		}
		else if(playerTwo.getPrizePileSize()==0)
		{
			System.out.println("Player One Wins!");
		}
	}
	
	//Game Engine
	public void runGame()
	{
		printInstructions();
		setUpGame();
		preTurn();
		while (playerOne.getPrizePileSize() != 0 && playerTwo.getPrizePileSize() != 0)
		{
			playerOneTurn();
			checkIfWinner();
			playerTwoTurn();
			checkIfWinner();
		}
	}
	
	public void printInstructions()
	{
		System.out.println("Print Instructions? (1 for Yes, 2 for No)");
		String userInput = in.next();
		if(userInput.equals("1"))
		{
		System.out.println("Pokemon Card Game Simulation Instructions\nTo start you are given a deck of cards consisting of the three types, Pokemon, Energy, and Trainer.\n7 of these cards are put into your hand to be played on the field.\nPokemon are played on the Active and Bench positions with the Active Pokemon being the primary attacker.\nEnergy is attached to Pokemon with the same type in order to unleash powerful special moves.\nTrainer cards perform abilities that alter gameplay, such as drawing cards or changing hands.\nThe objective of the game is to attack the opponents Active pokemon and defeat them.\nTaking down the Pokemon will send it to the Discard Pile and remove a card from the opponent's Prize Pile.\nThe first player to run out of cards in their Prize Pile loses.\nIn general, when playing cards, you can press 1 to Play or 2 to Not Play, except when specified otherwise.");
		}
	}
	
	public void runNumber()
	{
		/* runNumber is a void method which counts the times a pokemon is drawn in the
		 * first hand looped a large number of times to calculate the probability of
		 * having a pokemon in your hand.
		 */
		double count = 0; 
		for (int i = 1; i < 10000; i++)
		{
			Player test = new Player();
			test.drawHand();
			if (test.evaluateOpeningHand())
			{
				count++;
			}
		}
		System.out.println("The probability is: "+(count/10000)*100);
	}
	
	public void brickCalculator()
	{ 
		/*
		 * brickCalculator calculates the mulligan of a rare candy deck. It determines the probability of not having
		 * a rare candy in your deck after drawing your prize pile.
		 */
		double prob = 0;
		for (int i = 1; i < 10000; i++)
		{
			double count = 0;
			ArrayList<Card> brickDeck = new ArrayList<Card>();
			Player test = new Player(brickDeck, 3);
			
			test.drawHand();
			//check if hand has rare candy too
			while (test.evaluateOpeningHand() == false)
			{
				test.reshuffleHand();
			}
			test.drawPrizePile();
			
			for (int j = 0; j< test.getDeckSize();j++)
			{
				if(test.getDeck().get(j).getName().equals("Rare Candy"))
				{
					count=1;
				}
			}
			
			for (int j = 0; j< test.getHandSize();j++)
			{
				if(test.getHand().get(j).getName().equals("Rare Candy"))
				{
					count=1;
				}
			}
			
			prob += count;
		}
		prob = (prob/10000)*100;
		prob = 100 - prob;
		System.out.println("The probability is: "+prob);
	}
}
