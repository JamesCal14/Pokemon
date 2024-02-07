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
		for(int i = 0; i <(deckSize/3);i++)
		{
			//creating a deck filled with 20 fire energy, 20 charmanders, and 20 PR cards
			deck.add(new Energy("Fire"));
			deck.add(new Charmander());
			deck.add(new Trainer());
		}
	}
	
	public int getDeckSize()
	{
		return deck.size();
	}

	public void playerTurn()
	{
		hand.add(drawCard());
		//play pokemon
		playPokemon();
		//play energy
		playEnergy();
		//play trainer
		//attack
		//end
	}
	
	//Plays all pokemon in hand. Can be tweaked to add userinput
	public void playPokemon()
	{
		for(int i = hand.size()-1; i>=0;i--)
		{
			Card currentCard = hand.get(i);
			if(currentCard instanceof Pokemon && activePile.size()<1)
			{
				addToActive(currentCard);
			}
			else if(currentCard instanceof Pokemon && benchPile.size()<5)
			{
				addToBench(currentCard);
			}
		}
	}
	
	//Plays all energy in hand. Instead of all energy 1 at a time would be better. Add userinput
	public void playEnergy()
	{
		for(int i = hand.size()-1; i>=0;i--)
		{
			Card currentCard = hand.get(i);
			if(currentCard instanceof Energy && currentCard.getStorageSize()<1)
			{
				activePile.get(0).receiveEnergy((Energy) currentCard);
				hand.remove(currentCard);
			}
		}	
	}
	
	public Card drawCard()
	{
		//Draws a random card and removes it from the deck
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
	
	//Reshuffles hand and draws a new hand
	public void reshuffleHand()
	{
		for(int i = hand.size()-1;i>=0;i--)
		{
			deck.add(hand.get(i));
			hand.remove(i);
		}
		drawHand();
	}
	
	//Empty hand and add to discard pile
	public void discardHand()
	{
		for(int i = hand.size()-1;i>=0;i--)
		{
			discardPile.add(hand.get(i));
			hand.remove(i);
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
	
	public int prizePileSize()
	{
		return prizePile.size();
	}
	
	public void addToDeck(Card e)
	{
		deck.add(e);
	}
	
	public void discard(Card e)
	{
		discardPile.add(e);
	}
	
	public void addToBench(Card e)
	{
			benchPile.add(e);
			hand.remove(e);
	}
	
	public void addToActive(Card e)
	{
			activePile.add(e);
			hand.remove(e);
	}
	
	//Print methods
	public ArrayList<String> printDeck()
	{
		ArrayList<String> print = new ArrayList<String>();
		for (int i = 0; i<deck.size();i++)
		{
			print.add(deck.get(i).getName());
		}
		return print;
	}
	
	public ArrayList<String> printHand()
	{
		ArrayList<String> print = new ArrayList<String>();
		for (int i = 0; i<hand.size();i++)
		{
			print.add(hand.get(i).getName());
		}
		return print;
	}
	
	public ArrayList<String> printPrizePile()
	{
		ArrayList<String> print = new ArrayList<String>();
		for (int i = 0; i<prizePile.size();i++)
		{
			print.add(prizePile.get(i).getName());
		}
		return print;
	}
	
	public ArrayList<String> printActive()
	{
		ArrayList<String> print = new ArrayList<String>();
		for (int i = 0; i<activePile.size();i++)
		{
			print.add(activePile.get(i).getName());
		}
		return print;
	}
	
	public ArrayList<String> printBench()
	{
		ArrayList<String> print = new ArrayList<String>();
		for (int i = 0; i<benchPile.size();i++)
		{
			print.add(benchPile.get(i).getName());
		}
		return print;
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
