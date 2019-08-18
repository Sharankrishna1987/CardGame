package org.target.cardgame.data;

public enum Suit {

	SPADES(1), CLUBS(2), HEARTS(3), DIAMONDS(4);

	private final Integer order;

	private Suit(Integer order) {
		this.order = order;
	}

	public Integer getOrder() {
		return order;
	}

}