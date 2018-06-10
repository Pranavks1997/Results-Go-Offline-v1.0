package com.google.android.database;

import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.CursorAdapter;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

import static android.R.attr.name;
import static android.R.string.no;
import static com.google.android.database.R.id.usn;
import static java.security.AccessController.getContext;

/**
 * Created by user on 05-Feb-17.
 */

public class CustomCursorAdapter extends CursorAdapter {

    private Context mContext;
    private LayoutInflater mLayout;
    private Cursor mCursor;

    public CustomCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
        mContext = context;
        mCursor = c;
        mLayout = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    public Context getContext() {
        return mContext;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
//        //@inflate THE LAYOUT!!!
//        cursor = getCursor();
//        context = mContext;
        return mLayout.inflate(R.layout.list_item, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
//        cursor= mCursor;
        TextView nameTextView = (TextView) view.findViewById(R.id.Student_name);
        TextView idTextView = (TextView) view.findViewById(R.id.Student_id);
        // cursor = getCursor();
        //cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("name");
        String name = cursor.getString(columnIndex);
        nameTextView.setText(name);


        /**  //idTextView.setText(no);
         // int no = cursor.getInt(cursor.getColumnIndex("_id"));
         //        int cc = cursor.getCount();
         //        String[] array = new String[cc];
         //        cursor.moveToFirst();
         //        int i = 0;
         //        while (!cursor.isAfterLast()) {
         //            array[i] = cursor.getString(i);
         //            Log.v("CustomCursorAdapter", array[i]);
         //            i++;
         //            cursor.moveToNext();
         //        }*/
        double sgpa = cursor.getDouble(cursor.getColumnIndex("gpa"));
        TextView mark = (TextView) view.findViewById(R.id.Student_id);
        GradientDrawable markCircle = (GradientDrawable) mark.getBackground();
        int markBg = getMagnitudeColor(sgpa);
        markCircle.setColor(markBg);
        mark.setText(formatMark(sgpa));

        String usn1 = cursor.getString(cursor.getColumnIndex("usn"));
        TextView usn_tv = (TextView) view.findViewById(usn);
        String usn = "1RN15"+usn1;
        usn_tv.setText(usn);

    }
    private String formatMark(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.00");
        return magnitudeFormat.format(magnitude);
    }

    /**
     * Return the color for the magnitude circle based on the intensity of the earthquake.
     *
     * @param magnitude of the earthquake
     */
    public int getMagnitudeColor(double magnitude) {
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
}