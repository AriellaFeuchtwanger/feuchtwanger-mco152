package feuchtwanger.weather;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class WeatherJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WeatherJSONFile weather;
	private Color background;

	public WeatherJFrame() throws IOException {
		try {
			weather = new WeatherJSONFile(new WeatherURL(getZip()).getURL());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Sorry, something went wrong!");
		}

		background = new Color(100, 149, 237);
		setTitle("Weather");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new GridLayout(0, 1));
		getContentPane().setBackground(new Color(100, 149, 237));
		JLabel location = new JLabel(weather.getPlace() + ", "
				+ weather.getCountry());
		location.setFont(new Font("Times New Roman", Font.BOLD, 45));
		location.setAlignmentX(LEFT_ALIGNMENT);
		location.setHorizontalTextPosition(SwingConstants.LEFT);
		location.setBackground(background);
		add(location);
		JLabel temperature = new JLabel();
		temperature.setText("Current Temperature: "
				+ String.valueOf(weather.getTemp()));
		temperature.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		temperature.setBackground(background);
		add(temperature);
		add(getWeather());
		add(getWeatherDescription());
	}

	public String getZip() {
		return JOptionPane.showInputDialog("Enter your zipcode (5 digits): ");
	}

	private JPanel getWeather() throws IOException {
		JPanel panel = new JPanel();

		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setBackground(background);

		JLabel maxTemp = new JLabel("Hi " + weather.getTempMax());
		maxTemp.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		JLabel minTemp = new JLabel("/Lo " + weather.getTempMin());
		minTemp.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		JLabel image = new JLabel(getImage());
		image.setHorizontalAlignment(SwingConstants.RIGHT);
		
		panel.add(maxTemp);
		panel.add(minTemp);
		panel.add(image);

		return panel;
	}

	private JPanel getWeatherDescription() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setBackground(background);
		
		JLabel mainWeather = new JLabel(weather.getMain() + " - ");
		JLabel description = new JLabel(weather.getDescription());
		Font font = new Font("Times New Roman", Font.PLAIN, 25);
		mainWeather.setFont(font);
		description.setFont(font);
		
		panel.add(mainWeather);
		panel.add(description);
		
		return panel;
	}

	private ImageIcon getImage() throws IOException {
		String icon = weather.getIcon();

		URL url = new URL("http://openweathermap.org/img/w/" + icon + ".png");
		BufferedImage image = ImageIO.read(url);
		ImageIcon weatherImage = new ImageIcon(image);
		return weatherImage;
	}
}
