package feuchtwanger.gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class SmileJFrame extends JFrame{
	public static void main(String args[]){
		new SmileJFrame().setVisible(true);
	}
	
	public SmileJFrame(){
		setTitle("Smile");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BorderLayout layout = new BorderLayout();
		Container container = getContentPane();
		container.setLayout(layout);
		container.add(new SmileComponent(), BorderLayout.CENTER);
<<<<<<< HEAD
		container.add(new SmileComponent2(), BorderLayout.CENTER);
=======
		//container.add(new SmileComponent2(), BorderLayout.CENTER);
>>>>>>> f630de877d92290c1a05ebc57d60128db8e6db63
	}

}
