import java.util.ArrayList;
import java.util.Random;

/*
 * Nest Ball is a trainer card that searches the deck for a basic pokemon and adds it to the players bench.
 * It then shuffles the player's deck.
 * The method creates ArrayList of tempPokemon to find all the basic pokemon throughout the deck.
 * Then, using the Random import, picks a random pokemon from tempPokemon to add to bench.
 * Then, the deck is shuffled.
 * Included is a getName() method and getInfo() method.
 */
public class NestBall extends Trainer 
{
		public String name = "Nest Ball";
		@Override
		public void playable(Player player, Player p2)
		{
			ArrayList<Card> deck = player.getDeck();
			ArrayList<Pokemon> bench = player.getBenchPile();
			
			ArrayList<Pokemon> tempPokemon = new ArrayList<Pokemon>();
			
			int i = 0;
			while( i<deck.size())
			{
				if (deck.get(i) instanceof Pokemon)
				{
					tempPokemon.add((Pokemon) deck.get(i));
					deck.remove(i);
				}
				else
				{
					i++;
				}
			}
			
			Random rng = new Random();
			int saveRandomNumber = rng.nextInt(tempPokemon.size());
			bench.add(tempPokemon.get(saveRandomNumber));
			tempPokemon.remove(saveRandomNumber);
			
			for (int j = 0; j<tempPokemon.size();j++)
			{
				deck.add(tempPokemon.get(j));
			}
			System.out.println("Bench: "+player.printBench());
		}
		
		public String getName()
		{
			return name;
		}
		
		public void getInfo()
		{
			System.out.println("\nNest Ball - Trainer Card\nSearch your deck for a Basic Pokemon and put it onto your Bench. Then, shuffle your deck.\n");
		}
}
