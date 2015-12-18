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
		return thisName[(thisName.length - 1)].compareTo(otherName[(otherName.length - 1)]);
	}
}
