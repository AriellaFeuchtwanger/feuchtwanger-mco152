package feuchtwanger.quadraticEquation;

public class QuadraticEquation {
	double a;
	double b;
	double c;

	public QuadraticEquation(double a, double b, double c) {
		//If a is 0, the equation will be undefined ---- can't divide by 0
		if (a == 0.0)
			throw new InvalidZeroException();
		else
			this.a = a;

		//If b is 0, the equation in the square root symbol could wind up 
		//being negative. You cannot square root a negative number, that
		//will give you an imaginary number
		if (b == 0.0)
			throw new InvalidZeroException();
		else
			this.b = b;
		
		this.c = c;
	}

	public double getPositiveX() {
		double answer = (((-b) + (Math.sqrt((b * b) - (4 * a * c)))) / (2 * a));
		return answer;
	}

	public double getNegativeX() {
		double answer = (((-b) - (Math.sqrt((b * b) - (4 * a * c)))) / (2 * a));
		return answer;
	}
}
