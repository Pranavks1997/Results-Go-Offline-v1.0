package com.google.android.database;

/**
 * Created by user on 10-Feb-17.
 * This is for @CustomArrayadapter Class
 * {Which is to display the subject name and marks in @Details activity(i.e ClickingOnListItemIntent activity) }
 */


public class Word {
    private String mSubjectName;
    private int mMarks;

    public Word(String subjectName, int marks) {
        mSubjectName=subjectName;
        mMarks=marks;
    }
    public String getName(){
        return mSubjectName;
    }
    public long getMarks(){
        return mMarks;
    }

}

