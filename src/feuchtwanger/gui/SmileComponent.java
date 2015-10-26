package feuchtwanger.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent{
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		//g.drawLine(0, 300, 600, 50);
		g.setColor(Color.YELLOW);
		g.drawOval(230, 130, 300, 300);
		g.fillOval(230, 130, 300, 300);
		g.setColor(Color.BLUE);
		g.drawOval(280, 200, 75, 75);
		g.fillOval(280, 200, 75, 75);
		g.setColor(Color.BLACK);
		g.fillOval(300, 200, 45, 45);
		g.setColor(Color.BLUE);
		g.drawOval(400, 200, 75, 75);
		g.fillOval(400, 200, 75, 75);
		g.setColor(Color.BLACK);
		g.fillOval(420, 200, 45, 45);
		
		g.drawArc(310, 300, 150, 100, 900, 180);
		
	}

}
