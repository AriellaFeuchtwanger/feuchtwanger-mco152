package feuchtwanger.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class ScrabbleDictionary {

	//private ArrayList<String> dictionary;
	private HashSet dictionary;

	public ScrabbleDictionary() throws FileNotFoundException {

		Scanner input = new Scanner(new File("US.dic"));

		dictionary = new HashSet<String>();
		do {
			String s = input.next();
			if(!dictionary.contains(s)){
				dictionary.add(s);
			}
		} while (input.hasNext());

		input.close();
		this.dictionary = dictionary;
	}

	public boolean contains(String word) {
		return dictionary.contains(word);
	}
}
