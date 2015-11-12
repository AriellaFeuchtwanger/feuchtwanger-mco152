package feuchtwanger.connectFour;

import java.awt.Color;

public class Board {
	private Color[][] board;

	public Board() {
		board = new Color[7][6];
	}

	public void move(int row, int column, Color color) {
		if (board[row][column] != Color.RED
				&& board[row][column] != Color.YELLOW) {
			board[row][column] = color;
		}
	}

	public boolean win(int row, int column, Color color) {
		boolean win = false;

		win = checkRow(row, color);

		if (!win) {
			win = checkColumn(column, color);

			if (!win) {
				win = checkDiagonal();
			}
		}
		return win;
	}

	private boolean checkRow(int row, Color color) {
		int count = 0;

		for (int i = 0; i < board[row].length; i++) {
			if (board[row][i] == color) {
				count++;
			} else {
				count = 0;
			}
		}

		if (count == 4) {
			return true;
		}

		return false;
	}

	private boolean checkColumn(int column, Color color) {
		int count = 0;

		for (int i = 0; i < board.length; i++) {
			if (board[i][column] == color) {
				count++;
			} else {
				count = 0;
			}
		}

		if (count == 4) {
			return true;
		} else {
			return false;
		}
	}

	private boolean checkDiagonal() {
		int count = 0;
		for (int row = 0; row < board.length; row++) {
			count = 0;
			for (int column = 1; column < board[0].length; column++) {
				if (column - row < 7) {
					break;
				}

				if (board[row][column - row] != null
						&& board[row - 1][column - row + 1] == board[row][column
								- row]) {
					++count;
				} else {
					count = 1;
				}
			}
		}

		if (count == 4) {
			return true;
		}

		for (int column = 0; column < 7; ++column) {
			count = 0;

			for (int row = 1; row < 7; ++row) {
				if (column + row >= 7) {
					break;
				}
				if (board[row][column + row] != null
						&& board[row - 1][column + row - 1] == board[row][column
								+ row]) {
					count++;
				} else {
					count = 1;
				}
			}
		}

		if (count == 4) {
			return true;
		}

		for (int row = 0; row < 7; ++row) {
			count = 0;

			for (int column = 1; column < 7; ++column) {

				if (column + row >= 7) {
					break;
				}
				if (board[row + column][column] != null
						&& board[row + column - 1][column - 1] == board[row
								+ column][column]) {
					count++;
				} else {
					count = 1;
				}
			}
		}

		if (count == 4) {
			return true;
		}

		for (int row = 0; row < 7; ++row) {
			count = 0;

			for (int column = 5; column >= 0; --column) {
				if (column - row < 0) {
					break;
				}
				if (board[column - row][column] != null
						&& board[column - row - 1][column + 1] == board[column
								- row][column]) {
					count++;
				} else {
					count = 1;
				}
			}
		}

		if (count == 4) {
			return true;
		}
		return false;
	}
}
