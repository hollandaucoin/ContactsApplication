package com.example.contactsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class SearchResults extends AppCompatActivity {

    // CREATE ALL IMAGE BUTTONS, LIST VIEWS, AND ADAPTERS
    ImageButton ib_exit;
    ListView lv_results;
    PersonAdapter adapter;

    // CREATE ADDRESS BOOK
    AddressBook newList;

    // ON CREATE SET CONTENT TO SEARCH_RESULTS LAYOUT
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        // LISTEN FOR INCOMING INTENT DATA
        String searchInput = getIntent().getStringExtra("searchText");

        // CREATE 'NEW LIST' THAT IS THE RESULTS OF SEARCH FOR METHOD
        DataAccessService das = new FileIOService();
        newList = das.readAllContacts(getApplicationContext()).searchForOutput(searchInput);

        // FIND ALL IMAGE BUTTONS AND LIST VIEWS
        ib_exit = findViewById(R.id.ib_exit);
        lv_results = findViewById(R.id.lv_results);

        // CREATE ADAPTER AND SET LIST VIEW TO SEARCH LIST RESULTS
        adapter = new PersonAdapter(SearchResults.this, newList);
        lv_results.setAdapter(adapter);

        lv_results.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showResultPerson(position);
            }
        });

        // BACK BUTTON TO SHOW ALL
        ib_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToShowAll = new Intent(v.getContext(), ShowAll.class);
                startActivity(goToShowAll);
            }
        });
    }

    // METHOD TO SHOW PERSON WITHIN SEARCH RESULTS
    public void showResultPerson(int position) {

        // CREATE BASECONTACT AT THE POSITION SELECTED
        BaseContact bc = newList.getTheList().get(position);

        DataAccessService das = new FileIOService();
        AddressBook global = das.readAllContacts(getApplicationContext());

        // CREATE VARIABLE OF POSITION OF THE ORIGINAL ADDRESS BOOK TO PASS TO SHOW CONTACT
        int positionInGlobalList = 0;
        for (int i = 0 ; i < global.getTheList().size() ; i ++) {
            if (bc.getFirstName().equalsIgnoreCase(global.getTheList().get(i).getFirstName())) {
                if (bc.getLastName().equalsIgnoreCase(global.getTheList().get(i).getLastName())) {
                    positionInGlobalList = i;
                }
            }
        }

        // SHOW CONTACT USING IF STATEMENTS TO DETERMINE CONTACT TYPE
        if (bc.getClass() == PersonContact.class) {
            Intent showPersonal = new Intent(getApplicationContext(), ShowPersonal.class);
            showPersonal.putExtra("position", positionInGlobalList);
            startActivity(showPersonal);
        }
        else {
            Intent showBusiness = new Intent(getApplicationContext(), ShowBusiness.class);
            showBusiness.putExtra("position", positionInGlobalList);
            startActivity(showBusiness);
        }
    }

}
