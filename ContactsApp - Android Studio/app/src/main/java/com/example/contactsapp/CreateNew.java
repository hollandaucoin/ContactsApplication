package com.example.contactsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class CreateNew extends AppCompatActivity {

    // CREATE ALL BUTTONS AND IMAGE BUTTONS
    Button btn_personal, btn_business;
    ImageButton ib_newToMain;

    // ON CREATE SET CONTENT TO CREATE_NEW LAYOUT
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new);

        // FIND ALL BUTTONS AND IMAGE BUTTONS
        btn_personal = findViewById(R.id.btn_personal);
        btn_business = findViewById(R.id.btn_business);
        ib_newToMain = findViewById(R.id.ib_newToMain);

        // "PERSONAL CONTACT" BUTTON
        btn_personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToCreateNewPersonal = new Intent(v.getContext(), CreateNewPersonal.class);
                startActivity(goToCreateNewPersonal);
            }
        });

        // "BUSINESS CONTACT" BUTTON
        btn_business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToCreateNewBusiness = new Intent(v.getContext(), CreateNewBusiness.class);
                startActivity(goToCreateNewBusiness);
            }
        });

        // BACK BUTTON TO RETURN TO MAIN PAGE
        ib_newToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMain = new Intent(v.getContext(), MainActivity.class);
                startActivity(goToMain);
            }
        });



    }
}
