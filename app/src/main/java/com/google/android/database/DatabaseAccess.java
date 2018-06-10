package com.google.android.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 07-Feb-17.
 */

public class DatabaseAccess {
    public static SQLiteOpenHelper openHelper;
    public static SQLiteDatabase database;
    private static DatabaseAccess instance;
    public Cursor cc = null;


    /**
     * Private constructor to avoid object creation from outside classes
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new MyDatabase(context);
    }

    /**
     * return a singleton instance of DatabaseAccess.
     *
     * @param context the Context.
     * @return the instance of DatabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance== null)
            instance = new DatabaseAccess(context);
        return instance;
    }

    /**
     * open the database connection.
     */
    public void open() {
        this.database= openHelper.getReadableDatabase();
    }

    /**
     * close the database connection
     */
    public  void close() {
        if (database != null) {
            this.database.close();
        }
    }

    public Cursor getCursor() {
       // Cursor c = null;
        cc = database.rawQuery("SELECT * FROM student",null);
        cc.moveToFirst();
        return cc;
    }

//    public Cursor getTotalCursor() {
//        Cursor cur = database.rawQuery("SELECT _id,")
//
//    }
}
