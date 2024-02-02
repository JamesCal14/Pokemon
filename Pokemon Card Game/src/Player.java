import java.util.ArrayList;
import java.util.Random;

public class Player
{	
	/*
	 * deck  60
	 * hand  7
	 * prizePile 6
	 * discardPile no limit
	 * PokemonBench pile - no more than 5 pokemon
	 * Active Pokemon pile - only 1 pokemon
	 */
	private ArrayList<Card> deck;
	private ArrayList<Card> hand;
	private ArrayList<Card> prizePile;
	private ArrayList<Card> discardPile;
	private ArrayList<Card> benchPile;
	private ArrayList<Card> activePile;
	
	public Player()
	{
		deck = new ArrayList<Card>();
		hand = new ArrayList<Card>();
		prizePile = new ArrayList<Card>();
		discardPile = new ArrayList<Card>();
		benchPile = new ArrayList<Card>();
		activePile = new ArrayList<Card>();
		
		int deckSize = 60;
		for(int i = 1; i <deckSize;i++)
		{
			deck.add(new Energy());
			//deck.add(new Pokemon());
			deck.add(new Trainer());
		}
	}
	
	public Card drawCard()
	{
		//Draws a card and removes it from the deck
		Random rng = new Random();
		int cardIndex = rng.nextInt(deck.size());
		Card drawnCard = deck.get(cardIndex);
		deck.remove(cardIndex);
		return drawnCard;
	}
	
	public void drawHand()
	{
		for(int i = 0;i<7;i++)
		{
			hand.add(drawCard());
		}
	}

	public boolean evaluateOpeningHand()
	{
		for(int i = 0; i<hand.size();i++)
		{
			Card currentCard = hand.get(i);
			if(currentCard instanceof Pokemon)
			{
				return true;
			}
		}
		return false;
	}
	
	public void drawPrizePile()
	{
		for(int i = 0;i<6;i++)
		{
			prizePile.add(drawCard());
		}
	}
	
	public void addToDeck(Card e)
	{
		deck.add(e);
	}
	
	public void discard(Card e)
	{
		discardPile.add(e);
	}
	
	public void addToBench(Pokemon e)
	{
		benchPile.add(e);
	}
	
	public void addToActive(Pokemon e)
	{
		activePile.add(e);
	}
	
	public void runNumber()
	{
		/* runNumber is a void method which counts the times a pokemon is drawn in the
		 * first hand looped a large number of times to calculate the probability of
		 * having a pokemon in your hand.
		 * The deck used to call this method and the deck looping is different
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
}
