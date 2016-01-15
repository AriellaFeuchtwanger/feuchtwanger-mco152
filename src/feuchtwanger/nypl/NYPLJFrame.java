package feuchtwanger.nypl;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;

public class NYPLJFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public NYPLJFrame() {
		setTitle("NYPL Search");
		setSize(800, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		JPanel searchArea = new JPanel();
		searchArea.setLayout(new BoxLayout(searchArea, BoxLayout.X_AXIS));

		JPanel resultPanel = new JPanel();
		resultPanel.setLayout(new BorderLayout());

		JPanel imagePanel = new JPanel();
		imagePanel.setLayout(new BorderLayout());

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.setAlignmentX(CENTER_ALIGNMENT);

		JTextField input = new JTextField();
		input.setMaximumSize(new Dimension(800, 25));
		JButton search = new JButton("Search");

		JList<SearchResult> list = new JList<SearchResult>();
		JButton previous = new JButton("Previous");
		previous.setEnabled(false);
		JButton next = new JButton("Next");
		
		next.setEnabled(false);
		JLabel page = new JLabel("x/x");
		JLabel image = new JLabel(" ");
		JScrollPane scrollPane = new JScrollPane(image);
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(300, 1000));
		list.setMinimumSize(new Dimension(100, 100));
		list.setMaximumSize(new Dimension(100, 100));
		
		buttonPanel.add(Box.createRigidArea(new Dimension(160,0)));
		buttonPanel.add(previous);
		buttonPanel.add(page);
		buttonPanel.add(next);
		buttonPanel.add(Box.createRigidArea(new Dimension(5,0)));
		searchArea.add(input);
		searchArea.add(search);
		imagePanel.add(buttonPanel, BorderLayout.PAGE_START);
		imagePanel.add(scrollPane, BorderLayout.CENTER);
		resultPanel.add(listScroller, BorderLayout.LINE_START);
		resultPanel.add(imagePanel);
		

		add(searchArea);
		add(resultPanel);

		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String keyword = input.getText();
				new SearchThread(list, keyword)
						.start();
				repaint();
			}

		});
		
		list.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				ListModel model = list.getModel();
				SearchResult[]results = new SearchResult[model.getSize()];
				
				for(int i = 0; i < model.getSize(); i++){
					results[i] = (SearchResult) model.getElementAt(i);
				}
				
				new ImageThread(image, page, results[list.getSelectedIndex()],
						previous, next).start();

			}
		});
	}

	public static void main(String[] args) {
		new NYPLJFrame().setVisible(true);
	}
}
