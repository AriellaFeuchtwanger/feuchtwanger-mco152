package feuchtwanger.weather;

public class City {
	private double id;
	private String name;
	private Coordinates coord;
	private String country;
	private int population;
	
	public String getName(){
		return name;
	}
	
	public String getCountry(){
		return country;
	}
}
