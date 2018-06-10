//package com.google.android.database;
//
//import android.app.SearchManager;
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v7.app.ActionBarActivity;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.SearchView;
//import android.view.Menu;
//import android.view.MenuInflater;
//
//import static android.R.attr.handle;
//
///**
// * Created by user on 09-Feb-17.
// */
//
//public class SearchResultActivity extends AppCompatActivity {
//
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.search_activity_result);
//        handleIntent(getIntent());
//    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.search_menu, menu);
//
//
//        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
//
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
//
//        return true;
//    }
//
//    @Override
//    protected void onNewIntent(Intent intent) {
//        super.onNewIntent(intent);
//        handleIntent(intent);
//    }
//
//    /**
//     * handleIntent method
//     */
//    private void handleIntent(Intent intent) {
//        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
//            String query = intent.getStringExtra(SearchManager.QUERY);
//        }
//    }
//}
