package org.target.cardgame.model;

import org.target.cardgame.data.FaceValue;
import org.target.cardgame.data.Suit;

public class Card implements Comparable<Card> {

	private final Suit suit;
	private final FaceValue faceValue;

	public Card(Suit suit, FaceValue faceValue) {
		this.suit = suit;
		this.faceValue = faceValue;
	}

	public Suit getSuit() {
		return suit;
	}

	public FaceValue getFaceValue() {
		return faceValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((faceValue == null) ? 0 : faceValue.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (faceValue != other.faceValue)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}

	@Override
	public int compareTo(Card anotherCard) {

		int suitOrder = suit.getOrder().compareTo(anotherCard.getSuit().getOrder());

		if (suitOrder == 0) {
			return faceValue.getOrder().compareTo(anotherCard.getFaceValue().getOrder());
		}

		return suitOrder;

	}

	@Override
	public String toString() {
		return "Card [suit=" + suit + ", faceValue=" + faceValue + "]";
	}

}