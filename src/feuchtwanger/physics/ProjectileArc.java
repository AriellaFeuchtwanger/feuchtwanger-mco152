package feuchtwanger.physics;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class ProjectileArc extends JFrame{
	
	public static void main(String[] args){
		new ProjectileArc().setVisible(true);
	}
	public ProjectileArc(){
		
		setTitle("Projectile Arc");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BorderLayout layout = new BorderLayout();
		Container container = getContentPane();
		container.setLayout(layout);
		container.add(new ProjectileComponent(), BorderLayout.CENTER);
	}
}
