package org.target.cardgame.data;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SuitTest extends TestCase {
	
	public SuitTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(SuitTest.class);
	}
	
	public void testFaceValueOrder() {
		assertEquals(Suit.SPADES.getOrder(), new Integer(1));
		assertEquals(Suit.CLUBS.getOrder(), new Integer(2));
		assertEquals(Suit.HEARTS.getOrder(), new Integer(3));
		assertEquals(Suit.DIAMONDS.getOrder(), new Integer(4));
	}

}