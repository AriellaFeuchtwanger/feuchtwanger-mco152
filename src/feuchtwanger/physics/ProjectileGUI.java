package feuchtwanger.physics;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ProjectileGUI extends JFrame {

	private JLabel time;
	private JLabel velocity;
	private JLabel angle;
	private JTextField timeInfo;
	private JTextField velocityInfo;
	private JTextField angleInfo;
	private JButton calculate;
	private JLabel x;
	private JLabel y;

	public ProjectileGUI() {
		setTitle("Projectile");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		time = new JLabel("Time");
		add(time);
		timeInfo = new JTextField();
		add(timeInfo);

		velocity = new JLabel("Velocity");
		add(velocity);
		velocityInfo = new JTextField();
		add(velocityInfo);

		angle = new JLabel("Angle");
		add(angle);
		angleInfo = new JTextField();
		add(angleInfo);

		calculate = new JButton("Calculate");
		add(calculate);

		x = new JLabel();
		add(x);
		y = new JLabel();
		add(y);

		calculate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				double angleValue = Double.parseDouble(angleInfo.getText());
				double timeValue = Double.parseDouble(timeInfo.getText());
				double velocityValue = Double.parseDouble(velocityInfo.getText());

				Projectile p = new Projectile(angleValue, velocityValue, timeValue);

				x.setText(Double.toString(p.getX()));
				y.setText(Double.toString(p.getY()));

			}

		});

	}
}
