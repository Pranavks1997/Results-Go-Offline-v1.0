package com.google.android.database;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 10-Feb-17.
 * to display the subject name and marks in @Details activity(i.e ClickingOnListItemIntent activity)
 * takes @Word object of Word class
 */

public class CustomArrayAdapter extends ArrayAdapter<Word> {
    public CustomArrayAdapter(Context context, ArrayList<Word> objects) {
        super(context,0,objects);

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_details_for_clicking_on_first_list_item, parent, false);
        }
        Word currentWord = getItem(position);

        TextView subName= (TextView)convertView.findViewById(R.id.sub_name);
        TextView credit= (TextView)convertView.findViewById(R.id.credit);
        subName.setText(currentWord.getName());
        credit.setText(""+currentWord.getMarks());
        return convertView;
    }
}
