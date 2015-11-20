package feuchtwanger.connectFour;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ConnectFourJFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Game game;
	private PieceComponent[][] board;
	private int[] lastRows;
	private JLabel winner;
	private JPanel score;
	private JLabel pinkScore;
	private JLabel purpleScore;
	private JButton[] buttons;
	private JButton undo;
	private int lastRow;
	private int lastColumn;

	public ConnectFourJFrame(Game game) {
		this.game = game;
		lastRows = new int[7];
		buttons = new JButton[7];
		lastRow = 0;
		lastColumn = 0;

		setTitle("Connect Four");
		setSize(800, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Color backgroundFrame = new Color(255, 110, 180);
		Color backgroundBoard = new Color(67, 205, 128);
		getContentPane().setBackground(backgroundFrame);

		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		winner = new JLabel("Connect Four");
		winner.setAlignmentX(CENTER_ALIGNMENT);
		winner.setFont(new Font("Serif", Font.PLAIN, 25));
		winner.setBackground(Color.BLUE);

		JPanel boardPane = new JPanel();
		GridLayout gridLayout = new GridLayout(0, 7);
		boardPane.setLayout(gridLayout);
		boardPane.setBackground(backgroundBoard);

		board = new PieceComponent[6][7];

		boardPane = instantiateButtons(boardPane);

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = new PieceComponent(Color.WHITE);
				boardPane.add(board[i][j]);
			}
		}

		score = new JPanel();
		score.setLayout(new BoxLayout(score, BoxLayout.LINE_AXIS));
		score.setBackground(backgroundFrame);

		pinkScore = new JLabel(("Pink Score: " + game.getPinkWins()));
		pinkScore.setFont(new Font("Serif", Font.PLAIN, 25));
		score.add(pinkScore);
		score.add(Box.createHorizontalGlue());
		purpleScore = new JLabel(("Purple Score: " + game.getPurpleWins()));
		purpleScore.setFont(new Font("Serif", Font.PLAIN, 25));
		score.add(purpleScore);
		score.add(Box.createHorizontalGlue());

		undo = new JButton("Undo");
		undo.setAlignmentX(CENTER_ALIGNMENT);
		undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				undo();
			}
		});

		add(winner);
		add(boardPane);
		add(score);
		add(undo);
	}

	public void newGame() {
		game.reset();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j].setColor(Color.WHITE);
			}
		}

		for (int i = 0; i < lastRows.length; i++) {
			lastRows[i] = 5;
		}
		lastRow = 0;
		lastColumn = 0;
		winner.setText("Connect Four");
		pinkScore.setText("Pink Score: " + game.getPinkWins());
		purpleScore.setText("Purple Score: " + game.getPurpleWins());
	}

	public void undo() {
		game.undo(lastRow, lastColumn);
		board[lastRow][lastColumn].setColor(Color.WHITE);
		lastRows[lastColumn] = lastRow;
		lastRow = 0;
		lastColumn = 0;
	}

	private JPanel instantiateButtons(JPanel boardPane) {
		Color backgroundBoard = new Color(67, 205, 128);
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			buttons[i].setIcon(new ImageIcon("arrow.jpg"));
			buttons[i].setBackground(backgroundBoard);
			lastRows[i] = 5;
			boardPane.add(buttons[i]);
			final int column = i;

			buttons[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (game.isFull()) {
						newGame();
					}
					boolean win = false;
					try {
						win = game.move(lastRows[column], column);
						Color c = game.getColor();
						board[lastRows[column]][column].setColor(c);
						lastColumn = column;
						lastRow = lastRows[column];
						lastRows[column] = lastRow - 1;

						if (win) {
							winner.setText("Winner!!!!");
							newGame();
						}
					} catch (ArrayIndexOutOfBoundsException e1) {
						JOptionPane.showMessageDialog(null, "Move is out of bounds.");
					}

				}
			});
		}
		return boardPane;
	}
}
