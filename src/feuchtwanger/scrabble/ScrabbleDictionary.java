package feuchtwanger.scrabble;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class ScrabbleDictionary {

	private static ScrabbleDictionary singleton;
	private final HashSet<String> dictionary;

	public ScrabbleDictionary() throws IOException {

		final BufferedReader in = new BufferedReader(new FileReader("./US.dic"));

		dictionary = new HashSet<String>();
		String line;

		while ((line = in.readLine()) != null) {
			dictionary.add(line);
		}

		in.close();
	}

	public boolean contains(String word) {
		word.toLowerCase();
		return dictionary.contains(word);
	}
	
	//Typically called getInstance. Hides it.
	public static ScrabbleDictionary getInstance() throws IOException{
		if(singleton == null){
			singleton = new ScrabbleDictionary();
		}
		return singleton;
	}
}
