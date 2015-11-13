package feuchtwanger.connectFour;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class BoardComponent extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Board board;
	private int column;
	
	public BoardComponent(Board board){
		this.board = board;
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 800, 600);
		
		g.setColor(Color.WHITE);
		for(int i = 0; i < 7; i++){
			for(int j = 0; j < 6; j++){
				g.fillOval((i * 100), (j * 100), 25, 25);
			}
		}
	}
}
