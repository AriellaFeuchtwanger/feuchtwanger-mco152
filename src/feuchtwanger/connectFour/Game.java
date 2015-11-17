package feuchtwanger.connectFour;

import java.awt.Color;

public class Game {
	private Board board;
	private Player pinkPlayer;
	private Player purplePlayer;
	private Player lastPlayer;

	public Game() {
		board = new Board();
		Color pink = new Color(255, 62, 150);
		Color purple = new Color(178, 58, 238);
		pinkPlayer = new Player(pink);
		purplePlayer = new Player(purple);
		lastPlayer = purplePlayer;
	}

	public boolean move(int row, int column) {
		if (column > 6 || column < 0) {
			throw new MoveOutOfBoundsException();
		} else {
			boolean win = false;
			if (lastPlayer == purplePlayer) {
				lastPlayer = pinkPlayer;
			} else {
				lastPlayer = purplePlayer;
			}
			board.move(row, column, lastPlayer.getColor());
			win = win(row, column);
			if (win) {
				lastPlayer.addWin();
			}

			return win;
		}
	}

	public Board getBoard() {
		return board;
	}

	public Color getColor() {
		return lastPlayer.getColor();
	}

	public int getPinkWins() {
		return pinkPlayer.getWins();
	}

	public int getPurpleWins() {
		return purplePlayer.getWins();
	}

	public void reset() {
		board = new Board();
		lastPlayer = purplePlayer;
	}

	private boolean win(int row, int column) {
		boolean win = board.win(row, column, lastPlayer.getColor());
		return win;
	}
}
