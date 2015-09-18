package feuchtwanger.math;

import java.util.HashMap;
import java.util.Map;

public class CountingDuplicates {

	public static void main(String[] args){
		String array[] = new String[]{"A", "B", "B", "C"
		};
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for(String s : array){
			Integer count = map.get(s); //you get the key to the value
			if(count == null){
				map.put(s, 1); //Adds s to the map and says there's one thing there
				//The letter was not there in the first place
			}
			else{
				map.put(s, count+1); //s stays the same, and you add one to the map
				//Just like a set, a map cannot have duplicates
			}
		}
		
		//for(Map.Entry<String, Integer> entry : map.entrySet){
			//System.out.println(entry.getKey() + " " + entry.getValue());
		//}
	}
}
