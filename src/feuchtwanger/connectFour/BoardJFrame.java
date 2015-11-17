package feuchtwanger.connectFour;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BoardJFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Game g;
	private BoardComponent[][] board;
	private int[] lastRows;
	private JLabel winner;
	private JPanel score;
	private JLabel pinkScore;
	private JLabel purpleScore;
	private JButton[] buttons;

	public BoardJFrame(Game game) {
		g = game;
		lastRows = new int[7];
		buttons = new JButton[7];

		setTitle("Connect Four");
		setSize(800, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Color backgroundFrame = new Color(255, 110, 180);
		Color backgroundBoard = new Color(67, 205, 128);
		getContentPane().setBackground(backgroundFrame);

		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		winner = new JLabel("Connect Four", SwingConstants.CENTER);
		winner.setFont(new Font("Serif", Font.PLAIN, 25));
		winner.setBackground(Color.BLUE);

		JPanel boardPane = new JPanel();
		GridLayout gridLayout = new GridLayout(0, 7);
		boardPane.setLayout(gridLayout);
		boardPane.setBackground(backgroundBoard);

		board = new BoardComponent[6][7];
		// Image image = new ImageIO.read(getClass().getResource("arrow.png"));
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			buttons[i].setIcon(new ImageIcon("arrow.jpg"));
			lastRows[i] = 5;
			boardPane.add(buttons[i]);
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = new BoardComponent(Color.WHITE);
				boardPane.add(board[i][j]);
			}
		}

		score = new JPanel();
		score.setLayout(new BoxLayout(score, BoxLayout.X_AXIS));
		pinkScore = new JLabel("Pink Score: " + g.getPinkWins(),
				SwingConstants.LEFT);
		pinkScore.setFont(new Font("Serif", Font.PLAIN, 25));
		purpleScore = new JLabel("Yellow Score: " + g.getPurpleWins(),
				SwingConstants.LEFT);
		purpleScore.setFont(new Font("Serif", Font.PLAIN, 25));

		score.add(pinkScore);
		score.add(purpleScore);

		add(winner);
		add(boardPane);
		add(score);

		for (int i = 0; i < buttons.length; i++) {
			final int column = i;

			buttons[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					boolean win = g.move(lastRows[column], column);
					Color c = g.getColor();
					board[lastRows[column]][column].setColor(c);
					int lastRow = lastRows[column];
					lastRow--;
					lastRows[column] = lastRow;

					if (win) {
						winner.setText("Winner!!!!");
						newGame();
					}
				}
			});
		}
	}

	public void newGame() {
		g.reset();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j].setColor(Color.WHITE);
			}
		}

		for (int i = 0; i < lastRows.length; i++) {
			lastRows[i] = 5;
		}

		winner.setText("Connect Four");
		pinkScore.setText("Pink Score: " + g.getPinkWins());
		purpleScore.setText("     Purple Score: " + g.getPurpleWins());
	}
}
