package feuchtwanger.physics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

public class ProjectileComponent extends JComponent {

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Projectile p = new Projectile(31, 20, 0.0);
		Graphics2D g2 = (Graphics2D) g;
		double x1, x2, y1, y2;
		for (int i = 0; i < 120; i++) {
			x1 = p.getX();
			y1 = p.getY() + 540;
			p.setTime();
			x2 = p.getX();
			y2 = p.getY() + 540;

			g2.draw(new Line2D.Double(x1, y1, x2, y2));
		}
	}

}
