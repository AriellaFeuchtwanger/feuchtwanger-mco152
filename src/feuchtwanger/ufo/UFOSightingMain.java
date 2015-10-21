package feuchtwanger.ufo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class UFOSightingMain {

	public static void main(String[] args) throws IOException {
		final BufferedReader in = new BufferedReader(new FileReader("./ufo_awesome.json"));
		final Gson gson = new Gson();

		final UFOSightingList list = gson.fromJson(in, UFOSightingList.class);
		// Will return a list of UFO sightings

		TopTenLocations t = new TopTenLocations(list);

		HashMap<String, Integer> map = t.getTopTen();

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(" Location: " + entry.getKey());
			System.out.println(" Number of Sightings: " + entry.getValue());
		}

		in.close();
	}
}
