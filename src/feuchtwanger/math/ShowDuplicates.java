package feuchtwanger.math;

import java.util.HashSet;

public class ShowDuplicates {

	public static void main(String[] args) {
		String array[] = new String[] { "A", "B", "B", "B", "C" };

		HashSet set = new HashSet<String>();
		HashSet duplicates = new HashSet<String>();
		for (String s : array) {
			if (set.contains(s)) {
				if (!duplicates.contains(s)) {
					System.out.println(s);
					duplicates.add(s);
				}
			} else {
				set.add(s);
			}
		}
	}
}
