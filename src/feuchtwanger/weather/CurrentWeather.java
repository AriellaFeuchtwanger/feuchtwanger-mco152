package feuchtwanger.weather;

public class CurrentWeather {
	//Array of weather objects and a main object
	private Coordinates coordinates;
	private weather[] weather;
	private String base;
	private main main;
	private Wind wind;
	private Clouds clouds;
	private int dt;
	private Sys sys;
	private int id;
	private String name;
	private int cod;
	
	public double getTemp(){
		return main.getTemp();
	}
	
	public double getTempMin(){
		return main.getTempMin();
	}
	
	public double getTempMax(){
		return main.getTempMax();
	}
	
	public String getIcon(){
		return weather[0].getIcon();
	}
	
	public String getDescription(){
		return weather[0].getDescription();
	}
	
	public String getMain(){
		return weather[0].getMain();
	}
	
	public String getCountry(){
		return sys.getCountry();
	}
	
	public String getName(){
		return name;
	}
}
