package org.target.cardgame.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.target.cardgame.model.Player;

public class CardGame {

	private static Logger LOGGER = LoggerFactory.getLogger(CardGame.class);
	private static Scanner SCANNER = new Scanner(System.in);

	public static void main(String[] args) {

		LOGGER.info("\n----------------NEW GAME STARTED----------------\n");

		try {

			List<Player> players = new ArrayList<>();

			initializePlayers(players);

			Game game = new GameImpl(new DeckImpl(new ArrayList<>()), players);

			startGame(game);

			LOGGER.info("------------------------------------");

			LOGGER.debug("GAME OVER: Hit enter to view the results");
			SCANNER.nextLine();

			game.end();

		} catch (Exception exception) {
			LOGGER.error("Application terminated due to error");
		} finally {
			SCANNER.close();
		}

	}

	private static void initializePlayers(List<Player> players) {
		int maxPlayerCount = 1;

		while (true) {
			if (maxPlayerCount == 5) {
				break;
			}

			LOGGER.debug(String.format("Input Player %d name:", maxPlayerCount));
			String playerName = SCANNER.nextLine();
			LOGGER.info(String.format("Player %d name entered :%s \n", maxPlayerCount, playerName));

			while (playerName == null || playerName.isEmpty()) {
				LOGGER.info(String.format("ERROR: Player %d name is mandatory", maxPlayerCount));
				LOGGER.info("Please enter the name again");
				playerName = SCANNER.nextLine();
			}

			players.add(new Player(playerName));
			maxPlayerCount++;
		}

	}

	private static void startGame(Game game) {
		int maxRoundsCount = 1;

		while (true) {
			if (maxRoundsCount == 6) {
				break;
			}
			LOGGER.info("------------------------------------");

			if (maxRoundsCount == 1) {
				LOGGER.debug("Hit enter to start playing:");
			} else {
				LOGGER.debug("Hit enter to resume playing:");
			}

			SCANNER.nextLine();
			game.start();
			maxRoundsCount++;
		}

	}

}