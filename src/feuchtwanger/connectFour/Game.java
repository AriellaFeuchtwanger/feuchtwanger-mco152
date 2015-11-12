package feuchtwanger.connectFour;

import java.awt.Color;

public class Game {
	private Board board;
	private Player red;
	private Player yellow;
	private Player lastPlayer;
	
	public Game(){
		board = new Board();
		red = new Player(Color.RED);
		yellow = new Player(Color.YELLOW);
		lastPlayer = yellow; //You usually start with red (at least, I do)
	}
	
	public boolean move(int row, int column){
		boolean win = false;
		if(lastPlayer == yellow){
			lastPlayer = red;
		} else{
			lastPlayer = yellow;
		}
		board.move(row, column, lastPlayer.getColor());
		win = win(row, column);
		if(win){
			lastPlayer.addWin();
		}
		
		return win;
	}
	
	private boolean win(int row, int column){
		boolean win = board.win(row, column, lastPlayer.getColor());
		return win;
	}
}
