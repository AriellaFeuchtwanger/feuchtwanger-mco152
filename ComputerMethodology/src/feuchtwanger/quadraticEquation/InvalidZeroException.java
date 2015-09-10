package feuchtwanger.quadraticEquation;

public class InvalidZeroException extends RuntimeException {
	public InvalidZeroException() {
		super("The value you have entered cannot be 0.");
	}
}
