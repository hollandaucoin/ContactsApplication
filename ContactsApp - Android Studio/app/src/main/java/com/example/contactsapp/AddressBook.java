package com.example.contactsapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddressBook {

    private List<BaseContact> theList;

    // EMPTY LIST OF BASE CONTACTS
    public AddressBook() {
        this.theList = new ArrayList<BaseContact>();
    }

    // ADD SPECIFIC CONTACT (T generic allows pull from either business or person class) - GENERIC
    public <T extends BaseContact> void addOne(T contact) {
        this.theList.add(contact);
    }

    // REMOVE SPECIFIC CONTACT (T generic allows pull from either business or person class) - GENERIC
    public <T extends BaseContact> void deleteOne(T contact) {
        this.theList.remove(contact);
    }

    // SORT BY
    public void sortContacts() {
        List<BaseContact> sortedList = this.theList;
        Collections.sort(sortedList);
        this.theList = sortedList;
    }

    // OUTPUT SEARCH MATCH
    public AddressBook searchForOutput(String string) {

        // CREATE NEW ADDRESS BOOK FOR SEARCH RESULTS
        AddressBook searchList = new AddressBook();

        // CHECK TO SEE IF THE GIVEN STRING IS WITHIN THE NAME, PHONE, OR EMAIL AND ADD TO SEARCH LIST
        for (int i = 0; i < theList.size(); i++) {
            if (theList.get(i).getFirstName().toLowerCase().contains(string.toLowerCase())) {
                searchList.addOne(theList.get(i));
            } else if (theList.get(i).getLastName().toLowerCase().contains(string.toLowerCase())) {
                searchList.addOne(theList.get(i));
            } else if (theList.get(i).getPhoneNumber().contains(string)) {
                searchList.addOne(theList.get(i));
            } else if (theList.get(i).getEmailAddress().toLowerCase().contains(string.toLowerCase())) {
                searchList.addOne(theList.get(i));
            }
        }
            return searchList;
    }

    // FIND SIZE OF THE LIST
    public int size() {
        return theList.size();
    }

    // GETTER FOR THE LIST
    public List<BaseContact> getTheList() {
        return theList;
    }

    // SETTER FOR THE LIST
    public void setTheList(List<BaseContact> theList) {
        this.theList = theList;
    }

    // TO STRING FOR THE LIST
    @Override
    public String toString() {

        String book = "";

        for (int i = 0; i < theList.size(); i++) {
            book += "  * Position " + i + " * " + theList.get(i).toString() + "\n";
        }
        return book;
    }

}
