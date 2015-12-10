package feuchtwanger.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class WeatherJSONFile {

	private URL url;
	private CurrentWeather weather;

	WeatherJSONFile(URL url) throws IOException {
		this.url = url;
		getJSONFile();

	}

	public void getJSONFile() throws IOException {
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		Gson gson = new Gson();
		CurrentWeather weather = gson.fromJson(reader, CurrentWeather.class);
		this.weather = weather;
	}

	public double getTemp() {
		return weather.getTemp();
	}

	public double getTempMin() {
		return weather.getTempMin();
	}

	public double getTempMax() {
		return weather.getTempMax();
	}
	
	public String getIcon(){
		return weather.getIcon();
	}
	
	public String getDescription(){
		return weather.getDescription();
	}
	
	public String getMain(){
		return weather.getMain();
	}
	
	public String getCountry(){
		return weather.getCountry();
	}
	
	public String getPlace(){
		return weather.getName();
	}
}
