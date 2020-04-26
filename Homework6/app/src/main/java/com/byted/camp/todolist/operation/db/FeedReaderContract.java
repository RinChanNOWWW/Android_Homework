package com.byted.camp.todolist.operation.db;

import android.provider.BaseColumns;

/**
 * @author zhongshan
 * 2020-04-19.
 */
public class FeedReaderContract {

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
                    FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedEntry.COLUMN_NAME_TITLE + " TEXT," +
                    FeedEntry.COLUMN_NAME_SUBTITLE + " TEXT)";

    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;

    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private FeedReaderContract() {
    }

    /* Inner class that defines the table contents */
    public static class FeedEntry implements BaseColumns {

        public static final String TABLE_NAME = "entry";

        public static final String COLUMN_NAME_TITLE = "title";

        public static final String COLUMN_NAME_SUBTITLE = "subtitle";

        public static final String COLUMN_NAME_CONTENT = "content";
    }
}
