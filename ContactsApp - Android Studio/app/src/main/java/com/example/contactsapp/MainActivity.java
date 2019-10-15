package com.example.contactsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // CREATE ALL BUTTONS
    Button btn_createNew, btn_showAll;

    // ON CREATE SET CONTENT TO ACTIVITY_MAIN LAYOUT
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // FIND ALL BUTTONS
        btn_createNew = findViewById(R.id.btn_createNew);
        btn_showAll = findViewById(R.id.btn_showAll);

        // NEW CONTACT BUTTON
        btn_createNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToCreateNew = new Intent(v.getContext(), CreateNew.class);
                startActivity(goToCreateNew);
            }
        });

        // SHOW ALL BUTTON
        btn_showAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToShowAll = new Intent(v.getContext(), ShowAll.class);
                startActivity(goToShowAll);
            }
        });

    }

}
