import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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
	private ArrayList<Pokemon> benchPile;
	private ArrayList<Pokemon> activePile;
	Scanner in = new Scanner(System.in);
	
	public Player()
	{
		deck = new ArrayList<Card>();
		hand = new ArrayList<Card>();
		prizePile = new ArrayList<Card>();
		discardPile = new ArrayList<Card>();
		benchPile = new ArrayList<Pokemon>();
		activePile = new ArrayList<Pokemon>();
		
		int deckSize = 60;
		for(int i = 0; i <(deckSize/3);i++)
		{
			//creating a deck filled with 20 fire energy, 20 charmanders, and 20 PR cards
			deck.add(new Energy("Fire"));
			deck.add(new Charmander());
			deck.add(new ProfResearch());
		}
	}
	
	public int getDeckSize()
	{
		return deck.size();
	}
	
	
	public void attack(Player p)
	{
		Pokemon player = activePile.get(0);
		Pokemon enemy = p.activePile.get(0);
		
		System.out.println("Attack? (1 for Attack 1, 2 for Attack 2, 3 for No Attack)");
		String userInput = in.next();
		if(userInput.equals("1"))
		{
			System.out.println(player.getName()+" USE "+player.attackOneName+"!!");
			player.attackOne(enemy);
			System.out.println("Enemy HP: "+enemy.getHp() + "\nCharmander HP: "+player.getHp());
		}
		else if(userInput.equals("2"))
		{
			System.out.println(player.getName()+" USE "+player.attackTwoName+"!!");
			player.attackTwo(enemy);
			System.out.println("Enemy HP: "+enemy.getHp() + "\nCharmander HP: "+player.getHp());
		}
		else
		{
			System.out.println("No attack");
		}
		
		activePokemonStatus();
	}
	
	public void activePokemonStatus()
	{
		Pokemon poke = activePile.get(0);
		System.out.println("Active Pokemon: "+poke.getName()+" HP:"+poke.getHp()+" Energy Stored:"+poke.getStorageSize());
		if(poke.getHp()<=0)
		{
			discard(poke);
			activePile.remove(poke);
			prizePile.remove(prizePile.size()-1);
		}
	}
	
	public void play()
	{
		System.out.println("Choose a card to play");
		int i = in.nextInt();
		Card currentCard = hand.get(i);
		if(currentCard instanceof Pokemon)
		{
			System.out.println("Pokemon card found: "+getCard(i));
			System.out.println("Play pokemon card? (1 for Active, 2 for Bench, 3 for No play)");
			String userInput = in.next();
			if(userInput.equals("1") && activePile.size()<1)
			{
				Pokemon tempPoke = (Pokemon) currentCard;
				addToActive(tempPoke);
			}
			else if(userInput.equals("2") && benchPile.size()<5)
			{
				Pokemon tempPoke = (Pokemon) currentCard;
				addToBench(tempPoke);
			}
			else
			{
				System.out.println("Not played");
			}
		}
		
		else if(currentCard instanceof Energy)
		{
			System.out.println("Energy card found: "+getCard(i));
			System.out.println("Play energy card?");
			String userInput = in.next();
			if (userInput.equals("1"))
			{
				Energy tempCard = (Energy) currentCard;
				Pokemon tempPoke = (Pokemon) activePile.get(0);
				tempPoke.receiveEnergy(tempCard);
				hand.remove(currentCard);
			}
			else
			{
				System.out.println("Not played");
			}
		}
		
		if(currentCard instanceof Trainer)
		{
			System.out.println("Trainer card found: "+getCard(i));
			System.out.println("Play trainer card?");
			String userInput = in.next();
			if (userInput.equals("1"))
			{
				//playable goes through but does nothing to the deck as it doesnt realize its prof resaarch
				Trainer tempTrain = (Trainer) currentCard;
				tempTrain.playable(this);
			}
			else
			{
				System.out.println("Not played");
			}
		}
	}
	//Plays pokemon
	public void playPokemon()
	{
		for(int i = hand.size()-1; i>=0;i--)
		{
		}
	}
	
	//Plays one energy at a time and adds it to active pokemon
	//Assumes pokemon is in active pile, if active pile empty error occurs
	//Is the active pokemon receiving energy or just temppoke?
	public void playEnergy()
	{
		for(int i = hand.size()-1; i>=0;i--)
		{
		}	
	}
	
	public void playTrainer()
	{
		for (int i = hand.size()-1; i>=0;i--)
		{
			
		}
	}
	
	public String getCard(int i)
	{
			Card currentCard = hand.get(i);
			return currentCard.getName();
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
	
	public void draw()
	{
		hand.add(drawCard());
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
	
	public void addToBench(Pokemon e)
	{
			benchPile.add(e);
			hand.remove(e);
	}
	
	public void addToActive(Pokemon e)
	{
			activePile.add(e);
			hand.remove(e);
	}
	
	//Print methods
	public ArrayList<String> printDeck()
	{
		ArrayList<String> print = new ArrayList<String>();
		for (int i = 0; i<getDeck().size();i++)
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
		if(activePile.size()==0)
		{
			print.add("Empty");
		}
		for (int i = 0; i<activePile.size();i++)
		{
				print.add(activePile.get(i).getName());
		}
		return print;
	}
	
	public ArrayList<String> printBench()
	{
		ArrayList<String> print = new ArrayList<String>();
		if(activePile.size()==0)
		{
			print.add("Empty");
		}
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

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}
	
	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}
	public ArrayList<Card> getDiscardPile() {
		return discardPile;
	}

	public void setDiscardPile(ArrayList<Card> discardPile) {
		this.discardPile = discardPile;
	}
}
