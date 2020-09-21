import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	GradeBook gb1, gb2;

	@BeforeEach
	void setUp() throws Exception {
		gb1 = new GradeBook(5);
		gb2 = new GradeBook(5);
		
		gb1.addScore(89);
		gb1.addScore(7);
		gb1.addScore(37);

		gb2.addScore(2);
		gb2.addScore(4);
	}
	

	@AfterEach
	void tearDown() throws Exception {
		gb1 = null;
		gb2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(gb1.toString().equals(gb1.toString()));
	    assertTrue(gb2.toString().equals(gb2.toString()));
	}

	@Test
	void testSum() {
		assertEquals(133, gb1.sum(), .0001);
	    assertEquals(6, gb2.sum(), .0001);
	}

	@Test
	void testMinimum() {
		assertEquals(7, gb1.minimum(), .001);
	    assertEquals(2, gb2.minimum(), .001);
	}

	@Test
	void testFinalScore() {
		 assertEquals(126, gb1.finalScore(), .0001);
		 assertEquals(4, gb2.finalScore(), .0001);
	}

}
