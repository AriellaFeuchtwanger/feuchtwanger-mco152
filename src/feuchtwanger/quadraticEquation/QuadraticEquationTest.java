package feuchtwanger.quadraticEquation;

import org.junit.Test;
import org.junit.Assert;

public class QuadraticEquationTest {

	@Test
	public void testGetPositiveX() {
		QuadraticEquation q = new QuadraticEquation(2, 6, 4);
		double x = q.getPositiveX();

		Assert.assertEquals(-1.0, x, 0.01);
	}

	@Test
	public void testGetNegativeX() {
		QuadraticEquation q = new QuadraticEquation(2, 6, 4);
		double x = q.getNegativeX();

		Assert.assertEquals(-2.0, x, 0.01);
	}
	
}
