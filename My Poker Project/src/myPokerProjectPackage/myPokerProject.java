package myPokerProjectPackage;

import java.util.ArrayList;
import java.util.Arrays;
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
		boolean[] myStraightFlushCheck = checkStraightFlush(myHand);
		System.out.println(Arrays.toString(myStraightFlushCheck));

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
	
	public static boolean[] checkStraightFlush(List<Integer> myHand) {
		int[] checkStraight = new int[5], checkFlush = new int[5];
		for(int i=0; i<5; i++) {
			checkStraight[i] = myHand.get(i) % 13;
			checkFlush[i] = (int) Math.floor(myHand.get(i)/13);
		}
		Arrays.sort(checkStraight);
		int countStraight = 0, countFlush = 0;
		for(int i=0; i<4; i++) {
			if(checkStraight[i]+1 == checkStraight[i+1]) countStraight++;
			if(checkFlush[i] == checkFlush[i+1]) countFlush++;
		}
		boolean[] myReturn = new boolean[2];
		if(countStraight == 4) myReturn[0] = true;
		if(countFlush == 4) myReturn[1] = true;
		return(myReturn);
	}

}
