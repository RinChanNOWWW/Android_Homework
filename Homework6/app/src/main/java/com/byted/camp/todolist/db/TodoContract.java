package com.byted.camp.todolist.db;

import android.provider.BaseColumns;

/**
 * Created on 2019/1/22.
 *
 * @author xuyingyi@bytedance.com (Yingyi Xu)
 */
public final class TodoContract {

    // 定义表结构和 SQL 语句常量

    public static final String SQL_CREATE_NOTES =
            "CREATE TABLE " + TodoNote.TABLE_NAME + " (" +
                    TodoNote._ID + " INTEGER PRIMARY KEY," +
                    TodoNote.COLUMN_CONTENT + " TEXT," +
                    TodoNote.COLUMN_DATE + " DATETIME," +
//                    TodoNote.COLUMN_PRIORITY + " INTEGER," +
                    TodoNote.COLUMN_STATE + " INTEGER)";

    public static final String SQL_ADD_COLUMN_PRIORIY =
            "ALTER TABLE " +
            TodoNote.TABLE_NAME +
            " ADD " +
            TodoNote.COLUMN_PRIORITY + " INTEGER";


    private TodoContract() {
    }

    public static class TodoNote implements BaseColumns {
        public static final String TABLE_NAME = "notes";
        public static final String COLUMN_CONTENT = "content";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_PRIORITY = "priority";
        public static final String COLUMN_STATE = "state";
    }

}
