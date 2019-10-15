package com.example.contactsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class CreateNewBusiness extends AppCompatActivity {

    // CREATE ALL EDIT TEXTS AND IMAGE BUTTONS
    ImageButton ib_addNewB, ib_businessToCreate;
    EditText et_companyB, et_firstNameB, et_lastNameB, et_phoneNumberB, et_emailAddressB, et_photoB, et_streetAddressB,
            et_cityB, et_stateB, et_zipCodeB, et_businessHoursB, et_scheduleB, et_urlB;

    // CREATE ADDRESS BOOK
    AddressBook addressBook;

    // ON CREATE SET CONTENT TO CREATE_NEW_BUSINESS LAYOUT
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_business);

        // SET ADDRESS BOOK TO JSON FILE
        DataAccessService das = new FileIOService();
        addressBook = das.readAllContacts(getApplicationContext());

        // FIND ALL EDIT TEXTS AND IMAGE BUTTONS
        ib_addNewB = findViewById(R.id.ib_addNewB);
        ib_businessToCreate = findViewById(R.id.ib_businessToCreate);
        et_companyB = findViewById(R.id.et_companyB);
        et_firstNameB = findViewById(R.id.et_firstNameB);
        et_lastNameB = findViewById(R.id.et_lastNameB);
        et_phoneNumberB = findViewById(R.id.et_phoneNumberB);
        et_emailAddressB = findViewById(R.id.et_emailAddressB);
        et_photoB = findViewById(R.id.et_photoB);
        et_streetAddressB = findViewById(R.id.et_streetAddressB);
        et_cityB = findViewById(R.id.et_cityB);
        et_stateB = findViewById(R.id.et_stateB);
        et_zipCodeB = findViewById(R.id.et_zipCodeB);
        et_businessHoursB = findViewById(R.id.et_businessHoursB);
        et_scheduleB = findViewById(R.id.et_scheduleB);
        et_urlB = findViewById(R.id.et_urlB);


        // BUTTON TO ADD NEW CONTACT
        ib_addNewB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // GET STRINGS FROM EDIT TEXTS
                String companyB = et_companyB.getText().toString();
                String firstNameB = et_firstNameB.getText().toString();
                String lastNameB = et_lastNameB.getText().toString();
                String phoneNumberB = et_phoneNumberB.getText().toString();
                String emailAddressB = et_emailAddressB.getText().toString();
                String photoB = et_photoB.getText().toString();
                String streetAddressB = et_streetAddressB.getText().toString();
                String cityB = et_cityB.getText().toString();
                String stateB = et_stateB.getText().toString();
                String zipCodeB = et_zipCodeB.getText().toString();
                String businessHoursB = et_businessHoursB.getText().toString();
                String scheduleB = et_scheduleB.getText().toString();
                String urlB = et_urlB.getText().toString();

                // CREATE BUSINESS CONTACT
                BusinessContact b = new BusinessContact(companyB, firstNameB, lastNameB, phoneNumberB, emailAddressB, photoB,
                        streetAddressB, cityB, stateB, zipCodeB, businessHoursB, scheduleB, urlB);

                // ADD TO ADDRESS BOOK AND SAVE JSON FILE
                addressBook.addOne(b);
                DataAccessService das = new FileIOService();
                das.saveAllContacts(addressBook, getApplicationContext());

                //PUT STRINGS IN MESSAGE
                Intent i = new Intent(v.getContext(), ShowAll.class);
                startActivity(i);
            }
        });

        // BACK BUTTON TO CREATE NEW PAGE
        ib_businessToCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToCreate = new Intent(v.getContext(), CreateNew.class);
                startActivity(goToCreate);
            }
        });


        // LISTEN FOR INCOMING DATA
        Bundle incomingIntent = getIntent().getExtras();

        if (incomingIntent != null) {
            String company = incomingIntent.getString("company");
            String firstName = incomingIntent.getString("firstName");
            String lastName = incomingIntent.getString("lastName");
            String phoneNumber = incomingIntent.getString("phoneNumber");
            String emailAddress = incomingIntent.getString("emailAddress");
            String photo = incomingIntent.getString("photo");
            String streetAddress = incomingIntent.getString("streetAddress");
            String city = incomingIntent.getString("city");
            String state = incomingIntent.getString("state");
            String zipCode = incomingIntent.getString("zipCode");
            String businessHours = incomingIntent.getString("businessHours");
            String schedule = incomingIntent.getString("schedule");
            String websiteURL = incomingIntent.getString("websiteURL");

            // FILL IN THE FORM
            et_companyB.setText(company);
            et_firstNameB.setText(firstName);
            et_lastNameB.setText(lastName);
            et_phoneNumberB.setText(phoneNumber);
            et_emailAddressB.setText(emailAddress);
            et_photoB.setText(photo);
            et_streetAddressB.setText(streetAddress);
            et_cityB.setText(city);
            et_stateB.setText(state);
            et_zipCodeB.setText(zipCode);
            et_businessHoursB.setText(businessHours);
            et_scheduleB.setText(schedule);
            et_urlB.setText(websiteURL);
        }

    }
}
