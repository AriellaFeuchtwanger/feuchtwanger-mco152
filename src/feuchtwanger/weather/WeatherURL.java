package feuchtwanger.weather;

import java.net.MalformedURLException;
import java.net.URL;

public class WeatherURL {
	private String zip;
	private final String originalURL1 = "http://api.openweathermap.org/data/2.5/weather?zip=";
	private final String originalURL2 = ",us&appid=2de143494c0b295cca9337e1e96b00e0&units=imperial";
	
	public WeatherURL(String zip){
		if(zip != null){
			if(zip.length() == 5){
				this.zip = zip;
			}
		}
	}
	
	public URL getURL() throws MalformedURLException{
		String theURL = originalURL1 + zip + originalURL2;
		
		URL url = new URL(theURL);
		return url;
	}
}
