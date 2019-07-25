package com.e.taskapp_1.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.e.taskapp_1.Task;

@Database(entities = {Task.class},version = 1, exportSchema = false)
public abstract class MyDataBase extends RoomDatabase {

    public abstract TaskDao taskDao();
}
