package feuchtwanger.nypl;

public class NYPLSearch {
	private NYPLSearchAPI nyplAPI;
	
	public SearchResult[] getResults(){
		return nyplAPI.getResults();
	}
}
