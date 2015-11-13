package feuchtwanger.connectFour;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoardJFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BoardComponent[][] board;

	public BoardJFrame() {
		Game g = new Game();

		setTitle("Connect Four");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void playGame(Container pane) {
		JPanel gameBoard = new JPanel();

		gameBoard.setLayout(new GridLayout(0, 6));

		JButton dummy = new JButton("Dummy");
		Dimension buttonSize = dummy.getPreferredSize();
		gameBoard.setPreferredSize(new Dimension(
				(int) (buttonSize.getWidth() * 2.5), (int) (buttonSize
						.getHeight() * 3.5)));
		
		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j <= 6; j++) {
				gameBoard.add(new BoardComponent());
			}
		}
		
		pane.add(gameBoard);
	}
}
