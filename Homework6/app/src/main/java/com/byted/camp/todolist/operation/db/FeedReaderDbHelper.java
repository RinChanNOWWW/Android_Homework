package com.byted.camp.todolist.operation.db;

import static com.byted.camp.todolist.operation.db.FeedReaderContract.SQL_CREATE_ENTRIES;
import static com.byted.camp.todolist.operation.db.FeedReaderContract.SQL_DELETE_ENTRIES;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author zhongshan
 * 2020-04-19.
 */
public class FeedReaderDbHelper extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "FeedReader.db";


    public FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
        if (oldVersion == 1 && newVersion == 2) {
            db.execSQL("");
        }
    }
}

