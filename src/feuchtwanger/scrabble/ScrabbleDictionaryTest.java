package feuchtwanger.scrabble;

import java.io.IOException;

import org.junit.Test;
import org.junit.Assert;

public class ScrabbleDictionaryTest {

	@Test
	public void testScrabbleDictionaryPresent() throws IOException{
		Assert.assertTrue(ScrabbleDictionary.getInstance().contains("hello"));
	}
	
	@Test
	public void testScrabbleDictionaryNotFound() throws IOException{
		Assert.assertFalse(ScrabbleDictionary.getInstance().contains("ui"));
	}
}
