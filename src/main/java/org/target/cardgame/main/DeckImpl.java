package org.target.cardgame.main;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.target.cardgame.model.Card;

public class DeckImpl extends Deck {

	private static Logger LOGGER = LoggerFactory.getLogger(DeckImpl.class);

	public DeckImpl(List<Card> cards) {
		super(cards);
	}

	@Override
	public Queue<Card> shuffle() {

		LOGGER.info("Shuffing in progress...");

		List<Card> originalDeck = getDeck();
		Queue<Card> shuffledDeck = new LinkedList<>();
		Random random = new Random();
		int deckSize = originalDeck.size();
		int randomNumberLimit = deckSize;
		int suitRepeatingCounter = 0;
		boolean isFaceValueConsecutive;
		Card tempCard = null;

		// Not more than 3 consecutive cards of the same suit while shuffling.
		while (shuffledDeck.size() != deckSize) {

			int randomCardNumber = random.nextInt(randomNumberLimit);
			Card currentCard = originalDeck.get(randomCardNumber);

			if (tempCard == null || !currentCard.getSuit().equals(tempCard.getSuit())) {
				shuffledDeck.add(originalDeck.remove(randomCardNumber));
				tempCard = currentCard;
				suitRepeatingCounter = 0;
				isFaceValueConsecutive = false;
				randomNumberLimit--;
			} else {
				suitRepeatingCounter++;
				if ((randomNumberLimit != 1)
						&& (tempCard.getFaceValue().getOrder() + 1 == currentCard.getFaceValue().getOrder())) {
					isFaceValueConsecutive = true;
				} else {
					isFaceValueConsecutive = false;
				}
				if (suitRepeatingCounter == 3 && isFaceValueConsecutive) {
					suitRepeatingCounter--;
					continue;
				} else {
					shuffledDeck.add(originalDeck.remove(randomCardNumber));
					tempCard = currentCard;
					randomNumberLimit--;
				}
			}

		}

		LOGGER.info("Shuffing is complete. You are now ready to start the game.");

		return shuffledDeck;
	}

}