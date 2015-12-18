package feuchtwanger.contacts;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ContactInformationJFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private Contact contact;
	
	public ContactInformationJFrame(Contact contact){
		setTitle("Contact Information");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(new Color(171, 130, 255));
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		this.contact = contact;
		
		JLabel name = getContactName();
		JLabel email = getEmail();
		JLabel street = getStreet();
		JLabel suite = getSuite();
		JLabel city = getCity();
		JLabel zip = getZip();
		JLabel phone = getPhone();
		JLabel website = getWebsite();
		JLabel company = new JLabel("Company Information:");
		company.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		JLabel companyName = getCompanyName();
		JLabel companyCatchphrase = getCatchphrase();
		JLabel space = new JLabel(" ");
		
		add(name);
		add(space);
		add(email);
		add(street);
		add(suite);
		add(city);
		add(zip);
		add(phone);
		add(website);
		add(space);
		add(company);
		add(companyName);
		add(companyCatchphrase);
	}
	
	private JLabel getContactName(){
		JLabel label = new JLabel(contact.getName());
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		return label;
	}
	
	private JLabel getEmail(){
		JLabel label = new JLabel(contact.getEmail());
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		return label;
	}
	
	private JLabel getStreet(){
		JLabel label = new JLabel(contact.getAddress().getStreet());
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		return label;
	}
	
	private JLabel getSuite(){
		JLabel label = new JLabel(contact.getAddress().getSuite());
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		return label;
	}
	
	private JLabel getCity(){
		JLabel label = new JLabel(contact.getAddress().getCity());
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		return label;
	}
	
	private JLabel getZip(){
		JLabel label = new JLabel(contact.getAddress().getZip());
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		return label;
	}
	
	private JLabel getPhone(){
		JLabel label = new JLabel(contact.getPhone());
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		return label;
	}
	
	private JLabel getWebsite(){
		JLabel label = new JLabel(contact.getWebsite());
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		return label;
	}
	
	private JLabel getCompanyName(){
		JLabel label = new JLabel(contact.getCompany().getName());
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		return label;
	}
	
	private JLabel getCatchphrase(){
		JLabel label = new JLabel(contact.getCompany().getCatchphrase());
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		return label;
	}
}
