package feuchtwanger.nypl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ImageThread extends Thread {

	private JLabel image;
	private JLabel pages;
	private JButton previous;
	private JButton next;
	private SearchResult result;
	private Capture[] captures;
	private int pageNumber;

	public ImageThread(JLabel image, JLabel pages, SearchResult result,
			JButton previous, JButton next) {
		this.image = image;
		this.pages = pages;
		this.result = result;
		this.previous = previous;
		this.next = next;
		pageNumber = 0;
	}

	public void run() {
		pageNumber = 0;
		image.setText("");
		
		try {
			captures = new NYPLImagesJSON(result.getURL()).getCaptures();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			image.setIcon(setImage(captures[pageNumber].getImageLink()));
			pages.setText((pageNumber + 1) + "/" + captures.length);
			if(pageNumber == captures.length){
				previous.setEnabled(false);
				next.setEnabled(false);
			} else{
				previous.setEnabled(false);
				next.setEnabled(true);
			}
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		previous.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				image.setText("");
				pageNumber--;
				pages.setText((pageNumber + 1) + "/" + captures.length);
				ImageIcon icon;
				try {
					icon = setImage(captures[pageNumber].getImageLink());
					image.setIcon(icon);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(pageNumber == 0){
					previous.setEnabled(false);
				}
			}
			
		});
		
		next.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				previous.setEnabled(true);
				image.setText("");
				pageNumber++;
				pages.setText((pageNumber + 1) + "/" + captures.length);
				ImageIcon icon;
				try {
					icon = setImage(captures[pageNumber].getImageLink());
					image.setIcon(icon);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(pageNumber == captures.length){
					next.setEnabled(false);
				}
			}
			
		});
		//image.repaint();
		//pages.repaint();
	}
	
	private ImageIcon setImage(String url) throws IOException{
		URL urlLink = new URL(url);
		BufferedImage image = ImageIO.read(urlLink);
		ImageIcon icon = new ImageIcon(image);
		
		return icon;
	}
}
