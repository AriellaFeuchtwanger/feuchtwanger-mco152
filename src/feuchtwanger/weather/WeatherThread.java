package feuchtwanger.weather;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class WeatherThread extends Thread {
	private JLabel location;
	private JLabel temperature;
	private JLabel weatherDetail;
	private JLabel weatherDescription;
	private String zip;
	private JLabel image;
	private WeatherJSONFile weather;

	public WeatherThread(JLabel location, JLabel temperature, JLabel weatherDetail, JLabel weatherDescription,
			String zip, JLabel image) {
		this.location = location;
		this.temperature = temperature;
		this.weatherDetail = weatherDetail;
		this.weatherDescription = weatherDescription;
		this.image = image;
		this.zip = zip;
	}

	public void run() {
		WeatherURL url = new WeatherURL(zip);
		try {
			this.weather = new WeatherJSONFile(url.getURL());
		} catch (IOException e) {
			e.printStackTrace();
		}
		location.setText(weather.getPlace() + ", " + weather.getCountry());
		temperature.setText(String.valueOf(weather.getTemp()));
			weatherDetail.setText("Hi " + weather.getTempMax() + "/Lo " + weather.getTempMin());
		
		weatherDescription.setText(weather.getMain() + " - " + weather.getDescription());
		try {
			image.setIcon(getImage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private ImageIcon getImage() throws IOException {
		String icon = weather.getIcon();

		URL url = new URL("http://openweathermap.org/img/w/" + icon + ".png");
		BufferedImage image = ImageIO.read(url);
		ImageIcon weatherImage = new ImageIcon(image);
		return weatherImage;
	}
}
