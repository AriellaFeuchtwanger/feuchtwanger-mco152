package feuchtwanger.ufo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
		topTen = new HashMap<String, Integer>(10);
		ArrayList<Integer> views = new ArrayList<Integer>(map.values());

		Collections.sort(views);
		Collections.reverse(views);

		ArrayList<Integer> topTenViews = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			topTenViews.add(views.get(i));
		}
		
		for (Integer i : topTenViews) {
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				if (entry.getValue().equals(i)) {
					topTen.put(entry.getKey(), entry.getValue());
					break;
				}
			}
		}
		
		return topTen;
	}
}
