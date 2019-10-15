package com.example.contactsapp;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = BusinessContact.class, name = "Business"),
        @JsonSubTypes.Type(value = PersonContact.class, name = "Person")
})

public abstract class BaseContact implements Comparable<BaseContact>{

    // CREATE VARIABLES
    protected String firstName, lastName, phoneNumber, emailAddress, photo, streetAddress, city, state, zipCode;

    // CONSTRUCTOR TO FILL
    public BaseContact(String firstName, String lastName, String phoneNumber, String emailAddress, String photo, String streetAddress, String city, String state, String zipCode) {
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
    }

    @Override
    public String toString() {
        return "BaseContact [firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
                + ", emailAddress=" + emailAddress + ", photo=" + photo + ", streetAddress=" + streetAddress + ", city="
                + city + ", state=" + state + ", zipCode=" + zipCode + "]";
    }


    // GETTERS AND SETTERS
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


}