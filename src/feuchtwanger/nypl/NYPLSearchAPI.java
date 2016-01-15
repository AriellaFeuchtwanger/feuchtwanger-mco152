package feuchtwanger.nypl;

public class NYPLSearchAPI {
	private SearchResponse response;
	
	public SearchResult[] getResults(){
		return response.getResults();
	}
}
