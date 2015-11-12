package feuchtwanger.connectFour;

public class MoveOutOfBoundsException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public MoveOutOfBoundsException(){
		super("Move out of bounds.");
	}
}
