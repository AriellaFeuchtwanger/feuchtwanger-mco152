package feuchtwanger.anagrams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MostAnagrams {

	public static void main(String[] args) throws IOException {
		final BufferedReader input = new BufferedReader(new FileReader("./US.dic"));
		String[] lettersT;
		ArrayList<String> words;
		final HashMap<String, ArrayList<String>> anagrams = new HashMap<String, ArrayList<String>>();
		String newWord;
		String line;

		while ((line = input.readLine()) != null) {
			lettersT = line.split("");
			Arrays.sort(lettersT);
			final StringBuilder b = new StringBuilder();
			for (final String s : lettersT) {
				b.append(s);
			}
			newWord = b.toString();

			words = anagrams.get(newWord);
			if (words == null) {
				words = new ArrayList<String>();
				words.add(line);
				anagrams.put(newWord, words);
			} else {
				words.add(line);
				anagrams.put(newWord, words);
			}
		}

		int temp = 0;
		String largestAnagram = "";
		for (final Map.Entry<String, ArrayList<String>> entry : anagrams.entrySet()) {
			final int tempA = entry.getValue().size();
			if (tempA >= temp) {
				temp = tempA;
				largestAnagram = entry.getKey();
			}
		}
		System.out.println("Largest letter group: " + largestAnagram);
		System.out.println("Number of words: " + anagrams.get(largestAnagram).size());
		System.out.println("Words Included: " + anagrams.get(largestAnagram));
		input.close();

	}
}
