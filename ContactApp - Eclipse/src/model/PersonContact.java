package model;

public class PersonContact extends BaseContact {

	private String birthday;
	private String description;
	
	public PersonContact(String firstName, String lastName, String description, String phoneNumber, String emailAddress, String photo, String streetAddress, String city, String state, String zipCode, String country, String birthday) {
		super(firstName, lastName, phoneNumber, emailAddress, photo, streetAddress, city, state, zipCode, country);
		this.birthday = birthday;
		this.description = description;
	}
	
	public PersonContact() {
		super("FirstName", "LastName", "102-938-4756", "eaddress@gmail.com", "photograph.jpg", "789 Main St", "Redlands", "CA", "92373", "United States");
		this.birthday = "01/01/2000";
		this.description = "PersonDescription";
	}
	
	public void callTo() {
		System.out.println("Opening phone app to call " + getFirstName() + " " + getLastName() + "...");
	}
	
	public void textTo() {
		System.out.println("Opening messaging app to text " + getFirstName() + " " + getLastName() + "...");
	}
	
	public void emailTo() {
		System.out.println("Opening mail app to email " + getFirstName() + " " + getLastName() + "...");
	}
	
	public void navigateTo() {
		System.out.println("Opening GPS app to navigate to " + getFirstName() + " " + getLastName() + "...");
	}

	@Override
	public String toString() {
		return "\nPerson Contact - \n   Name: " + firstName + " " + lastName + "\n   Description: " + description + "\n   Phone Number: " + phoneNumber
				+ "\n   Email Address: " + emailAddress + "\n   Photo: " + photo + "\n   Address: " + streetAddress + " "
				+ city + ", " + state + " " + zipCode + " " + country + "\n   Birthday: " + birthday + "\n";
	}

	@Override
	public int compareTo(BaseContact o) {
		return 0;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
