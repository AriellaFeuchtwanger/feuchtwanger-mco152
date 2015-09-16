package feuchtwanger.scrabble;

import java.io.FileNotFoundException;

import org.junit.Test;
import org.junit.Assert;

public class ScrabbleDictionaryTest {

	@Test
	public void testScrabbleDictionaryPresent() throws FileNotFoundException{
		ScrabbleDictionary d = new ScrabbleDictionary();
		
		Assert.assertTrue(d.contains("cat"));
	}
	
	@Test
	public void testScrabbleDictionaryNotFound() throws FileNotFoundException{
		ScrabbleDictionary d = new ScrabbleDictionary();
		
		Assert.assertFalse(d.contains("ui"));
	}
}
