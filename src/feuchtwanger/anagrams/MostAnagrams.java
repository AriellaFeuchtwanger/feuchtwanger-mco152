package feuchtwanger.anagrams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MostAnagrams {

	public static void main(String[] args) throws FileNotFoundException {
		final Scanner input = new Scanner(new File("./US.dic"));
		String[] lettersT;
		String word;
		ArrayList<String> words;
		final HashMap<String, ArrayList<String>> anagrams = new HashMap<String, ArrayList<String>>();
		String newWord;

		anagrams.put(input.next(), new ArrayList<String>());
		do {
			word = input.next();
			lettersT = word.split("");
			Arrays.sort(lettersT);
			final StringBuilder b = new StringBuilder();
			for (final String s : lettersT) {
				b.append(s);
			}
			newWord = b.toString();

			words = anagrams.get(newWord);
			if (words == null) {
				words = new ArrayList<String>();
				words.add(word);
				anagrams.put(newWord, words);
			} else {
				words.add(word);
				anagrams.put(newWord, words);
			}
		} while (input.hasNext());

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
