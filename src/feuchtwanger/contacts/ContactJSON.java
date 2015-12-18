package feuchtwanger.contacts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;

import feuchtwanger.weather.CurrentWeather;

public class ContactJSON {
	private Contact[] contactList;
	
	public ContactJSON() throws IOException{
		createContacts();
	}
	
	public void createContacts() throws IOException{
		URL url = new URL("http://jsonplaceholder.typicode.com/users");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		Gson gson = new Gson();
		Contact[] contactList = gson.fromJson(reader, Contact[].class);
		this.contactList = contactList;
	}
	
	public Contact[] getContactList(){
		return contactList;
	}
}
