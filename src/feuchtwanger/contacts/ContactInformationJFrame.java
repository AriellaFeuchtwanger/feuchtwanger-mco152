package feuchtwanger.contacts;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ContactInformationJFrame extends JFrame{
	private Contact contact;
	
	public ContactInformationJFrame(Contact contact){
		setTitle("Contact Information");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(new Color(255, 187, 255));
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		this.contact = contact;
		
		JLabel name = setName();
		JLabel email = setEmail();
		JLabel street = setStreet();
		JLabel suite = setSuite();
		JLabel city = setCity();
		JLabel zip = setZip();
		JLabel phone = setPhone();
		JLabel website = setWebsite();
		JLabel company = new JLabel("Company Information:");
		company.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		JLabel companyName = setCompanyName();
		JLabel companyCatchphrase = setCatchphrase();
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
	
	private JLabel setName(){
		JLabel label = new JLabel(contact.getName());
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setBackground(new Color(255, 187, 255));
		return label;
	}
	
	private JLabel setEmail(){
		JLabel label = new JLabel(contact.getEmail());
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setBackground(new Color(255, 187, 255));
		return label;
	}
	
	private JLabel setStreet(){
		JLabel label = new JLabel(contact.getAddress().getStreet());
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setBackground(new Color(255, 187, 255));
		return label;
	}
	
	private JLabel setSuite(){
		JLabel label = new JLabel(contact.getAddress().getSuite());
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setBackground(new Color(255, 187, 255));
		return label;
	}
	
	private JLabel setCity(){
		JLabel label = new JLabel(contact.getAddress().getCity());
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setBackground(new Color(255, 187, 255));
		return label;
	}
	
	private JLabel setZip(){
		JLabel label = new JLabel(contact.getAddress().getZip());
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setBackground(new Color(255, 187, 255));
		return label;
	}
	
	private JLabel setPhone(){
		JLabel label = new JLabel(contact.getPhone());
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setBackground(new Color(255, 187, 255));
		return label;
	}
	
	private JLabel setWebsite(){
		JLabel label = new JLabel(contact.getWebsite());
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setBackground(new Color(255, 187, 255));
		return label;
	}
	
	private JLabel setCompanyName(){
		JLabel label = new JLabel(contact.getCompany().getName());
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setBackground(new Color(255, 187, 255));
		return label;
	}
	
	private JLabel setCatchphrase(){
		JLabel label = new JLabel(contact.getCompany().getCatchphrase());
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setBackground(new Color(255, 187, 255));
		return label;
	}
}
