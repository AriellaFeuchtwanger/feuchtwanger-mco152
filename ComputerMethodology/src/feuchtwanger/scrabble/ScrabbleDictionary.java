package feuchtwanger.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ScrabbleDictionary {

	ArrayList<String> dictionary;

	public ScrabbleDictionary() throws FileNotFoundException {

		Scanner input = new Scanner(new File("US.dic"));

		ArrayList<String> dictionary = new ArrayList<String>();
		do {
			dictionary.add(input.next());

		} while (input.hasNext());

		this.dictionary = dictionary;
	}

	public boolean contains(String word) {
		if (this.dictionary.contains(word)) {
			return true;
		} else
			return false;
	}
}
