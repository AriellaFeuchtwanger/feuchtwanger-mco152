package feuchtwanger.weather;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

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
		setSize(1300, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
		getContentPane().setBackground(new Color(100, 149, 237));

		JLabel location = new JLabel("TBD");
		location.setFont(new Font("Times New Roman", Font.BOLD, 35));
		location.setAlignmentX(CENTER_ALIGNMENT);
		location.setHorizontalTextPosition(SwingConstants.CENTER);
		location.setBackground(background);

		JLabel[] dates = new JLabel[16];
		JLabel[] weatherDetail = new JLabel[16];
		JLabel[] weatherDescription = new JLabel[16];
		JLabel[] images = new JLabel[16];

		add(location);
		JPanel panel = new JPanel(new GridLayout(0, 8));
		panel.setBackground(background);
		

		for (int i = 0; i < 16; i++) {
			dates[i] = setDate(i);
			weatherDetail[i] = setWeatherDescription();
			weatherDescription[i] = setWeatherDescription();
			images[i] = new JLabel();

			panel.add(dates[i]);
			panel.add(weatherDetail[i]);
			panel.add(weatherDescription[i]);
			panel.add(images[i]);
		}

		JTextField cityField = new JTextField();
		cityField.setMaximumSize(new Dimension(100, 100));
		JButton reset = new JButton("Reset City (no spaces, please!)");
		reset.setAlignmentX(CENTER_ALIGNMENT);

		add(panel);
		add(cityField);
		add(reset);

		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				WeatherThread thread = new WeatherThread(location,
						weatherDetail, weatherDescription, cityField.getText(),
						images);
				thread.start();
				panel.repaint();
			}
		});
	}

	public JLabel setWeatherDetail() {
		JLabel weatherDetail = new JLabel("TBD");
		weatherDetail.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		weatherDetail.setBackground(background);

		return weatherDetail;
	}

	public JLabel setWeatherDescription() {
		JLabel weatherDescription = new JLabel("TBD");
		weatherDescription.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		weatherDescription.setBackground(background);

		return weatherDescription;
	}
	
	public JLabel setDate(int day){
		LocalDate today = LocalDate.now();
		JLabel date = new JLabel(today.getMonth() + " "
				+ (today.getDayOfMonth() + day) + ", " + today.getYear());
		date.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		return date;
	}
}
