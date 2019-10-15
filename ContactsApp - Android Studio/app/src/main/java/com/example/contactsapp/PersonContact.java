package com.example.contactsapp;

public class PersonContact extends BaseContact {

    // CREATE VARIABLES
    private String birthday, description;

    // CONSTRUCTOR TO FILL
    public PersonContact(String firstName, String lastName, String description, String phoneNumber, String emailAddress, String photo, String streetAddress, String city, String state, String zipCode, String birthday) {
        super(firstName, lastName, phoneNumber, emailAddress, photo, streetAddress, city, state, zipCode);
        this.birthday = birthday;
        this.description = description;
    }

    // DEFAULT CONSTRUCTOR
    public PersonContact() {
        super("FirstName", "LastName", "102-938-4756", "eaddress@gmail.com", "photograph.jpg", "789 Main St", "Redlands", "CA", "92373");
        this.birthday = "01/01/2000";
        this.description = "PersonDescription";
    }

    @Override
    public String toString() {
        return "\nPerson Contact - \n   Name: " + firstName + " " + lastName + "\n   Description: " + description + "\n   Phone Number: " + phoneNumber
                + "\n   Email Address: " + emailAddress + "\n   Photo: " + photo + "\n   Address: " + streetAddress + " "
                + city + ", " + state + " " + zipCode + "\n   Birthday: " + birthday + "\n";
    }

    // COMPARATOR FOR SORT FEATURE
    @Override
    public int compareTo(BaseContact o) {
        return this.getFirstName().compareTo(o.getFirstName());
    }

    // GETTERS AND SETTERS
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