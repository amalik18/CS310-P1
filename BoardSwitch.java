/**************************************************************************
 * @author <INSERT YOUR NAME>
 * CS310 Spring 2018
 * Project 1
 * George Mason University
 * 
 * File Name: BoardSwitch.java
 *
 * Description: <A Class responsible for managing players, their positions, turns, and the winner.>
 * 
 ***************************************************************************/
public class BoardSwitch<T extends Card> extends Board<T>{

	// TO DO: add your implementation and JavaDoc

	public BoardSwitch(Deck<T> deck){
		//constructor
		//start with zero players
		super(deck); //call on the Board class to set initial conditions

	}
	@Override
	public Player<T> getCurrentPlayer() {
		// return the current player
		// O(1)
		return this.currentPlayer;
	}
	@Override
	public int getNumPlayers() {
		// return how many players 
		// O(1)
		return this.numPlayer;
	}
	@Override
	public Deck<T> getDeck(){
		//return the current deck
		// O(1)
		return this.deck;
	}
	@Override
	public boolean changeTurn() {
		// move the current player to the next one in the linked list
		// return false if cannot change
		// O(1)
		if (this.currentPlayer.getNext() != null) { //if the current player isn't null, set current player to current.next
			this.currentPlayer = this.currentPlayer.getNext();
			return true;
		}
		else {
			return false;
		}
	}
	public Player<T> findWinner(){
		// return the player with the highest point
		// O(N)
		int points = 0; //initialize to 0
		int iterations = 0; //to break out of loop
		Player <T> winner = null;
		Player <T> temp = this.currentPlayer; //temporary player object
		boolean option = true; //loop case
		while (option) {
			if (iterations == this.numPlayer) { //if this loop is run the same amount of times as there are players then brek
				option = false;
				break;
			}
			if (temp.getPoints() > points) { //compare points of temp to points variable, if greater change the winner player
				winner = temp;
				points = winner.getPoints();
			}
			if (temp.getPoints() == points) { //for ties, if the points are the same go in lexicographical order
				int check = winner.getName().compareTo(temp.getName());
				if (check > 0) {
					winner = temp;
					points = temp.getPoints();
				}
			}
			temp = temp.getNext(); //iterate through the players
			iterations++;			
		}
		return winner;
	}

	@Override
	public void addPlayer(Player<T> x) {
		// add another player in the linked list
		// should add to the right of currentPlayer
		// O(N)
		if (this.currentPlayer == null) { //if there is no player, add it
			this.currentPlayer = x;
			this.currentPlayer.setNext(x);
			this.numPlayer++;
		}
		else { 
			x.setNext(this.currentPlayer); //add x and point it to currentPlayer
			this.numPlayer++; //add 1 to total num of players
			Player <T> current = this.currentPlayer; //dummy player
			boolean option = true; //loop condition
			while (option) {
				if (current.getNext() == this.currentPlayer) { //trying to find the player who points to currentPlayer
					current.setNext(x); //once found point it to x
					option = false; //completed task end the loop
				}
				current = current.getNext(); //iterate through the players
			}
		}
	}

	//-----------------------------------------------------
	// example test code... edit this as much as you want!
	// you will need working CardSwitch, Hand, Player, Deck and PlaySwitch classes to run the given code

	public static void main(String[] args) {
		Deck<CardSwitch> deck = new Deck<CardSwitch>();
		PlaySwitch.init_deck(deck);

		BoardSwitch<CardSwitch> myBoard = new BoardSwitch<CardSwitch>(deck);
		Player<CardSwitch> player1 = new Player<CardSwitch>("Tom");
		Player<CardSwitch> player2 = new Player<CardSwitch>("Zerry");
		Player<CardSwitch> player3 = new Player<CardSwitch>("James");

		myBoard.addPlayer(player1);

		if (myBoard.getNumPlayers() ==1  && myBoard.getCurrentPlayer() == player1
				&& player1.getNext() == player1){
			System.out.println("Yay 1");
		}
		myBoard.addPlayer(player2);
		if (myBoard.getNumPlayers() ==2  && myBoard.getCurrentPlayer() == player1
				&& (myBoard.changeTurn()==true) && myBoard.getCurrentPlayer() == player2){
			System.out.println("Yay 2");
		}
		myBoard.addPlayer(player3);
		
		player1.receiveCard(new CardSwitch(Card.Rank.ACE, Card.Suit.SPADES));
		player1.receiveCard(new CardSwitch(Card.Rank.JACK, Card.Suit.CLUBS));
		player2.receiveCard(new CardSwitch(Card.Rank.NINE, Card.Suit.HEARTS));
		player2.receiveCard(new CardSwitch(Card.Rank.TWO, Card.Suit.SPADES));
		player3.receiveCard(new CardSwitch(Card.Rank.TEN, Card.Suit.SPADES));
		player3.receiveCard(new CardSwitch(Card.Rank.NINE, Card.Suit.SPADES));
		System.out.println(myBoard.findWinner());

		if (player1.getNext() == player2 && player2.getNext() == player1
				&& myBoard.findWinner() == player3){
			System.out.println("Yay 3");
		}


	}
}
