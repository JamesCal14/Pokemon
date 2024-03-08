import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player
{	
	/*
	 * The Player Class is the main class of the PokemonCardGame. It manages the creation of the deck, hand,
	 * prizePile, etc. The player constructor fills the deck with the specificed cards of whichever Pokemon 
	 * and Trainer card are chosen. The main methods of this class are play and attack which do exactly what
	 * the name suggests. attack() takes object of type Player and makes the two players' active pokemon
	 * battle one another and also uses the activePokemonStatus() method. 
	 * play() takes object of type Player and gives the user options and allows them to play their cards in hand.
	 * Throughout the class are various helper methods such as drawCard(), drawHand(), reshuffleHand(), etc.
	 * These all help certain trainer cards and methods do their specificed action.
	 * At the end are print methods which help give a visual of all the variables like deck and hand as well as
	 * multiple getter and setter methods.
	 * There is also a constructor of Player which takes parameters however this is only used with the brickCalculator()
	 * method found in the PokemonCardGame Class.
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
		/*
		 * Constructor creates a deck of specified cards. Does not use userInput.
		 */
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
			deck.add(new AceTrainer());
		}
	}
	
	public void attack(Player p)
	{
		/*
		 * Attack gets the Pokemon in activePile of both players. 
		 * Then calls the corresponding attack method depending on userInput.
		 * At the end calls activePokemonStatus() for both players.
		 */
		Pokemon player = activePile.get(0);
		Pokemon enemy = p.activePile.get(0);
		
		System.out.println("Attack? (1 for Attack 1, 2 for Attack 2, 3 for No Attack)");
		String userInput = in.next();
		if(userInput.equals("1"))
		{
			System.out.println(player.getName()+" USE "+player.getAttackOneName()+"!!");
			player.attackOne(enemy);
			System.out.println("Enemy HP: "+enemy.getHp() + "\nCharmander HP: "+player.getHp());
		}
		else if(userInput.equals("2"))
		{
			System.out.println(player.getName()+" USE "+player.getAttackTwoName()+"!!");
			player.attackTwo(enemy);
			System.out.println("Enemy HP: "+enemy.getHp() + "\nCharmander HP: "+player.getHp());
		}
		else
		{
			System.out.println("No attack");
		}
		
		activePokemonStatus();
		p.activePokemonStatus();
	}
	
	public void activePokemonStatus()
	{
		/*
		 * Checks status of active Pokemon and prints out current HP and energy.
		 * If pokemon is dead, removes from activePile and sends to discardPile.
		 * Prize pile will decrease.
		 * Then requires player to play a pokemon from hand.
		 * If bench is filled will automatically take bench Pokemon and put in Active.
		 * If no pokemon in hand, hand will be discarded and redrawn.
		 */
		Pokemon poke = activePile.get(0);
		System.out.println("Active Pokemon: "+poke.getName()+" HP:"+poke.getHp()+" Energy Stored:"+poke.getStorageSize());
		if(poke.getHp()<=0)
		{
			activePile.remove(poke);
			discard(poke);
			prizePile.remove(prizePile.size()-1);
			System.out.println("Prize Pile Size: "+this.getPrizePileSize());
			if(benchPile.size()>0)
			{
				activePile.add(benchPile.get(0));
				benchPile.remove(0);
				System.out.println("\nActive Pokemon Defeated, Bench Pokemon moved\n");
			}
			else
			{
			System.out.println("\nActive Pokemon Defeated, Play another pokemon\n"+printHand()+"\n(If no pokemon, press 0 to discard your hand and draw a new hand)");
			int i = in.nextInt() - 1;
			while (i==-1)
			{
				discardHand();
				drawHand();
				System.out.println(printHand());
				i = in.nextInt() - 1;
			}
			Card currentCard = hand.get(i);
			addToActive((Pokemon) currentCard);
			hand.remove(i);
			}
		}
	}
	
	public void play(Player p2)
	{
		/*
		 * Play method takes userInput 1-7 to play a card from your hand. It checks the type of card
		 * and plays the respective action. Additionally it has an info function to print card info.
		 * It loops until the user inputs 0 to end the turn or there are no cards in the hand. There is a while
		 * loop at the end of the method to try and catch outOfBounds errors when userInput is higher
		 * than hand.size(). tCount is a instance variable which makes it to where you can only play
		 * one trainer card per turn.
		 */
		double tCount = 0;
		String userInput;
		System.out.println("Choose a card to play (1-"+hand.size()+") OR Type 0 to END TURN");
		int j = in.nextInt() - 1;
		
		while (j != -1 && j<hand.size())
		{
		Card currentCard = hand.get(j);
		System.out.println("Card found: "+getCard(j));
		System.out.println("Play card? (Type info for card information)");
		if(currentCard instanceof Pokemon)
		{
			System.out.println("(1 for Active, 2 for Bench, 3 for No play)");
			userInput = in.next();
			if(userInput.equals("1") && activePile.size()<1)
			{
				Pokemon tempPoke = (Pokemon) currentCard;
				addToActive(tempPoke);
			}
			else if(userInput.equals("2") && getBenchPile().size()<5)
			{
				Pokemon tempPoke = (Pokemon) currentCard;
				addToBench(tempPoke);
			}
			else
			{
				System.out.println("Not played");
			}
			
			if(userInput.equals("info"))
			{
				currentCard.getInfo();
			}
		}
		
		else if(currentCard instanceof Energy)
		{
			userInput = in.next();
			if (userInput.equals("1") && activePile.size()>0)
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
			
			if(userInput.equals("info"))
			{
				currentCard.getInfo();
			}
		}
		
		else if(currentCard instanceof Trainer && tCount<1)
		{
			userInput = in.next();
			if (userInput.equals("1"))
			{
				Trainer tempTrain = (Trainer) currentCard;
				tempTrain.playable(this, p2);
				hand.remove(currentCard);
				tCount=1;
			}
			else
			{
				System.out.println("Not played");
			}
			
			if(userInput.equals("info"))
			{
				currentCard.getInfo();
			}
		}
		System.out.println(printHand());
		System.out.println("Choose a card to play (1-7) OR Type 0 to END TURN");
		j = in.nextInt() - 1;
		
		while (j>=hand.size())
		{
			System.out.println("Choose another card");
			j = in.nextInt() - 1;
		}
		}
	}
	
	//Returns card name
	public String getCard(int i)
	{
			Card currentCard = hand.get(i);
			return currentCard.getName();
	}
	
	//Draws a random card and removes it from the deck
	public Card drawCard()
	{
		Random rng = new Random();
		int cardIndex = rng.nextInt(deck.size());
		Card drawnCard = deck.get(cardIndex);
		deck.remove(cardIndex);
		return drawnCard;
	}
	
	//Draw card and add to hand
	public void draw()
	{
		hand.add(drawCard());
	}
	
	//Draw 7 cards and add to hand
	public void drawHand()
	{
		for(int i = 0;i<7;i++)
		{
			hand.add(drawCard());
		}
	}
	
	//Reshuffles hand back into deck and draws a new hand
	public void reshuffleHand()
	{
		for(int i = hand.size()-1;i>=0;i--)
		{
			deck.add(hand.get(i));
			hand.remove(i);
		}
		drawHand();
	}
	
	//Empty hand into discard pile
	public void discardHand()
	{
		for(int i = hand.size()-1;i>=0;i--)
		{
			discardPile.add(hand.get(i));
			hand.remove(i);
		}
	}
	
	//Return hand back into deck
	public void returnHand()
	{
		for(int i = hand.size()-1;i>=0;i--)
		{
			deck.add(hand.get(i));
			hand.remove(i);
		}
	}

	//Checks if Pokemon is in opening hand
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
	
	//Draws prize pile
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
			hand.remove(e);
	}
	
	public void addToActive(Pokemon e)
	{
			activePile.add(e);
			hand.remove(e);
	}
	
	// Various Print methods
	
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
		for (int i = 0; i<getBenchPile().size();i++)
		{
			print.add(getBenchPile().get(i).getName());
		}
		return print;
	}
	
	// Constructor method specifically for the brickCalculator method
	
	public Player(ArrayList<Card> deck, int candy)
	{
		this.deck = deck;
		hand = new ArrayList<Card>();
		prizePile = new ArrayList<Card>();
		discardPile = new ArrayList<Card>();
		benchPile = new ArrayList<Pokemon>();
		activePile = new ArrayList<Pokemon>();
	
		for(int k = 0; k <10;k++)
		{
			deck.add(new Energy("Fire"));
		}
		for(int k = 0; k <15;k++)
		{
			deck.add(new Charmander());
		}
		for(int k = 0; k < (35 - candy);k++)
		{
			deck.add(new ProfResearch());
		}
		for(int k = 0; k < candy;k++)
		{
			deck.add(new Trainer("Rare Candy"));
		}
	}

	// Getter and setter methods for certain variables
	
	public int getDeckSize()
	{
		return deck.size();
	}
		
	public int getHandSize()
	{
		return hand.size();
	}
		
	public int getPrizePileSize()
	{
		return prizePile.size();
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


	public ArrayList<Pokemon> getBenchPile() {
		return benchPile;
	}


	public void setBenchPile(ArrayList<Pokemon> benchPile) {
		this.benchPile = benchPile;
	}
}
