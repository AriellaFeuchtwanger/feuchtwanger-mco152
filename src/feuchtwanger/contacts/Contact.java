package feuchtwanger.contacts;

public class Contact implements Comparable<Contact>{
	private int id;
	private String name;
	private String username;
	private String email;
	private Address address;
	private String phone;
	private String website;
	private Company company;
	
	public String getName(){
		return name;
	}
	
	public String getEmail(){
		return email;
	}
	
	public Address getAddress(){
		return address;
	}
	
	public String getPhone(){
		return phone;
	}
	
	public String getWebsite(){
		return website;
	}
	
	public Company getCompany(){
		return company;
	}
	
	public int compareTo(Contact other){
		String[] thisName = name.split(" ");
		String[] otherName = other.getName().split(" ");
		String lastName = thisName[thisName.length-1];
		String otherLastName = otherName[otherName.length-1];
		
		if(lastName.length() < 2){
			lastName = thisName[thisName.length-2];
		} else if(otherLastName.length() < 2){
			otherLastName = otherName[otherName.length-2];
		}
		return lastName.compareTo(otherLastName);
	}
}
