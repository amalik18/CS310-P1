/**************************************************************************
 * @author <INSERT YOUR NAME>
 * CS310 Spring 2018
 * Project 1
 * George Mason University
 * 
 * File Name: Hand.java
 *
 * Description: <A class that uses a type T which extends the abstract Card class. 
 * This class allows for the creation of a "hand", simply a generic array
 * used to store Card objects.>
 * 
 ***************************************************************************/

public class Hand<T extends Card>{

	// TO DO: add your implementation and JavaDoc
	private T [] cards;
	private int numCards;

	@SuppressWarnings("unchecked")
	public Hand(){
		// constructor
		// initial size of cards must be no greater than 5 s
		this.cards = (T[]) new Card[5];
		this.numCards = 0;
	}

	public int numCards(){
		// return the number of cards
		// O(1)
		return this.numCards;
	} 


	public T getCard(int index){
		// return card at index 
		// throw RuntimeException for invalid index
		// O(1)
		if (index < 0 || index > this.cards.length) { //throw exception for negative and too large indexes
			throw new RuntimeException("Invalid Index");
		}
		else {
			return this.cards[index];
		}
	}

	public void setCard(int index, T c){
		// change the card at index to be c 
		// throw RuntimeException for invalid index
		// O(1)
		if ((index < numCards) && (index > 0)){ //check if index is greater than 0 and less than the array size
			this.cards[index] = c;
		}
		else {
			throw new RuntimeException("Invalid Index");
		}
	}
	@SuppressWarnings("unchecked")
	public void addCard(T c){
		// add card c at the end 
		// O(N)
		if (this.cards.length == this.numCards) { //if the array needs to be resized, do it
			T [] temp = (T[]) new Card [(3*this.numCards/2)+1]; //this method was taken from Professor Krishnan's slides
			for (int i = 0; i < this.cards.length; i++){ //re-add the cards to the new array
				temp[i] = this.cards[i];
			}
			this.cards = temp;
		}
		this.cards[this.numCards] = c; // add the card to the array
		this.numCards++;
	}


	public int indexOf(T c){
		// find the index of a given card c, 
		// returns -1 if not found 
		// O(N) 
		int index = -1;
		for (int i = 0; i < this.cards.length; i++) { //iterate through the array, if i = number of cards, then break.
			if (i == numCards) {
				break;
			}
			if (this.cards[i].toString().equals(c.toString())) { //check if the card at index i matches c.
				index = i;
				break;
			}
		}
		return index;
	}

	public T removeCard(int index){
		// remove the card at index, 
		// throw RuntimeException for invalid index
		// O(N)
		if ((index >= 0) && (index < this.cards.length)) { //check if index is okay
			T card = this.cards[index]; //dummy card
			T temp = null; // will use to replace the card
			this.cards[index] = temp;
			this.numCards--; //decrease the count of cards
			for (int i = 0; i < this.cards.length; i++) { //fix the order such that null is last
				if(this.cards[i] == null && (i != this.cards.length-1)) {
					this.cards[i] = this.cards[i+1];
					this.cards[i+1] = null;
				}
			}
			return card;

		}
		else {
			throw new RuntimeException("Invalid Index");
		}

	}
	@SuppressWarnings("unchecked")
	public boolean removeCard(T c){
		// remove card c, 
		// returns false if no such card
		// O(N)
		int curSize = this.numCards;
		int index = 0;
		for (int i = 0; i < this.cards.length; i++) { //find the card, compare the values and assign it null.
			if (this.cards[i].toString().equals(c.toString())) {
				index = i;
				Card q = null;
				T temp = (T) q;
				this.cards[index] = temp;
				this.numCards--;
			}
		}
		for (int i = 0; i < this.cards.length; i++) { //fix the order such that null is last
			if (this.cards[i] == null && (i != this.cards.length - 1)) {
				this.cards[i] = this.cards[i+1];
				this.cards[i+1] = null;
			}
		}
		if (this.numCards == curSize) { //if the num of cards is the same then return false
			return false;
		}
		else {
			return true;
		}
	}



	// --------------------------------------------------------
	// example test code... edit this as much as you want!
	// you will need a working CardSwitch class to run the given code


	// Not required, update for your testing purpose
	@Override
	public String toString(){
		// return string representation of hand
		// update if you want to include information for all cards in hand
		return "Hand with "+numCards+" cards";


	}


	public static void main(String[] args) {

		CardSwitch card1 = new CardSwitch(Card.Rank.ACE, Card.Suit.SPADES);
		CardSwitch card2 = new CardSwitch(Card.Rank.JACK, Card.Suit.SPADES);
		CardSwitch card3 = new CardSwitch(Card.Rank.NINE, Card.Suit.HEARTS);
		CardSwitch card4 = new CardSwitch(Card.Rank.TWO, Card.Suit.CLUBS);
		CardSwitch card5 = new CardSwitch(Card.Rank.FOUR, Card.Suit.DIAMONDS);
		CardSwitch card6 = new CardSwitch(Card.Rank.TEN, Card.Suit.HEARTS);



		Hand<CardSwitch> myHand = new Hand<CardSwitch>();
		myHand.addCard(card1);
		myHand.addCard(card2);
		myHand.addCard(card4);
		myHand.addCard(card5);
		myHand.addCard(card6);


		if ((myHand.numCards() == 5) && (myHand.getCard(0).equals(card1))){
			System.out.println("Yay 1");
		}

		myHand.addCard(card3);

		if ( (card2.equals(myHand.removeCard(1))) && (myHand.getCard(1).equals(card4))){
			System.out.println("Yay 2");
		}

		if ((myHand.indexOf(card1)==0) && (myHand.indexOf(card2) == -1 )){
			System.out.println("Yay 3");
		}
	}
}