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
		
		// Print cards in hand and result
		printHand(myHand);
		checkHand(myHand);

	}
	
	// Prints value of myHand in text format
	public static void printHand(List<Integer> myHand) {
		String[] myValueArray = { "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
		String[] mySuitArray = { "Diamonds", "Hearts", "Clubs", "Spades" };
		int myValue, mySuit;
		for(int i=0; i<5; i++) {
			myValue = myHand.get(i) % 13;
			mySuit = (int) Math.floor(myHand.get(i)/13);
			System.out.println(myValueArray[myValue] + " of " + mySuitArray[mySuit]);
		}
	}
	
	
	public static void checkHand(List<Integer> myHand) {
		// 0=Pair, 1=Two Pair, 2=Three of a Kind, 3=Straight, 4=Flush, 5=Full House, 6=Four of a Kind, 7=Straight Flush
		boolean[] myCheck = new boolean[8];
		
		
		// Split cards into Values and Suits
		int[] myValues = new int[5], mySuits = new int[5];
		for(int i=0; i<5; i++) {
			myValues[i] = myHand.get(i) % 13;
			mySuits[i] = (int) Math.floor(myHand.get(i)/13);
		}
		Arrays.sort(myValues);
		
		// Check for Pair, Two Pair, Three of a Kind, Full House, Four of a Kind
		int pairValue1 = 13, pairValue2 = 13;
		for(int i=0; i<4; i++) {
			if(myValues[i] == myValues[i+1]) {
				if(!myCheck[0]) {
					myCheck[0] = true;
					pairValue1 = myValues[i];
				} else {
					if(myValues[i]!=pairValue1) {
						myCheck[1] = true;
						pairValue2 = myValues[i];
					}
					else if((myValues[i]==pairValue1)||(myValues[i]==pairValue2)) {
						if(!myCheck[2]) myCheck[2] = true;
						else if(!myCheck[6]) myCheck[6] = true;
					}
				}
			}
		}
		if((pairValue1 != 13)&&(pairValue2 != 13)&&(myCheck[2])) myCheck[5] = true;
		
		
		// Check for Straight, Flush, Straight Flush
		int countStraight = 0, countFlush = 0;
		for(int i=0; i<4; i++) {
			if(myValues[i]+1 == myValues[i+1]) countStraight++;
			if(mySuits[i] == mySuits[i+1]) countFlush++;
		}
		if(countStraight == 4) myCheck[3] = true;
		if(countFlush == 4) myCheck[4] = true;
		if((myCheck[3])&&(myCheck[4])) myCheck[7] = true;
		
		
		// Checks boolean for highest value
		int myBestHand = 8;
		for(int i=0; i<7; i++) {
			if(myCheck[i]) myBestHand = i;
		}
		String myAnswer;
		if(myBestHand!=8) {
			String[] pokerHands = {"A Pair", "Two Pairs", "Three of a Kind", "A Straight", "A Flush", "A Full House", "Four of a Kind", "A Straight Flush"};
			myAnswer = "You Have " + pokerHands[myBestHand] + "!";
		} else myAnswer = "You Have Nothing! Good Day Sir!";
				
		System.out.println(myAnswer);
	}
}
