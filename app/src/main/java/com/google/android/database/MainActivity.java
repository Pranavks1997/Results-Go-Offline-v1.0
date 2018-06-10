package com.google.android.database;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.ListView;

import java.util.ArrayList;

import static com.google.android.database.DatabaseAccess.database;
import static com.google.android.database.DatabaseAccess.openHelper;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private ListView listView;
   // private com.google.android.database.MyDatabase db;
    private Context mContext;
    private Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;


//        db = new com.google.android.database.MyDatabase(this);
//        employees = db.getEmployees(); // you would not typically call this on the main thread
//
//        ListAdapter adapter = new SimpleCursorAdapter(this,
//                android.R.layout.simple_list_item_1,
//                employees,
//                new String[] {"name"},
//                new int[] {android.R.id.text1});
//
//        getListView().setAdapter(adapter);
        this.listView = (ListView) findViewById(R.id.list_view);
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        //DatabaseAccess.open();
        database = openHelper.getWritableDatabase();
        c = databaseAccess.getCursor();
        if (c == null) {
            int namec = 777777777;
        }
        if (c != null) {
            // c.moveToNext();
            c.moveToFirst();
            String name = c.getString(c.getColumnIndex("name"));
            Log.v("MainActivity", name + "DDdddddddddddddd");

        }
        c.moveToFirst();
        CustomCursorAdapter customCursorAdapter = new CustomCursorAdapter(MainActivity.this, c);
        listView.setAdapter(customCursorAdapter);
        listView.setEmptyView(findViewById(R.id.progressbar));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Log.v("MainActiviy", position + "ddddddddddddddddd");

                Intent t = new Intent(mContext, ClickingOnListItemIntent.class);
                t.putExtra("position", position);
                c.moveToPosition(position);
                t.putExtra("totalCredits", c.getInt(c.getColumnIndex("total")));
                t.putExtra("Sub1", c.getInt(c.getColumnIndex("sub1")));
                t.putExtra("Sub2", c.getInt(c.getColumnIndex("sub2")));
                t.putExtra("Sub3", c.getInt(c.getColumnIndex("sub3")));
                t.putExtra("Sub4", c.getInt(c.getColumnIndex("sub4")));
                t.putExtra("Sub5", c.getInt(c.getColumnIndex("sub5")));
                t.putExtra("Sub6", c.getInt(c.getColumnIndex("sub6")));
                t.putExtra("Sub7", c.getInt(c.getColumnIndex("sub7")));
                t.putExtra("Gpa", c.getDouble(c.getColumnIndex("gpa")));
                t.putExtra("name", c.getString(c.getColumnIndex("name")));

                startActivity(t);

            }
        });
//        if (database != null) {
//            DatabaseAccess.database.close();
//            c.close();
//        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        MenuItem searchMenuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        //searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        //searchView.setSubmitButtonEnabled(true);
       // searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        //CustomCursorAdapter.getFilter().filter(newText);
        return true;
    }
    //    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        //employees.close();
//        db.close();
//    }


    private class CustomFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults filterResults = new FilterResults();
            if (charSequence != null && charSequence.length() > 0) {

            }
            return null;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

        }
    }
}