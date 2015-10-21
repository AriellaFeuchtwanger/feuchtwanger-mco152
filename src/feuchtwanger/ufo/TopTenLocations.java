package feuchtwanger.ufo;

import java.util.HashMap;
import java.util.Map;

public class TopTenLocations {

	private UFOSightingList list;
	private HashMap<String, Integer> map;
	private HashMap<String, Integer> topTen;

	public TopTenLocations(UFOSightingList list) {
		this.list = list;
		map = new HashMap<String, Integer>();

		createMap();
	}

	// Creates a map with all the locations and the number of sightings in each
	private void createMap() {
		for (UFOSighting u : list) {
			if (!map.containsKey(u.getLocation().trim().toUpperCase())) {
				map.put(u.getLocation().trim().toUpperCase(), 1);
			} else {
				Integer views = map.get(u.getLocation().trim().toUpperCase());
				map.put(u.getLocation().trim().toUpperCase(), (views + 1));
			}
		}
	}

	public HashMap<String, Integer> getMap() {
		return map;
	}

	public HashMap<String, Integer> getTopTen() {
		topTen = new HashMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {

		}
		return topTen;
	}
}
