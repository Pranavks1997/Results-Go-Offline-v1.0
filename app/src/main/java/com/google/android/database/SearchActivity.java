//package com.google.android.database;
//
//import android.app.DownloadManager;
//import android.app.ListActivity;
//import android.app.SearchManager;
//import android.content.Intent;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.os.Bundle;
//import android.widget.ArrayAdapter;
//
//import static com.google.android.database.DatabaseAccess.openHelper;
//
///**
// * Created by user on 10-Feb-17.
// */
//
//public class SearchActivity extends ListActivity {
//SQLiteDatabase database;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.search_activity_result);
//
//        //get the intent , Verify the action and get the query
//        Intent intent = getIntent();
//        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
//            String query = intent.getStringExtra(SearchManager.QUERY);
//
//            Cursor cursor = doMySearch(query);
//            cursor.moveToFirst();
//
//            //ArrayAdapter<String> a = new ArrayAdapter<String>(this,R.layout.);
//        }
//    }
//
//
//    private Cursor doMySearch(String query) {
//        this.database= openHelper.getReadableDatabase();
//
//        Cursor cursor = this.database.rawQuery("SELECT * FROM student WHERE name=", new String[]{query});
//
//        return cursor;
//
//    }
//}
