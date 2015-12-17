package feuchtwanger.weather;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;

public class WeatherTest {

	@Test
	public void testURL(){
		WeatherURL url = new WeatherURL("Brooklyn");
		URL name;
		try {
			name = url.getURL();
			Assert.assertNotNull(name);
		} catch (MalformedURLException e) {
			Assert.fail("Didn't work.");
		}
	}
	
	@Test
	public void testGetTempMin() throws IOException{
		WeatherURL url = new WeatherURL("Brooklyn");
		try {
			WeatherJSONFile weather = new WeatherJSONFile(url.getURL());
			Assert.assertNotNull(weather.getTempMin(9));
		} catch (MalformedURLException e) {
			Assert.fail("Didn't work - URL");
		}
	}
	
	@Test
	public void testGetTempMax() throws IOException{
		WeatherURL url = new WeatherURL("Brooklyn");
		try {
			WeatherJSONFile weather = new WeatherJSONFile(url.getURL());
			Assert.assertNotNull(weather.getTempMax(1));
		} catch (MalformedURLException e) {
			Assert.fail("Didn't work - URL");
		}
	}
	
	@Test
	public void testGetIcon() throws IOException{
		WeatherURL url = new WeatherURL("Brooklyn");
		try {
			WeatherJSONFile weather = new WeatherJSONFile(url.getURL());
			Assert.assertNotNull(weather.getIcon(1));
		} catch (MalformedURLException e) {
			Assert.fail("Didn't work - URL");
		}
	}
	
	@Test
	public void testGetDescripion() throws IOException{
		WeatherURL url = new WeatherURL("Brooklyn");
		try {
			WeatherJSONFile weather = new WeatherJSONFile(url.getURL());
			Assert.assertNotNull(weather.getDescription(1));
		} catch (MalformedURLException e) {
			Assert.fail("Didn't work - URL");
		}
	}
	
	
	@Test
	public void testGetMain() throws IOException{
		WeatherURL url = new WeatherURL("Brooklyn");
		try {
			WeatherJSONFile weather = new WeatherJSONFile(url.getURL());
			Assert.assertNotNull(weather.getMain(1));
		} catch (MalformedURLException e) {
			Assert.fail("Didn't work - URL");
		}
	}
	
}
