package feuchtwanger.contacts;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ContactJFrame extends JFrame {

	public ContactJFrame() {
		setTitle("Contacts");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DefaultListModel<String> model = new DefaultListModel<String>();
		JList list = new JList(model);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setBackground(new Color(255, 187, 255));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		

		add(list);

		ContactThread thread = new ContactThread(list, model);
		thread.start();
	}
}
