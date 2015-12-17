package feuchtwanger.weather;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class WeatherThread extends Thread {
	private JLabel location;
	private JLabel[] weatherDetail;
	private JLabel[] weatherDescription;
	private String city;
	private JLabel[] images;
	private WeatherJSONFile weather;

	public WeatherThread(JLabel location,
			JLabel[] weatherDetail, JLabel[] weatherDescription, String city,
			JLabel[] images) {
		this.location = location;
		this.weatherDetail = weatherDetail;
		this.weatherDescription = weatherDescription;
		this.images = images;
		this.city = city;
	}

	public void run() {
		WeatherURL url = new WeatherURL(city);
		try {
			this.weather = new WeatherJSONFile(url.getURL());
		} catch (IOException e) {
			e.printStackTrace();
		}
		location.setText(weather.getCity() + ", " + weather.getCountry());
		for (int i = 0; i < 16; i++) {
			weatherDetail[i].setText("Hi " + weather.getTempMax(i) + "/Lo "
					+ weather.getTempMin(i));

			weatherDescription[i].setText(weather.getMain(i) + " - "
					+ weather.getDescription(i));
			try {
				images[i].setIcon(getImage(i));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private ImageIcon getImage(int day) throws IOException {
		String icon = weather.getIcon(day);

		URL url = new URL("http://openweathermap.org/img/w/" + icon + ".png");
		BufferedImage image = ImageIO.read(url);
		ImageIcon weatherImage = new ImageIcon(image);
		return weatherImage;
	}
	
}
