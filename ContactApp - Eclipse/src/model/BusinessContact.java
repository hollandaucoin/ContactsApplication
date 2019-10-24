package model;

public class BusinessContact extends BaseContact{

	private String company, businessHours, websiteURL;
	private Boolean[] daysOfWeekOpen;
	
	public BusinessContact(String company, String firstName, String lastName, String phoneNumber, String emailAddress, String photo, String streetAddress, String city, String state, String zipCode, String country, String businessHours, Boolean[] daysOfWeekOpen, String websiteURL) {
		super(firstName, lastName, phoneNumber, emailAddress, photo, streetAddress, city, state, zipCode, country);
		this.company = company;
		this.businessHours = businessHours;
		this.daysOfWeekOpen = daysOfWeekOpen;
		this.websiteURL = websiteURL;
	}
	
	public BusinessContact() {
		super("OwnerFirst", "OwnerLast", "098-765-4321", "email@gmail.com", "picture.jpg", "456 Main St", "Phoenix", "AZ", "85017", "United States");
		this.company = "CompanyName";
		this.businessHours = "8:00AM - 9:00PM";
		this.daysOfWeekOpen = new Boolean [] {false, true, true, true, true, true, false};
		this.websiteURL = "http://www.idk.com";
	}
	
	public void callTo() {
		System.out.println("Opening phone app to call " + getCompany() + "...");
	}

	public void textTo() {
		System.out.println("Opening messaging app to text " + getCompany() + "...");
	}

	public void emailTo() {
		System.out.println("Opening mail app to email " + getCompany() + "...");
	}

	public void navigateTo() {
		System.out.println("Opening GPS app to navigate to " + getCompany() + "...");
	}

	public void openURL() {
		System.out.println("Opening the URL from " + getCompany() + " in browser...");
	}
	

	@Override
	public String toString() {
		String daysOpenString = "";
		String[] days = {"Sunday - ", "Monday - ", "Tuesday - ", "Wednesday - ", "Thursday - ", "Friday - ", "Saturday - "};
		
		for (int i = 0; i <= daysOfWeekOpen.length-1; i++) {
			if (daysOfWeekOpen[i] == true) {
				daysOpenString += days[i] + "Open, ";
			}
			else {
				daysOpenString += days[i] + "Closed, ";
			}
		}
		

		
		return  "\nBusiness Contact - \n   Company Name: " + company + "\n   Owner: " + firstName + " " + lastName + "\n   Phone Number: " + phoneNumber
				+ "\n   Email Address: " + emailAddress + "\n   Photo: " + photo + "\n   Address: " + streetAddress + " "
				+ city + ", " + state + " " + zipCode + " " + country + "\n   Business Hours: " + businessHours + "\n   Schedule: " + daysOpenString
				+ "\n   Website: " + websiteURL + "\n";
	}

	@Override
	public int compareTo(BaseContact o) {
		return 0;
	}

	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getBusinessHours() {
		return businessHours;
	}

	public void setBusinessHours(String businessHours) {
		this.businessHours = businessHours;
	}

	public String getWebsiteURL() {
		return websiteURL;
	}

	public void setWebsiteURL(String websiteURL) {
		this.websiteURL = websiteURL;
	}

	public Boolean[] getDaysOfWeekOpen() {
		return daysOfWeekOpen;
	}

	public void setDaysOfWeekOpen(Boolean[] daysOfWeekOpen) {
		this.daysOfWeekOpen = daysOfWeekOpen;
	}
	
}
