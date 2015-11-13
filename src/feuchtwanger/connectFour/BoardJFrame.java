package feuchtwanger.connectFour;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class BoardJFrame extends JFrame {
	public BoardJFrame() {
		Game g = new Game();
		
		setTitle("Connect Four");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BorderLayout layout = new BorderLayout();
		Container container = getContentPane();
		container.setLayout(layout);
		container.add(new BoardComponent(g.getBoard()), BorderLayout.CENTER);
	}
}
