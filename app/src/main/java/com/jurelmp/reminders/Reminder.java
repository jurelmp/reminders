package com.jurelmp.reminders;

/**
 * Created by Jurel on 7/20/2016.
 */
public class Reminder {

    private int mId;
    private String mContent;
    private int mImportant;

    public Reminder(int mId, String mContent, int mImportant) {
        this.mId = mId;
        this.mContent = mContent;
        this.mImportant = mImportant;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public int getmImportant() {
        return mImportant;
    }

    public void setmImportant(int mImportant) {
        this.mImportant = mImportant;
    }
}
