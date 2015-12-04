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
	
	WeatherJSONFile(URL url){
		this.url = url;
	}
	
	public void getJSONFile() throws IOException{
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		Gson gson = new Gson();
		
	}
}
