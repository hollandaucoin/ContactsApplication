package com.example.contactsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class CreateNewPersonal extends AppCompatActivity {

    // CREATE ALL EDIT TEXTS AND IMAGE BUTTONS
    ImageButton ib_addNewP, ib_personalToCreate;
    EditText et_firstNameP, et_lastNameP, et_descriptionP, et_phoneNumberP, et_emailAddressP, et_photoP, et_streetAddressP,
            et_cityP, et_stateP, et_zipCodeP, et_birthdayP;

    // CREATE ADDRESS BOOK
    AddressBook addressBook;

    // ON CREATE SET CONTENT TO CREATE_NEW_PERSONAL LAYOUT
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_personal);

        // SET ADDRESS BOOK TO JSON FILE
        DataAccessService das = new FileIOService();
        addressBook = das.readAllContacts(getApplicationContext());

        // FIND ALL EDIT TEXTS AND IMAGE BUTTONS
        ib_addNewP = findViewById(R.id.ib_addNewP);
        ib_personalToCreate = findViewById(R.id.ib_personalToCreate);
        et_firstNameP = findViewById(R.id.et_firstNameP);
        et_lastNameP = findViewById(R.id.et_lastNameP);
        et_descriptionP = findViewById(R.id.et_descriptionP);
        et_phoneNumberP = findViewById(R.id.et_phoneNumberP);
        et_emailAddressP = findViewById(R.id.et_emailAddressP);
        et_photoP = findViewById(R.id.et_photoP);
        et_streetAddressP = findViewById(R.id.et_streetAddressP);
        et_cityP = findViewById(R.id.et_cityP);
        et_stateP = findViewById(R.id.et_stateP);
        et_zipCodeP = findViewById(R.id.et_zipCodeP);
        et_birthdayP = findViewById(R.id.et_birthdayP);

        // BUTTON TO ADD NEW CONTACT
        ib_addNewP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // GET STRINGS FROM EDIT TEXTS
                String firstNameP = et_firstNameP.getText().toString();
                String lastNameP = et_lastNameP.getText().toString();
                String descriptionP = et_descriptionP.getText().toString();
                String phoneNumberP = et_phoneNumberP.getText().toString();
                String emailAddressP = et_emailAddressP.getText().toString();
                String photoP = et_photoP.getText().toString();
                String streetAddressP = et_streetAddressP.getText().toString();
                String cityP = et_cityP.getText().toString();
                String stateP = et_stateP.getText().toString();
                String zipCodeP = et_zipCodeP.getText().toString();
                String birthdayP = et_birthdayP.getText().toString();

                // CREATE BUSINESS CONTACT
                PersonContact p = new PersonContact(firstNameP, lastNameP, descriptionP, phoneNumberP, emailAddressP, photoP,
                        streetAddressP, cityP, stateP, zipCodeP, birthdayP);

                // ADD TO ADDRESS BOOK AND SAVE JSON FILE
                addressBook.addOne(p);
                DataAccessService das = new FileIOService();
                das.saveAllContacts(addressBook, getApplicationContext());

                //PUT STRINGS IN MESSAGE
                Intent i = new Intent(v.getContext(), ShowAll.class);
                startActivity(i);
            }
        });

        // BACK BUTTON TO CREATE NEW PAGE
        ib_personalToCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToCreate = new Intent(v.getContext(), CreateNew.class);
                startActivity(goToCreate);
            }
        });


        // LISTEN FOR INCOMING DATA
        Bundle incomingIntent = getIntent().getExtras();

        if (incomingIntent != null) {
            String firstName = incomingIntent.getString("firstName");
            String lastName = incomingIntent.getString("lastName");
            String description = incomingIntent.getString("description");
            String phoneNumber = incomingIntent.getString("phoneNumber");
            String emailAddress = incomingIntent.getString("emailAddress");
            String photo = incomingIntent.getString("photo");
            String streetAddress = incomingIntent.getString("streetAddress");
            String city = incomingIntent.getString("city");
            String state = incomingIntent.getString("state");
            String zipCode = incomingIntent.getString("zipCode");
            String birthday = incomingIntent.getString("birthday");

            // FILL IN THE FORM
            et_firstNameP.setText(firstName);
            et_lastNameP.setText(lastName);
            et_descriptionP.setText(description);
            et_phoneNumberP.setText(phoneNumber);
            et_emailAddressP.setText(emailAddress);
            et_photoP.setText(photo);
            et_streetAddressP.setText(streetAddress);
            et_cityP.setText(city);
            et_stateP.setText(state);
            et_zipCodeP.setText(zipCode);
            et_birthdayP.setText(birthday);
        }

    }
}
