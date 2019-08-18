package org.target.cardgame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.target.cardgame.data.FaceValue;
import org.target.cardgame.data.Suit;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CardTest extends TestCase {
	
	public CardTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(CardTest.class);
	}
	
	public void testCardRank() {
		List<Card> actualList = new ArrayList<>();
		actualList.add(new Card(Suit.CLUBS, FaceValue.QUEEN));
		actualList.add(new Card(Suit.HEARTS, FaceValue.JACK));
		actualList.add(new Card(Suit.SPADES, FaceValue.NINE));
		actualList.add(new Card(Suit.DIAMONDS, FaceValue.JACK));
		actualList.add(new Card(Suit.CLUBS, FaceValue.TWO));
		actualList.add(new Card(Suit.DIAMONDS, FaceValue.FOUR));
		actualList.add(new Card(Suit.SPADES, FaceValue.JACK));
		actualList.add(new Card(Suit.HEARTS, FaceValue.SEVEN));
		Collections.sort(actualList);
		
		List<Card> expectedList = new ArrayList<>();
		expectedList.add(new Card(Suit.SPADES, FaceValue.NINE));
		expectedList.add(new Card(Suit.SPADES, FaceValue.JACK));
		expectedList.add(new Card(Suit.CLUBS, FaceValue.TWO));
		expectedList.add(new Card(Suit.CLUBS, FaceValue.QUEEN));
		expectedList.add(new Card(Suit.HEARTS, FaceValue.SEVEN));
		expectedList.add(new Card(Suit.HEARTS, FaceValue.JACK));
		expectedList.add(new Card(Suit.DIAMONDS, FaceValue.FOUR));
		expectedList.add(new Card(Suit.DIAMONDS, FaceValue.JACK));
		
		assertEquals(actualList, expectedList);
		
	}

}