package feuchtwanger.quadraticEquation;

import org.junit.Assert;
import org.junit.Test;

public class QuadraticEquationTest {

	@Test
	public void testGetNegativeX() {
		final QuadraticEquation q = new QuadraticEquation(2, 6, 4);
		final double x = q.getNegativeX();

		Assert.assertEquals(-2.0, x, 0.01);
	}

	@Test
	public void testGetPositiveX() {
		final QuadraticEquation q = new QuadraticEquation(2, 6, 4);
		final double x = q.getPositiveX();

		Assert.assertEquals(-1.0, x, 0.01);
	}

	@Test
	public void testThrowsInvalidException() {
		try {
			new QuadraticEquation(0, 0, 0);
			Assert.fail("didn't throw exception");
		} catch (final InvalidZeroException e) {
			// expected
		}
	}

}
