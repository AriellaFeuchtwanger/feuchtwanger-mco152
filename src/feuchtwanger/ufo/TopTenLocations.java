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
	
	public ArrayList<Integer> getViews(){
		ArrayList<Integer> views = new ArrayList<Integer>(map.values());
		Collections.sort(views);
		Collections.reverse(views);

		
		return views;
	}
}
