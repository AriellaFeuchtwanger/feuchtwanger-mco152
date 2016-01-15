package feuchtwanger.nypl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;

public class NYPLSearchJSON {
	private SearchResult[] results;
	private String keyword;

	public NYPLSearchJSON(String keyword) throws IOException {
		this.keyword = keyword;
		setResults();
	}

	public void setResults() throws IOException {
		URL url = new URL("http://api.repo.nypl.org/api/v1/items/search?q="
				+ keyword + "&publicDomainOnly=true");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("Authorization",
				"Token token=\"v4z5bk2xixde59zk\"");

		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		Gson gson = new Gson();
		NYPLSearch file = gson.fromJson(reader, NYPLSearch.class);
		results = file.getResults();
	}
	
	public SearchResult[] getResults(){
		return results;
	}
}
