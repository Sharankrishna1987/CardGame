package org.target.cardgame.data;

public enum FaceValue {

	ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);

	private final Integer order;

	private FaceValue(Integer order) {
		this.order = order;
	}

	public Integer getOrder() {
		return order;
	}

}