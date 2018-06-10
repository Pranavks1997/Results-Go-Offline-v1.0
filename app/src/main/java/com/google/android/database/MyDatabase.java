package com.google.android.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.io.File;

import static android.R.attr.name;


public class MyDatabase extends SQLiteAssetHelper {

    FirebaseStorage storage = FirebaseStorage.getInstance();



    // Create a storage reference from our app
    StorageReference storageRef = storage.getReferenceFromUrl("https://firebasestorage.googleapis.com/v0/b/vturesultsnamewise.appspot.com/o/student?alt=media&token=3aac5870-e914-4ea5-a8e8-1af3172a51f7");


//    File localFile = File.createTempFile("database","sqlite");
//
//    storage.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
//        @Override
//        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
//            // Local temp file has been created
//        }
//    }).addOnFailureListener(new OnFailureListener() {
//        @Override
//        public void onFailure(@NonNull Exception exception) {
//            // Handle any errors
//        }
//    });



    // Create a reference with an initial file path and name
    //StorageReference pathReference = storageRef.child("images/stars.jpg");

    // Create a reference to a file from a Google Cloud Storage URI
    //StorageReference gsReference = storage.getReferenceFromUrl("gs://bucket/images/stars.jpg");

    // Create a reference from an HTTPS URL
// Note that in the URL, characters are URL escaped!
    //StorageReference httpsReference = storage.getReferenceFromUrl("https://firebasestorage.googleapis.com/b/bucket/o/images%20stars.jpg");

//    File localFile = File.createTempFile("images", "jpg");
//
//    islandRef.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
//        @Override
//        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
//            // Local temp file has been created
//        }
//    }).addOnFailureListener(new OnFailureListener() {
//        @Override
//        public void onFailure(@NonNull Exception exception) {
//            // Handle any errors
//        }
//    });

    private static final String DATABASE_NAME = "student.db";
    private static final int DATABASE_VERSION = 1;

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        // you can use an alternate constructor to specify a database location
        // (such as a folder on the sd card)
        // you must ensure that this folder is available and you have permission
        // to write to it
        //super(context, DATABASE_NAME, context.getExternalFilesDir(null).getAbsolutePath(), null, DATABASE_VERSION);

    }

    public Cursor getEmployees() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {"name"};
        String sqlTables = "student";

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, null, null,
                null, null, null);

        c.moveToFirst();
        return c;

    }

}