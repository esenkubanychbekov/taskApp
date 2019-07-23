package com.e.taskapp_1.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.e.taskapp_1.Task;

@Database(entities = {Task.class},version = 1, exportSchema = false)
public abstract class MyDataBase extends RoomDatabase {

    public abstract TaskDao taskDao();
}
