package com.example.contactsapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonAdapter extends BaseAdapter {

    // CREATE ACTIVITY AND ADDRESS BOOK
    Activity mActivity;
    AddressBook addressBook;

    // CONSTRUCTOR
    public PersonAdapter(Activity mActivity, AddressBook addressBook) {
        this.mActivity = mActivity;
        this.addressBook = addressBook;
    }

    // GETTERS
    @Override
    public int getCount() {
        return addressBook.getTheList().size();
    }

    @Override
    public BaseContact getItem(int position) {
        return addressBook.getTheList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View onePersonLine;

        LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        onePersonLine = inflater.inflate(R.layout.person_one_line, parent, false);

        TextView tv_name = onePersonLine.findViewById(R.id.tv_name);
        TextView tv_type = onePersonLine.findViewById(R.id.tv_type);
        TextView tv_number = onePersonLine.findViewById(R.id.tv_number);
        ImageView iv_icon = onePersonLine.findViewById(R.id.iv_icon);

        BaseContact bc = this.getItem(position);

        tv_name.setText(bc.getFirstName() + " " + bc.getLastName());
        tv_number.setText(bc.getPhoneNumber());

        if (bc.getClass() == PersonContact.class) {
            tv_type.setText(" -   " + ((PersonContact) bc).getDescription());
        }
        else {
            tv_type.setText(" -   " + ((BusinessContact) bc).getCompany());
        }

        int iconResourceNumbers [] = {
                R.drawable.icon1, R.drawable.icon2, R.drawable.icon3, R.drawable.icon4, R.drawable.icon5,
                R.drawable.icon6, R.drawable.icon7, R.drawable.icon9, R.drawable.icon8, R.drawable.icon10,
                R.drawable.icon11, R.drawable.icon12, R.drawable.icon13, R.drawable.icon14, R.drawable.icon15,
                R.drawable.icon16
        };

        iv_icon.setImageResource(iconResourceNumbers[Integer.parseInt(bc.getPhoto())-1]);

        return onePersonLine;
    }

}
