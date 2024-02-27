/**************************************************************************
 * @author <Ali Malik>
 * CS310 Spring 2018
 * Project 1
 * George Mason University
 * 
 * File Name: CardSwitch.java
 *
 * Description: <A class that extends the abstract Card class,
 * the point of this class is to create Card objects so that the game Switch 
 * can be played.>
 * 
 ***************************************************************************/

public class CardSwitch extends Card{

	// TO DO: fill the code below and add JavaDoc

	public CardSwitch(Rank r, Suit s){
		// constructor to create card for the game Switch
		super(r,s);
	}

	public boolean equals(Card anotherCard){
		// checks if two cards equals and returns a boolean
		if ((anotherCard.getRank().equals(super.getRank())) && (anotherCard.getSuit().equals(super.getSuit()))) { //compare the ranks and suit
			return true;
		}
		else {
			return false;
		}

	}

	public int getPoints(){
		// return points of the card
		int points;
		if (super.getRank() == Card.Rank.ACE){
			points = 1;
		}
		else if (super.getRank() == Card.Rank.TWO){
			points = 2;
		}
		else if (super.getRank() == Card.Rank.THREE){
			points = 3;
		}
		else if (super.getRank() == Card.Rank.FOUR){
			points = 4;
		}
		else if (super.getRank() == Card.Rank.FIVE){
			points = 5;
		}
		else if (super.getRank() == Card.Rank.SIX){
			points = 6;
		}
		else if (super.getRank() == Card.Rank.SEVEN){
			points = 7;
		}
		else if (super.getRank() == Card.Rank.EIGHT){
			points = 8;
		}
		else if (super.getRank() == Card.Rank.NINE){
			points = 9;
		}
		else {
			points = 10;
		}
		return points;

	}

	@Override
	public String toString(){
		// convert card to string consisting of as "(rank,suit)"
		// see examples below for format
		String s = "(";
		if (super.getRank() == Card.Rank.ACE){
			s += "ACE,";
		}
		else if (super.getRank() == Card.Rank.TWO){
			s += "TWO,";
		}
		else if (super.getRank() == Card.Rank.THREE){
			s += "THREE,";
		}
		else if (super.getRank() == Card.Rank.FOUR){
			s += "FOUR,";
		}
		else if (super.getRank() == Card.Rank.FIVE){
			s += "FIVE,";
		}
		else if (super.getRank() == Card.Rank.SIX){
			s += "SIX,";
		}
		else if (super.getRank() == Card.Rank.SEVEN){
			s += "SEVEN,";
		}
		else if (super.getRank() == Card.Rank.EIGHT){
			s += "EIGHT,";
		}
		else if (super.getRank() == Card.Rank.NINE){
			s += "NINE,";
		}
		else if (super.getRank() ==  Card.Rank.TEN){
			s += "TEN,";
		}
		else if (super.getRank() == Card.Rank.JACK) {
			s += "JACK,";
		}
		else if (super.getRank() == Card.Rank.QUEEN) {
			s += "QUEEN,";
		}
		else if (super.getRank() == Card.Rank.KING) {
			s += "KING,";
		}
		else{
			System.out.println("Sorry that Rank doesn't exist.");
		}

		if (super.getSuit() == Card.Suit.SPADES) {
			s += "SPADES)";
		}
		else if (super.getSuit() == Card.Suit.HEARTS) {
			s += "HEARTS)";
		}
		else if (super.getSuit() == Card.Suit.DIAMONDS) {
			s += "DIAMONDS)";
		}
		else if (super.getSuit() == Card.Suit.CLUBS) {
			s += "CLUBS)";
		}
		else {
			System.out.println("Sorry that Suit doesn't exist");
		}
		return s;
	}

	//----------------------------------------------------
	//example test code... edit this as much as you want!
	public static void main(String[] args) {
		CardSwitch card = new CardSwitch(Card.Rank.ACE, Card.Suit.SPADES);
		CardSwitch card1 = new CardSwitch(Card.Rank.TWO, Card.Suit.CLUBS);
		if (card.getRank().equals(Card.Rank.ACE)){
			System.out.println("Yay 1");
		}

		if ("(ACE,SPADES)".equals(card.toString())){
			System.out.println("Yay 2");
		}

		if (card.getPoints()==1){
			System.out.println("Yay 3");
		}

		if (!(card.equals(card1))){
			System.out.println("Yay 4");
		}
	}

}
