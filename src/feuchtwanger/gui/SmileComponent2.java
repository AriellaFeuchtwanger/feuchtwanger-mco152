package feuchtwanger.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

public class SmileComponent2 extends JComponent {
	private int x1 = 300;
	private int x2 = 420;
	private int y = 200;
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		addMouseMotionListener(new MouseAdapter() { 
	          public void mouseMoved(MouseEvent me) { 
	            if(me.getX() < 300){
	            	x1 = 280;
	            	x2 = 400;
	            }
	            else if(me.getX() > 420){
	            	x1 = 315;
	            	x2 = 435;
	            } else{
	            	x1 = 305;
	            	x2 = 425;
	            }
	            
	            if(me.getY() < 200){
	            	y = 200;
	            }
	            else if(me.getY() > 200){
	            	y = 225;
	            }
	            
	          } 
	        }); 

		// g.drawLine(0, 300, 600, 50);
		g.setColor(Color.YELLOW);
		g.drawOval(230, 130, 300, 300); // can also do getWidth() or getHeight()
		g.fillOval(230,130,300, 300);

		g.setColor(Color.BLUE);
		g.drawOval(280, 200, 75, 75);
		g.fillOval(280, 200, 75, 75);

		g.setColor(Color.BLACK);
		g.fillOval(x1, y, 45, 45);

		g.setColor(Color.BLUE);
		g.drawOval(400, 200, 75, 75);
		g.fillOval(400, 200, 75, 75);

		g.setColor(Color.BLACK);
		g.fillOval(x2, y, 45, 45);

		g.drawArc(310, 300, 150, 100, 900, 180);

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
