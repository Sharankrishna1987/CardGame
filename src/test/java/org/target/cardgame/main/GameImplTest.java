package org.target.cardgame.main;

import java.util.ArrayList;
import java.util.Arrays;

import org.target.cardgame.model.Player;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class GameImplTest extends TestCase {

	public GameImplTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(GameImplTest.class);
	}

	public void testWinner() {
		Game game = new GameImpl(new DeckImpl(new ArrayList<>()),
				Arrays.asList(new Player("Player 1"), new Player("Player 2"), new Player("Player 3")));
		game.start();
		assertEquals(false, game.end().isEmpty());
	}

}