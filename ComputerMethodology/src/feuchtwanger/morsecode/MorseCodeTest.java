package feuchtwanger.morsecode;

import org.junit.Test;
import org.junit.Assert;

public class MorseCodeTest {

	@Test
	public void testEncode(){
		MorseCode code = new MorseCode();
		String message = code.encode("Hi");
		
		Assert.assertEquals(".... ..    ", message);
	}
	
	@Test
	public void testDecode(){
		MorseCode code = new MorseCode();
		String message = code.encode(".... ..    ");
		
		
	}
}
