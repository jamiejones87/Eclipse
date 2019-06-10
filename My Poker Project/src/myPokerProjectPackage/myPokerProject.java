package myPokerProjectPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class myPokerProject {

	public static void main(String[] args) {
		// Create a deck of 52 cards and shuffle
		List<Integer> myDeck = new ArrayList<Integer>();
		for(int i=0; i<52; i++) myDeck.add(i);
		Collections.shuffle(myDeck);
		
		// Deal 5 cards from deck into hand
		List<Integer> myHand = new ArrayList<Integer>();
		for(int i=0; i<5; i++) {
			myHand.add(myDeck.get(0));
			myDeck.remove(0);
		}
		
		printHand(myHand);

	}
	
	public static void printHand(List<Integer> myHand) {
		String[] myValueArray = { "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		String[] mySuitArray = { "Diamonds", "Hearts", "Clubs", "Spades" };
		int myValue, mySuit;
		for(int i=0; i<5; i++) {
			myValue = myHand.get(i) % 13;
			mySuit = (int) Math.floor(myHand.get(i)/13);
			System.out.println(myValueArray[myValue] + " of " + mySuitArray[mySuit]);
		}
	}

}
