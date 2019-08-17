package org.target.cardgame.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.target.cardgame.data.FaceValue;
import org.target.cardgame.data.Suit;
import org.target.cardgame.model.Card;

public abstract class Deck {

	private final List<Card> cards;
	private final Map<Card, Integer> rankMap = new HashMap<>();

	public Deck(List<Card> cards) {
		this.cards = cards;
		initialize();
		populateRank();
	}

	private void initialize() {
		for (Suit suit : Suit.values()) {
			for (FaceValue faceValue : FaceValue.values()) {
				Card card = new Card(suit, faceValue);
				cards.add(card);
			}
		}
	}

	private void populateRank() {
		// Assuming the Suit and FaceValue enums are always not in sorted order
		Collections.sort(cards);
		int rank = 52;
		for (Card card : cards) {
			rankMap.put(card, rank--);
		}
	}

	public int getRank(Card card) {
		return rankMap.get(card);
	}

	public List<Card> getDeck() {
		// Returning a deck copy to make sure that the original deck is not
		// modified
		return new ArrayList<Card>(cards);
	}

	// Allowing the subclass to decide the shuffling algorithm
	abstract Queue<Card> shuffle();

}