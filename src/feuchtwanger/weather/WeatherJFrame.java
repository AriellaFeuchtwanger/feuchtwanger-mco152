package feuchtwanger.weather;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class WeatherJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color background;

	public WeatherJFrame() throws IOException {
		background = new Color(100, 149, 237);
		setTitle("Weather");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new GridLayout(0, 1));
		getContentPane().setBackground(new Color(100, 149, 237));

		JLabel location = new JLabel("TBD");
		location.setFont(new Font("Times New Roman", Font.BOLD, 45));
		location.setAlignmentX(LEFT_ALIGNMENT);
		location.setHorizontalTextPosition(SwingConstants.LEFT);
		location.setBackground(background);

		JLabel temperature = new JLabel("TBD");
		temperature.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		temperature.setBackground(background);

		JLabel weatherDetail = new JLabel("TBD");
		weatherDetail.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		weatherDetail.setBackground(background);
		
		JLabel weatherDescription = new JLabel("TBD");
		weatherDescription.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		weatherDescription.setBackground(background);
		JTextField zipField = new JTextField();
		JLabel image = new JLabel();

		JButton reset = new JButton("Reset Zip Code");
		
		add(location);
		add(temperature);
		add(weatherDetail);
		add(weatherDescription);
		add(image);
		add(zipField);
		add(reset);
		
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				WeatherThread thread = new WeatherThread(location, temperature, weatherDetail, weatherDescription,
						zipField.getText(), image);
				thread.start();
			}
		});
	}
}
