package feuchtwanger.weather;

public class WeatherList {
	private long dt;
	private Temp temp;
	private double pressure;
	private int humidity;
	private weather[] weather;
	private double speed;
	private int deg;
	private int clouds;
	
	public String getMain(){
		return weather[0].getMain();
	}
	
	public String getDescription(){
		return weather[0].getDescription();
	}
	
	public String getIcon(){
		return weather[0].getIcon();
	}
	
	public double getMin(){
		return temp.getMin();
	}
	
	public double getMax(){
		return temp.getMax();
	}
	
	public long getDt(){
		return dt;
	}
}
