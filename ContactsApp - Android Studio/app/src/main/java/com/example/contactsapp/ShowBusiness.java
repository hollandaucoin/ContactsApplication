package com.example.contactsapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowBusiness extends AppCompatActivity {

    // CREATE ALL BUTTONS, TEXT VIEWS, EDIT TEXTS, IMAGE BUTTONS
    Button btn_editContactSB, btn_deleteContactSB;
    TextView tv_showContactB, tv_companySB;
    EditText et_phoneNumberSB, et_emailAddressSB, et_address1SB, et_address2SB, et_businessHoursSB, et_scheduleSB, et_websiteSB, et_photoSB;
    ImageButton ib_exitSB, ib_callSB, ib_textSB, ib_emailSB, ib_navigateSB, ib_websiteSB;
    ImageView iv_contactPictureSB;

    // CREATE ADDRESS BOOK
    AddressBook addressBook;

    // INITIALIZE POSITION VARIABLE TO 0
    int position = 0;

    // ON CREATE SET CONTENT TO SHOW_BUSINESS LAYOUT
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_business);

        // FIND ALL BUTTONS, TEXT VIEWS, EDIT TEXTS, IMAGE BUTTONS
        btn_editContactSB = findViewById(R.id.btn_editContactSB);
        btn_deleteContactSB = findViewById(R.id.btn_deleteContactSB);

        tv_showContactB = findViewById(R.id.tv_showContactB);
        tv_companySB = findViewById(R.id.tv_companySB);

        et_phoneNumberSB = findViewById(R.id.et_phoneNumberSB);
        et_emailAddressSB = findViewById(R.id.et_emailAddressSB);
        et_address1SB = findViewById(R.id.et_address1SB);
        et_address2SB = findViewById(R.id.et_address2SB);
        et_businessHoursSB = findViewById(R.id.et_businessHoursSB);
        et_scheduleSB = findViewById(R.id.et_scheduleSB);
        et_websiteSB = findViewById(R.id.et_websiteSB);
        et_photoSB = findViewById(R.id.et_photoSB);

        ib_exitSB = findViewById(R.id.ib_exitSB);
        ib_callSB = findViewById(R.id.ib_callSB);
        ib_textSB = findViewById(R.id.ib_textSB);
        ib_emailSB = findViewById(R.id.ib_emailSB);
        ib_navigateSB = findViewById(R.id.ib_navigateSB);
        ib_websiteSB = findViewById(R.id.ib_websiteSB);

        iv_contactPictureSB = findViewById(R.id.iv_contactPictureSB);

        // SET ADDRESS BOOK TO JSON FILE
        DataAccessService das = new FileIOService();
        addressBook = das.readAllContacts(getApplicationContext());

        // USE INTENT TO GET POSITION OF CONTACT CHOSEN FROM SHOW ALL, AND ASSIGN TO PERSON CONTACT B
        int positionToShow = getIntent().getIntExtra("position", position);
        BusinessContact b = (BusinessContact) addressBook.getTheList().get(positionToShow);

        // SET TEXT OF ALL TEXT AND EDIT VIEWS
        tv_showContactB.setText(b.getFirstName() + " " + b.getLastName());
        tv_companySB.setText(b.getCompany());
        et_phoneNumberSB.setText(b.getPhoneNumber());
        et_emailAddressSB.setText(b.getEmailAddress());
        et_address1SB.setText(b.getStreetAddress() + " " + b.getCity() + ", " + b.getState());
        et_address2SB.setText(b.getZipCode() + " United States");
        et_businessHoursSB.setText(b.getBusinessHours());
        et_scheduleSB.setText(b.getSchedule());
        et_websiteSB.setText(b.getWebsiteURL());
        et_photoSB.setText(b.getPhoto());

        // CREATE ARRAY OF IMAGES
        int iconResourceNumbers [] = {
                R.drawable.icon1, R.drawable.icon2, R.drawable.icon3, R.drawable.icon4, R.drawable.icon5,
                R.drawable.icon6, R.drawable.icon7, R.drawable.icon9, R.drawable.icon8, R.drawable.icon10,
                R.drawable.icon11, R.drawable.icon12, R.drawable.icon13, R.drawable.icon14, R.drawable.icon15,
                R.drawable.icon16
        };

        // ASSIGN CONTACT IMAGE TO CHOSEN PHOTO NUMBER
        iv_contactPictureSB.setImageResource(iconResourceNumbers[Integer.parseInt(b.getPhoto())-1]);


        // EDIT CONTACT BUTTON
        btn_editContactSB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // USE INTENT TO GET POSITION OF CONTACT CHOSEN FROM SHOW ALL, AND SEND TO EDIT CONTACT
                int positionToShow = getIntent().getIntExtra("position", position);
                editBusiness(positionToShow);
            }
        });

        // DELETE CONTACT BUTTON
        btn_deleteContactSB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // USE INTENT TO GET POSITION OF CONTACT CHOSEN FROM SHOW ALL, AND SEND TO DELETE CONTACT
                int positionToShow = getIntent().getIntExtra("position", position);
                deleteBusinessConfirm(positionToShow);
            }
        });

        // EXIT BUTTON
        ib_exitSB.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {
                Intent goToShowAll = new Intent(v.getContext(), ShowAll.class);
                startActivity(goToShowAll);
            }
        });

        // CALL BUTTON
        ib_callSB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCall(et_phoneNumberSB.getText().toString());
            }
        });

        // TEXT BUTTON
        ib_textSB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openText(et_phoneNumberSB.getText().toString(), "");
            }
        });

        // EMAIL BUTTON
        ib_emailSB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String [] addresses = new String[1];
                addresses[0] = et_emailAddressSB.getText().toString();

                openEmail(addresses, "");
            }
        });

        // NAVIGATE BUTTON
        ib_navigateSB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mapsQuery = "geo:0,0?q=" + et_address1SB.getText().toString();
                Uri mapUri = Uri.parse(mapsQuery);
                openMaps(mapUri);
            }
        });

        ib_websiteSB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openURL(et_websiteSB.getText().toString());
            }
        });

    }

    // EDIT CONTACT METHOD USING POSITION CHOSEN
    public void editBusiness(final int positionToShow) {

        // CREATE DIALOGUE BUILDER TO CONFIRM EDIT ACTION
        AlertDialog.Builder alertDialogBuilderEdit = new AlertDialog.Builder(this);
        alertDialogBuilderEdit.setMessage("Are you sure you want to edit " + addressBook.getTheList().get(positionToShow).getFirstName()
                + " " + addressBook.getTheList().get(positionToShow).getLastName() + "'s contact?");

        // SET "YES" OPTION AND PERFORM EDIT
        alertDialogBuilderEdit.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Intent editBusiness = new Intent(getApplicationContext(), CreateNewBusiness.class);

                // PULL CONTACT AT POSITION FROM GLOBAL ADDRESS BOOK
                BusinessContact b = (BusinessContact) addressBook.getTheList().get(positionToShow);

                // SENDING DATA TO A "NEW CONTACT" FORM TO EDIT
                editBusiness.putExtra("company", b.getCompany());
                editBusiness.putExtra("firstName", b.getFirstName());
                editBusiness.putExtra("lastName", b.getLastName());
                editBusiness.putExtra("phoneNumber", b.getPhoneNumber());
                editBusiness.putExtra("emailAddress", b.getEmailAddress());
                editBusiness.putExtra("streetAddress", b.getStreetAddress());
                editBusiness.putExtra("city", b.getCity());
                editBusiness.putExtra("state", b.getState());
                editBusiness.putExtra("zipCode", b.getZipCode());
                editBusiness.putExtra("businessHours", b.getBusinessHours());
                editBusiness.putExtra("schedule", b.getSchedule());
                editBusiness.putExtra("websiteURL", b.getWebsiteURL());
                editBusiness.putExtra("photo", b.getPhoto());

                // REMOVE THE CONTACT BEING EDITED
                addressBook.deleteOne(addressBook.getTheList().get(positionToShow));

                // SAVE CHANGES TO JSON FILE
                DataAccessService das = new FileIOService();
                das.saveAllContacts(addressBook, getApplicationContext());

                startActivity(editBusiness);
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
    public void deleteBusinessConfirm(final int positionToShow) {

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

    public void openURL(String url) {
        if (!url.startsWith("http://") || !url.startsWith("https://")) {
            url = "http://" + url;
        }
        Uri webpage = Uri.parse(url);
        Intent openWebpage = new Intent(Intent.ACTION_VIEW, webpage);

        if (openWebpage.resolveActivity(getPackageManager()) != null) {
            startActivity(openWebpage);
        }
    }
}
