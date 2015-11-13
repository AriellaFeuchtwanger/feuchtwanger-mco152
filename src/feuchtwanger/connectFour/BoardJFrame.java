package feuchtwanger.connectFour;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;

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

		GridLayout layout = new GridLayout();
		Container container = getContentPane();
		container.setLayout(layout);
		
	}
}
