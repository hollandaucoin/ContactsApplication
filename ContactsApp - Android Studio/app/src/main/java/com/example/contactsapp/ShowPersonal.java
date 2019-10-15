package com.example.contactsapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class ShowPersonal extends AppCompatActivity {

    // CREATE ALL BUTTONS, TEXT VIEWS, EDIT TEXTS, IMAGE BUTTONS
    Button btn_editContactSP, btn_deleteContactSP;
    TextView tv_showContactP, tv_descriptionSP;
    EditText et_phoneNumberSP, et_emailAddressSP, et_address1SP, et_address2SP, et_birthdaySP, et_photoSP;
    ImageButton ib_exitSP, ib_callSP, ib_textSP, ib_emailSP, ib_navigateSP;
    ImageView iv_contactPictureSP;

    // CREATE ADDRESS BOOK
    AddressBook addressBook;

    // INITIALIZE POSITION VARIABLE TO 0
    int position = 0;

    // ON CREATE SET CONTENT TO SHOW_PERSONAL LAYOUT
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_personal);

        // FIND ALL BUTTONS, TEXT VIEWS, EDIT TEXTS, IMAGE BUTTONS
        btn_editContactSP = findViewById(R.id.btn_editContactSP);
        btn_deleteContactSP = findViewById(R.id.btn_deleteContactSP);

        tv_showContactP = findViewById(R.id.tv_showContactP);
        tv_descriptionSP = findViewById(R.id.tv_descriptionSP);

        et_phoneNumberSP = findViewById(R.id.et_phoneNumberSP);
        et_emailAddressSP = findViewById(R.id.et_emailAddressSP);
        et_photoSP = findViewById(R.id.et_photoSP);
        et_address1SP = findViewById(R.id.et_address1SP);
        et_address2SP = findViewById(R.id.et_address2SP);
        et_birthdaySP = findViewById(R.id.et_birthdaySP);
        et_photoSP = findViewById(R.id.et_photoSP);

        ib_exitSP = findViewById(R.id.ib_exitSP);
        ib_callSP = findViewById(R.id.ib_callSP);
        ib_textSP = findViewById(R.id.ib_textSP);
        ib_emailSP = findViewById(R.id.ib_emailSP);
        ib_navigateSP = findViewById(R.id.ib_navigateSP);

        iv_contactPictureSP = findViewById(R.id.iv_contactPictureSP);

        // SET ADDRESS BOOK AS A GLOBAL VARIABLE TO BE ACCESSIBLE


        DataAccessService das = new FileIOService();
        addressBook = das.readAllContacts(getApplicationContext());

        // USE INTENT TO GET POSITION OF CONTACT CHOSEN FROM SHOW ALL, AND ASSIGN TO PERSON CONTACT P
        int positionToShow = getIntent().getIntExtra("position", position);
        PersonContact p = (PersonContact) addressBook.getTheList().get(positionToShow);

        // SET TEXT OF ALL TEXT AND EDIT VIEWS
        tv_showContactP.setText(p.getFirstName() + " " + p.getLastName());
        tv_descriptionSP.setText(p.getDescription());
        et_phoneNumberSP.setText(p.getPhoneNumber());
        et_emailAddressSP.setText(p.getEmailAddress());
        et_photoSP.setText(p.getPhoto());
        et_address1SP.setText(p.getStreetAddress() + " " + p.getCity() + ", " + p.getState());
        et_address2SP.setText(p.getZipCode() + " United States");
        et_birthdaySP.setText(p.getBirthday());

        // CREATE ARRAY OF IMAGES
        int iconResourceNumbers [] = {
                R.drawable.icon1, R.drawable.icon2, R.drawable.icon3, R.drawable.icon4, R.drawable.icon5,
                R.drawable.icon6, R.drawable.icon7, R.drawable.icon9, R.drawable.icon8, R.drawable.icon10,
                R.drawable.icon11, R.drawable.icon12, R.drawable.icon13, R.drawable.icon14, R.drawable.icon15,
                R.drawable.icon16
        };

        // ASSIGN CONTACT IMAGE TO CHOSEN PHOTO NUMBER
        iv_contactPictureSP.setImageResource(iconResourceNumbers[Integer.parseInt(p.getPhoto())-1]);


        // EDIT CONTACT BUTTON
        btn_editContactSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // USE INTENT TO GET POSITION OF CONTACT CHOSEN FROM SHOW ALL, AND SEND TO EDIT CONTACT
                int positionToShow = getIntent().getIntExtra("position", position);
                editPersonal(positionToShow);
            }
        });

        // DELETE CONTACT BUTTON
        btn_deleteContactSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // USE INTENT TO GET POSITION OF CONTACT CHOSEN FROM SHOW ALL, AND SEND TO DELETE CONTACT
                int positionToShow = getIntent().getIntExtra("position", position);
                deletePersonalConfirm(positionToShow);
            }
        });

        // EXIT BUTTON
        ib_exitSP.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {
                Intent goToStart = new Intent(v.getContext(), ShowAll.class);
                startActivity(goToStart);
            }
        });

        // CALL BUTTON
        ib_callSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCall(et_phoneNumberSP.getText().toString());
            }
        });

        // TEXT BUTTON
        ib_textSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openText(et_phoneNumberSP.getText().toString(), "");
            }
        });

        // EMAIL BUTTON
        ib_emailSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String [] addresses = new String[1];
                addresses[0] = et_emailAddressSP.getText().toString();

                openEmail(addresses, "Hello friend");
            }
        });

        // NAVIGATE BUTTON
        ib_navigateSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mapsQuery = "geo:0,0?q=" + et_address1SP.getText().toString();
                Uri mapUri = Uri.parse(mapsQuery);
                openMaps(mapUri);
            }
        });

    }

    // EDIT CONTACT METHOD USING POSITION CHOSEN
    public void editPersonal(final int positionToShow) {

        // CREATE DIALOGUE BUILDER TO CONFIRM EDIT ACTION
        AlertDialog.Builder alertDialogBuilderEdit = new AlertDialog.Builder(this);
        alertDialogBuilderEdit.setMessage("Are you sure you want to edit " + addressBook.getTheList().get(positionToShow).getFirstName()
                + " " + addressBook.getTheList().get(positionToShow).getLastName() + "'s contact?");

        // SET "YES" OPTION AND PERFORM EDIT
        alertDialogBuilderEdit.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Intent editPersonal = new Intent(getApplicationContext(), CreateNewPersonal.class);

                // PULL CONTACT AT POSITION FROM GLOBAL ADDRESS BOOK
                PersonContact p = (PersonContact) addressBook.getTheList().get(positionToShow);

                // SENDING DATA TO A "NEW CONTACT" FORM TO EDIT
                editPersonal.putExtra("firstName", p.getFirstName());
                editPersonal.putExtra("lastName", p.getLastName());
                editPersonal.putExtra("description", p.getDescription());
                editPersonal.putExtra("phoneNumber", p.getPhoneNumber());
                editPersonal.putExtra("emailAddress", p.getEmailAddress());
                editPersonal.putExtra("photo", p.getPhoto());
                editPersonal.putExtra("streetAddress", p.getStreetAddress());
                editPersonal.putExtra("city", p.getCity());
                editPersonal.putExtra("state", p.getState());
                editPersonal.putExtra("zipCode", p.getZipCode());
                editPersonal.putExtra("birthday", p.getBirthday());

                // REMOVE THE CONTACT BEING EDITED
                addressBook.deleteOne(addressBook.getTheList().get(positionToShow));

                // SAVE CHANGES TO JSON FILE
                DataAccessService das = new FileIOService();
                das.saveAllContacts(addressBook, getApplicationContext());

                startActivity(editPersonal);
            }
        });

        // SET "NO" OPTION AND DO NOTHING
        alertDialogBuilderEdit.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        // CREATE AND SHOW THE BUILT DIALOGUE
        AlertDialog alertDialogEdit = alertDialogBuilderEdit.create();
        alertDialogEdit.show();
    }

    // DELETE CONTACT METHOD USING POSITION CHOSEN
    public void deletePersonalConfirm(final int positionToShow) {

        // CREATE DIALOGUE BUILDER TO CONFIRM DELETE ACTION
        AlertDialog.Builder alertDialogBuilderDelete = new AlertDialog.Builder(this);
        alertDialogBuilderDelete.setMessage("Are you sure you want to delete " + addressBook.getTheList().get(positionToShow).getFirstName()
                + " " + addressBook.getTheList().get(positionToShow).getLastName() + " from your contacts?");

        // SET "YES" OPTION AND PERFORM REMOVAL
        alertDialogBuilderDelete.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                addressBook.deleteOne(addressBook.getTheList().get(positionToShow));

                // SAVE CHANGES TO JSON FILE
                DataAccessService das = new FileIOService();
                das.saveAllContacts(addressBook, getApplicationContext());

                Intent showAll = new Intent(getApplicationContext(), ShowAll.class);

                startActivity(showAll);
            }
        });

        // SET "NO" OPTION AND DO NOTHING
        alertDialogBuilderDelete.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        // CREATE AND SHOW THE BUILT DIALOGUE
        AlertDialog alertDialogDelete = alertDialogBuilderDelete.create();
        alertDialogDelete.show();
    }

    public void openCall(String phoneNumber) {
        Intent openCall = new Intent(Intent.ACTION_DIAL);
        openCall.setData(Uri.parse("tel:" + phoneNumber));

        if (openCall.resolveActivity(getPackageManager()) != null) {
            startActivity(openCall);
        }
    }

    public void openText(String phoneNumber, String message) {
        Intent openText = new Intent(Intent.ACTION_SENDTO);
        openText.setData(Uri.parse("smsto:" + phoneNumber));
        openText.putExtra("sms_body", message);

        if (openText.resolveActivity(getPackageManager()) != null) {
            startActivity(openText);
        }
    }

    public void openEmail(String [] addresses, String subject) {
        Intent openEmail = new Intent(Intent.ACTION_SENDTO);
        openEmail.setData(Uri.parse("mailto:"));
        openEmail.putExtra(Intent.EXTRA_EMAIL, addresses);
        openEmail.putExtra(Intent.EXTRA_SUBJECT, subject);

        if (openEmail.resolveActivity(getPackageManager()) != null) {
            startActivity(openEmail);
        }
    }

    public void openMaps(Uri address) {
        Intent openMaps = new Intent(Intent.ACTION_VIEW);
        openMaps.setData(address);

        if (openMaps.resolveActivity(getPackageManager()) != null) {
            startActivity(openMaps);
        }
    }


}
