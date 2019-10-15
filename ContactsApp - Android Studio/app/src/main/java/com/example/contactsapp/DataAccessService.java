package com.example.contactsapp;

import android.content.Context;

public interface DataAccessService {

    // CALL METHODS FROM FILEIOSERVICE
    AddressBook readAllContacts(Context context);
    void saveAllContacts(AddressBook ad, Context context);

}
