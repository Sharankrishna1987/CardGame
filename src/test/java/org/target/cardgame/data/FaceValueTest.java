package org.target.cardgame.data;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FaceValueTest extends TestCase {
	
	public FaceValueTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(FaceValueTest.class);
	}
	
	public void testFaceValueOrder() {
		assertEquals(FaceValue.ACE.getOrder(), new Integer(1));
		assertEquals(FaceValue.TWO.getOrder(), new Integer(2));
		assertEquals(FaceValue.THREE.getOrder(), new Integer(3));
		assertEquals(FaceValue.FOUR.getOrder(), new Integer(4));
		assertEquals(FaceValue.FIVE.getOrder(), new Integer(5));
		assertEquals(FaceValue.SIX.getOrder(), new Integer(6));
		assertEquals(FaceValue.SEVEN.getOrder(), new Integer(7));
		assertEquals(FaceValue.EIGHT.getOrder(), new Integer(8));
		assertEquals(FaceValue.NINE.getOrder(), new Integer(9));
		assertEquals(FaceValue.TEN.getOrder(), new Integer(10));
		assertEquals(FaceValue.JACK.getOrder(), new Integer(11));
		assertEquals(FaceValue.QUEEN.getOrder(), new Integer(12));
		assertEquals(FaceValue.KING.getOrder(), new Integer(13));
	}

}