package feuchtwanger.weather;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;

public class WeatherTest {

	@Test
	public void testURL(){
		WeatherURL url = new WeatherURL("11210");
		URL name;
		try {
			name = url.getURL();
			Assert.assertNotNull(name);
		} catch (MalformedURLException e) {
			Assert.fail("Didn't work.");
		}
	}
	
	@Test
	public void testGetTemp() throws IOException{
		WeatherURL url = new WeatherURL("11210");
		try {
			WeatherJSONFile weather = new WeatherJSONFile(url.getURL());
			Assert.assertNotNull(weather.getTemp());
		} catch (MalformedURLException e) {
			Assert.fail("Didn't work - URL");
		}
	}
	
	@Test
	public void testGetTempMin() throws IOException{
		WeatherURL url = new WeatherURL("11210");
		try {
			WeatherJSONFile weather = new WeatherJSONFile(url.getURL());
			Assert.assertNotNull(weather.getTempMin());
		} catch (MalformedURLException e) {
			Assert.fail("Didn't work - URL");
		}
	}
	
	@Test
	public void testGetTempMax() throws IOException{
		WeatherURL url = new WeatherURL("11210");
		try {
			WeatherJSONFile weather = new WeatherJSONFile(url.getURL());
			Assert.assertNotNull(weather.getTempMax());
		} catch (MalformedURLException e) {
			Assert.fail("Didn't work - URL");
		}
	}
	
	@Test
	public void testGetIcon() throws IOException{
		WeatherURL url = new WeatherURL("11210");
		try {
			WeatherJSONFile weather = new WeatherJSONFile(url.getURL());
			Assert.assertNotNull(weather.getIcon());
		} catch (MalformedURLException e) {
			Assert.fail("Didn't work - URL");
		}
	}
	
	
	@Test
	public void testGetDescripion() throws IOException{
		WeatherURL url = new WeatherURL("11210");
		try {
			WeatherJSONFile weather = new WeatherJSONFile(url.getURL());
			Assert.assertNotNull(weather.getDescription());
		} catch (MalformedURLException e) {
			Assert.fail("Didn't work - URL");
		}
	}
	
	
	@Test
	public void testGetMain() throws IOException{
		WeatherURL url = new WeatherURL("11210");
		try {
			WeatherJSONFile weather = new WeatherJSONFile(url.getURL());
			Assert.assertNotNull(weather.getMain());
		} catch (MalformedURLException e) {
			Assert.fail("Didn't work - URL");
		}
	}
	
}
