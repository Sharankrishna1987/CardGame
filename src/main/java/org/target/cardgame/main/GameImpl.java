package org.target.cardgame.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.target.cardgame.model.Card;
import org.target.cardgame.model.Player;

public class GameImpl implements Game {
	
	private static Logger LOGGER = LoggerFactory.getLogger(GameImpl.class);

	private final Deck deck;
	private final List<Player> players;
	private final Queue<Card> cards;
	private int roundCount = 1;
	private final TreeMap<Integer, Player> currentRoundResult;

	public GameImpl(Deck deck, List<Player> players) {
		this.deck = deck;
		this.players = players;
		this.currentRoundResult = new TreeMap<>();
		this.cards = deck.shuffle();
	}

	@Override
	public void start() {
		LOGGER.info(String.format("Round:%d Started \n", roundCount));

		for (Player player : players) {
			player.setCurrentCard(cards.poll());
			currentRoundResult.put(deck.getRank(player.getCurrentCard()), player);
			LOGGER.info(player.toString() + "\n");
		}

		computeResult();

		roundCount++;
	}

	@Override
	public List<Player> end() {
		List<Player> winnerList = new ArrayList<Player>();

		Collections.sort(players);

		int tempWinnerCount = 0;

		for (Player player : players) {
			LOGGER.info(String.format("Player %s victory count is %d \n", player.getName(), player.getVictoryCount()));

			if (tempWinnerCount == 0 || tempWinnerCount == player.getVictoryCount()) {
				winnerList.add(player);
			} else {
				continue;
			}

			tempWinnerCount = player.getVictoryCount();
		}

		LOGGER.info("------------------------------------");

		if (winnerList.size() == 1) {
			LOGGER.info(String.format("The winner is %s", winnerList.get(0).getName()));
		} else {
			winnerList.forEach((winner) -> LOGGER.info(String.format("Joint Winners: %s", winner.getName())));
		}
		
		return winnerList;

	}

	private void computeResult() {
		Player currentRoundWinner = currentRoundResult.firstEntry().getValue();
		currentRoundWinner.incrementVictoryCount();
		LOGGER.info(
				String.format("Player %s is the winner of Round:%d \n", currentRoundWinner.getName(), roundCount));
		LOGGER.info(String.format("Round:%d Completed \n", roundCount));
		currentRoundResult.clear();
	}

}