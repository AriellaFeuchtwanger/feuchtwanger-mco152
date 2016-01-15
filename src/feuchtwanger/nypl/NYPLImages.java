package feuchtwanger.nypl;

public class NYPLImages {
	private NYPLImagesAPI nyplAPI;
	
	public Capture[] getCaptures(){
		return nyplAPI.getCaptures();
	}
}
