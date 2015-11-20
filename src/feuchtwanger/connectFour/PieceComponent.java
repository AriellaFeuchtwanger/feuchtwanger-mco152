package feuchtwanger.connectFour;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class PieceComponent extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color c;

	public PieceComponent(Color c) {
		this.c = c;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(c);
		g.fillOval(22, 5, 70, 70);
		
	}

	public void setColor(Color color) {
		c = color;
		super.repaint();
	}
}
