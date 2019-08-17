package org.target.cardgame.data;

public enum FaceValue {

	ACE(1, "Ace"), TWO(2, "2"), THREE(3, "3"), FOUR(4, "4"), FIVE(5, "5"), SIX(6, "6"), SEVEN(7, "7"), EIGHT(8,
			"8"), NINE(9, "9"), TEN(10, "10"), JACK(11, "Jack"), QUEEN(12, "Queen"), KING(13, "King");

	private final Integer order;
	private final String value;

	private FaceValue(Integer order, String value) {
		this.order = order;
		this.value = value;
	}

	public Integer getOrder() {
		return order;
	}

	public String getValue() {
		return value;
	}

}