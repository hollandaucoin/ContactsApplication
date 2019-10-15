package com.example.contactsapp;

import android.app.Application;

public class MyApplication extends Application{

    // CREATE ADDRESS BOOK
    private static AddressBook addressBook = new AddressBook();

    public static AddressBook getAddressBook() {
        return addressBook;
    }

    public static void setAddressBook() {
        addressBook = addressBook;
    }


    // READ IN CONTACTS FROM JSON FILE
    public void onCreate() {
        super.onCreate();

        DataAccessService das = new FileIOService();
        addressBook = das.readAllContacts(getApplicationContext());

    }
}