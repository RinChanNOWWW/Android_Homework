package com.byted.camp.todolist.operation.activity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.provider.BaseColumns;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.byted.camp.todolist.R;
import com.byted.camp.todolist.operation.db.FeedReaderContract.FeedEntry;
import com.byted.camp.todolist.operation.db.FeedReaderDbHelper;


public class DatabaseActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "DatabaseActivity";

    private Button addBtn;
    private Button deleteBtn;
    private Button updateBtn;
    private Button queryBtn;

    private HandlerThread mWorkThread;
    private WorkHander mWorkHander;

    private FeedReaderDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        addBtn = findViewById(R.id.btn_add);
        addBtn.setOnClickListener(this);
        deleteBtn = findViewById(R.id.btn_delete);
        deleteBtn.setOnClickListener(this);
        updateBtn = findViewById(R.id.btn_update);
        updateBtn.setOnClickListener(this);
        queryBtn = findViewById(R.id.btn_query);
        queryBtn.setOnClickListener(this);

        mWorkThread = new HandlerThread("operation_database");
        mWorkThread.start();
        mWorkHander = new WorkHander(mWorkThread.getLooper());

        dbHelper = new FeedReaderDbHelper(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mWorkThread.quitSafely();
        dbHelper.close();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                mWorkHander.sendEmptyMessage(WorkHander.MSG_ADD_DATA);
                break;
            case R.id.btn_delete:
                mWorkHander.sendEmptyMessage(WorkHander.MSG_DELETE_DATA);
                break;
            case R.id.btn_update:
                mWorkHander.sendEmptyMessage(WorkHander.MSG_UPDATE_DATA);
                break;
            case R.id.btn_query:
                mWorkHander.sendEmptyMessage(WorkHander.MSG_QUERY_DATA);
                break;
            default:
                break;
        }
    }

    private void addData() {
        // Gets the data repository in write mode
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FeedEntry.COLUMN_NAME_TITLE, "my_title");
        values.put(FeedEntry.COLUMN_NAME_SUBTITLE, "my_subtitle");

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(FeedEntry.TABLE_NAME, null, values);
        Log.i(TAG, "perform add data, result:" + newRowId);

        values.put(FeedEntry.COLUMN_NAME_TITLE, "title1");
        values.put(FeedEntry.COLUMN_NAME_SUBTITLE, "my_subtitle1");
        newRowId = db.insert(FeedEntry.TABLE_NAME, null, values);
        Log.i(TAG, "perform add data(title1), result:" + newRowId);

        values.put(FeedEntry.COLUMN_NAME_TITLE, "title2");
        values.put(FeedEntry.COLUMN_NAME_SUBTITLE, "my_subtitle2");
        newRowId = db.insert(FeedEntry.TABLE_NAME, null, values);
        Log.i(TAG, "perform add data(title2), result:" + newRowId);

        values.put(FeedEntry.COLUMN_NAME_TITLE, "title3");
        values.put(FeedEntry.COLUMN_NAME_SUBTITLE, "my_subtitle3");
        newRowId = db.insert(FeedEntry.TABLE_NAME, null, values);
        Log.i(TAG, "perform add data(title3), result:" + newRowId);

//        User user = new User();
//        user.firstName = "zhang";
//        user.lastName = "san";
//        AppDatabase.getInstance(this).userDao().insertAll(user);
    }

    private void deleteData() {
        // Gets the data repository in write mode
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Define 'where' part of query.
        String selection = FeedEntry.COLUMN_NAME_TITLE + " LIKE ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = {"my_title"};
        // Issue SQL statement.
        int deletedRows = db.delete(FeedEntry.TABLE_NAME, selection, selectionArgs);
        Log.i(TAG, "perform delete data, result:" + deletedRows);
    }

    private void updateData() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // New value for one column
        String title = "title_1";
        ContentValues values = new ContentValues();
        values.put(FeedEntry.COLUMN_NAME_TITLE, title);

        // Which row to update, based on the title
        String selection = FeedEntry.COLUMN_NAME_TITLE + " LIKE ?";
        String[] selectionArgs = {"title1"};

        int count = db.update(
                FeedEntry.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        Log.i(TAG, "perform update data, result:" + count);
    }

    private void queryData() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                FeedEntry.COLUMN_NAME_TITLE,
                FeedEntry.COLUMN_NAME_SUBTITLE
        };

        // Filter results WHERE "title" = 'My Title'
        String selection = FeedEntry.COLUMN_NAME_TITLE + " = ?";
        String[] selectionArgs = {"my_title"};

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                FeedEntry.COLUMN_NAME_SUBTITLE + " DESC";

        Cursor cursor = db.query(
                FeedEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        Log.i(TAG, "perfrom query data:");
        while (cursor.moveToNext()) {
            long itemId = cursor.getLong(cursor.getColumnIndexOrThrow(FeedEntry._ID));
            String title = cursor.getString(cursor.getColumnIndex(FeedEntry.COLUMN_NAME_TITLE));
            String subTitle = cursor.getString(cursor.getColumnIndex(FeedEntry.COLUMN_NAME_SUBTITLE));
            Log.i(TAG, "itemId:" + itemId + ", title:" + title + ", subTitle:" + subTitle);
        }
        cursor.close();
    }

    private class WorkHander extends Handler {

        // 增加数据
        public static final int MSG_ADD_DATA = 1;
        // 删除数据
        public static final int MSG_DELETE_DATA = 2;
        // 修改数据
        public static final int MSG_UPDATE_DATA = 3;
        // 查询数据
        public static final int MSG_QUERY_DATA = 4;


        public WorkHander(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MSG_ADD_DATA:
                    addData();
                    break;
                case MSG_DELETE_DATA:
                    deleteData();
                    break;
                case MSG_UPDATE_DATA:
                    updateData();
                    break;
                case MSG_QUERY_DATA:
                    queryData();
                    break;
                default:
                    break;
            }
        }
    }
}
