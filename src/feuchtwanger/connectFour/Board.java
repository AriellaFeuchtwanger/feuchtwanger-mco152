package feuchtwanger.connectFour;

import java.awt.Color;

public class Board {
	private Color[][] board;

	public Board() {
		board = new Color[6][7];
	}

	public void move(int row, int column, Color color) {
		if (board[row][column] != Color.RED
				&& board[row][column] != Color.YELLOW) {
			board[row][column] = color;
		}
	}

	public boolean win(int row, int column, Color color) {
		boolean win = false;

		if (column > board[row].length) {
			throw new MoveOutOfBoundsException();
		}
		win = checkRow(row, color);

		if (!win) {
			win = checkColumn(column, color);

			if (!win) {
				win = checkDiagonal(color);
			}
		}
		return win;
	}

	private boolean checkRow(int row, Color color) {
		int count = 0;

		for (int i = 0; i < board[row].length; i++) {
			if (board[row][i] == color) {
				count++;
				if (count == 4) {
					return true;
				}
			} else {
				count = 0;
			}
		}

		return false;
	}

	private boolean checkColumn(int column, Color color) {
		int count = 0;

		for (int i = 0; i < board.length; i++) {
			if (board[i][column] == color) {
				count++;
				if (count == 4) {
					return true;
				}
			} else {
				count = 0;
			}
		}

		return false;
	}

	private boolean checkDiagonal(Color c) {
		for (int i = 0; i < board.length - 3; i++) {
			for (int j = 0; j < board[i].length - 3; j++) {
				if ((board[i][j] == c) && (board[i + 1][j + 1] == c)
						&& (board[i + 2][j + 2] == c)
						&& (board[i + 3][j + 3] == c)) {
					return true;
				}
			}
		}
		for (int i = (board.length - 1); i >= 3; i--) {
			for (int j = 0; j < (board[i].length - 3); j++) {
				if ((board[i][j] == c) && (board[i - 1][j + 1] == c)
						&& (board[i - 2][j + 2] == c)
						&& (board[i - 3][j + 3] == c)) {
					return true;
				}
			}
		}
		return false;
	}
}
