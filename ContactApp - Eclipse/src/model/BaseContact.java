//Holland Aucoin
//January 28, 2019
//CST 135 - 825MWF
//Milestone 3 - BaseContact

package model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo (
		use = JsonTypeInfo.Id.NAME,
		include = JsonTypeInfo.As.PROPERTY,
		property = "type")
	@JsonSubTypes ({
		@Type(value = BusinessContact.class, name = "Business"),
		@Type(value = PersonContact.class, name = "Person")
	})

public abstract class BaseContact implements Comparable<BaseContact>{
	
	protected String firstName, lastName, phoneNumber, emailAddress, photo;
	protected String streetAddress, city, state, zipCode, country;
	
	public BaseContact(String firstName, String lastName, String phoneNumber, String emailAddress, String photo, String streetAddress, String city, String state, String zipCode, String country) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.photo = photo;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
	}
	
	// DEFAULT CONSTRUCTOR
	public BaseContact () {
		this.firstName = "No first name yet";
		this.lastName = "No last name yet";
		this.phoneNumber = "123-456-7890";
		this.emailAddress = "myemail@gmail.com";
		this.photo = "myphoto.jpg";
		this.streetAddress = "123 Main St";
		this.city = "Monroe";
		this.state = "WA";
		this.zipCode = "98272";
		this.country = "United States";
	}
	
	public void callTo() {
		System.out.println("Opening phone app to call...");
	}
	
	public void textTo() {
		System.out.println("Opening messaging app to text...");
	}
	
	public void emailTo() {
		System.out.println("Opening mail app to email...");
	}
	
	public void navigateTo() {
		System.out.println("Opening GPS app to navigate...");
	}
	
	public void openURL() {
		System.out.println("Opening URL in browser...");
	}
	
	@Override
	public String toString() {
		return "BaseContact [firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
				+ ", emailAddress=" + emailAddress + ", photo=" + photo + ", streetAddress=" + streetAddress + ", city="
				+ city + ", state=" + state + ", zipCode=" + zipCode + ", country=" + country + "]";
	}
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
