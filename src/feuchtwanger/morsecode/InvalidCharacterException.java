package feuchtwanger.morsecode;

public class InvalidCharacterException extends RuntimeException {
	public InvalidCharacterException() {
		super("Invalid character");
	}
}
