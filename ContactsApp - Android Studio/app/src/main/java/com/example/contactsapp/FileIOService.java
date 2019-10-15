package com.example.contactsapp;

import android.content.Context;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class FileIOService implements DataAccessService {

    // CREATE OBJECT MAPPER
    ObjectMapper om = new ObjectMapper();

    // DEFAULT CONSTRUCTOR
    public FileIOService() {

    }

    // METHOD TO READ ALL CONTACTS FROM JSON FILE
    public AddressBook readAllContacts(Context context) {

        // GET GLOBAL ADDRESSBOOK
        AddressBook addressBook = MyApplication.getAddressBook();

        try {
            File path = context.getExternalFilesDir(null);
            File file = new File (path, "contacts.txt");
            addressBook = new ObjectMapper().readerFor(AddressBook.class).readValue(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return addressBook;
    }

    // METHOD TO SAVE ALL CONTACTS TO JSON FILE
    public void saveAllContacts(AddressBook ad, Context context) {

        try {
            File path = context.getExternalFilesDir(null);
            File file = new File (path, "contacts.txt");
            om.writerWithDefaultPrettyPrinter().writeValue(file, ad);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



