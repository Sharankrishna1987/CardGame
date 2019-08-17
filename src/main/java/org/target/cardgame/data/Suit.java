package org.target.cardgame.data;

public enum Suit {

	SPADES("S", 1), CLUBS("C", 2), HEARTS("H", 3), DIAMONDS("D", 4);

	private final String shortName;
	private final Integer order;

	private Suit(String shortName, Integer order) {
		this.shortName = shortName;
		this.order = order;
	}

	public String getShortName() {
		return shortName;
	}

	public Integer getOrder() {
		return order;
	}

}