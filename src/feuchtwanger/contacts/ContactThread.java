package feuchtwanger.contacts;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ContactThread extends Thread{
	private JList list;
	private DefaultListModel<String> model;
	private Contact[] contactList;
	
	public ContactThread(JList list, DefaultListModel<String> model){
		this.list = list;
		
		this.model = model;
	}
	
	public void run(){
		try {
			contactList = new ContactJSON().getContactList();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Arrays.sort(contactList);
		
		for(int i = 0; i < contactList.length; i++){
			model.addElement(contactList[i].getName());
		}
		
		list.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					ContactInformationJFrame contactInformation = new ContactInformationJFrame(contactList[list
							.getSelectedIndex()]);
					contactInformation.setVisible(true);
				}

			}

		});
	}
}
