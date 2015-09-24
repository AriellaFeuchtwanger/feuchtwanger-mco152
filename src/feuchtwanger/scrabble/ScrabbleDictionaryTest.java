package feuchtwanger.scrabble;

import java.io.IOException;

import org.junit.Test;
import org.junit.Assert;

public class ScrabbleDictionaryTest {

	@Test
	public void testScrabbleDictionaryPresent() throws IOException{
		ScrabbleDictionary d = new ScrabbleDictionary();
		
		Assert.assertTrue(d.contains("hello"));
	}
	
	@Test
	public void testScrabbleDictionaryNotFound() throws IOException{
		ScrabbleDictionary d = new ScrabbleDictionary();
		
		Assert.assertFalse(d.contains("ui"));
	}
}
