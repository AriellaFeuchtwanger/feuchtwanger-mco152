package feuchtwanger.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JFrameDemo extends JFrame {

	private JLabel label;
	private JLabel labelA;
	private JButton buttonA;
	private JButton buttonB;
	private JTextField textField;

	public JFrameDemo() {
		// Must set title, size, shutdown
		setTitle("JFrameDemo");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		label = new JLabel("All this text gets shown all the time.");
		add(label);
		buttonB = new JButton("A button. Yay.");
		add(buttonB);

		buttonB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Holy shnikeys it works!");

			}

		});
		textField = new JTextField();
		add(textField);
		labelA = new JLabel("Check it out!");
		add(labelA);
		buttonA = new JButton("Button 1");
		add(buttonA);
	}
}
