package feuchtwanger.contacts;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class ContactThread extends Thread{
	private JList<Contact> list;
	private DefaultListModel<Contact> model;
	private Contact[] contactList;
	
	public ContactThread(JList<Contact> list, DefaultListModel<Contact> model){
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
			model.addElement(contactList[i]);
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
