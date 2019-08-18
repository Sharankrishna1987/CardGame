package org.target.cardgame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PlayerTest extends TestCase {

	public PlayerTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(PlayerTest.class);
	}

	public void testPlayerRanking() {
		Player player1 = new Player("player1");
		Player player2 = new Player("player2");
		Player player3 = new Player("player3");
		Player player4 = new Player("player4");

		player2.incrementVictoryCount();
		player1.incrementVictoryCount();
		player1.incrementVictoryCount();
		player4.incrementVictoryCount();
		player4.incrementVictoryCount();
		player2.incrementVictoryCount();
		player2.incrementVictoryCount();
		player4.incrementVictoryCount();
		player3.incrementVictoryCount();
		player2.incrementVictoryCount();

		assertEquals(new Integer(2), player1.getVictoryCount());
		assertEquals(new Integer(4), player2.getVictoryCount());
		assertEquals(new Integer(1), player3.getVictoryCount());
		assertEquals(new Integer(3), player4.getVictoryCount());

		List<Player> actualPlayers = new ArrayList<>();
		actualPlayers.add(player1);
		actualPlayers.add(player2);
		actualPlayers.add(player3);
		actualPlayers.add(player4);

		Collections.sort(actualPlayers);

		List<Player> expectedPlayers = new ArrayList<>();
		expectedPlayers.add(player2);
		expectedPlayers.add(player4);
		expectedPlayers.add(player1);
		expectedPlayers.add(player3);

		assertEquals(expectedPlayers, actualPlayers);
	}

}