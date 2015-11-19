package feuchtwanger.connectFour;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class BoardComponent extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color c;

	public BoardComponent(Color c) {
		this.c = c;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(c);
		g.fillOval(0, 0, 70, 70);

		super.repaint();
	}

	public void setColor(Color color) {
		c = color;
	}
}
