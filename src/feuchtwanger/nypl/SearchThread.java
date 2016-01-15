package feuchtwanger.nypl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

public class SearchThread extends Thread {
	private JList<SearchResult> list;
	private String keyword;
	private SearchResult[] results;

	public SearchThread(JList<SearchResult> list, String keyword) {
		this.list = list;
		this.keyword = keyword;
	}

	public void run() {
		try {
			results = new NYPLSearchJSON(keyword).getResults();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		list.setListData(results);
	}
}
