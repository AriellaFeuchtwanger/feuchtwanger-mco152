package feuchtwanger.nypl;

public class NYPLImagesAPI {
	private ImageResponse response;
	
	public Capture[] getCaptures(){
		return response.getCaptures();
	}
}
