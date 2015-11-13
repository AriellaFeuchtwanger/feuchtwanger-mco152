package feuchtwanger.connectFour;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class BoardComponent extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.GREEN);
		//g.fillRect(0, 0, 800, 600);

		//g.setColor(Color.WHITE);
		
		g.fillOval(400, 300, 100, 100);
	}
}
