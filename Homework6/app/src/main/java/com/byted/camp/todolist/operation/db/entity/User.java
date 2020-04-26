package com.byted.camp.todolist.operation.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * @author zhongshan
 * 2020-04-19.
 */
@Entity(tableName = "user")
public class User {
    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

//
//    @ColumnInfo(name = "age")
//    public String age;

}
