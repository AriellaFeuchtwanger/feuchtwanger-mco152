package feuchtwanger.pythagoreanTheorem;

import org.junit.Assert;
import org.junit.Test;

public class PythagoreanTheoremTest {

	@Test
	public void testSetAB() {
		PythagoreanTheorem p = new PythagoreanTheorem();
		p.setAB(4.0, 3.0);
		double c = p.getC();

		Assert.assertEquals(5.0, c, 0.01);
	}

	public void testSetBC() {
		PythagoreanTheorem p = new PythagoreanTheorem();
		p.setBC(4.0, 5.0);
		double a = p.getA();

		Assert.assertEquals(3.0, a, 0.01);
	}

	public void testSetCA() {
		PythagoreanTheorem p = new PythagoreanTheorem();
		p.setCA(5.0, 3.0);
		double b = p.getB();

		Assert.assertEquals(4.0, b, 0.01);

	}
}
