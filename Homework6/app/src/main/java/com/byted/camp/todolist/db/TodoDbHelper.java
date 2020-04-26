package com.byted.camp.todolist.db;

import static com.byted.camp.todolist.db.TodoContract.SQL_ADD_COLUMN_PRIORIY;
import static com.byted.camp.todolist.db.TodoContract.SQL_CREATE_NOTES;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created on 2019/1/22.
 *
 * @author xuyingyi@bytedance.com (Yingyi Xu)
 */
public class TodoDbHelper extends SQLiteOpenHelper {

    // 定义数据库名、版本；创建数据库

    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "TodoList.db";
    public TodoDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_NOTES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion == 1 && newVersion == 2) {
            db.execSQL(SQL_ADD_COLUMN_PRIORIY);
        }
    }

}
