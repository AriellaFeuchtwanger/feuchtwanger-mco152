package feuchtwanger.nypl;

public class SearchResult {
	private String title;
	private String apiItemURL;
	
	public String getTitle(){
		return title;
	}
	
	public String getURL(){
		return apiItemURL;
	}
	
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append(title);
		return buffer.toString();
	}
}
