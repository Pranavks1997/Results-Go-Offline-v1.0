package com.google.android.database;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
//import android.widget.ListView;
//
///**
// * Created by user on 10-Feb-17.
// */
//
//public class CollegeList extends AppCompatActivity {
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.college_list);
//
//        ListView l = (ListView) findViewById(R.id.college_list);
//        ArrayAdapter<String> m = new ArrayAdapter<String>(this,R.layout.college_list);
//        m.add(("Rnsit"));
//        l.setAdapter(m);
//        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                switch(i)
//
//                {
//                    case 1:
//                        Intent rnsit = new Intent(CollegeList.this, MainActivity.class);
//                        startActivity(rnsit);
//                }
//            }
//        });
//        m.notifyDataSetChanged();
//    }
//}
