package feuchtwanger.contacts;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class ContactJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContactJFrame() {
		setTitle("Contacts");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DefaultListModel<Contact> model = new DefaultListModel<Contact>();
		JList<Contact> list = new JList<Contact>(model);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setBackground(new Color(255, 187, 255));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		

		add(list);

		ContactThread thread = new ContactThread(list, model);
		thread.start();
	}
}
