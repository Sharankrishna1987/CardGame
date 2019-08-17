package org.target.cardgame.main;

import java.util.ArrayList;

import org.target.cardgame.data.FaceValue;
import org.target.cardgame.data.Suit;
import org.target.cardgame.model.Card;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class DeckImplTest extends TestCase {

	public DeckImplTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(DeckImplTest.class);
	}

	public void testGetRank() {
		DeckImpl deckImpl = new DeckImpl(new ArrayList<>());

		assertEquals(13, deckImpl.getRank(new Card(Suit.DIAMONDS, FaceValue.ACE)));
		assertEquals(1, deckImpl.getRank(new Card(Suit.DIAMONDS, FaceValue.KING)));
		assertEquals(52, deckImpl.getRank(new Card(Suit.SPADES, FaceValue.ACE)));
		assertEquals(40, deckImpl.getRank(new Card(Suit.SPADES, FaceValue.KING)));
	}

	public void testShuffle() {
		DeckImpl deckImpl = new DeckImpl(new ArrayList<>());
		deckImpl.shuffle();

		assertEquals(13, deckImpl.getRank(new Card(Suit.DIAMONDS, FaceValue.ACE)));
		assertEquals(1, deckImpl.getRank(new Card(Suit.DIAMONDS, FaceValue.KING)));
		assertEquals(52, deckImpl.getRank(new Card(Suit.SPADES, FaceValue.ACE)));
		assertEquals(40, deckImpl.getRank(new Card(Suit.SPADES, FaceValue.KING)));
	}

	public void testGetDeck() {
		DeckImpl deckImpl = new DeckImpl(new ArrayList<>());
		assertEquals(52, deckImpl.getDeck().size());
	}

}