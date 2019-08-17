package org.target.cardgame.model;

public class Player implements Comparable<Player> {

	private final String name;
	private Card currentCard;
	private Integer victoryCount = 0;

	public Player(String name) {
		this.name = name;
	}

	public void setCurrentCard(Card currentCard) {
		this.currentCard = currentCard;
	}
	
	public void incrementVictoryCount() {
		victoryCount++;
	}

	public String getName() {
		return name;
	}
	
	public Integer getVictoryCount() {
		return victoryCount;
	}
	
	public Card getCurrentCard() {
		return currentCard;
	}

	@Override
	public int compareTo(Player anotherPlayer) {
		return anotherPlayer.getVictoryCount().compareTo(victoryCount);
	}

	@Override
	public String toString() {
		return String.format("Player:%s is issued with %s", name, currentCard != null ? currentCard.toString() : null);
	}

}