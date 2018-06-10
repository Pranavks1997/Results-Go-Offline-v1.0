package com.google.android.database;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.google.android.database.R.id.sgpa;

//import static com.google.android.database.R.id.total;

/**
 * Created by user on 08-Feb-17.
 */

public class ClickingOnListItemIntent extends AppCompatActivity implements Filterable{
    private int columnIndex;
    private String total;
    private Context mCtx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCtx=this;

        //columnIndex = getIntent().getExtras().getInt("position");
        total = ""+ getIntent().getExtras().getInt("totalCredits");
        String sub1 = ""+ getIntent().getExtras().getInt("Sub1");
        String sub2 = ""+ getIntent().getExtras().getInt("Sub2");
        String sub3 = ""+ getIntent().getExtras().getInt("Sub3");
        String sub4 = ""+ getIntent().getExtras().getInt("Sub4");
        String sub5 = ""+ getIntent().getExtras().getInt("Sub5");
        String sub6 = ""+ getIntent().getExtras().getInt("Sub6");
        String sub7 = ""+ getIntent().getExtras().getInt("Sub7");
        String gpa = ""+ getIntent().getExtras().getDouble("Gpa");
        String name =  getIntent().getExtras().getString("name");


        setContentView(R.layout.clicking_on_list_item_intent);
        //CollapsingToolbarLayout collapsing_container = (CollapsingToolbarLayout) findViewById(R.id.collapsing);
       // collapsing_container.setTitle((getResources().getString(R.string.hello)));
//        this.setTitle("Details");
        //TextView totalTextView = (TextView) findViewById(R.id.sub_marks);
        TextView s = (TextView) findViewById(R.id.total_credit_points);
        GradientDrawable gradientDrawable = (GradientDrawable)(s.getBackground());
        int creditsbg = getMagnitudeColor(Integer.valueOf(total));
        gradientDrawable.setColor(creditsbg);
        s.setText(total);

        TextView sgpas = (TextView) findViewById(sgpa);
        TextView nameTv = (TextView) findViewById(R.id.name);
        sgpas.setText(gpa);
        nameTv.setText(name);
        /**totalTextView.append(sub1+"\n");
        totalTextView.append(sub2+"\n");
        totalTextView.append(sub3+"\n");
        totalTextView.append(sub4+"\n");
        totalTextView.append(sub5+"\n");
        totalTextView.append(sub6+"\n");*/
//        totalTextView.append(sub7+"\n");
//        int i = (Integer.valueOf(sub1)/40);
//        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, i, getResources().getDisplayMetrics());
//        View sub21 = (View) findViewById(R.id.sub11);

        String A="Subject_name";
        final ArrayList<Word> row = new ArrayList<Word>();
        row.add(new Word(A, Integer.valueOf(sub1)));
        row.add(new Word(A, Integer.valueOf(sub2)));
        row.add(new Word(A, Integer.valueOf(sub3)));
        row.add(new Word(A, Integer.valueOf(sub4)));
        row.add(new Word(A, Integer.valueOf(sub5)));
        row.add(new Word(A, Integer.valueOf(sub6)));
        row.add(new Word(A, Integer.valueOf(sub7)));


        CustomArrayAdapter i = new CustomArrayAdapter(this,row);
        ListView list =(ListView) findViewById(R.id.llist);
        list.setAdapter(i);




    }

    @Override
    public Filter getFilter() {
        return null;
    }
    public int getMagnitudeColor(int magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
        }

        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
    public Context getContext() {
        return mCtx;
    }
}
