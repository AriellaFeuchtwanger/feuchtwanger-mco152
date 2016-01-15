package feuchtwanger.nypl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class NYPLImagesJSON {
	private String url;
	private NYPLImages images;
	
	public NYPLImagesJSON(String url) throws IOException{
		this.url = url;
		setImages();
	}
	
	public void setImages() throws IOException{
		URL urlLink = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) urlLink.openConnection();
		connection.setRequestProperty("Authorization",
				"Token token=\"v4z5bk2xixde59zk\"");
		
		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		Gson gson = new Gson();
		images = gson.fromJson(reader, NYPLImages.class);
	}
	
	public Capture[] getCaptures(){
		return images.getCaptures();
	}
}
