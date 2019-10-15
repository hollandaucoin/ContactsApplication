package com.example.contactsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;


public class ShowAll extends AppCompatActivity {

    // CREATE FEATURES
    ImageButton ib_addNew, ib_allToMenu, ib_search, ib_sort;
    EditText et_searchInput;

    ListView lv_contactsList;
    PersonAdapter adapter;
    AddressBook addressBook;

    MyApplication app = new MyApplication();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);

        // SET ADDRESS BOOK TO JSON FILE
        DataAccessService das = new FileIOService();
        addressBook = das.readAllContacts(getApplicationContext());

        // LOCATE FEATURES ON LAYOUT
        ib_sort = findViewById(R.id.ib_sort);
        ib_search = findViewById(R.id.ib_search);
        ib_addNew = findViewById(R.id.ib_addNew);
        ib_allToMenu = findViewById(R.id.ib_allToMenu);
        ib_search = findViewById(R.id.ib_search);
        et_searchInput = findViewById(R.id.et_searchInput);
        lv_contactsList = findViewById(R.id.lv_contactsList);

        // CREATE ADAPTER AND SET LIST VIEW TO ADDRESS BOOK
        adapter = new PersonAdapter(ShowAll.this, addressBook);
        lv_contactsList.setAdapter(adapter);

        lv_contactsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showPerson(position);
            }
        });

        // SORT BUTTON
        ib_sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addressBook.sortContacts();
                DataAccessService das = new FileIOService();
                das.saveAllContacts(addressBook, getApplicationContext());
                adapter.notifyDataSetChanged();
            }
        });

        // SEARCH BUTTON TO RESULTS
        ib_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToSearchResults = new Intent(v.getContext(), SearchResults.class);
                goToSearchResults.putExtra("searchText", et_searchInput.getText().toString());
                startActivity(goToSearchResults);
            }
        });

        // ADD BUTTON TO CREATE NEW
       ib_addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToNew = new Intent(v.getContext(), CreateNew.class);
                startActivity(goToNew);
            }
        });

       // BACK BUTTON TO MAIN
        ib_allToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMenu = new Intent(v.getContext(), MainActivity.class);
                startActivity(goToMenu);
            }
        });


    }
        // METHOD TO SHOW ONE PERSONAL OR BUSINESS CONTACT
        public void showPerson(int position) {

            BaseContact bc = addressBook.getTheList().get(position);

            if (bc.getClass() == PersonContact.class) {
                Intent showPersonal = new Intent(getApplicationContext(), ShowPersonal.class);
                showPersonal.putExtra("position", position);
                startActivity(showPersonal);
            }
            else {
                Intent showBusiness = new Intent(getApplicationContext(), ShowBusiness.class);
                showBusiness.putExtra("position", position);
                startActivity(showBusiness);
            }
        }

}
