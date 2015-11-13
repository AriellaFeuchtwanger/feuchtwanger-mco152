package feuchtwanger.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int y = 200;
	private int height = 75;
	private int pupilHeight = 45;
	private boolean closing = true;
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// g.drawLine(0, 300, 600, 50);
		g.setColor(Color.YELLOW);
		g.drawOval(230, 130, 300, 300); // can also do getWidth() or getHeight()
		g.fillOval(230, 130, 300, 300);

		g.setColor(Color.BLUE);
		g.drawOval(280, y, 75, height);
		g.fillOval(280, y, 75, height);

		g.setColor(Color.BLACK);
		g.fillOval(300, y, 45, pupilHeight);

		g.setColor(Color.BLUE);
		g.drawOval(400, y, 75, height);
		g.fillOval(400, y, 75, height);

		g.setColor(Color.BLACK);
		g.fillOval(420, y, 45, pupilHeight);

		g.drawArc(310, 300, 150, 100, 900, 180);

		
		if (closing) {
			if (pupilHeight != 0) {
				pupilHeight--;
			}

			if (pupilHeight == 0 && height == 0) {
				pupilHeight++;
			}
			if (y == 275) {
				y--;
				closing = false;
			} else {
				y++;
			}

			if (height == 0) {
				height++;
			} else {
				height--;
			}
		} else {
			if (pupilHeight != 45) {
				pupilHeight++;
			}

			if (pupilHeight == 45 && height == 75) {
				pupilHeight--;
			}
			if (y == 200) {
				y++;
				closing = true;
			} else{
				y--;
			}
			
			if(height == 75){
				height--;
			} else{
				height++;
			}
		}

		try {
			Thread.sleep(16);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		super.repaint(); // will refresh the screen without having to change the
							// size, but
		// then it just keeps going
	}

}
