package com.example.contactsapp;

public class BusinessContact extends BaseContact{

    // CREATE VARIABLES
    private String company, businessHours, websiteURL, schedule;

    // CONSTRUCTOR TO FILL
    public BusinessContact(String company, String firstName, String lastName, String phoneNumber, String emailAddress, String photo, String streetAddress, String city, String state, String zipCode, String businessHours, String schedule, String websiteURL) {
        super(firstName, lastName, phoneNumber, emailAddress, photo, streetAddress, city, state, zipCode);
        this.company = company;
        this.businessHours = businessHours;
        this.schedule = schedule;
        this.websiteURL = websiteURL;
    }

    // DEFAULT CONSTRUCTOR
    public BusinessContact() {
        super("OwnerFirst", "OwnerLast", "098-765-4321", "email@gmail.com", "picture.jpg", "456 Main St", "Phoenix", "AZ", "85017");
        this.company = "CompanyName";
        this.businessHours = "8:00AM - 9:00PM";
        this.schedule = "SMTWThFS";
        this.websiteURL = "http://www.idk.com";
    }

    @Override
    public String toString() {

        return  "\nBusiness Contact - \n   Company Name: " + company + "\n   Owner: " + firstName + " " + lastName + "\n   Phone Number: " + phoneNumber
                + "\n   Email Address: " + emailAddress + "\n   Photo: " + photo + "\n   Address: " + streetAddress + " "
                + city + ", " + state + " " + zipCode + "\n   Business Hours: " + businessHours + "\n   Schedule: " + schedule
                + "\n   Website: " + websiteURL + "\n";
    }

    // COMPARATOR FOR SORT FEATURE
    @Override
    public int compareTo(BaseContact o) {
        return this.getFirstName().compareTo(o.getFirstName());
    }

    // GETTERS AND SETTERS
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

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

}
