package feuchtwanger.quadraticEquation;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class QuadraticEquationGUI extends JFrame {

	private JLabel a;
	private JLabel b;
	private JLabel c;
	private JLabel x;
	private JLabel answerPos;
	private JLabel answerNeg;
	private JTextField answerA;
	private JTextField answerB;
	private JTextField answerC;
	private JButton calculate;

	public QuadraticEquationGUI() {
		setTitle("Quadratic Equation");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		a = new JLabel("A");
		add(a);
		answerA = new JTextField();
		add(answerA);

		b = new JLabel("B");
		add(b);
		answerB = new JTextField();
		add(answerB);

		c = new JLabel("C");
		add(c);
		answerC = new JTextField();
		add(answerC);

		calculate = new JButton("Calculate");
		add(calculate);
		x = new JLabel("X");
		add(x);
		answerPos = new JLabel();
		add(answerPos);
		answerNeg = new JLabel();
		add(answerNeg);
		calculate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				double valueA = Double.parseDouble(answerA.getText());
				double valueB = Double.parseDouble(answerB.getText());
				double valueC = Double.parseDouble(answerC.getText());

				QuadraticEquation q = new QuadraticEquation(valueA, valueB, valueC);

				answerPos.setText(Double.toString(q.getPositiveX()));
				answerNeg.setText(Double.toString(q.getNegativeX()));
			}

		});

	}
}
