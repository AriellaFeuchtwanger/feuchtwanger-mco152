package feuchtwanger.pythagoreanTheorem;

public class PythagoreanTheorem {
	double a;
	double b;
	double c;

	public PythagoreanTheorem() {

	}

	public void setAB(double a, double b) {
		//Check if it's 0 or negative ---- a triangle can't have a negative side 
		if (a > 0) {
			this.a = a;
		}
		else
			throw new InvalidDataException();
		if (b > 0)
			this.b = b;
		else
			throw new InvalidDataException();
		double answerOne = (this.a * this.a) + (this.b * this.b);
		c = Math.sqrt(answerOne);
	}

	public void setBC(double b, double c) {
		if(b > 0)
			this.b = b;
		else
		throw new InvalidDataException();
		if(c > 0)
			this.c = c;
		else
			throw new InvalidDataException();
		double answerOne = (this.c * this.c) - (this.b * this.b);
		a = Math.sqrt(answerOne);
	}

	public void setCA(double c, double a) {
		if(c > 0)
			this.c = c;
		else
			throw new InvalidDataException();
		if(a > 0)
			this.a = a;
		else
			throw new InvalidDataException();
		double answerOne = (this.c * this.c) - (this.a * this.a);
		b = Math.sqrt(answerOne);
	}

	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}

	public double getC() {
		return c;
	}
}
