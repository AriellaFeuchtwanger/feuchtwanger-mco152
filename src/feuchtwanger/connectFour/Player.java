package feuchtwanger.connectFour;

import java.awt.Color;

public class Player {

	private int wins;
	private Color yourColor;
	
	public Player(Color yourColor){
		this.yourColor = yourColor;
		wins = 0;
	}
	
	public void addWin(){
		wins++;
	}
	
	public int getWins(){
		return wins;
	}
	
	public Color getColor(){
		return yourColor;
	}
}
